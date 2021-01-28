#!/usr/bin/awk -f

function max(a, b) {
	return a > b ? a : b
}

function matrix_difference(file1, file2) {
	save_rs = RS
	RS = "^$"
	getline content1 < file1
	close(file1)
	getline content2 < file2
	close(file2)
	RS = save_rs

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

		print > "tmp"
	}
}

# Tests
#
# BEGIN {
# 	matrix_difference("tests/2/A", "tests/2/B")
# }
