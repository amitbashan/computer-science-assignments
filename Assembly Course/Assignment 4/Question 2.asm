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
	mov bx, N - 1

	_loop:
		cmp bx, 0
		jl done
		shl A[bx], k
		jnc continue
		rcl A[bx - 1], 1
		dec bx

		continue:
			dec bx
			jmp _loop

	done:
		.exit
end