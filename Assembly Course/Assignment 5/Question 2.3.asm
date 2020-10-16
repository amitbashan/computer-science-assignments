.model small
.stack 100h

.data
	A dw 12, 5, 8, -1, 4
	B dw -2, 9, 0, 18, 3
	C dw 5 dup (?)
	array_size equ 10
	array_length equ 5
	format_string db ', $'
	a_array_string db 'A array: $'
	b_array_string db 'B array: $'
	c_array_string db 'C array: $'

.code
	mov ax, @data
	mov ds, ax

	push array_size
	push offset C
	push offset B
	push offset A
	call array_sum

	mov ah, 9
	mov dx, offset a_array_string ; Could've made this into a procedure too but it seems to be unnecessary.
	int 21h
	push array_size
	push offset A
	call print_array
	call newline

	mov ah, 9
	mov dx, offset b_array_string
	int 21h
	push array_size
	push offset B
	call print_array
	call newline

	mov ah, 9
	mov dx, offset c_array_string
	int 21h
	push array_size
	push offset C
	call print_array

	.exit

	print_array PROC NEAR
		push bp
		mov bp, sp
		mov bx, [bp + 4] ; Array offset.
		mov cx, [bp + 6] ; Array size.
		sub cx, 2 ; Just a little ugly hack. Otherwise it will print the formatting string at the end too!
		add cx, bx ; Now it's the array's last value offset.

		print_array_loop:
			cmp bx, cx
			jg print_array_done
			push bx
			push cx
			push [bx]
			call print_signed_number
			pop cx
			pop bx
			cmp bx, cx
			je skip_format
			mov ah, 9
			mov dx, offset format_string
			int 21h

			skip_format:
				add bx, 2
				jmp print_array_loop

		print_array_done:
			pop bp
			ret 4
	print_array ENDP

	newline PROC NEAR
		push ax
		push dx
		mov ah, 2
		mov dl, 13
		int 21h
		mov dl, 10
		int 21h
		pop dx
		pop ax
		ret
	newline ENDP

	array_sum PROC NEAR
		push bp
		mov bp, sp
		; AX is reserved for signed_sum procedure.
		mov bx, [bp + 4] ; First array offset.
		mov cx, [bp + 6] ; Second array offset.
		mov dx, [bp + 8] ; Third array offset.
		mov si, [bp + 10] ; Array size.
		sub si, 2 ; If the size as the starting offset it will point to a value outside the array, so we subtract 2 bytes from the size.

		array_sum_loop:
			cmp si, 0
			jl array_sum_done
			mov di, bx
			add di, si
			push [di]
			mov di, cx
			add di, si
			push [di]
			call signed_sum
			mov di, dx
			add di, si
			mov [di], ax
			sub si, 2
			jmp array_sum_loop

		array_sum_done:
			pop bp
			ret 8
	array_sum ENDP

	; Result will stored in AX.
	signed_sum PROC NEAR
		push bp
		mov bp, sp
		mov ax, [bp + 4]
		add ax, [bp + 6]
		pop bp
		ret 4
	signed_sum ENDP

	print_signed_number PROC NEAR
		push bp
		mov bp, sp
		mov ax, [bp + 4]
		mov si, ax
		mov bx, 10
		xor cx, cx
		cmp ax, 0
		jge next
		neg ax

		next:
			xor dx, dx
			div bx
			add dx, '0'
			push dx
			inc cx
			cmp ax, 0
			jne next
			cmp si, 0
			jge _end
			push '-'
			inc cx 

		_end:
			cmp cx, 0
			je return
			pop dx
			mov ah, 2
			int 21h
			dec cx
			jmp _end

			return:
				pop bp
				ret 2
		
	print_signed_number ENDP
end
