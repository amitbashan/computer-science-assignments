.model small
.stack 100h

.data
	A db 12, 5, 'A', 0Fh, -1
	N equ $ - A
	k equ 1

.code
	mov ax, @data
	mov ds, ax

	xor ax, ax
	xor bx, bx

	_loop:
		cmp bx, N
		je done
		shl A[bx], k
		inc bx
		jmp _loop

	done:
		.exit
end