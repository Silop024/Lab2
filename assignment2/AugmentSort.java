/*README
**
**Author Jack Webb 2020-09-11
**Last updated .......
**A sorting method which takes an array of integers and sorts them
**in ascending order (left to right).
**
**Since we set hole = current at the start of each iteration inside
**augmentSort the only possible way hole != current is if an element
**is being swapped due to it having to go into the while loop and
**the hole being decremented in doing so.
*/

import java.io.*;
import java.util.*;

public class AugmentSort
{
   /*Insertionsort starts by assuming the first element is sorted.
   **This is why current starts at 1. If the current element we
   **are inspecting is smaller than it's predecessor we enter the
   **inner loop. While there we go back down the array until we
   **either reach an element that is smaller than the current or
   **until we reach the first index 0.
   */
   public static void augmentSort(int[] array)
   {
      //Local variable to count swaps
      int swaps = 0;
      //Local variable used to index the currently inspected element
      int current = 1;
      //Local variable used to index the hole
      int hole;
      //Local variable used to store the value of the current element
      int number;

      //The outer loop
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
            //Print the array after every inner loop iteration
            print(array);
            //Move the hole one step down the array
            hole--;
         }
         //Check if we entered the while loop and increment swap if so
         if(hole != current)
            swaps++;
         //Put the stored value in the hole
         array[hole] = number;
         //Increment current to inspect the next element
         current++;
      }
      //Print the array and number of swaps when all is done
      print(array);
      System.out.println("Number of swaps: " + swaps);
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

      //Almost same code as Lab 1 assignment 2
      //I didnt want to input one integer at a time
      //Had to add -48 because of ASCII values
      InputStreamReader input = new InputStreamReader(System.in);
      int number = (input.read() - 48);

      while((i < size) && !(number == '\n'))
      {
         arr[i++] = number;
         number = (input.read() - 48);
      }

      System.out.println("Before insertionSort:");
      print(arr);
      System.out.println();
      augmentSort(arr);
      System.out.println("After insertionSort:");
      print(arr);



      //Test code for question 1
      System.out.println();
      System.out.println("Question 1 demo:");
      int[] array = {1, 2, 4, 3, 5, 0};
      System.out.println("Before insertionSort:");
      print(array);
      System.out.println();
      augmentSort(array);
      System.out.println("After insertionSort:");
      print(array);
   }
}
