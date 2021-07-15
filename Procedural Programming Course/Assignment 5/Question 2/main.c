#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>

void **gMax(int n, int m, int (*cmp)(void *, void *), void *base, ...) {
	va_list arrays;
	int result_length = 0;
	char *current_array = base;

	va_start(arrays, base);

	while ((va_arg(arrays, void *)) != NULL)
		++result_length;

	void **result = malloc((result_length + 1) * sizeof(void *));

	va_start(arrays, base);

	for (int index = 0; current_array != NULL; ++index) {
		void *maximum = current_array;

		for (int index_2 = 1; index_2 < n; ++index_2) {
			void *item = current_array + index_2 * m;

			if (cmp(maximum, item) < 0)
				maximum = item;
		}

		result[index] = maximum;
		current_array = va_arg(arrays, void *);
	}

	va_end(arrays);

	return result;
}

int intcmp(void *a, void *b) {
	return *(int *) a > *(int *) b ? 1 : -1;
}

int main() {
	int a[] = {5, 2, 3, 5},
			b[] = {2, 8, 8, 8},
			c[] = {7, 6, 12, 5};

	int **result = (int **) gMax(4, sizeof(int), intcmp, a, b, c, NULL);

	for (int i = 0; i < 3; ++i) {
		printf("%d ", *result[i]);
	}

	// Output should be: 5 8 12

	return 0;
}