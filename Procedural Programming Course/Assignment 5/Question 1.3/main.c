#include <stdlib.h>
#include <string.h>

struct Pair {
	char *a, *b;
	unsigned int hamming_distance;
};

/*
 * There is no specific information on what is there
 * to be returned besides an array that contains the
 * Hamming distances. So I decided to return an array
 * with a struct that contains the pair of strings
 * being checked and its Hamming distance.
 */
struct Pair *hamming_distance(char **array[]) {
	struct Pair *result = NULL,
			*result_copy = NULL;

	/*
	 * I think it is better to determine
	 * the size of the result upfront
	 * for memory allocation here, however due
	 * to a limitation of needing to use
	 * only pointers I think I'll need
	 * to stick to `realloc`.
	 */

	for (char ***row = array; *row != NULL; ++row)
		for (char **column = *row; *column != NULL; ++column)
			for (char ***row_2 = array; *row_2 != NULL; ++row_2)
				for (char **column_2 = *row_2; *column_2 != NULL; ++column_2)
					if (strcmp(*column, *column_2) != 0 && strlen(*column) == strlen(*column_2)) {
						result = realloc(result, result_copy - result);

						if (result_copy == NULL)
							result_copy = result;

						int insert = 1;

						for (struct Pair *pair = result, *end = result_copy; pair != end; ++pair)
							if (!strcmp(pair->a, *column_2) && !strcmp(pair->b, *column))
								insert = 0;

						if (insert) {
							result_copy->a = *column;
							result_copy->b = *column_2;

							for (char *a = *column, *b = *column_2; *a != '\0'; ++a, ++b)
								if (*a == *b)
									result_copy->hamming_distance = result_copy->hamming_distance + 1;

							++result_copy;
						}
					}

	return result;
}

int main() {
	char *arrP1[] = {"father", "mother", NULL},
			*arrP2[] = {"sister", "brother", "grandfather", NULL},
			*arrP3[] = {"grandmother", NULL},
			*arrP4[] = {"uncle", "aunt", NULL},
			**arrPP[] = {arrP1, arrP2, arrP3, arrP4, NULL};

	struct Pair *result = hamming_distance(arrPP);

	/*
	 * 	Result should be:
	 *
	 * 	father
	 * 	mother
	 * 	4
	 *
	 * 	father
	 * 	sister
	 * 	2
	 *
	 * 	mother
	 * 	sister
	 * 	2
	 *
	 * 	grandfather
	 * 	grandmother
	 * 	9
	 */

	return 0;
}
