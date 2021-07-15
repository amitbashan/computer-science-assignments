#include <stdio.h>

/*
 *
 * Not really sure about this one. I could
 * have wrongly interpreted the question as
 * it's unreasonable to use ONLY pointers/pointer arithmetic.
 *
 */
void transpose(int *matrix[]) {
	int *maximum_row_length = &*matrix[0], *maximum_row_end;

	for (int **row = matrix; *row != NULL; ++row)
		if (*row[0] > *maximum_row_length) {
			maximum_row_length = &*row[0];
			maximum_row_end = *row + *row[0];
		}

	for (int *index = maximum_row_end - 1; index > maximum_row_length; --index) {
		for (int **row = matrix; *row != NULL; ++row)
			printf((maximum_row_end - index) < *row[0] ? "%d " : "  ", *(*row + (maximum_row_end - index)));

		printf("\n");
	}
}

int main() {
	int A[] = {5, -5, 14, 5, 2};
	int B[] = {3, 6, 11};
	int C[] = {4, 1, -3, 4};
	int D[] = {6, 2, 7, 1, 8, 2};
	int E[] = {2, 15};
	int F[] = {3, 4, -2};
	int *All[] = {A, B, C, D, E, F, NULL};

	transpose(All);

	return 0;
}
