#!/bin/bash

echo -n "Enter parameters in the format file-num1-num2:c1-c2:d1-d2 "

# Ugly, I know. I just wanna finish the assignment already.
IFS=: read part1 part2 part3
IFS=-
part1_array=($part1)
part2_array=($part2)
part3_array=($part3)
lines=`sed -n ${part1_array[1]},${part1_array[2]}p ${part1_array[0]}`
IFS=$'\n'

for line in $lines; do
	a=`echo $line | cut -c ${part2_array[0]}-${part2_array[1]}`
	b=`echo $line | cut -f ${part3_array[0]}-${part3_array[1]} -d " "`

	echo "$a $b"
done
