int countDigits(int number) {
	int result = 0;

	while (number != 0) {
		++result;
		number /= 10;
	}

	return result;
}
