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
        cmp A[bx], '$'
        je done
        mov cl, A[bx]
        mov B[bx], cl
        inc bx
        jmp _loop

    done:
        .exit
end
