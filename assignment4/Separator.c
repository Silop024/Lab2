/*README
**Author Jack Webb 2020-09-13
**
**
**
*/




#include <stdio.h>
#include <stdlib.h>


void separate(int *a, int length)
{
   int i;
   int j = length/2;
   int temp;
   int time = 0;
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
         time++;
      }
   }
   printf("Time %d\n", time);
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
   int array[] = {1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1};
   int length = 10;
   printf("%d\n", length);
   print(array, length);
   separate(array, length);
   print(array, length);
   return 0;
}
