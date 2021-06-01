#include <stdio.h>
#include <stdlib.h>

enum Cell {
	Dead,
	Alive,
};

struct Grid {
	unsigned int row_size, column_size;
	enum Cell **grid;
};

void print_grid(struct Grid grid) {
	for (unsigned int column_index = 0; column_index < grid.column_size; ++column_index) {
		for (unsigned int row_index = 0; row_index < grid.row_size; ++row_index)
			grid.grid[row_index][column_index] == Alive ? printf("[+]") : printf("   ");

		printf("\n");
	}
}

struct Grid new_grid(unsigned int row_size, unsigned int column_size) {
	struct Grid result = {
			row_size,
			column_size,
			malloc(row_size * sizeof(enum Cell *)),
	};

	for (unsigned int index = 0; index < row_size; ++index)
		result.grid[index] = malloc(column_size * sizeof(enum Cell));

	return result;
}

void free_grid(struct Grid grid) {
	for (unsigned int index = 0; index < grid.row_size; ++index)
		free(grid.grid[index]);

	free(grid.grid);
}

// Naive and inelegant solution, but couldn't think of anything else.
unsigned int calculate_surrounding_alive_cells(struct Grid grid,
											   int x,
											   int y) {
	unsigned int result = 0;

	// Left
	if (x - 1 >= 0 && grid.grid[x - 1][y] == Alive)
		++result;

	// Right
	if (x + 1 < grid.row_size && grid.grid[x + 1][y] == Alive)
		++result;

	// Up
	if (y - 1 >= 0 && grid.grid[x][y - 1] == Alive)
		++result;

	// Down
	if (y + 1 < grid.column_size && grid.grid[x][y + 1] == Alive)
		++result;

	// Top-left
	if (y - 1 >= 0 && x - 1 >= 0 && grid.grid[x - 1][y - 1] == Alive)
		++result;

	// Top-right
	if (y - 1 >= 0 && x + 1 < grid.row_size && grid.grid[x + 1][y - 1] == Alive)
		++result;

	// Bottom-left
	if (y + 1 < grid.column_size && x - 1 >= 0 && grid.grid[x - 1][y + 1] == Alive)
		++result;

	// Bottom-right
	if (y + 1 < grid.column_size && x + 1 < grid.row_size && grid.grid[x + 1][y + 1] == Alive)
		++result;

	return result;
}

/*
 * 	NOTE:
 *
 *    I didn't fully read question 1 at first so I
 *    wrote the solution where there is no maximum
 *    grid size, and it just returns a grid
 *    that is expanded if it needs to be.
 *
 *    I am not too sure about what to use
 *    so there are two versions of the solution.
 *
 *    The solution that is commented out will
 *    return an expanded grid. The other will not.
 *

	 struct Grid extend_grid(struct Grid grid) {
		struct Grid result = new_grid(grid.row_size + 2, grid.column_size + 2);

		for (unsigned int column_index = 1; column_index - 1 < grid.column_size; ++column_index) {
			for (unsigned int row_index = 1; row_index - 1 < grid.row_size; ++row_index) {
				result.grid[row_index][column_index] = grid.grid[row_index - 1][column_index - 1];
			}
		}

		return result;
	 }

	 int should_be_extended(struct Grid grid) {
		if (grid.row_size < 3 || grid.column_size < 3) return 0;

		for (unsigned int column_index = 0; column_index < grid.column_size; ++column_index) {
			if (column_index + 2 > grid.column_size) break;

  			// Could've combined these two if
 			// statements into one but seems
 			// inelegant.

			if (grid.grid[0][column_index] == Alive
				&& grid.grid[0][column_index + 1] == Alive
				&& grid.grid[0][column_index + 2] == Alive)
				return 1;

			if (grid.grid[grid.row_size - 1][column_index] == Alive
				&& grid.grid[grid.row_size - 1][column_index + 1] == Alive
				&& grid.grid[grid.row_size - 1][column_index + 2] == Alive)
				return 1;
		}

		for (unsigned int row_index = 0; row_index < grid.row_size; ++row_index) {
			if (row_index + 2 > grid.column_size) break;

 			// Could've combined these two if
 			// statements into one but seems
 			// inelegant.

			if (grid.grid[row_index][0] == Alive
				&& grid.grid[row_index + 1][0] == Alive
				&& grid.grid[row_index + 2][0] == Alive)
				return 1;

			if (grid.grid[row_index][grid.column_size - 1] == Alive
				&& grid.grid[row_index + 1][grid.column_size - 1] == Alive
				&& grid.grid[row_index + 2][grid.column_size - 1] == Alive)
				return 1;
		}

		return 0;
	}

	struct Grid evolve(struct Grid grid) {
		int extended = should_be_extended(grid);

		grid = extended ? extend_grid(grid) : grid;

		struct Grid result = new_grid(grid.row_size, grid.column_size);

		for (unsigned int column_index = 0; column_index < grid.column_size; ++column_index) {
			for (unsigned int row_index = 0; row_index < grid.row_size; ++row_index) {
				unsigned int surrounding_alive_cells =
						calculate_surrounding_alive_cells(grid,
														  (int) row_index,
														  (int) column_index);
				enum Cell current_cell = grid.grid[row_index][column_index];

				if ((current_cell == Alive
					 &&
					 (surrounding_alive_cells == 2 || surrounding_alive_cells == 3)
					)
					|| (current_cell == Dead && surrounding_alive_cells == 3))
					result.grid[row_index][column_index] = Alive;
			}
		}

		return result;
	}

 */

struct Grid evolve(struct Grid grid) {
	struct Grid result = new_grid(grid.row_size, grid.column_size);

	for (unsigned int column_index = 0; column_index < grid.column_size; ++column_index) {
		for (unsigned int row_index = 0; row_index < grid.row_size; ++row_index) {
			unsigned int surrounding_alive_cells =
					calculate_surrounding_alive_cells(grid,
													  (int) row_index,
													  (int) column_index);
			enum Cell current_cell = grid.grid[row_index][column_index];

			if ((current_cell == Alive
				 &&
				 (surrounding_alive_cells == 2 || surrounding_alive_cells == 3)
				)
				|| (current_cell == Dead && surrounding_alive_cells == 3))
				result.grid[row_index][column_index] = Alive;
		}
	}

	return result;
}

/*
 * NOTE:
 *
 * 	The document is quite ambiguous when
 * 	talking about the format of the input
 * 	so I assume the numbers given in the input
 * 	are separated by spaces.
 *
 */
int main() {
	unsigned int iterations, maximum_width, maximum_height;
	struct Grid grid;

	if (scanf("%u%u%u", &iterations, &maximum_width, &maximum_height) != 3) {
		fprintf(stderr, "Failed to parse either the number of iterations, maximum width or maximum height.\n");

		return 1;
	}

	grid = new_grid(maximum_width, maximum_height);

	for (unsigned int column_index = 0; column_index < grid.column_size; ++column_index)
		for (unsigned int row_index = 0; row_index < grid.row_size; ++row_index) {
			if (scanf("%u", &grid.grid[row_index][column_index]) != 1) {
				fprintf(stderr, "Failed to parse cell state at index %d.\n", column_index * grid.row_size + row_index);

				return 1;
			}

			if (grid.grid[row_index][column_index] > 1 || grid.grid[row_index][column_index] < 0) {
				printf("Cell value `%d` at index %d is invalid. Only 0 and 1 is accepted.\n", grid.grid[row_index][column_index], column_index * grid.row_size + row_index);

				return 1;
			}
		}

	struct Grid generations[iterations];

	printf("Iterations: %d\n", iterations);
	printf("Maximum width: %d\n", maximum_width);
	printf("Maximum height: %d\n\n", maximum_height);

	for (unsigned int index = 0; index <= iterations; ++index, grid = evolve(grid)) {
		generations[index] = grid;

		printf("Iteration #%d\n", index);
		print_grid(grid);
		printf("\n");
	}

	for (unsigned int index = 0; index <= iterations; ++index)
		free_grid(generations[index]);

	return 0;
}
