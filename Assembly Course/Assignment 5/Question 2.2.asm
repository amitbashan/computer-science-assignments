.model small
.stack 100h

.data
	A dw 12, 5, 8, -1, 4
	B dw -2, 9, 0, 18, 3
	C dw 5 dup (?)

.code
	mov ax, @data
	mov ds, ax

	; We're not told to use the procedure, so just exit.
	jmp _exit

	array_sum PROC NEAR
		push bp
		mov bp, sp
		; AX is reserved for signed_sum procedure.
		mov bx, [bp + 4] ; First array offset.
		mov cx, [bp + 6] ; Second array offset.
		mov dx, [bp + 8] ; Third array offset.
		mov si, [bp + 10] ; Array size.
		sub si, 2 ; If the size as the starting offset it will point to a value outside the array, so we subtract 2 bytes from the size.

		array_sum_loop:
			cmp si, 0
			jl array_sum_done
			mov di, bx
			add di, si
			push [di]
			mov di, cx
			add di, si
			push [di]
			call signed_sum
			mov di, dx
			add di, si
			mov [di], ax
			sub si, 2
			jmp array_sum_loop

		array_sum_done:
			pop bp
			ret 8
	array_sum ENDP

	; Result will stored in AX.
	signed_sum PROC NEAR
		push bp
		mov bp, sp
		mov ax, [bp + 4]
		add ax, [bp + 6]
		pop bp
		ret 4
	signed_sum ENDP

	_exit:
		.exit
end
