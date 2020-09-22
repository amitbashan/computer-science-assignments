.model small
.stack 100h

.data
	A dw -43, 1254, -235, -12, 63
	N equ $ - A
	sum dw 0

.code
	mov ax, @data
	mov ds, ax
	
	xor bx, bx

	_loop:
		xor ax, ax
		cmp bx, N
		je done
		mov ax, A[bx]
		add sum, ax
		add bx, 2
		jmp _loop

	done:
		.exit
end
