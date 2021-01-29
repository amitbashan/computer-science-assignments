#!/bin/bash

cd exams/"$1"/sem-"$2" || exit
rooms=($(find . -type f | sort -bn))

function check_room() {
	local lines
	local output

	while IFS= read -r line; do
		lines+=("$line")
	done < "$1"

	for ((x = 0; x < ${#lines[@]}; ++x)); do
		date=$(echo "${lines[$x]}" | cut -f1 -d ':')
		occurrences=$(grep -c "$date" < "$1")

		if ((occurrences > 2)); then
			output+="$date
"
		fi
	done

	echo "$output" | sort -bn | uniq | tail -n +2 | xargs
}

for room in "${rooms[@]}"; do
	result=$(check_room "$room")

	if [ -n "$result" ]; then
		echo "${room:2}:$result"
	fi
done
