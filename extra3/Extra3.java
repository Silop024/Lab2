/*README
**Author Jack Webb 2020-09-20
**
**
**
**
*/

import java.util.Random;

public class Extra3
{
    //Simple method that swaps two elements in an array
    public static void swap(int[] array, int i, int j)
    {
       int temp = array[i];
       array[i] = array[j];
       array[j] = temp;
    }

    /*****************QUICKSORT FIRST ELEMENT PARTITION*****************/
    public static void quickSortP(int[] array, int low, int high)
    {
       if(low < high)
       {
          int p = partition(array, low, high);
          quickSortP(array, low, p - 1);
          quickSortP(array, p + 1, high);
       }
    }

    public static int partition(int[] array, int low, int high)
    {
        //Pivot element
        int pivot = array[high];
        //Partitioning item
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


    /*******************QUICKSORT WITH MEDIAN-OF-THREE PIVOT***************/
    public static void quickSortM(int[] array, int low, int high)
    {
        if(low < high)
        {
            int p = medOfThree(array, low, high);
            quickSortM(array, low, p - 1);
            quickSortM(array, p + 1, high);
        }
    }

    public static int medOfThree(int[] array, int low, int high)
    {
        //Set mid to the middle index of the array
        int mid = (low + high) / 2;

        //If the element in the middle is less than the element in the lowest,
        //swap them
        if(array[mid] < array[low])
            swap(array, low, mid);

        //If the element in the highest index is less than the lowest, swap
        if(array[high] < array[low])
            swap(array, low, high);

        //If thte element in the middle index is less than the highest, swap
        if(array[mid] < array[high])
            swap(array, mid, high);

        //If it the first or none if-condition, pivot is high.
        //If it entered the first and second, pivot is mid.
        //If it entered all three, pivot is low
        //This makes sure that there exists at least one lower and one higher
        //element each side of the pivot

        //Pivot is high if: It never entered an if-condition or only first.
        //Pivot is mid if: It entered the first two if, or if it entered the last.
        //Pivot is low if: It entered all three if, it entered the second if, or
        //it entered the first and last if.
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

    /*To get a fair evaluation of the time differences of two sorting methods,
    **this method fills two arrays with the same elements in both with integers
    **between -99 and 99.
    */
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

    //A method to print the arrays when desired
    public static void print(int[] array)
    {
       for(int e : array)
          System.out.print("[" + e + "]");
       System.out.println();
    }


    //Variables used for storing the time it takes to execute a method
    static long quickStart1;
    static long quickEnd1;
    static long quickTime1;

    static long quickStart2;
    static long quickEnd2;
    static long quickTime2;


    public static void main(String[] args) {
       int[] array1 = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
       int[] array2 = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

       quickStart1 = System.nanoTime();
       quickSortP(array1, 0, array2.length - 1);
       quickEnd1 = System.nanoTime();
       quickTime1 = quickEnd1 - quickStart1;
       System.out.print("Sorted with quicksort: ");
       print(array1);
       System.out.println("Time to execute first element: " + quickTime1);

       quickStart2 = System.nanoTime();
       quickSortM(array2, 0, array2.length - 1);
       quickEnd2 = System.nanoTime();
       quickTime2 = quickEnd2 - quickStart2;
       System.out.print("Sorted with quicksort: ");
       print(array2);
       System.out.println("Time to execute median-of-three: " + quickTime2);

       /********TEN ELEMENTS******/
       //Initializing and filling the arrays
       int[] ten1       = new int[10];
       int[] ten2       = new int[10];
       filler(ten1, ten2);

       //Quick sorting the array while timing it
       quickStart1 = System.nanoTime();
       quickSortP(ten1, 0, ten1.length - 1);
       quickEnd1 = System.nanoTime();
       quickTime1 = quickEnd1 - quickStart1;
       print(ten1);

       //Quick sorting (median-of-three) the array while timing it
       quickStart2 = System.nanoTime();
       quickSortM(ten2, 0, ten2.length - 1);
       quickEnd2 = System.nanoTime();
       quickTime2 = quickEnd2 - quickStart2;
       print(ten2);

       //Printing the time it took for each sorting algorithm
       System.out.println("Ten elements");
       System.out.println
       ("Time to execute first element/median of three: " + quickTime1+"/ "+quickTime2);

       /******A HUNDRED ELEMENTS*******/
       int[] hundred1   = new int[100];
       int[] hundred2   = new int[100];
       filler(hundred1, hundred2);

       quickStart1 = System.nanoTime();
       quickSortP(hundred1, 0, hundred1.length - 1);
       quickEnd1 = System.nanoTime();
       quickTime1 = quickEnd1 - quickStart1;

       quickStart2 = System.nanoTime();
       quickSortM(hundred2, 0, hundred2.length - 1);
       quickEnd2 = System.nanoTime();
       quickTime2 = quickEnd2 - quickStart2;

       System.out.println("Hundred elements");
       System.out.println
       ("Time to execute first element/median of three: " + quickTime1+"/ "+quickTime2);

       /******A THOUSAND ELEMENTS********/
       int[] thousand1  = new int[1000];
       int[] thousand2  = new int[1000];
       filler(thousand1, thousand2);

       quickStart1 = System.nanoTime();
       quickSortP(thousand1, 0, thousand1.length - 1);
       quickEnd1 = System.nanoTime();
       quickTime1 = quickEnd1 - quickStart1;

       quickStart2 = System.nanoTime();
       quickSortM(thousand2, 0, thousand2.length - 1);
       quickEnd2 = System.nanoTime();
       quickTime2 = quickEnd2 - quickStart2;

       System.out.println("A thousand elements");
       System.out.println
       ("Time to execute first element/median of three: " + quickTime1+"/ "+quickTime2);

       /********TEN THOUSAND ELEMENTS******/
       int[] tt1        = new int[10000];
       int[] tt2        = new int[10000];
       filler(tt1, tt2);

       quickStart1 = System.nanoTime();
       quickSortP(tt1, 0, tt1.length - 1);
       quickEnd1 = System.nanoTime();
       quickTime1 = quickEnd1 - quickStart1;

       quickStart2 = System.nanoTime();
       quickSortM(tt2, 0, tt2.length - 1);
       quickEnd2 = System.nanoTime();
       quickTime2 = quickEnd2 - quickStart2;

       System.out.println("Ten thousand elements");
       System.out.println
       ("Time to execute first element/median of three: " + quickTime1+"/ "+quickTime2);

       /******HUNDRED THOUSAND ELEMENTS********/
       int[] ht1        = new int[100000];
       int[] ht2        = new int[100000];
       filler(ht1, ht2);

       quickStart1 = System.nanoTime();
       quickSortP(ht1, 0, ht1.length - 1);
       quickEnd1 = System.nanoTime();
       quickTime1 = quickEnd1 - quickStart1;

       quickStart2 = System.nanoTime();
       quickSortM(ht2, 0, ht2.length - 1);
       quickEnd2 = System.nanoTime();
       quickTime2 = quickEnd2 - quickStart2;

       System.out.println("Hundred thousand elements");
       System.out.println
       ("Time to execute first element/median of three: " + quickTime1+"/ "+quickTime2);

       /*******A MILLION ELEMENTS**********/
       int[] million1   = new int[1000000];
       int[] million2   = new int[1000000];
       filler(million1, million2);
       System.out.println("Filled with a million integers");

       quickStart1 = System.nanoTime();
       quickSortP(million1, 0, million1.length - 1);
       quickEnd1 = System.nanoTime();
       quickTime1 = quickEnd1 - quickStart1;

       quickStart2 = System.nanoTime();
       quickSortM(million2, 0, million2.length - 1);
       quickEnd2 = System.nanoTime();
       quickTime2 = quickEnd2 - quickStart2;

       System.out.println("A million elements");
       System.out.println
       ("Time to execute first element/median of three: " + quickTime1+"/ "+quickTime2);
    }
}
