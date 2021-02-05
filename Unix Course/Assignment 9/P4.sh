#!/bin/bash

file_name=$1
i=$2
j=$3
count=0

occurrences=`cat $file_name | tr '[:space:]' '[\n*]' | grep -v "^\s*$" | sort | uniq -c`
occurrences_array=($occurrences)

for ((x = 0; x < ${#occurrences_array[@]}; x += 2)); do
	if ((occurrences_array[x] >= i && occurrences_array[x] <= j)); then
		((++count))
	fi
done

echo $count
