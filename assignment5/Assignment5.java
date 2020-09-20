/*README
**Author Jack Webb 2020-09-17
**Last updated 2020-09-18
**
**
**
*/

import java.util.Arrays;
import java.util.Random;
import java.lang.Math;



public class Assignment5
{
   static long mergeStart;
   static long mergeEnd;
   static long mergeTime;
   static long insertStart;
   static long insertEnd;
   static long insertTime;

   public static int[] merge(int[] left, int[] right)
   {
      //Create array in which the two subarrays are to be inserted
      int[] array = new int[left.length + right.length];
      //Indices for the three arrays
      int leftIndex = 0;
      int rightIndex = 0;
      int i = 0;

      //While both subarrays are not saturated, compare the elements in each
      //of their indices and put in the smalles of them in the array in
      //ascending order
      while(leftIndex < left.length && rightIndex < right.length)
      {
         if(left[leftIndex] <= right[rightIndex])
            array[i++] = left[leftIndex++];
         else
            array[i++] = right[rightIndex++];
      }

      //When one of the subarrays has been saturated, it will enter one of
      //these while loops, depending on which subarray is not fully saturated.
      //It will insert the remaining elements of that subarray directly into
      //the array.
      while(leftIndex < left.length)
         array[i++] = left[leftIndex++];

      while(rightIndex < right.length)
         array[i++] = right[rightIndex++];
      //Return a sorted and merged array
      return array;
   }

   public static int[] mergeSort(int[] array)
   {
      //If only 1 or less elements, no need to sort, return it
      if(array.length <= 1)
         return array;

      //Finding the middle to divide the array
      int mid = (array.length)/2;
      //Creating subarrays for each side
      int[] left = new int[mid];
      int[] right = new int[array.length - mid];

      //Filling the subarrays with the contents of the bigger array
      for(int i = 0, j = 0; i < array.length; i++)
      {
         if(i < mid)
            left[i] = array[i];
         else
            right[j++] = array[i];
      }
      //Recursive calls to split the arrays further, starting with the left
      left = mergeSort(left);
      right = mergeSort(right);
      //Return a merged and sorted array
      return merge(left, right);
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
      //Index for arrays
      int i = 0;
      //The lowest and highest values of the elements
      //(highest = high - 1), (lowest = low)
      int low = -99;
      int high = 100;

      //Create the random number generator
      Random r = new Random();
      while(i < array1.length)
      {
         //nextInt returns a pseudorandom int between 0 and exclusive
         //(value in parentheses)
         //(high - low) makes it a value between, in this case, 0-198. To make
         //sure we get the desired -99 to 99 we then add -99 to each random int
         //which takes it from 0-198 to -99 - 99
         int n = r.nextInt(high - low) + low;
         //Insert the randomly generated int into the arrays
         array1[i] = n;
         array2[i] = n;
         //Increment index
         i++;
      }
   }

   public static void main(String[] args) {
      int[] array1 = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
      int[] array2 = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

      mergeStart = System.nanoTime();
      mergeSort(array1);
      mergeEnd = System.nanoTime();
      mergeTime = mergeEnd - mergeStart;
      System.out.println("Time to execute mergesort: " + mergeTime);

      insertStart = System.nanoTime();
      insertionSort(array2);
      insertEnd = System.nanoTime();
      insertTime = insertEnd - insertStart;
      System.out.println("Time to execute insertsort: " + insertTime);

      /********TEN ELEMENTS******/
      //Initializing and filling the arrays
      int[] ten1       = new int[10];
      int[] ten2       = new int[10];
      filler(ten1, ten2);

      //Insertion sorting the array while timing it
      insertStart = System.nanoTime();
      insertionSort(ten2);
      insertEnd = System.nanoTime();
      insertTime = insertEnd - insertStart;

      //Merge sorting the array while timing it
      mergeStart = System.nanoTime();
      mergeSort(ten1);
      mergeEnd = System.nanoTime();
      mergeTime = mergeEnd - mergeStart;

      //Printing the time it took for each sorting algorithm
      System.out.println("Ten elements");
      System.out.println
      ("Time to execute mergesort/insertionsort: " + mergeTime+"/ "+insertTime);

      /******A HUNDRED ELEMENTS*******/
      int[] hundred1   = new int[100];
      int[] hundred2   = new int[100];
      filler(hundred1, hundred2);

      mergeStart = System.nanoTime();
      mergeSort(hundred1);
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
      mergeSort(thousand1);
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
      int[] tt1        = new int[10000];
      int[] tt2        = new int[10000];
      filler(tt1, tt2);

      mergeStart = System.nanoTime();
      mergeSort(tt1);
      mergeEnd = System.nanoTime();
      mergeTime = mergeEnd - mergeStart;

      insertStart = System.nanoTime();
      insertionSort(tt2);
      insertEnd = System.nanoTime();
      insertTime = insertEnd - insertStart;

      System.out.println("Ten thousand elements");
      System.out.println
      ("Time to execute mergesort/insertionsort: " + mergeTime+"/ "+insertTime);

      /******HUNDRED THOUSAND ELEMENTS********/
      int[] ht1        = new int[100000];
      int[] ht2        = new int[100000];
      filler(ht1, ht2);

      mergeStart = System.nanoTime();
      mergeSort(ht1);
      mergeEnd = System.nanoTime();
      mergeTime = mergeEnd - mergeStart;

      insertStart = System.nanoTime();
      insertionSort(ht2);
      insertEnd = System.nanoTime();
      insertTime = insertEnd - insertStart;

      System.out.println("Hundred thousand elements");
      System.out.println
      ("Time to execute mergesort/insertionsort: " + mergeTime+"/ "+insertTime);

      /*******A MILLION ELEMENTS**********/
      // int[] million1   = new int[1000000];
      // int[] million2   = new int[1000000];
      // filler(million1, million2);
      // System.out.println("Filled with a million integers");
      //
      // mergeStart = System.nanoTime();
      // mergeSort(million1);
      // mergeEnd = System.nanoTime();
      // mergeTime = mergeEnd - mergeStart;
      // System.out.println("Mergesort done");
      // System.out.println("Mergesort time: " + mergeTime);
      //
      // insertStart = System.nanoTime();
      // // insertionSort(million2);
      // insertEnd = System.nanoTime();
      // insertTime = insertEnd - insertStart;
      //
      // System.out.println("A million elements");
      // System.out.println
      // ("Time to execute mergesort/insertionsort: " + mergeTime+"/ "+insertTime);
   }
}
