#!/usr/bin/awk -f

# Bad solution.
# Just wanted to get it done already without much thought.

function sum_array(array, _sum) {
	for (x = 1; x <= length(array); ++x) {
		_sum += array[x]
	}

	return _sum
}

BEGIN {
	max_sum = 0
}

{
	for (x = 1; x <= NF; ++x) {
		array[x] = $x
	}

	array_length = length(array)
	array_sum += sum_array(array)

	if (array_length == 1) {
		printf "%s YES\n", FILENAME

		if (array_sum > max_sum) {
        	max_sum = array_sum
        }

		nextfile
	}

	if (FNR == 1) {
		sum[2] += array[1]
		sum[3] += array[array_length]

		for (x = 1; x <= array_length; ++x) {
			sum[1] += array[x]
		}
	} else if (FNR != 1 && FNR != array_length) {
		sum[2] += array[1]
		sum[3] += array[array_length]
	} else if (FNR == array_length) {
		sum[2] += array[1]
        sum[3] += array[array_length]

		for (x = 1; x <= array_length; ++x) {
			sum[4] += array[x]
		}

		if (sum[1] == sum[2] && sum[1] == sum[3] && sum[1] == sum[4]) {
			printf "%s YES\n", FILENAME
		} else {
			printf "%s NO\n", FILENAME
		}

		if (array_sum > max_sum) {
			max_sum = array_sum
		}

		sum[1] = 0
		sum[2] = 0
		sum[3] = 0
		sum[4] = 0
		array_sum = 0
		delete array
	}
}

END {
	print max_sum
}
