#!/bin/bash

# Sorry for the messy code.

for word in "$@"; do
	if ((${#word} % 2 != 0)); then
		continue
	fi

	read -r -a splitted <<< "$(echo "$word" | fold -w "$((${#word} / 2))" | tr '\n' '[:space:]')"
	read -r -a pairs1 <<< "$(echo "${splitted[0]}" | fold -w 2 | tr '\n' '[:space:]')"
	read -r -a pairs2 <<< "$(echo "${splitted[1]}" | fold -w 2 | tr '\n' '[:space:]')"

	for ((i = 0; i < ${#pairs1[@]}; ++i)); do
		filtered1=$(echo "${pairs1[$i]}" | tr -s '[:lower:]' | tr -s '0-9')
		filtered2=$(echo "${pairs2[$i]}" | tr -s '[:lower:]' | tr -s '0-9')

		if ((i == 0)) && ! [[ "${pairs1[0]}" =~ ^[+-]?[0-9]+$ ]]; then
			break
		fi

		if ((i % 2 == 0)) && [[ "${pairs1[$i + 1]}" =~ ^[+-]?[0-9]+$ ]]; then
			break
		else
			if ((${#filtered1} > 1)) && ((${#filtered2} > 1)); then
				break
			elif [ "${pairs1[$i]}" = "${pairs2[$i]}" ]; then
				if ((i == ${#pairs1[@]} - 1)); then
					echo "$word"
				fi
			else
				break
			fi
		fi
	done
done
