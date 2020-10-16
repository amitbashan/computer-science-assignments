.model small
.stack 100h

.data
	A db 254, 17, 99, 113, 5
	N dw 5	; Can also be expressed as "N equ $ - A".

.code
	mov ax, @data
	mov ds, ax

	push N
	push offset A
	call highest_prime_number ; AH = 0x71 (113)

	.exit

	highest_prime_number PROC NEAR
		push bp
		mov bp, sp
		xor dh, dh ; Current max prime number.
		mov bx, [bp + 4] ; Array offset.
		mov cx, [bp + 6] ; Array size.
		xor si, si ; Counter

		highest_prime_number_loop:
			cmp si, cx
			je highest_prime_number_done
			mov di, bx
			add di, si
			push bx
			push [di]
			call is_prime_number
			pop bx
			test al, al ; Decided to use this instead of "cmp ah, 0", saves more bytes, and it's as fast.
			jz highest_prime_number_skip
			cmp dh, [di]
			jge highest_prime_number_skip
			mov dh, [di]

			highest_prime_number_skip:
				inc si
				jmp highest_prime_number_loop

		highest_prime_number_done:
			mov ah, dh
			pop bp
			ret 4
	highest_prime_number ENDP

	is_prime_number PROC NEAR
		push bp
		mov bp, sp
		mov al, [bp + 4] ; Number.
		cmp al, 2
		jl not_prime
		je prime
		mov bl, 2 ; Divisor/Counter.

		is_prime_number_loop:
			cmp bl, al
			jg prime
			xor ah, ah
			div bl
			test ah, ah ; Decided to use this instead of "cmp ah, 0", saves more bytes, and it's as fast.
			jz not_prime
			inc bl
			jmp is_prime_number_loop

		not_prime:
			xor al, al
			jmp is_prime_number_done

		prime:
			mov al, 1

		is_prime_number_done:
			pop bp
			ret 2
	is_prime_number ENDP
end
