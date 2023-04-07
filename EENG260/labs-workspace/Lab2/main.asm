		.thumb
		.global main
; Your constants go here
aSystemControlBase: .field 0x400FE000,32 ; Base address for the System Control registers (which includes RCGCGPIO)
bit5: .equ 0x20 ; bit 5 enables GPIO port F
oRCGCGPIO: .equ 0x608 ; offset for RCGCGPIO from base System Control registers address
aGPIOFBase: .field 0x40025000,32 ; Base address for GPIO Port F registers (APB)
pin2: .equ 0x02 ; bit 2 high only, for setting pin2 direction, etc.
pin4: .equ 0x10 ; bit 4 high only, for setting pin4 pull-up, etc.
oGPIODIR: .equ 0x400 ; offset for GPIODIR (pin direction) from any GPIO port base address
oGPIODEN: .equ 0x51C ; offset for GPIODEN (digital I/O) from any GPIO port base address
oGPIOPUR: .equ 0x510 ; offset for GPIOPUR (pull-up resistor) from any GPIO port base address
oGPIOp4Read: .equ 0x040 ; offset for GPIODATA from any GPIO port base address, further offset to mask pin 4 to allow read
oGPIOp2Write: .equ 0x008 ; offset for GPIODATA from any GPIO port base address, further offset to mask pin 2 to allow write

main:	.asmfunc
; Your code goes here
		LDR R0, aSystemControlBase
		MOV R1, #bit5
		STR R1, [R0, #oRCGCGPIO]

		LDR R0, aGPIOFBase
		MOV R1, #pin2
		STR R1, [R0, #oGPIODIR]
		STR R1, [R0, #oGPIOp2Write]

		ADD R1, #pin4
		STR R1, [R0, #oGPIODEN]
		MOV R2, #pin2
		MOV R1, #pin4
		STR R1, [R0, #oGPIOPUR]

switch:	LDR R1, [R0, #oGPIOp4Read]
		CMP R1, #0
		BEQ on
		MOV R2, #0
		STR R2, [R0, #oGPIOp2Write]
		B switch

on:		MOV R2, #pin2
		STR R2, [R0, #oGPIOp2Write]
		B switch

loop:	MOV R0, R0
		B loop
		.endasmfunc
		.end

