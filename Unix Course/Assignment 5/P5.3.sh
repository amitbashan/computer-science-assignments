#!/bin/bash

for file_name in "$@"; do
	contents=$(tr -s '[:space:]' < "$file_name" | tr '[:space:]' '\n')
	unique_words=$(echo "$contents" | sort | uniq -c | wc -l | tr -d '[:space:]')
	repetitions=$(echo "$contents" | uniq -c | sort -bnr)
	read -r -a array <<< "$repetitions"
	echo "$file_name $unique_words ${array[0]}"
done
