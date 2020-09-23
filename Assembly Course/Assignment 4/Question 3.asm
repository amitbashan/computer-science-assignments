.model small
.stack 100h

.data
	A dw 51219
	yes_string db 'YES', '$'
	no_string db 'NO', '$'
.code
	mov ax, @data
	mov ds, ax

	mov ax, A
	xor cx, cx

	_loop:
		cmp cx, 8
		je continue
		sal al, 1
		rcr bl, 1
		inc cx
		jmp _loop

	continue:
		xor ah, bl
		cmp ah, 0
		je print_yes
		mov ah, 9
		mov dx, offset no_string
		int 21h
		jmp done

	print_yes:
		mov ah, 9
		mov dx, offset yes_string
		int 21h

	done:
		.exit
end
