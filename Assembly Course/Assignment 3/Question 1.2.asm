.model small
.stack 100H

.data
    A db '     This      is     a          test     $'
    B db 100 dup('$')

.code
    mov ax, @data
    mov ds, ax
    xor ax, ax
    xor bx, bx
    xor cx, cx

    _loop:
        mov ah, A[bx]
        mov al, A[bx + 1]
        cmp ah, '$'
        je done
        cmp al, '$'
        je done
        cmp ah, ' '
        je continue
        inc bx
        jmp _loop

        continue:
            cmp al, ' '
            jne increment
            inc bx
            jmp _loop

        increment:
            inc cx
            inc bx
            jmp _loop

    done:
        .exit
end
