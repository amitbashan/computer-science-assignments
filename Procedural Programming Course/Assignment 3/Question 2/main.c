#include <stdio.h>

// Solution to Question 2.1
void print_integer_binary(int integer) {
	for (int index = sizeof integer * 8 - 1; index >= 0; --index)
		printf("%d", integer >> index & 1);
}

// Solution to Question 2.2
int rotate_left(int a, int n) {
	return (a << n) | (a >> (sizeof a * 8 - 1));
}

// Solution to Question 2.3
int compress_string_of_8_digits(const char *string) {
	int result = 0;

	for (int index = 0; index < 8; ++index)
		result |= (string[index] - '0') << ((7 - index) * 4);

	return result;
}

int main() {
	print_integer_binary(compress_string_of_8_digits("12345678"));

	return 0;
}
