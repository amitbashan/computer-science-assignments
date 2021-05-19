#include <stdio.h>
#include <limits.h>

#define MAX(a, b) (a > b ? a : b)

void print_array(const int array[], int start_index, int end_index) {
	if (start_index == end_index || start_index > end_index) {
		printf("[]");

		return;
	}

	printf("[");

	for (unsigned int index = start_index; index < end_index; ++index)
		printf(index == end_index - 1 ? "%d]\n" : "%d, ", array[index]);
}

void find_maximum_subarray_sum(const int array[], int size) {
	int maximum_sum = INT_MIN,
			maximum_start_index = 0,
			maximum_end_index = 0;

	for (int index = 0; index < size; ++index) {
		int current_sum = 0;

		for (int index_2 = index; index_2 < size; ++index_2) {
			current_sum += array[index_2];

			if (current_sum > maximum_sum) {
				maximum_sum = current_sum;
				maximum_start_index = index;
				maximum_end_index = index_2 + 1;
			}
		}
	}

	print_array(array, maximum_start_index, maximum_end_index);
	printf("Maximum subarray sum: %d\n", maximum_sum);
}

int main() {
	const int array[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4},
			size = 9;

	find_maximum_subarray_sum(array, size);

	return 0;
}
