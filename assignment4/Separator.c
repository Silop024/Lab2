/*README
**Author Jack Webb 2020-09-13
**Last updated ....
**A method which takes an array of integers and orders the elements
**so that all negative elements come before the positive. This is
**done in-place.
*/




#include <stdio.h>
#include <stdlib.h>


void separate(int *a, int length)
{
   //Index variable i, starts in first half
   int i;
   //Index variable j, starts in second half
   int j = length/2;
   //Temp used while swapping places of two indices
   int temp;
   //Was used to check for time complexity
   //int time = 0;

   /*Inner loop iterates through the first half of the array
   **and for each index in the first half the inner loop iterates
   **through the second half checking for positives/negatives and
   **if an element in the first half is positive while an element in
   **the second half is negative they swap places. If the element being
   **inspected in the first half is negative it goes to the next.
   **TIme complexity: Worst case O(2n), Best case O(n/2)
   */
   for(i = 0; i <= (length/2); i++)
   {
      for(j = length/2; j < length; j++)
      {
         if(a[i] < 0)
            break;
         if(a[i] > 0 && a[j] < 0)
         {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
         }
         //Used to check for time complexity
         //time++;
      }
   }
   //Used to check for time complexity
   //printf("Time %d\n", time);
}

void print(int a[], int length)
{
   int i;
   for(i = 0; i < length; i++)
      printf("[%d]", a[i]);
   printf("\n");
}

int main()
{
   int array[] = {-1, -1, 1, 1, -1, -1, 1, 1};
   int length = sizeof(array)/4;
   printf("%d\n", length);
   print(array, length);
   separate(array, length);
   print(array, length);
   return 0;
}
