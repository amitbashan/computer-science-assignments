#!/usr/bin/awk -f

{
	# Next time just let me use GNU awk with ENDFILE
	# instead of writing an ugly hack.

	if (FNR == 1) {
		"wc -l " FILENAME " | xargs | cut -d ' ' -f 1" | getline count
	}

	sum = 0

	for (x = 1; x <= NF; ++x) {
    	array[x, NR] = $x
    }

	for (x = 0; x <= NF; ++x) {
		current_max = 0

		for (y = 1; y <= NR; ++y) {
			if (array[x, y] > current_max) {
				current_max = vector[x, y]
			} else if (array[x, y] == "") {
				break
			}
		}

		sum += current_max
	}

	if (FNR == count) {
		printf "%s:%s\n", FILENAME, sum
	}
}
