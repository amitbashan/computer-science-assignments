.model small
.stack 100h

.data
	A dw 12, 5, 8, -1, 4
	B dw -2, 9, 0, 18, 3
	C dw 5 dup (?)

.code
	mov ax, @data
	mov ds, ax

	push A ; 12
	push B ; -2
	call signed_sum ; AX = 0xA
	
	.exit

	; Result will stored in AX.
	signed_sum PROC NEAR
		push bp
		mov bp, sp
		mov ax, [bp + 4]
		add ax, [bp + 6]
		pop bp
		ret 4
	signed_sum ENDP
end