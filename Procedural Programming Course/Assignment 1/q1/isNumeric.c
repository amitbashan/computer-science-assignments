#include <ctype.h>

int isNumeric(const char* string) {
	if (*string == '-') ++string;

	while (*string != '\n') {
		if (!isdigit(*string)) {
			return 0;
		}

		++string;
	}

	return 1;
}
