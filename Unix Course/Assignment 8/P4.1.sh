#!/bin/bash

function get_column() {
	while read -r -a array; do
		value=${array[$2 - 1]}

		if [ -z "$value" ]; then
			echo -n "nil "
		else
			echo -n "$value "
		fi
	done < "$1"
}

function max() {
	echo $(($1 > $2 ? $1 : $2))
}

read -r -a i_column <<< "$(get_column "$1" "$2")"
read -r -a j_column <<< "$(get_column "$1" "$3")"
max_column=$(max ${#i_column[@]} ${#j_column[@]})
side=0

for ((i = 0; i < max_column; ++i)); do
	x=${i_column[$i]}
	y=${j_column[$i]}

	if ((i == max_column - 1)); then
		result="YES"

		if [ -z "$quotient" ]; then
			result="NO"
		fi

		break
	fi

	if [ "$x" = "nil" ] || [ "$y" = "nil" ]; then
		continue
	fi

	if ((y % x == 0)) && ((side == 0)); then
		side=1
	elif ((x % y == 0)) && ((side == 0)); then
		side=2
	fi

	if ((y % x == 0)) && ((side == 1)); then
		if [ -z "$quotient" ]; then
			quotient=$((y / x))
		elif ((quotient != y / x)); then
			result="NO"
			break
		fi
	elif ((x % y == 0)) && ((side == 2)); then
		if [ -z "$quotient" ]; then
			quotient=$((x / y))
		elif ((quotient != x / y)) && [ -n "$quotient" ]; then
			result="NO"
			break
		fi
	else
		result="NO"
		break
	fi
done

echo "$result"
