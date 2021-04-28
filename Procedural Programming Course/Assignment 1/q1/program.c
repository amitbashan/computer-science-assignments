#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>
#include "myHeaders/program.h"

#define SIZE 10 // Assuming we accept 32-bit integers (2 ^ 32 = 10 digits).

// Question 1.1
int createNumByIdx(int num, int indices) {
	int result = num, digitsCount = countDigits(num) - 1;

	for (int index = 0; indices != 0; indices /= 10, ++index)
		result = replaceDigitByIdx(result, index, getDigitByIdx(num, digitsCount - indices % 10));

	return result;
}

// Question 1.2
int createNumByIdx2(int num, int indices) {
	int result = num;

	for (int index = 0; indices != 0; indices /= 10, ++index)
		result = replaceDigitByIdx(result, index, getDigitByIdx(num, indices % 10));

	return result;
}

int main() {
	char numInput[SIZE], indicesInput[SIZE];

	if (fgets(numInput, SIZE, stdin) == NULL || fgets(indicesInput, SIZE, stdin) == NULL) {
		if (feof(stdin)) {
			return 2;
		} else return 5;
	}

	if (!isNumeric(numInput) || !isNumeric(indicesInput)) return 4;
	if (*numInput == '-' || *indicesInput == '-') return 3;

	unsigned int numDigits = strlen(numInput) - 1, indicesDigits = strlen(indicesInput) - 1;

	for (int index = 0; index < indicesDigits; ++index)
		if (indicesInput[index] - '0' > numDigits) return 1;

    int num = atoi(numInput), indices = atoi(indicesInput);

  printf("\nQuestion 1.1:\n");
	printf("%d\n", createNumByIdx(num, indices));
	printf("\nQuestion 1.2:\n");
	printf("%d\n", createNumByIdx2(num, indices));
}
