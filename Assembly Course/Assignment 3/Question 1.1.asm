.model small
.stack 100H

.data
	A db '     This      is     a          test     $'
	B db 100 dup('$')

.code
	mov ax, @data
	mov ds, ax

	xor bx, bx
	xor cx, cx

	_loop:
		mov ah, A[bx]
		cmp ah, '$'
		je done
		inc bx
		cmp ah, ' '
		jne _loop
		inc cx
		jmp _loop

	done:
		.exit
end
