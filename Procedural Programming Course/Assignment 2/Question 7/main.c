#include <stdlib.h>
#include <stdio.h>
#include <string.h>

/*
 * Sorry for the very messy code, memory leaks
 * that I haven't caught, and the overly explicit
 * result that the polynomial print function emits.
 *
 * I've had enough of this question.
 *
*/

#define MAX(a, b) (((a) > (b)) ? (a) : (b))

struct result {
	int *remainder;
	int remainder_size;
	int *quotient;
	int quotient_size;
};

void print_polynomial(const int polynomial[], int size) {
	for (int index = 0; index < size; ++index) {
		if (index == 0 && polynomial[index] != 0) {
			printf("%d", polynomial[index]);

			continue;
		}
		if (polynomial[index] == 0) continue;
		if (polynomial[index] >= 1) printf("+");

		printf("%dx^%d", polynomial[index], index);
	}

	printf("\n");
}

int *add_polynomial(const int summand_1[],
					const int summand_2[],
					int summand_1_size,
					int summand_2_size,
					int *result_size) {
	int size = MAX(summand_1_size, summand_2_size),
			*result = malloc(size * (sizeof(int)));

	for (int index = 0; index < summand_1_size; ++index)
		result[index] = summand_1[index];

	for (int index = 0; index < summand_2_size; ++index)
		result[index] += summand_2[index];

	if (result_size != NULL) *result_size = size;

	return result;
}

int *subtract_polynomial(const int minuend[],
						 const int subtrahend[],
						 int minuend_size,
						 int subtrahend_size,
						 int *result_size) {
	int size = MAX(minuend_size, subtrahend_size),
			*result = malloc(size * (sizeof(int)));

	for (int index = 0; index < minuend_size; ++index)
		result[index] = minuend[index];

	for (int index = 0; index < subtrahend_size; ++index)
		result[index] -= subtrahend[index];

	*result_size = size;

	return result;
}

int *multiply_polynomial(const int multiplicand[],
						 const int multiplier[],
						 int multiplicand_size,
						 int multiplier_size,
						 int *result_size) {
	int size = multiplicand_size + multiplier_size - 1;
	int *result = malloc(size * sizeof(int));

	for (int index = 0; index < size; ++index)
		result[index] = 0;

	for (int index = 0; index < multiplicand_size; ++index)
		for (int index_2 = 0; index_2 < multiplier_size; ++index_2)
			result[index + index_2] += multiplicand[index] * multiplier[index_2];

	*result_size = size;

	return result;
}

int get_highest_degree_coefficient(const int *array, int size) {
	for (int index = size - 1; index >= 0; --index) {
		if (array[index]) return array[index];
	}

	return 1;
}

int calculate_actual_size(const int polynomial[], int size) {
	int actual_size = 0;

	for (int index = 0; index < size; ++index) {
		if (polynomial[index]) ++actual_size;
	}

	return actual_size;
}

struct result calculate_remainder(const int dividend[],
								  const int divisor[],
								  int dividend_size,
								  int divisor_size,
								  const struct result last_result) {
	struct result result = {};
	int remainder_size = 0,
			quotient_term_size = abs(
			calculate_actual_size(dividend, dividend_size)
			- calculate_actual_size(divisor, divisor_size) + 1),
			*quotient_term = malloc(quotient_term_size * sizeof(int));

	quotient_term[quotient_term_size - 1] = get_highest_degree_coefficient(dividend, dividend_size) /
											get_highest_degree_coefficient(divisor, divisor_size);

	int *multiply_result = multiply_polynomial(
			divisor,
			quotient_term,
			divisor_size,
			quotient_term_size,
			&remainder_size
	), *subtract_result = subtract_polynomial(
			dividend,
			multiply_result,
			dividend_size,
			remainder_size,
			&remainder_size
	);

	result.remainder = subtract_result;
	result.remainder_size = remainder_size;

	if (last_result.quotient_size == 0) {
		result.quotient = quotient_term;
		result.quotient_size = quotient_term_size;
	} else {
		result.quotient = add_polynomial(
				quotient_term,
				last_result.quotient,
				quotient_term_size,
				last_result.quotient_size,
				&result.quotient_size
		);
	}

	return result;
}

// Solution to question 7.
void divide_polynomial(const int dividend[],
					   const int divisor[],
					   int dividend_size,
					   int divisor_size) {
	int actual_divisor_size = calculate_actual_size(divisor, divisor_size);
	struct result start_result = {
			0,
			0,
			0,
			0,
	},
			result = calculate_remainder(
			dividend,
			divisor,
			dividend_size,
			divisor_size,
			start_result
	);

	while (calculate_actual_size(result.remainder, result.remainder_size) - 1 >= actual_divisor_size - 1) {
		result = calculate_remainder(
				result.remainder,
				divisor,
				result.remainder_size,
				divisor_size,
				result
		);
	}

	printf("Quotient = ");
	print_polynomial(result.quotient, result.quotient_size);
	printf("Remainder = ");
	print_polynomial(result.remainder, result.remainder_size);
}

int main() {
	int dividend[] = {5, -1, 3, 2},
			divisor[] = {1, -1, 1},
			dividend_size = 4,
			divisor_size = 3;

	printf("Dividend = ");
	print_polynomial(dividend, dividend_size);
	printf("Divisor = ");
	print_polynomial(divisor, divisor_size);
	divide_polynomial(dividend, divisor, dividend_size, divisor_size);

	return 0;
}
