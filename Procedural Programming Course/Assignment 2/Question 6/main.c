#include <stdio.h>

int is_subarray(const int a[], const int b[], int size_a, int size_b) {
	if (size_a == 0 && size_b == 0) return 1;
	if (size_a == 0) return 0;
	if (size_b == 0) return 1;
	if (*a == *b)
		return is_subarray(a + 1, b + 1, size_a - 1, size_b - 1);

	return is_subarray(a, b + 1, size_a, size_b - 1);
}

int main() {
	const int a[] = {2, 8, 14, -9, 5, 6, 2, 19, 4},
			b[] = {8, 5, 2, 4};
	int size_a = 9,
			size_b = 4;

	printf(is_subarray(a, b, size_a, size_b) ? "YES" : "NO");

	return 0;
}
