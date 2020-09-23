; We haven't learned procedures in assembly
; yet (push arguments onto stack, etc) so sadly, I cannot use it.
; Sorry for the ugly code control flow routine!

.model small
.stack 100h

.data
	number dw 234
	number_string db 4 dup(' '), '$'

.code
	mov ax, @data
	mov ds, ax

	mov bx, number
	xor cx, cx ; Manages the control flow, used by "check" routine.

	check:
		cmp cx, 0
		je part_0
		cmp cx, 1
		je part_0_continue
		cmp cx, 2
		je part_1
		cmp cx, 3
		je part_1_continue
		cmp cx, 4
		je part_2
		cmp cx, 5
		je part_2_continue
		cmp cx, 6
		je part_3
		cmp cx, 7
		je part_3_continue
		jg done

	part_0:
		mov dl, bh
		shr dl, 4
		jmp convert

		part_0_continue:
			mov ah, 2
			mov dl, dh
			int 21h

	part_1:
		mov dl, bh
		and dl, 0Fh
		jmp convert

		part_1_continue:
			mov ah, 2
			mov dl, dh
			int 21h

	part_2:
		mov dl, bl
		shr dl, 4
		jmp convert

		part_2_continue:
			mov ah, 2
			mov dl, dh
			int 21h

	part_3:
		mov dl, bl
		and dl, 0Fh
		jmp convert

		part_3_continue:
			mov ah, 2
			mov dl, dh
			int 21h

	jmp done

	; Routine that takes a digit (0 - 15) in DL register and outputs
	; it's ASCII hexadecimal representation in DH.
	; This routine does NOT modify DL.
	convert:
		inc cx
		mov dh, dl
		cmp dl, 10
		jnl convert_hex
		add dh, '0'
		jmp check

		convert_hex:
			add dh, 55 ; 'A' - 10
			jmp check

	done:
		.exit
end