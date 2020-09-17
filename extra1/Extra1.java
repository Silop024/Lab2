import java.util.*;
import java.io.*;

public class Extra1
{
   public static void insertionSort(int[] array)
   {
      //Local variable used to index the currently inspected element
      int current = array.length - 2;
      //Local variable used to index the hole
      int hole;
      //Local variable used to store the value of the current element
      int number;

      while(current > 0)
      {
         //Store the value of the current element
         number = array[current];
         //Set the hole to the current index being inspected
         hole = current;

         //The inner loop
         while(((array.length - 1) > hole) && (number < array[hole + 1]))
         {
            //Move the current one step down the array
            array[hole] = array[hole + 1];
            //Print the array after every inner loop iteration
            print(array);
            //Move the hole one step down the array
            hole++;
         }
         //Put the stored value in the hole
         array[hole] = number;
         //Increment current to inspect the next element
         current--;
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
