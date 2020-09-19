.model small
.stack 100h

.data
	A db -3, 0, 3, 5
	N1 equ $ - A
	B db -2, -1, 2, 7, 21
	N2 equ $ - B
	C db N1 + N2 dup(0) ; Should be: -3, -2, -1, 0, 2, 3, 5, 7, 21
	N3 equ $ - C
	number_string db 4 dup(' '), '$'
	format_string db ', $'
	a_array_string db 'A array: $'
	b_array_string db 'B array: $'
	c_array_string db 'C array: $'

.code
	mov ax, @data
	mov ds, ax

	xor bx, bx ; A and B loop counter
	xor si, si ; C loop counter

	_loop:
		cmp bx, N1
		je move_remaining_b_values
		cmp bx, N2
		je move_remaining_a_values
		mov al, A[bx]
		mov ah, B[bx]
		cmp al, ah
		jl move_a_value
		mov C[si], ah
		mov C[si + 1], al
		jmp _end_loop

		move_a_value:
			mov C[si], al
			mov C[si + 1], ah

		_end_loop:
			inc bx
			add si, 2
			jmp _loop

		move_remaining_a_values:
			cmp bx, N1
			je done
			mov al, A[bx]
			mov C[si], al
			inc bx
			inc si
			jmp move_remaining_a_values

		move_remaining_b_values:
			cmp bx, N2
			je done
			mov ah, B[bx]
			mov C[si], ah
			inc bx
			inc si
			jmp move_remaining_b_values

	done:
		; Printing A array

		mov ah, 9
		mov dx, offset a_array_string
		int 21h
		xor bx, bx ; Inner loop counter
		mov cl, 10 ; Divisor
		xor di, di ; Outer loop counter

		a_print_loop:
			cmp di, N1 ; Check if done going over the array
			je print_b
			mov al, A[bx] ; Current value
			mov si, offset number_string + 3 ; Pointing SI to the end of number_string
			cmp al, 0 ; If number is negative, make it positive (to not mess with two's complement)
			jge a_next
			neg al

			a_next:
				xor ah, ah ; AH must be nulled when the divisor is a byte
				div cl ; Now AH contains the remainder
				add ah, '0' ; Converting the digit to an ASCII code
				mov [si], ah ; Modifying number_string
				dec si ; Decrement SI for next iteration
				cmp al, 0 ; Check if it's the loop's last iteration
				jne a_next ; If not, jump back!
				cmp A[bx], 0 ; Was the number negative?
				jge a_end ; If it wasn't, print it already
				mov byte ptr [si], '-' ; Else, add a negative sign and then print
				dec si

			a_end:
				inc si
				mov ah, 9 ; Asking DOS to print for us the string
				mov dx, si
				int 21h
				cmp di, N1 - 1 ; Check if we have printed the last value
				je a_skip_format ; If we did, skip the fancy string formatting
				mov dx, offset format_string
				int 21h
				
				a_skip_format:
					xor si, si
					inc bx
					inc di

			a_reset_number_string_loop:
				cmp si, 4
				je a_print_loop
				mov number_string[si], ' '
				inc si
				jmp a_reset_number_string_loop

		; Printing B array

		print_b:
			; Printing newline
			mov dl, 10
			mov ah, 2
			int 21h
			mov dl, 13
			mov ah, 2
			int 21h
			mov ah, 9
			mov dx, offset b_array_string
			int 21h
			xor bx, bx ; Inner loop counter
			xor di, di ; Outer loop counter

			b_print_loop:
				cmp di, N2 ; Check if done going over the array
				je print_c
				mov al, B[bx] ; Current value
				mov si, offset number_string + 3 ; Pointing SI to the end of number_string
				cmp al, 0 ; If number is negative, make it positive (to not mess with two's complement)
				jge b_next
				neg al

				b_next:
					xor ah, ah ; AH must be nulled when the divisor is a byte
					div cl ; Now AH contains the remainder
					add ah, '0' ; Converting the digit to an ASCII code
					mov [si], ah ; Modifying number_string
					dec si ; Decrement SI for next iteration
					cmp al, 0 ; Check if it's the loop's last iteration
					jne b_next ; If not, jump back!
					cmp B[bx], 0 ; Was the number negative?
					jge b_end ; If it wasn't, print it already
					mov byte ptr [si], '-' ; Else, add a negative sign and then print
					dec si

				b_end:
					inc si
					mov ah, 9 ; Asking DOS to print for us the string
					mov dx, si
					int 21h
					cmp di, N2 - 1 ; Check if we have printed the last value
					je b_skip_format ; If we did, skip the fancy string formatting
					mov dx, offset format_string
					int 21h
					
					b_skip_format:
						xor si, si
						inc bx
						inc di

				b_reset_number_string_loop:
					cmp si, 4
					je b_print_loop
					mov number_string[si], ' '
					inc si
					jmp b_reset_number_string_loop

		; Printing C array

		print_c:
			; Printing newline
			mov dl, 10
			mov ah, 2
			int 21h
			mov dl, 13
			mov ah, 2
			int 21h
			mov ah, 9
			mov dx, offset c_array_string
			int 21h
			xor bx, bx ; Inner loop counter
			xor di, di ; Outer loop counter

			c_print_loop:
				cmp di, N3 ; Check if done going over the array
				je _exit
				mov al, C[bx] ; Current value
				mov si, offset number_string + 3 ; Pointing SI to the end of number_string
				cmp al, 0 ; If number is negative, make it positive (to not mess with two's complement)
				jge c_next
				neg al

				c_next:
					xor ah, ah ; AH must be nulled when the divisor is a byte
					div cl ; Now AH contains the remainder
					add ah, '0' ; Converting the digit to an ASCII code
					mov [si], ah ; Modifying number_string
					dec si ; Decrement SI for next iteration
					cmp al, 0 ; Check if it's the loop's last iteration
					jne c_next ; If not, jump back!
					cmp C[bx], 0 ; Was the number negative?
					jge c_end ; If it wasn't, print it already
					mov byte ptr [si], '-' ; Else, add a negative sign and then print
					dec si

				c_end:
					inc si
					mov ah, 9 ; Asking DOS to print for us the string
					mov dx, si
					int 21h
					cmp di, N3 - 1 ; Check if we have printed the last value
					je c_skip_format ; If we did, skip the fancy string formatting
					mov dx, offset format_string
					int 21h
					
					c_skip_format:
						xor si, si
						inc bx
						inc di

				c_reset_number_string_loop:
					cmp si, 4
					je c_print_loop
					mov number_string[si], ' '
					inc si
					jmp c_reset_number_string_loop

	_exit:
		.exit
end
