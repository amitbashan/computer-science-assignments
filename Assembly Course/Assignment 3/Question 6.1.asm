.model small
.stack 100h

.data
	A db -5, 35, 25, -12, 63
	N equ $ - A
	sum db 0

.code
	mov ax, @data
	mov ds, ax

	xor bx, bx

	_loop:
		cmp bx, N
		je done
		mov al, A[bx]
		add sum, al
		inc bx
		jmp _loop

	done:
		.exit
end
