#include <stdio.h>
#include <ctype.h>

int main() {
	int inWord = 0,
			isSpace = 0,
			character,
			characters = 0,
			words = 0,
			lines = 0,
			letters = 0,
			digits = 0,
			whitespaces = 0;

	while ((character = getchar()) != EOF) {
		if (character == '\n') {
			++lines;
		} else if (isalpha(character)) {
			++letters;
		} else if (isdigit(character)) {
			++digits;
		}

		if (isspace(character)) {
			++whitespaces;

			if (inWord) {
				inWord = 0;

				if (!isSpace) ++words;
			}

			isSpace = 1;
		} else {
			isSpace = 0;
			inWord = 1;
		}

		++characters;
	}

	printf("\nCharacters: %u\n", characters);
	printf("Words: %u\n", words);
	printf("Lines: %u\n", lines);
	printf("Letters: %u\n", letters);
	printf("Digits: %u\n", digits);
	printf("Whitespaces: %u\n", whitespaces);
}
