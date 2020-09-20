/*README
**Author Jack Webb 2020-09-19
**Last updated
**
**
**
**
**
**
*/

import java.util.Random;


public class Extra2
{
   /**********************MERGESORT***************************/

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

   /******************QUICKSORT********************************/

   public static void quickSort(int[] array, int low, int high)
   {
      if(low < high)
      {
         int p = partition(array, low, high);
         quickSort(array, low, p - 1);
         quickSort(array, p + 1, high);
      }
   }

   //Simple method that swaps two elements in an array
   public static void swap(int[] array, int i, int j)
   {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
   }

   public static int partition(int[] array, int low, int high)
   {
      int pivot = array[high];
      int i = low;
      int j;

      for(j = low; j < high; j++)
      {
         if(array[j] < pivot)
         {
            swap(array, i, j);
            i++;
         }
      }
      swap(array, i, high);
      return i;
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

   public static void print(int[] array)
   {
      for(int e : array)
         System.out.print("[" + e + "]");
      System.out.println();
   }

   static long mergeStart;
   static long mergeEnd;
   static long mergeTime;

   static long quickStart;
   static long quickEnd;
   static long quickTime;


   public static void main(String[] args) {
      int[] array1 = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
      int[] array2 = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

      mergeStart = System.nanoTime();
      mergeSort(array1);
      mergeEnd = System.nanoTime();
      mergeTime = mergeEnd - mergeStart;
      System.out.print("Sorted with mergesort: ");
      print(mergeSort(array1));
      System.out.println("Time to execute mergesort: " + mergeTime);

      quickStart = System.nanoTime();
      quickSort(array2, 0, array2.length - 1);
      quickEnd = System.nanoTime();
      quickTime = quickEnd - quickStart;
      System.out.print("Sorted with quicksort: ");
      print(array2);
      System.out.println("Time to execute quicksort: " + quickTime);

      /********TEN ELEMENTS******/
      //Initializing and filling the arrays
      int[] ten1       = new int[10];
      int[] ten2       = new int[10];
      filler(ten1, ten2);

      //Insertion sorting the array while timing it
      quickStart = System.nanoTime();
      quickSort(ten2, 0, ten2.length - 1);
      quickEnd = System.nanoTime();
      quickTime = quickEnd - quickStart;
      print(ten2);

      //Merge sorting the array while timing it
      mergeStart = System.nanoTime();
      mergeSort(ten1);
      mergeEnd = System.nanoTime();
      mergeTime = mergeEnd - mergeStart;
      print(mergeSort(ten1));

      //Printing the time it took for each sorting algorithm
      System.out.println("Ten elements");
      System.out.println
      ("Time to execute mergesort/quicksort: " + mergeTime+"/ "+quickTime);

      /******A HUNDRED ELEMENTS*******/
      int[] hundred1   = new int[100];
      int[] hundred2   = new int[100];
      filler(hundred1, hundred2);

      mergeStart = System.nanoTime();
      mergeSort(hundred1);
      mergeEnd = System.nanoTime();
      mergeTime = mergeEnd - mergeStart;

      quickStart = System.nanoTime();
      quickSort(hundred2, 0, hundred2.length - 1);
      quickEnd = System.nanoTime();
      quickTime = quickEnd - quickStart;

      System.out.println("Hundred elements");
      System.out.println
      ("Time to execute mergesort/quicksort: " + mergeTime+"/ "+quickTime);

      /******A THOUSAND ELEMENTS********/
      int[] thousand1  = new int[1000];
      int[] thousand2  = new int[1000];
      filler(thousand1, thousand2);

      mergeStart = System.nanoTime();
      mergeSort(thousand1);
      mergeEnd = System.nanoTime();
      mergeTime = mergeEnd - mergeStart;

      quickStart = System.nanoTime();
      quickSort(thousand2, 0, thousand2.length - 1);
      quickEnd = System.nanoTime();
      quickTime = quickEnd - quickStart;

      System.out.println("A thousand elements");
      System.out.println
      ("Time to execute mergesort/quicksort: " + mergeTime+"/ "+quickTime);

      /********TEN THOUSAND ELEMENTS******/
      int[] tt1        = new int[10000];
      int[] tt2        = new int[10000];
      filler(tt1, tt2);

      mergeStart = System.nanoTime();
      mergeSort(tt1);
      mergeEnd = System.nanoTime();
      mergeTime = mergeEnd - mergeStart;

      quickStart = System.nanoTime();
      quickSort(tt2, 0, tt2.length - 1);
      quickEnd = System.nanoTime();
      quickTime = quickEnd - quickStart;

      System.out.println("Ten thousand elements");
      System.out.println
      ("Time to execute mergesort/quicksort: " + mergeTime+"/ "+quickTime);

      /******HUNDRED THOUSAND ELEMENTS********/
      int[] ht1        = new int[100000];
      int[] ht2        = new int[100000];
      filler(ht1, ht2);

      mergeStart = System.nanoTime();
      mergeSort(ht1);
      mergeEnd = System.nanoTime();
      mergeTime = mergeEnd - mergeStart;

      quickStart = System.nanoTime();
      quickSort(ht2, 0, ht2.length - 1);
      quickEnd = System.nanoTime();
      quickTime = quickEnd - quickStart;

      System.out.println("Hundred thousand elements");
      System.out.println
      ("Time to execute mergesort/quicksort: " + mergeTime+" / "+quickTime);

      /*******A MILLION ELEMENTS**********/
      int[] million1   = new int[1000000];
      int[] million2   = new int[1000000];
      filler(million1, million2);
      System.out.println("Filled with a million integers");

      mergeStart = System.nanoTime();
      mergeSort(million1);
      mergeEnd = System.nanoTime();
      mergeTime = mergeEnd - mergeStart;

      quickStart = System.nanoTime();
      quickSort(million2, 0, million2.length - 1);
      quickEnd = System.nanoTime();
      quickTime = quickEnd - quickStart;

      System.out.println("A million elements");
      System.out.println
      ("Time to execute mergesort/quicksort: " + mergeTime+" / "+quickTime);
   }
}
