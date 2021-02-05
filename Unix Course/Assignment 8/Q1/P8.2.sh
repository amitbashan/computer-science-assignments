#!/bin/bash

rows=0
columns=0
output=""

function max() {
	echo $(($1 > $2 ? $1 : $2))
}

function min() {
	echo $(($1 > $2 ? $2 : $1))
}

while read -r -a array; do
	if [ ${#array[@]} -gt $columns ]; then
		columns=${#array[@]}
	fi

	((++rows))
done < "$1"

x=$(min $rows $columns)
y=$(max $rows $columns)

for ((a = 1; a <= x; ++a)); do
	for ((b = 1; b <= y; ++b)); do
		if ((a == b)); then
			continue
		fi

		result=$(./P4.1.sh $1 $a $b)

		if [ "$result" = "YES" ]; then
			output+="$a $b
" # Weird way to insert a newline.
		fi
	done
done

if [ -z "$output" ]; then
	echo "None"
else
	echo "$output" | sort | tail -n +2
fi
