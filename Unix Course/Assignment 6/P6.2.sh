#!/bin/bash

words=$(echo "$@" | awk -F '-dirs' '{print $1}' | xargs)
directories=$(echo "$@" | awk -F '-dirs' '{print $2}' | xargs)

for word in $words; do
	all=true
	echo -n "$word "

	for directory in $directories; do
		read -r -a occurrences <<< "$(grep -rl "\<$word\>" "$directory" | xargs)"
		echo -n "${#occurrences[@]} "

		if ((${#occurrences[@]} == 0)); then
			all=false
		fi
	done

	if $all; then
		echo -n "ALL"
	else
		echo -n "NOTALL"
	fi

	echo
done
