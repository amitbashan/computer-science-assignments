.model small
.stack 100h

.data
	number db 54
	number_string db 3 dup(' '), '$'

.code
	mov ax, @data
	mov ds, ax

	mov al, number
	xor bx, bx
	mov ch, 2

	_loop:
		cmp al, 0
		je done
		xor ah, ah
		div ch
		cmp ah, 0
		jne _loop
		inc bh
		jmp _loop

	done:
		mov al, bh
		mov ch, 10
		mov si, offset number_string + 2

		print_loop:
			xor ah, ah
			div ch
			add ah, '0'
			mov [si], ah
			dec si
			cmp al, 0
			jne print_loop
			jmp _end
	
	_end:
		inc si
		mov ah, 9
		mov dx, si
		int 21h
	.exit
end
