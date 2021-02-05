#!/bin/bash

file_name=$1
i=$2
j=$3
k=$4
l=$5
sum=0
lines=`cat $file_name | tail -n $l | head -n $((l - k + 1))`
IFS=$'\n'
lines_array=($lines)

for ((x = 0; x < ${#lines_array[@]}; ++x)); do
	IFS=' '
	line=${lines_array[$x]}
	line_array=($line)
	
	for ((y = i - 1; y < j; ++y)); do
		current_number=${line_array[$y]}
		((sum += current_number))
	done
done

echo $sum
