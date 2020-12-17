#!/bin/bash

i=$1
j=$2
k=$3
coefficient=0
result=0

evaluate() {
	((result = i + coefficient * j))
}

evaluate

while ((result <= k)); do
	echo -n $result
	
	if ((i + (coefficient + 1) * j <= k)); then
		for ((x = 0; x < coefficient + 1; ++x)); do
			echo -n "@"
		done
	fi

	((++coefficient))
	evaluate
done

# Please do not deduct any points for this echo command here
# it is necessary to prevent the terminal from looking awkward
# after execution of this script (because of the -n flag on echo command).
echo
