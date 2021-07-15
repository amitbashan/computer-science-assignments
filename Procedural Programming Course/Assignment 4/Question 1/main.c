#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void printAllStrings(const char **array[]) {
	printf("[");

	for (unsigned int index = 0; array[index] != NULL; ++index) {
		printf("[");

		for (unsigned int index_2 = 0; array[index][index_2] != NULL; ++index_2)
			printf(array[index][index_2 + 1] == NULL ? "\"%s\"" : "\"%s\", ", array[index][index_2]);

		printf(array[index + 1] == NULL ? "]" : "], ");
	}

	printf("]\n");
}

void swap(const char **a, const char **b) {
	const char *tmp = *a;
	*a = *b;
	*b = tmp;
}

unsigned int calculate_length(const char **array[]) {
	unsigned int result = 0;

	for (unsigned int index = 0; array[index] != NULL; ++index)
		for (unsigned int index_2 = 0; array[index][index_2] != NULL; ++index_2)
			++result;

	return result;
}

const char **flatten(const char **array[], unsigned int *length_result) {
	unsigned int index = 0, length = calculate_length(array);
	const char **flattened_array = malloc(sizeof(const char *) * length);
	flattened_array[length] = NULL;

	for (unsigned int subarray_index = 0; array[subarray_index] != NULL; ++subarray_index)
		for (unsigned int item_index = 0; array[subarray_index][item_index] != NULL; ++item_index, ++index)
			flattened_array[index] = array[subarray_index][item_index];

	if (length_result != NULL) *length_result = length;

	return flattened_array;
}

// Very inefficient but didn't have anything else in mind.
void sort(const char **array[]) {
	unsigned int length;
	const char **flattened_array = flatten(array, &length);

	for (unsigned int index = 0; index < length; ++index)
		for (unsigned int index_2 = 0; index_2 < length - index - 1; ++index_2)
			if (strcmp(flattened_array[index_2], flattened_array[index_2 + 1]) > 0)
				swap(&flattened_array[index_2], &flattened_array[index_2 + 1]);

	unsigned int index = 0;

	for (unsigned int subarray_index = 0; array[subarray_index] != NULL; ++subarray_index)
		for (unsigned int item_index = 0; array[subarray_index][item_index] != NULL; ++item_index, ++index)
			array[subarray_index][item_index] = flattened_array[index];

	free(flattened_array);
}

const char *maxLengthString(const char **array[]) {
	unsigned int maximum_subarray_index, maximum_item_index, maximum_length = 0;

	for (unsigned int subarray_index = 0; array[subarray_index] != NULL; ++subarray_index)
		for (unsigned int item_index = 0; array[subarray_index][item_index] != NULL; ++item_index) {
			unsigned int length = strlen(array[subarray_index][item_index]);

			if (maximum_length < length) {
				maximum_subarray_index = subarray_index;
				maximum_item_index = item_index;
				maximum_length = length;
			}
		}

	return array[maximum_subarray_index][maximum_item_index];
}

int main() {
	char *arrP1[] = {"father", "mother", NULL};
	char *arrP2[] = {"sister", "brother", "grandfather", NULL};
	char *arrP3[] = {"grandmother", NULL};
	char *arrP4[] = {"uncle", "aunt", NULL};
	char **arrPP[] = {arrP1, arrP2, arrP3, arrP4, NULL};

	printAllStrings(arrPP);
	sort(arrPP);
	printAllStrings(arrPP);
	printf("%s\n", maxLengthString(arrPP));

	return 0;
}
