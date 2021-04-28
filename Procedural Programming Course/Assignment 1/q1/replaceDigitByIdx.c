#include "myHeaders/program.h"

int replaceDigitByIdx(int number, int index, int digit) {
	int result = 0, multiply = 1, digitCount = countDigits(number);

	if (index > digitCount || index > 9)
		return -1;

	for (int indices = 0; number / 10 != 0; ++indices, number /= 10, multiply *= 10) {
		int remainder = number % 10;

		if (indices == index)
			result = result + digit * multiply;
		else
			result = result + remainder * multiply;
	}

	if (index == digitCount - 1)
		result = result + digit * multiply;
	else
		result = result + number * multiply;

	return result;
}
