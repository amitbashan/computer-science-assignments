#include <stdio.h>
#include <limits.h>
#include <stdarg.h>

void find_maximum_subarray_sum(int size, ...) {
	int
			maximum_sum = INT_MIN,
			current_sum = 0,
			maximum_start_index = 0,
			maximum_end_index = 0,
			current_start_index = 0;
	va_list arguments;

	va_start(arguments, size);

	for (int index = 0; size != 0; --size, ++index) {
		current_sum += va_arg(arguments, int);

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

	if (maximum_start_index != maximum_end_index) {
		va_start(arguments, size);

		printf("[");

		for (int index = 0; index < maximum_end_index; ++index) {
			if (index < maximum_start_index) va_arg(arguments, int);
			else printf(index == maximum_end_index - 1 ? "%d]\n" : "%d, ", va_arg(arguments, int));
		}
	}

	printf("Maximum subarray sum: %d\n", maximum_sum);

	va_end(arguments);
}

int main() {
	find_maximum_subarray_sum(9, -2, 1, -3, 4, -1, 2, 1, -5, 4);

	return 0;
}
