.model small
.stack 100h

.data

.code
	mov ax, @data
	mov ds, ax

	push 17
	call is_prime_number ; AL = 1
	jmp _exit

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

	_exit:
		.exit
end
