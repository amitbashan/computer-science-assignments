#!/bin/bash

echo -n "Enter parameters in the format d1@d2 "
IFS=@ read d1 d2

function evaluate_contents() {
	d1_contents=`find $d1 | tail -n +2`
	d2_contents=`find $d2 | tail -n +2`
	d1_array=($d1_contents)
	d2_array=($d2_contents)
}

evaluate_contents

for ((i = 0; i < ${#d1_array[@]}; ++i)); do
	for ((k = 0; k < ${#d2_array[@]}; ++k)); do
		if [ "${d1_array[i]:${#d1}}" = "${d2_array[k]:${#d2}}" ]; then
			if [[ -d ${d2_array[k]} ]] && [[ -d ${d1_array[i]} ]]; then
				rm -r ${d1_array[i]}
				evaluate_contents
			elif [[ -f ${d2_array[k]} ]] && [[ -f ${d1_array[i]} ]]; then
				rm ${d1_array[i]}
				evaluate_contents
			fi
		fi
	done
done
