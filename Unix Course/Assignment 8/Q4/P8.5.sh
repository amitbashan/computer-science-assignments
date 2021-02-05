#!/bin/bash

# Converts trying of format `HH-MM` to minutes.
# Input needs to be valid. There are no checks.
function to_minutes() {
	IFS='-'

	read -r -a array <<< "$1"

	hours=${array[0]}
	minutes=${array[1]}
	((result = hours * 60 + minutes))

	echo "$result"
}

function check_exam() {
	IFS=':'

	read -r -a array <<< "$1"

	date1=${array[0]}
	end_time=$(to_minutes "${array[3]}")

	read -r -a array <<< "$2"

	date2=${array[0]}
	start_time=$(to_minutes "${array[2]}")

	if [ "$date1" = "$date2" ] && ((start_time - end_time <= 60)) && ((start_time - end_time > 0)); then
		return 0
	else
		return 1
	fi
}

# Not quite elegant but wanted
# to finish assignment already.

lines=()
output=""

while IFS= read -r line; do
	lines+=("$line")
done < "$1"

for ((x = 0; x < ${#lines[@]}; ++x)); do
	for ((y = 0; y < ${#lines[@]}; ++y)); do
		if check_exam "${lines[$x]}" "${lines[$y]}"; then
			date=$(echo "${lines[$x]}" | cut -f1 -d ':')
			output+="$date
"
		fi
	done
done

echo "$output" | sort -bn | uniq | tail -n +2
