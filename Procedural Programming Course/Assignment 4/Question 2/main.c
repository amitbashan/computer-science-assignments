#include <stdio.h>
#include <string.h>

void swap(void *a, void *b, unsigned int size) {
	char buffer[size];

	memcpy(buffer, a, size);
	memcpy(a, b, size);
	memcpy(b, buffer, size);
}

void sort(void *array, unsigned int size, unsigned int item_size, int (*comparator)(void *, void *)) {
	unsigned int length = size / item_size;

	for (unsigned int index = 0; index < length; ++index)
		for (unsigned int index_2 = 0; index_2 < length - index - 1; ++index_2) {
			void *current = array + item_size * index_2;
			void *next = array + item_size * (index_2 + 1);

			if (comparator(current, next) > 0)
				swap(current, next, item_size);
		}
}

int intcmp(void *a, void *b) {
	return *(int *) a > *(int *) b ? 1 : -1;
}

int doublecmp(void *a, void *b) {
	return *(double *) a > *(double *) b ? 1 : -1;
}

int strcmp_2(void *a, void *b) {
	return strcmp((const char *) a, (const char *) b);
}

int ptrcmp(void *a, void *b) {
	return a > b ? 1 : -1;
}

/*
 *
 * Too lazy to write a "generic" print function
 * and a macro that generates comparison functions.
 *
 */
int main() {
	const int integer_array[] = {2, 7, 6, 4, 1};

	sort((void *) integer_array, sizeof integer_array, sizeof *integer_array, intcmp);

	for (int i = 0; i < sizeof integer_array / sizeof *integer_array; ++i) {
		printf("%d ", integer_array[i]);
	}

	printf("\n");

	const double double_array[] = {12.5, 2.7, 3.0, 5.5, 5.9, 1.0};

	sort((void *) double_array, sizeof double_array, sizeof *double_array, doublecmp);

	for (int i = 0; i < sizeof double_array / sizeof *double_array; ++i) {
		printf("%f ", double_array[i]);
	}

	printf("\n");

	char string_array[][5] = {"abc", "xy", "ac"};

	sort((void *) string_array, sizeof string_array, sizeof *string_array, strcmp_2);

	for (int i = 0; i < sizeof string_array / sizeof *string_array; ++i) {
		printf("%s ", string_array[i]);
	}

	printf("\n");

	char *string_array_2[] = {"abc", "xy", "ac"};

	sort((void *) string_array_2, sizeof string_array_2, sizeof *string_array_2, ptrcmp);

	for (int i = 0; i < sizeof string_array_2 / sizeof *string_array_2; ++i) {
		printf("%s ", string_array_2[i]);
	}

	return 0;
}