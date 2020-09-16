; Sorry for the ugly code, just wanted to get it done already

.model small
.stack 100h

.data
	array db -32, 52, 66, -22, 12
	N equ $ - array
	numberString db 7 dup('$')
.code
	mov ax, @data
	mov ds, ax

	mov si, offset array[N - 1] ; Current max value
	mov di, offset array[N - 2] ; Index

	_loop:
		cmp di, offset array
		jl done
		mov al, [si]
		mov ah, [di]
		cmp al, ah
		jg _end
		mov si, di

		_end:
			dec di
			jmp _loop

	done:
		; SI now points to the max value
		mov di, offset array[N - 1] ; DI now points to the last value of the array
		; Swap values
		mov al, [di]
		mov ah, [si]
		mov [di], ah
		mov [si], al
		; Print array
		xor di, di
		mov bl, 10

		print_loop:
			cmp di, N
			je exit
			mov al, array[di]
			mov si, offset numberString + 5
			cmp al, 0
			jge next
			neg al

			next:
				xor ah, ah
				div bl
				add ah, '0'
				mov [si], ah
				dec si
				cmp al, 0
				jne next
				cmp array[di], 0
				jge sof
				mov byte ptr [si], '-'
				dec si

			sof:
				; Finally print the string
				inc si
				mov ah, 9
				mov dx, si
				int 21h
				cmp di, N - 1
				je reset_numberString

				; Add some fancy formatting to make the output readable
				format:
					mov ah, 2
					mov dl, ','
					int 21h
					mov ah, 2
					mov dl, ' '
					int 21h

				reset_numberString:
					xor bx, bx

					reset_loop:
						cmp bx, 7
						jne continue
						inc di
						jmp print_loop

						continue:
							mov numberString[bx], '$'
							inc bx
							jmp reset_loop

	exit:
		.exit
end