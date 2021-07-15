#include <stdio.h>
#include <stdlib.h>

struct TNode {
	int info;
	struct TNode *left, *right;
};

typedef struct TNode TNode;

struct LNode {
	int info;
	struct LNode *next;
};

typedef struct LNode LNode;

struct LLNode {
	struct LNode *info;
	struct LLNode *next;
};

typedef struct LLNode LLNode;

LNode *newListNode(int info, LNode *next) {
	LNode *result = malloc(sizeof(LNode));

	result->info = info;
	result->next = next;

	return result;
}

LLNode *new2DListNode(LNode *info, LLNode *next) {
	LLNode *result = malloc(sizeof(LLNode));

	result->info = info;
	result->next = next;

	return result;
}

TNode *newTreeNode(int info, TNode *left, TNode *right) {
	TNode *result = malloc(sizeof(TNode));

	result->info = info;
	result->left = left;
	result->right = right;

	return result;
}

TNode *insert(TNode *tree, int info) {
	if (tree == NULL)
		return newTreeNode(info, NULL, NULL);

	if (info > tree->info)
		tree->right = insert(tree->right, info);
	else if (info < tree->info)
		tree->left = insert(tree->left, info);

	return tree;
}

TNode *buildTree(LLNode *list) {
	TNode *tree = newTreeNode(list->info->info, NULL, NULL);
	LLNode *current_list = list;

	while (current_list != NULL) {
		LNode *current_sublist = current_list->info;

		while (current_sublist != NULL) {
			insert(tree, current_sublist->info);

			current_sublist = current_sublist->next;
		}

		current_list = current_list->next;
	}

	return tree;
}

int main() {
	LNode *a = newListNode(9, newListNode(4, newListNode(2, NULL))),
	*b = newListNode(9, newListNode(4, newListNode(6, newListNode(5, NULL)))),
	*c = newListNode(9, newListNode(4, newListNode(6, newListNode(8, newListNode(7, NULL))))),
	*d = newListNode(9, newListNode(12, newListNode(17, NULL)));

	LLNode *e = new2DListNode(a, new2DListNode(b, new2DListNode(c, new2DListNode(d, NULL))));

	TNode *tree = buildTree(e);

	return 0;
}