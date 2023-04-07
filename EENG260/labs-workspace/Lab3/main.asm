		.thumb
		.global main
; Your constants go here
GPIOUnlock: .field 0x4C4F434B,32
aSystemControlBase: .field 0x400FE000,32 ; Base address for the System Control registers (which includes RCGCGPIO)
bit3: .equ 0x08 ; bit 3 enables GPIO port D
bit5: .equ 0x20 ; bit 5 enables GPIO port F
oRCGCGPIO: .equ 0x608 ; offset for RCGCGPIO from base System Control registers address
oRCC: .equ 0x060 ; offset for RCC from base System Control registers address
aGPIOFBase: .field 0x40025000,32 ; Base address for GPIO Port F registers (APB)
aGPIODBase: .field 0x40007000,32 ; Base address for GPIO Port D registers (APB)
pin0: .equ 0x01 ; bit 0 high only
pin1: .equ 0x02 ; bit 1 high only
pin2: .equ 0x04 ; bit 2 high only, for setting pin2 direction, etc.
pin3: .equ 0x08 ; bit 3 high only
pin4: .equ 0x10 ; bit 4 high only, for setting pin4 pull-up, etc.
oGPIODIR: .equ 0x400 ; offset for GPIODIR (pin direction) from any GPIO port base address
oGPIODEN: .equ 0x51C ; offset for GPIODEN (digital I/O) from any GPIO port base address
oGPIOPUR: .equ 0x510 ; offset for GPIOPUR (pull-up resistor) from any GPIO port base address
oGPIODR4R: .equ 0x504 ; offset for GPIODR4R (4 mA strength) from any GPIO port base address
oGPIOLOCK: .equ 0x520 ; offset for GPIOLOCK (write access) from any GPIO port base address
oGPIOCR: .equ 0x524 ; offset for GPIOCR (committing register values) from any GPIO port base address
oGPIOp0Read: .equ 0x004 ;
oGPIOp4Read: .equ 0x040 ; offset for GPIODATA from any GPIO port base address, further offset to mask pin 4 to allow read
oGPIODWrite: .equ 0x03C ; offset for GPIODATA from any GPIO port base address, further offset to mask pin 2 to allow write

main:	.asmfunc
; Your code goes here
		LDR R0, aSystemControlBase
		MOV R1, #bit5
		ORR R1, R1, #bit3
		STR R1, [R0, #oRCGCGPIO]

		LDR R0, aGPIOFBase
		MOV R1, #pin0
		LDR R2, GPIOUnlock
		STR R2, [R0, #oGPIOLOCK]
		MOV R2, #0xFF
		STR R2, [R0, #oGPIOCR]
		ORR R1, R1, #pin4
		STR R1, [R0, #oGPIODEN]
		STR R1, [R0, #oGPIOPUR]

		LDR R0, aGPIODBase
		MOV R1, #0x0F
		STR R1, [R0, #oGPIODEN]
		STR R1, [R0, #oGPIODR4R]
		STR R1, [R0, #oGPIODIR]

		MOV R2, #0x0
		MOV R3, #0x0
		MOV R4, #0x0
		MOV R5, #0x0
		MOV R6, #0x00
		LDR R0, aGPIOFBase
		LDR R1, aGPIODBase

switch:	LDR R3, [R0, #oGPIOp4Read]
		CMP R2, R3
		BNE uc
		LDR R5, [R0, #oGPIOp0Read]
		CMP R4, R5
		BNE dc
		B switch

uc:		BL wait
		MOV R2, R3
		CMP R3, #0
		BEQ up
		B switch

dc:		BL wait
		MOV R4, R5
		CMP R5, #0
		BEQ down
		B switch

up:		ADD R6, #1
		STR R6, [R1, #oGPIODWrite]
		B switch

down:	SUB R6, #1
		STR R6, [R1, #oGPIODWrite]
		B switch
.endasmfunc

.align
wait:	.asmfunc
		MOV 	R7, #0
		MOVW	R8, #0xE010
		MOVT	R8, #0xE000
		STR		R7, [R8]
		ADD		R9, R8, #0x08
		STR		R7, [R9]
		MOVW	R10, #0x0000
		MOVT	R10, #0x0000
		SUB		R9, R8, #0x04
		STR		R10, [R9]
		MOV		R10, #5
		STR		R10, [R9]

wloop:
		BEQ 	wloop
		BX		LR
.endasmfunc
.end

