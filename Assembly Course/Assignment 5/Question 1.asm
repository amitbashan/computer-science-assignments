.model small
.stack 100h

.data
	number dw -2584

.code
	mov ax, @data
	mov ds, ax
	
	push number
	call print_signed_number
	jmp _exit

	print_signed_number PROC NEAR
		push bp
		mov bp, sp
		mov ax, [bp + 4]
		mov si, ax
		mov bx, 10
		xor cx, cx
		cmp ax, 0
		jge next
		neg ax

		next:
			xor dx, dx
			div bx
			add dx, '0'
			push dx
			inc cx
			cmp ax, 0
			jne next
			cmp si, 0
			jge _end
			push '-'
			inc cx 

		_end:
			cmp cx, 0
			je return
			pop dx
			mov ah, 2
			int 21h
			dec cx
			jmp _end

			return:
				pop bp
				ret 2
		
	print_signed_number ENDP

	_exit:
		.exit
end