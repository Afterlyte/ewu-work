		.thumb
		.global main
; Your constants go here
arrayLocation:	.field 0x20000400,32 ; Example of creating a 32-bit value in ROM, containing the address of a location in RAM, that can be referenced using the label arrayLocation
countSize:		.equ 16 ; Example of setting up a constant that the assembler can swap out at compile time for a constant value (similar to using #define in C)
main:	.asmfunc
; Your code goes here
		LDR		R1, arrayLocation	; load array memory location from constant to R1
		MOVB	R0, #0x00			; set R0 to 0
store:	STRB 	R0, [R1]			; store value of R0 to value at current memory location of R1
		ADD 	R1, #1				; add 1 to the memory address of R1
		ADD		R0, #1				; add 1 to the value of R0
		CMP		R0, #countSize		; compare the value of R0 to the count size constant
		BNE		store				; branch to store if count size is not reached (loops until 16 loops have been done, 0-15)
		LDR		R1, arrayLocation	; load array memory location from constant back into R1
		MOVB	R2, #0x00			; set R2 to 0
		MOVB	R3, #0x00			; set R3 to 0
sum:	LDRB	R0, [R1]			; load value at current memory location of R1 to R0
		ADD		R3, R0				; add value of R0 to R3
		ADD		R1, #1				; add 1 to the memory address of R1
		ADD		R2, #1				; add 1 to the value of R2
		CMP		R2, #countSize		; compare the value of R2 to the count size constant
		BNE		sum					; branch to sum if count size is not reached (loops same amount of times)
loop:	MOV R0, R0					; loop for keeping debug program running
		B loop
		.endasmfunc
		.end
