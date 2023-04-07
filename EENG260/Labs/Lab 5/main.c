#include <stdbool.h>
#include <stdint.h>
#include <inc/hw_memmap.h>
#include <driverlib/sysctl.h>
#include <driverlib/gpio.h>
#include <driverlib/systick.h>
#include <inc/hw_nvic.h>
#include <driverlib/interrupt.h>
#include <driverlib/timer.h>

#define NVIC_ST_CURRENT_R       (*((volatile uint32_t *)0xE000E018))
#define NVIC_ST_RELOAD_R       (*((volatile uint32_t *)0xE000E014))
#define NVIC_ST_CTRL_R       (*((volatile uint32_t *)0xE000E010))

bool up = true;
uint8_t count = 0;
int digit = 0;

void configureSysTick(void) {
    NVIC_ST_CTRL_R = 0x0;
    NVIC_ST_RELOAD_R = 160000;
    NVIC_ST_CURRENT_R = 0x0;
    NVIC_ST_CTRL_R = 0x00000005;
}

void sysTick_delay(void) {
    NVIC_ST_RELOAD_R = 160000;
    NVIC_ST_CURRENT_R = 0x0;
    while((NVIC_ST_CTRL_R&0x00010000)==0) {
        ;
    }
}

void displayOnes(int ones) {
    GPIOPinWrite(GPIO_PORTE_BASE, GPIO_PIN_1 | GPIO_PIN_2 | GPIO_PIN_3, 0);
    GPIOPinWrite(GPIO_PORTD_BASE, GPIO_PIN_0 | GPIO_PIN_1 | GPIO_PIN_2 | GPIO_PIN_3, ones);
    GPIOPinWrite(GPIO_PORTE_BASE, GPIO_PIN_1 | GPIO_PIN_2 | GPIO_PIN_3, 2);
}

void displayTens(int tens) {
    GPIOPinWrite(GPIO_PORTE_BASE, GPIO_PIN_1 | GPIO_PIN_2 | GPIO_PIN_3, 0);
    if(count >= 10) GPIOPinWrite(GPIO_PORTD_BASE, GPIO_PIN_0 | GPIO_PIN_1 | GPIO_PIN_2 | GPIO_PIN_3, tens);
    else GPIOPinWrite(GPIO_PORTD_BASE, GPIO_PIN_0 | GPIO_PIN_1 | GPIO_PIN_2 | GPIO_PIN_3, 15);
    GPIOPinWrite(GPIO_PORTE_BASE, GPIO_PIN_1 | GPIO_PIN_2 | GPIO_PIN_3, 4);
}

void displayHundreds(int hundreds) {
    GPIOPinWrite(GPIO_PORTE_BASE, GPIO_PIN_1 | GPIO_PIN_2 | GPIO_PIN_3, 0);
    if(count >= 100) GPIOPinWrite(GPIO_PORTD_BASE, GPIO_PIN_0 | GPIO_PIN_1 | GPIO_PIN_2 | GPIO_PIN_3, hundreds);
    else GPIOPinWrite(GPIO_PORTD_BASE, GPIO_PIN_0 | GPIO_PIN_1 | GPIO_PIN_2 | GPIO_PIN_3, 15);
    GPIOPinWrite(GPIO_PORTE_BASE, GPIO_PIN_1 | GPIO_PIN_2 | GPIO_PIN_3, 8);
}

void display(int dis) {
    int ones = count % 10;
    int tens = (count % 100 - ones) / 10;
    int hundreds = (count - (tens * 10) - ones) / 100;
    if(dis == 0) {
        displayOnes(ones);
        digit = 1;
    }
    else if(dis == 1) {
        displayTens(tens);
        digit = 2;
    }
    else if(dis == 2) {
        displayHundreds(hundreds);
        digit = 0;
    }
}

void SW1IntHandler(void) {
    GPIOIntClear(GPIO_PORTF_BASE, GPIO_PIN_4);
    GPIOIntDisable(GPIO_PORTF_BASE, GPIO_PIN_4);
    sysTick_delay();
    if(up) {
        up = false;
    } else {
        up = true;
    }
    GPIOIntEnable(GPIO_PORTF_BASE, GPIO_PIN_4);
}

void Timer0IntHandler(void) {
    TimerIntClear(TIMER0_BASE, TIMER_TIMA_TIMEOUT);
    TimerIntDisable(TIMER0_BASE, TIMER_TIMA_TIMEOUT);
    if(up) {
        count++;
    }
    else {
        count--;
    }
    TimerIntEnable(TIMER0_BASE, TIMER_TIMA_TIMEOUT);
}

void Timer1IntHandler(void) {
    TimerIntClear(TIMER1_BASE, TIMER_TIMA_TIMEOUT);
    TimerIntDisable(TIMER1_BASE, TIMER_TIMA_TIMEOUT);
    display(digit);
    TimerIntEnable(TIMER1_BASE, TIMER_TIMA_TIMEOUT);
}

void configureTimers(void) {
    SysCtlPeripheralEnable(SYSCTL_PERIPH_TIMER0);
    SysCtlPeripheralEnable(SYSCTL_PERIPH_TIMER1);
    TimerConfigure(TIMER0_BASE, TIMER_CFG_PERIODIC);
    TimerConfigure(TIMER1_BASE, TIMER_CFG_PERIODIC);
    TimerClockSourceSet(TIMER0_BASE, TIMER_CLOCK_SYSTEM);
    TimerClockSourceSet(TIMER1_BASE, TIMER_CLOCK_SYSTEM);
    TimerLoadSet(TIMER0_BASE, TIMER_A, 16000000);
    TimerLoadSet(TIMER1_BASE, TIMER_A, 88888);
    TimerIntRegister(TIMER0_BASE, TIMER_A, Timer0IntHandler);
    TimerIntRegister(TIMER1_BASE, TIMER_A, Timer1IntHandler);
    TimerIntClear(TIMER0_BASE, TIMER_TIMA_TIMEOUT);
    TimerIntClear(TIMER1_BASE, TIMER_TIMA_TIMEOUT);
    TimerIntEnable(TIMER0_BASE, TIMER_TIMA_TIMEOUT);
    TimerIntEnable(TIMER1_BASE, TIMER_TIMA_TIMEOUT);
    TimerEnable(TIMER0_BASE, TIMER_A);
    TimerEnable(TIMER1_BASE, TIMER_A);
}

void configurePins(void) {
    SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOD);
    SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOE);
    SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOF);
    GPIOPinTypeGPIOInput(GPIO_PORTF_BASE, GPIO_PIN_4);
    GPIOPinTypeGPIOOutput(GPIO_PORTD_BASE, GPIO_PIN_0 | GPIO_PIN_1 | GPIO_PIN_2 | GPIO_PIN_3);
    GPIOPinTypeGPIOOutput(GPIO_PORTE_BASE, GPIO_PIN_1 | GPIO_PIN_2 | GPIO_PIN_3);
    GPIOPadConfigSet(GPIO_PORTF_BASE, GPIO_PIN_4, GPIO_STRENGTH_4MA, GPIO_PIN_TYPE_STD_WPU);
//    GPIOPadConfigSet(GPIO_PORTD_BASE, GPIO_PIN_0 | GPIO_PIN_1 | GPIO_PIN_2 | GPIO_PIN_3, GPIO_STRENGTH_2MA, GPIO_PIN_TYPE_STD);
//    GPIOPadConfigSet(GPIO_PORTE_BASE, GPIO_PIN_1 | GPIO_PIN_2 | GPIO_PIN_3, GPIO_STRENGTH_2MA, GPIO_PIN_TYPE_STD);
    GPIOIntRegister(GPIO_PORTF_BASE, SW1IntHandler);
    GPIOIntTypeSet(GPIO_PORTF_BASE, GPIO_PIN_4, GPIO_FALLING_EDGE);
    GPIOIntClear(GPIO_PORTF_BASE, GPIO_PIN_4);
    GPIOIntEnable(GPIO_PORTF_BASE, GPIO_PIN_4);
}

/**
 * main.c
 */
int main(void)
{
    configureSysTick();
    configurePins();
    configureTimers();
    IntMasterEnable();
    while(1) {

    }
}
