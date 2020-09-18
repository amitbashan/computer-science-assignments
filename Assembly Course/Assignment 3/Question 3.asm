.model small
.stack 100h

.data
	array db 1, -2, 3, -4, -5
	N equ $ - array
	number_string db 4 dup(' '), '$'
	format_string db ', $'

.code
	mov ax, @data
	mov ds, ax

	xor ax, ax ; Max value
	xor bx, bx ; Loop counter
	xor si, si ; Max value index

	find_max_value_loop:
		cmp bx, N ; Check if done scanning array
		je done
		cmp al, array[bx] ; Check if current max value is greater than current value in loop
		jge skip_switch
		mov al, array[bx] ; If current max value is not greater than current value, switch between them
		mov si, bx ; Store max value index for swapping

		skip_switch:
			inc bx ; Increment index
			jmp find_max_value_loop

	done:
		xchg al, array[N - 1] ; Swap max value with last value in array
		xchg array[si], al ; Swap max value's index with last value in array

		xor bx, bx ; Inner loop counter
		mov cl, 10 ; Divisor
		xor di, di ; Outer loop counter

		print_loop:
			cmp di, N ; Check if done going over the array
			je _exit
			mov al, array[bx] ; Current value
			mov si, offset number_string + 3 ; Pointing SI to the end of number_string
			cmp al, 0 ; If number is negative, make it positive (to not mess with two's complement)
			jge next
			neg al

			next:
				xor ah, ah ; AH must be nulled when the divisor is a byte
				div cl ; Now AH contains the remainder
				add ah, '0' ; Converting the digit to an ASCII code
				mov [si], ah ; Modifying number_string
				dec si ; Decrement SI for next iteration
				cmp al, 0 ; Check if it's the loop's last iteration
				jne next ; If not, jump back!
				cmp array[bx], 0 ; Was the number negative?
				jge _end ; If it wasn't, print it already
				mov byte ptr [si], '-' ; Else, add a negative sign and then print
				dec si

			_end:
				inc si
				mov ah, 9 ; Asking DOS to print for us the string
				mov dx, si
				int 21h
				cmp di, N - 1 ; Check if we have printed the last value
				je skip_format ; If we did, skip the fancy string formatting
				mov dx, offset format_string
				int 21h
				
				skip_format:
					xor si, si
					inc bx
					inc di

			reset_number_string_loop:
				cmp si, 4
				je print_loop
				mov number_string[si], ' '
				inc si
				jmp reset_number_string_loop
	
	_exit:
		.exit
end
