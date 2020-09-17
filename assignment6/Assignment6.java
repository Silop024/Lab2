/*README
**Code by David Landup
**stackabuse.com/merge-sort-in-java
**
**
**
*/

import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

public class Assignment6
{
   static long mergeStart;
   static long mergeEnd;
   static long mergeTime;
   static long insertStart;
   static long insertEnd;
   static long insertTime;
   /*Mergesort by David Landup
   **
   */
   public static void merge(int[] array, int low, int mid, int high) {

      // Creating temporary subarrays
      int leftArray[] = new int[mid - low + 1];
      int rightArray[] = new int[high - mid];

      // Copying our subarrays into temporaries
      for (int i = 0; i < leftArray.length; i++)
         leftArray[i] = array[low + i];
      for (int i = 0; i < rightArray.length; i++)
         rightArray[i] = array[mid + i + 1];

      // Iterators containing current index of temp subarrays
      int leftIndex = 0;
      int rightIndex = 0;

      // Copying from leftArray and rightArray back into array
      for (int i = low; i < high + 1; i++) {
         // If there are still uncopied elements in R and L, copy minimum of the two
         if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
               array[i] = leftArray[leftIndex];
               leftIndex++;
            } else {
               array[i] = rightArray[rightIndex];
               rightIndex++;
            }
         } else if (leftIndex < leftArray.length) {
            // If all elements have been copied from rightArray, copy rest of leftArray
            array[i] = leftArray[leftIndex];
            leftIndex++;
         } else if (rightIndex < rightArray.length) {
            // If all elements have been copied from leftArray, copy rest of rightArray
            array[i] = rightArray[rightIndex];
            rightIndex++;
         }
      }
   }

   public static void mergeSort(int[] array, int low, int high) {
      if(high <= low + 30 - 1){
         insertionSort(array);
         return;
      }

      //if (high <= low) return;

      int mid = (low+high)/2;
      mergeSort(array, low, mid);
      mergeSort(array, mid+1, high);

      merge(array, low, mid, high);

   }

   //Insertionsort by me
   public static void insertionSort(int[] array)
   {
      //Local variable used to index the currently inspected element
      int current = 1;
      //Local variable used to index the hole
      int hole;
      //Local variable used to store the value of the current element
      int number;

      while(current < array.length)
      {
         //Store the value of the current element
         number = array[current];
         //Set the hole to the current index being inspected
         hole = current;

         //The inner loop
         while((0 < hole) && (number < array[hole - 1]))
         {
            //Move the current one step down the array
            array[hole] = array[hole - 1];
            //Move the hole one step down the array
            hole--;
         }
         //Put the stored value in the hole
         array[hole] = number;
         //Increment current to inspect the next element
         current++;
      }
   }

   public static void filler(int[] array1, int[] array2)
   {
      int i = 0;
      int low = -99;
      int high = 100;
      Random r = new Random();
      while(i < array1.length)
      {
         int n = r.nextInt(high - low) + low;
         array1[i] = n;
         array2[i] = n;
         i++;
      }
   }

   public static void main(String[] args) {
      int[] array1 = new int[] {5, 6, 7, 2, 4, 1, 7};
      int[] array2 = new int[] {5, 6, 7, 2, 4, 1, 7};

      mergeSort(array1, 0, array1.length - 1);
      mergeTime = mergeEnd - mergeStart;
      System.out.println(Arrays.toString(array1));
      System.out.println("Time to execute mergesort: " + mergeTime);

      insertionSort(array2);
      insertTime = insertEnd - insertStart;
      System.out.println(Arrays.toString(array2));
      System.out.println("Time to execute insertsort: " + insertTime);

      /********TEN ELEMENTS******/
      //Initializing and filling the arrays
      int[] ten1       = new int[10];
      int[] ten2       = new int[10];
      filler(ten1, ten2);
      //Merge sorting the array while timing it
      mergeStart = System.nanoTime();
      mergeSort(ten1, 0, 9);
      mergeEnd = System.nanoTime();
      mergeTime = mergeEnd - mergeStart;

      //Insertion sorting the array while timing it
      insertStart = System.nanoTime();
      insertionSort(ten2);
      insertEnd = System.nanoTime();
      insertTime = insertEnd - insertStart;

      //Printing the time it took for each sorting algorithm
      System.out.println("Ten elements");
      System.out.println
      ("Time to execute mergesort/insertionsort: " + mergeTime+"/ "+insertTime);

      /******A HUNDRED ELEMENTS*******/
      int[] hundred1   = new int[100];
      int[] hundred2   = new int[100];
      filler(hundred1, hundred2);

      mergeStart = System.nanoTime();
      mergeSort(hundred1, 0, 99);
      mergeEnd = System.nanoTime();
      mergeTime = mergeEnd - mergeStart;

      insertStart = System.nanoTime();
      insertionSort(hundred2);
      insertEnd = System.nanoTime();
      insertTime = insertEnd - insertStart;

      System.out.println("Hundred elements");
      System.out.println
      ("Time to execute mergesort/insertionsort: " + mergeTime+"/ "+insertTime);

      /******A THOUSAND ELEMENTS********/
      int[] thousand1  = new int[1000];
      int[] thousand2  = new int[1000];
      filler(thousand1, thousand2);

      mergeStart = System.nanoTime();
      mergeSort(thousand1, 0, 999);
      mergeEnd = System.nanoTime();
      mergeTime = mergeEnd - mergeStart;

      insertStart = System.nanoTime();
      insertionSort(thousand2);
      insertEnd = System.nanoTime();
      insertTime = insertEnd - insertStart;

      System.out.println("A thousand elements");
      System.out.println
      ("Time to execute mergesort/insertionsort: " + mergeTime+"/ "+insertTime);

      /********TEN THOUSAND ELEMENTS******/
      // int[] tt1        = new int[10000];
      // int[] tt2        = new int[10000];
      // filler(tt1, tt2);
      //
      // mergeStart = System.nanoTime();
      // mergeSort(tt1, 0, 9999);
      // mergeEnd = System.nanoTime();
      // mergeTime = mergeEnd - mergeStart;
      //
      // insertStart = System.nanoTime();
      // insertionSort(tt2);
      // insertEnd = System.nanoTime();
      // insertTime = insertEnd - insertStart;
      //
      // System.out.println("Ten thousand elements");
      // System.out.println
      // ("Time to execute mergesort/insertionsort: " + mergeTime+"/ "+insertTime);

      /******HUNDRED THOUSAND ELEMENTS********/
      // int[] ht1        = new int[100000];
      // int[] ht2        = new int[100000];
      // filler(ht1, ht2);
      //
      // mergeStart = System.nanoTime();
      // mergeSort(ht1, 0, 99999);
      // mergeEnd = System.nanoTime();
      // mergeTime = mergeEnd - mergeStart;
      //
      // insertStart = System.nanoTime();
      // insertionSort(ht2);
      // insertEnd = System.nanoTime();
      // insertTime = insertEnd - insertStart;
      //
      // System.out.println("Hundred thousand elements");
      // System.out.println
      // ("Time to execute mergesort/insertionsort: " + mergeTime+"/ "+insertTime);

      /*******A MILLION ELEMENTS**********/
      // int[] million1   = new int[1000000];
      // int[] million2   = new int[1000000];
      // filler(million1, million2);
      // System.out.println("Filled with a million integers");
      //
      // mergeStart = System.nanoTime();
      // mergeSort(million1, 0, 999999);
      // mergeEnd = System.nanoTime();
      // mergeTime = mergeEnd - mergeStart;
      // System.out.println("Mergesort done");
      // System.out.println("Mergesort time: " + mergeTime);
      //
      // insertStart = System.nanoTime();
      // insertionSort(million2);
      // insertEnd = System.nanoTime();
      // insertTime = insertEnd - insertStart;
      //
      // System.out.println("A million elements");
      // System.out.println
      // ("Time to execute mergesort/insertionsort: " + mergeTime+"/ "+insertTime);
   }
}
