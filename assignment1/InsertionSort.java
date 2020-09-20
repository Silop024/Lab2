/*     README
**
**Author Jack Webb 2020-09-11
**Last updated .......
**A sorting method which takes an array of integers and sorts them
**in ascending order (left to right).
**
**
**
**
*/




import java.util.*;
import java.io.*;

/*Insertionsort starts by assuming the first element is sorted.
**This is why current starts at 1. If the current element we
**are inspecting is smaller than it's predecessor we enter the
**inner loop. While there we go back down the array until we
**either reach an element that is smaller than the current or
**until we reach the first index 0.
*/
public class InsertionSort
{
   public static void insertionSort(int[] array)
   {
      //Local variable used to index the currently inspected element
      int current = 1;
      //Local variable used to index the hole
      int hole;
      //Local variable used to store the value of the current element
      int number;

      while(current <= array.length - 1)
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
            //Print the array after every inner loop iteration
            print(array);
            //Move the hole one step down the array
            hole--;
         }
         //Put the stored value in the hole
         array[hole] = number;
         //Increment current to inspect the next element
         current++;
      }
      //Print the array and number of swaps when all is done
      print(array);
   }

   //Print each element in the array with a newline after.
   public static void print(int[] array)
   {
      for(int e : array)
         System.out.print(e);
      System.out.println();
   }

   //Main method for testing the augmentSort method
   public static void main(String[] args)
      throws Exception
   {
      Scanner in = new Scanner(System.in);
      int size;

      System.out.println("How many integers do you want to input?");
      size = in.nextInt();

      int[] arr = new int[size];
      int i = 0;

      System.out.println("Input:");

      while(i < arr.length)
      {
         arr[i++] = in.nextInt();
      }

      System.out.println("Before insertionSort:");
      print(arr);
      insertionSort(arr);
      System.out.println("After insertionSort:");
      print(arr);




      //Test code for question 1
      System.out.println();
      System.out.println("Question 1 demo:");
      int[] array = {1, 2, 4, 3, 5, 0};
      System.out.println("Before insertionSort:");
      print(array);
      insertionSort(array);
      System.out.println("After insertionSort:");
      print(array);
   }
}
