#include <stdbool.h>
#include <stdint.h>
#include <inc/hw_memmap.h>
#include <driverlib/sysctl.h>
#include <driverlib/gpio.h>
#include <driverlib/systick.h>
#include <inc/hw_nvic.h>
#include <driverlib/interrupt.h>


#define NVIC_ST_CURRENT_R       (*((volatile uint32_t *)0xE000E018))
#define NVIC_ST_RELOAD_R       (*((volatile uint32_t *)0xE000E014))
#define NVIC_ST_CTRL_R       (*((volatile uint32_t *)0xE000E010))

int sw1 = 0;
int sw2 = 0;

void configureSysTick(void) {
    NVIC_ST_CTRL_R = 0x0;
    NVIC_ST_RELOAD_R = 1600000;
    NVIC_ST_CURRENT_R = 0x0;
    NVIC_ST_CTRL_R = 0x00000005;
}

void sysTick_delay(void) {
    NVIC_ST_RELOAD_R = 1600000;
    NVIC_ST_CURRENT_R = 0x0;
    while((NVIC_ST_CTRL_R&0x00010000)==0) {
        ;
    }
}

void PortFIntHandler(void) {
    int status = GPIOIntStatus(GPIO_PORTF_BASE, false);
    GPIOIntClear(GPIO_PORTF_BASE, status);
    if(GPIOPinRead(GPIO_PORTF_BASE, GPIO_PIN_4) == 0) {
        sysTick_delay();
        sw1 = 1;
    }
    else if(GPIOPinRead(GPIO_PORTF_BASE, GPIO_PIN_0) == 0) {
        sysTick_delay();
        sw2 = 1;
    }
}

void configurePins(void) {
    SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOD);
    SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOF);
    GPIOUnlockPin(GPIO_PORTF_BASE, GPIO_PIN_0);
    GPIOPinTypeGPIOInput(GPIO_PORTF_BASE, GPIO_PIN_0 | GPIO_PIN_4);
    GPIOPinTypeGPIOOutput(GPIO_PORTD_BASE, GPIO_PIN_0 | GPIO_PIN_1 | GPIO_PIN_2 | GPIO_PIN_3);
    GPIOPadConfigSet(GPIO_PORTF_BASE, GPIO_PIN_0 | GPIO_PIN_4, GPIO_STRENGTH_2MA, GPIO_PIN_TYPE_STD_WPU);
    GPIOPadConfigSet(GPIO_PORTD_BASE, GPIO_PIN_0 | GPIO_PIN_1 | GPIO_PIN_2 | GPIO_PIN_3, GPIO_STRENGTH_4MA, GPIO_PIN_TYPE_STD);
    GPIOIntRegister(GPIO_PORTF_BASE, PortFIntHandler);
    GPIOIntTypeSet(GPIO_PORTF_BASE, GPIO_PIN_0 | GPIO_PIN_4, GPIO_FALLING_EDGE);
    GPIOIntEnable(GPIO_PORTF_BASE, GPIO_PIN_0 | GPIO_PIN_4);
}

void setPins(uint8_t count) {
    GPIOPinWrite(GPIO_PORTD_BASE, GPIO_PIN_0 | GPIO_PIN_1 | GPIO_PIN_2 | GPIO_PIN_3, count);
}

/**
 *
 *
 * main.c
 */
int main(void)
{
    int count = 0;
    configureSysTick();
	configurePins();
	while(1) {
	    if(sw1 == 1) {
	        count++;
	        setPins(count);
	        sw1 = 0;
	    }
	    else if(sw2 == 1) {
	        count--;
	        setPins(count);
	        sw2 = 0;
	    }
	}
}


