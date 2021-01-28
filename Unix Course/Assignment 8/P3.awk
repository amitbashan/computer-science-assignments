#!/usr/bin/awk -f

function max(a, b) {
	return a > b ? a : b
}

function read_file(file, 		tmp, save_rs)
{
    save_rs = RS
    RS = "^$"
    getline tmp < file
    close(file)
    RS = save_rs

    return tmp
}

# Everything after the two parameters `file1` and `file2` are LOCAL VARIABLES!
function matrix_difference(file1, file2, 		content1, content2, rows1_count, rows2_count, rows1, rows2, columns1_count, columns2_count, max_row, max_column, matrix1, matrix2, x, y) {
	content1 = read_file(file1)
	content2 = read_file(file2)

	rows1_count = split(content1, rows1, "\n")

	for (x = 1; x < rows1_count; ++x) {
		columns1_count = split(rows1[x], columns1)

		if (max_column < columns1_count) {
			max_column = columns1_count
		}

		for (y = 1; y <= columns1_count; ++y) {
			matrix1[x, y] = columns1[y]
		}
	}

	rows2_count = split(content2, rows2, "\n")

	for (x = 1; x < rows2_count; ++x) {
		columns2_count = split(rows2[x], columns2)

		if (max_column < columns2_count) {
			max_column = columns2_count
		}

		for (y = 1; y <= columns2_count; ++y) {
			matrix2[x, y] = columns2[y]
		}
	}

	max_row = max(rows1_count, rows2_count)

	for (x = 1; x < max_row; ++x) {
		for (y = 1; y <= max_column; ++y) {
			if (matrix1[x, y] == "" && matrix2[x, y] == "") {
				continue
			}

			if (matrix1[x, y] != "") {
				printf "%s ", matrix1[x, y] - matrix2[x, y] > "tmp"
			}
		}

		printf "\n" > "tmp"
	}

	close("tmp")
}

{
	if (FNR == 1) {
		filenames=filenames "-" FILENAME

		printf "The matrix %s is:\n", FILENAME
	}

	print $0
}

END {
	filenames = substr(filenames, 2)

	printf "The matrix difference %s is:\n", filenames

	filenames_count = split(filenames, filenames_array, "-")

	for (i = 1; i <= filenames_count; ++i) {
		if (i == 1) {
			matrix_difference(filenames_array[i], filenames_array[i + 1])
			++i
		} else {
			matrix_difference("tmp", filenames_array[i])
		}
	}

	result = read_file("tmp")

	printf "%s", result

	# Not sure if we're supposed to delete
	# `tmp` file. Document didn't say anything
	# about it so I just left it the way it is.
}
