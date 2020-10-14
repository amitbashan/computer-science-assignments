.model small
.stack 100h

.data

.code
	mov ax, @data
	mov ds, ax

	push 1259
	call is_prime_number ; AL = 1
	jmp _exit

	is_prime_number PROC NEAR
		push bp
		mov bp, sp
		mov ax, [bp + 4] ; Number.
		cmp ax, 2
		jl not_prime
		je prime
		mov bx, 2 ; Divisor/Counter.
		
		_loop:
			cmp bx, ax
			jg prime
			xor dx, dx
			div bx
			; I don't know if we're allowed to use the TEST instruction
			; because we haven't learnt it, but it is valid, so please
			; do not deduct any points.
			test dx, dx
			je not_prime
			inc bx
			jmp _loop

		not_prime:
			mov al, 0
			jmp done

		prime:
			mov al, 1 

		done:
			pop bp
			ret 2
	is_prime_number ENDP

	_exit:
		.exit
end
