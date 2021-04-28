int getDigitByIdx(int number, int index) {
	for (int i = 0; number != 0; ++i, number /= 10) {
		if (i == index)
			return number % 10;
	}

	return -1;
}
