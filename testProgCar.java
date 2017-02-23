////////////////////////////
//ALEC                    //
//CSC 160                 //
////////////////////////////
//    This program was made/
// to test the class car. //
////////////////////////////


//needed for main 
import java.util.*;

//my test program
public class testProgCar
{
   //main method
   public static void main (String[] args)
   {
      //i created a saturn with both valid input
      car Saturn = new car("Saturn Ion", 1922, "Black", 50000);
      //i created the cobra with invalid paramaters
      car Ford = new car("Shelby Cobra", 1844, "gray", -5);
      //i created the charger wit the max and min values respectively
      car Dodge = new car("Dodge Charger", 2014, "Red", 0);
      //i just like this car, it costs a half a million and its fast 
      car Ferrari = new car("Ferrari enzo", 2008, "Yellow", 2800);
      //tests hi value
      car test = new car("test1bad", 2015, "Mustard", 100); 
      //vice versa
      car test2 = new car("test2bad", 1879, "blue", -1);
      
      //prints the results
      System.out.print( Saturn + "\n\n" + Ford + "\n\n" + Dodge + "\n\n" + Ferrari + "\n\n" + test + 
         "\n\n" + test2 );  
   }
   
}