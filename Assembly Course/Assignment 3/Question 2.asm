.model small
.stack 100h

.data
	num dw 65535
	numString db 5 dup('$')

.code
	mov	ax,	@data
	mov	ds,	ax

	mov ax, num
	mov bx, 10
	mov si, offset numString + 4

	_loop:
		xor dx, dx
		div bx
		add dl, '0'
		mov [si], dl
		dec si
		cmp ax, 0
		jne _loop
		inc si
		mov ah, 9
		mov dx, si
		int 21h
	.exit
end
