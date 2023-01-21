//A maze is a path or collection of paths, typically from an entrance to a goal. Generally, In this 
problem, there is a given maze of size N x N binary matrix of blocks where source block is the upper left 
most block that is maze [0][0] and destination block is lower right most block that is maze[N-1][N-1]. 
Some cells are valid to move and some cells are blocked. Possible move is forward and down. In the 
maze matrix, 0 means the block is a dead end and 1 means the block can be used in the path from 
source to destination. The maze is given using a binary matrix, where it is marked with 1, it is a valid 
path, otherwise 0 for a blocked cell.

#include <stdio.h>

void mergeSort(int p, int q, int arr[], int aux[])
 {
    if (q <= p)

        {

        return;
    }

    int middle = (p + q) / 2;

    mergeSort(p, middle, arr, aux);
    mergeSort(middle + 1, q, arr, aux);

    int left = p;
    int right = middle + 1;
       int r;

    for (r = p; r <= q; r++) {
        if (left == middle + 1)
            {
            aux[r] = arr[right];
            right++;

        }
        else if (right == q + 1)
            {
            aux[r] = arr[left];
            left++;
        }
        else if (arr[left] < arr[right])
            {
            aux[r] = arr[left];
            left++;
        }
        else {

            aux[r] = arr[right];
            right++;

             }

    }

    for (r = p; r <= q; r++) {

             arr[r] = aux[r];
    }
}


int main() {
  int arr[100], aux[100], n, i;

  printf("\nEnter number of elements in the array:\n");
  scanf("%d", &n);

  printf("\nEnter %d integers: ", n);

 for (i = 0; i < n; i++)
    scanf("%d", &arr[i]);

  mergeSort(0, n - 1, arr, aux);

  printf("\nPrinting the sorted array:\n");

  for (i = 0; i < n; i++)
     printf("%d\n", arr[i]);

  return 0;
}


