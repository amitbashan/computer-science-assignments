#include <stdio.h>
#include <limits.h>

void print_array(const int array[], int start_index, int end_index) {
	if (start_index == end_index || start_index > end_index) {
		printf("[]");

		return;
	}

	printf("[");

	for (unsigned int index = start_index; index < end_index; ++index)
		printf(index == end_index - 1 ? "%d]\n" : "%d, ", array[index]);
}

// Solution to Question 1
void find_maximum_subarray_sum_1(const int array[], int size) {
	int
			maximum_sum = INT_MIN,
			current_sum = 0,
			maximum_start_index = 0,
			maximum_end_index = 0,
			current_start_index = 0;

	for (int index = 0; index < size; ++index) {
		current_sum += array[index];

		if (current_sum < 0) {
			current_sum = 0;
			current_start_index = index + 1;
		}

		if (maximum_sum < current_sum) {
			maximum_sum = current_sum;
			maximum_start_index = current_start_index;
			maximum_end_index = index + 1;
		}
	}

	print_array(array, maximum_start_index, maximum_end_index);
	printf("Maximum subarray sum: %d\n", maximum_sum);
}

/*
 * Solution to Question 2
 *
 * 	Pretty sure that if an entire array consists of negative
 * 	numbers then the maximum sum of a subarray would be the
 * 	highest number in that array. So, I included a flag which checks
 * 	if we encountered a positive number. If not, just return highest
 * 	number (singleton array).
 *
 */
void find_maximum_subarray_sum_2(const int array[], int size) {
	int
			maximum_sum = INT_MIN,
			current_sum = 0,
			maximum_start_index = 0,
			maximum_end_index = 0,
			current_start_index = 0,
			maximum_number_index = 0,
			flag = 1;

	for (int index = 0; index < size; ++index) {
		if (array[index] > 0) flag = 0;
		if (array[maximum_number_index] < array[index]) maximum_number_index = index;

		current_sum += array[index];

		if (current_sum < 0) {
			current_sum = 0;
			current_start_index = index + 1;
		}

		if (maximum_sum < current_sum) {
			maximum_sum = current_sum;
			maximum_start_index = current_start_index;
			maximum_end_index = index + 1;
		}
	}

	if (flag) {
		print_array(array, maximum_number_index, maximum_number_index + 1);

		maximum_sum = array[maximum_number_index];
	} else {
		print_array(array, maximum_start_index, maximum_end_index);
	}

	printf("Maximum subarray sum: %d\n", maximum_sum);
}

int main() {
	const int array[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4},
			size = 9;

	find_maximum_subarray_sum_1(array, size);
	find_maximum_subarray_sum_2(array, size);

	return 0;
}
