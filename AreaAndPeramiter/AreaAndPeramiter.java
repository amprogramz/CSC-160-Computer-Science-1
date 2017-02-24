//////////////////////////////
//Alec Mcdaugale//////////////
//csc 160/////////////////////
//////////////////////////////

//import swing JOptionPane (GUI) options,
//and java util for (CMD)output, havent figured out how to save data to a text file yet.

import javax.swing.JOptionPane;
import java.util.*;

//program file name
public class AreaAndPeramiter
{
   //not exactly shure what this is yet, if possible clarify, the book goes over this part 
   //vaguely in chapter 2 but im curios to where else you would use this
   public static void main(String args[])
   {
      //Declarations
      //name on the window
      String n = "Area and Peramiter";
      //corrects user if they input length and width of a square instead of a rectangle 
      String ifSquare = " ";
      
      //name of the user
      String name = (String)(JOptionPane.showInputDialog(null,
         "Please enter your name:",
         n,
         JOptionPane.PLAIN_MESSAGE));
         
      //initalise Continue as true to enter loop
      boolean Continue = true;
    while (Continue = true)
    {
      //let the user enter the length and width
      int length = Integer.parseInt(JOptionPane.showInputDialog(null,
         name + ", what is the lenght of your rectangle?",
         n,
         JOptionPane.PLAIN_MESSAGE));
         
      //i added this part for fun, prints info in console to create a record
      System.out.println(name + " input: \nLength: " + length);
      
      int width = Integer.parseInt(JOptionPane.showInputDialog(null,
         name + ", what is the width?",
         n,
         JOptionPane.PLAIN_MESSAGE));
      System.out.println("Width: " + width);
      
      //equation to calculate area,
      //equation to calculate peramiter.
      int area = length * width;
      int peramiter = (length * 2) + (width * 2);  
      
      if (length == width)
         ifSquare = "\nYour shape is actually a square";
      else
         ifSquare = " ";
      // display results
      System.out.println( "\nArea = " + area + "\nPeramiter = " + peramiter + "\n");
      
      JOptionPane.showMessageDialog(null, "Ok " + name + ifSquare + 
         "\nThe area is:      " + area + "\nThe peramiter: " + peramiter,
         n,
         //leaves no icon, plain message
         JOptionPane.PLAIN_MESSAGE);
         
      //prompt user to continue or quit,
      //loop or exit array   
      Object[] options = {"Continue",
                          "Quit"};
      //set answer to equal the input option                    
      int answer = JOptionPane.showOptionDialog(null,
         //text displayed
         "Would you like to continue?",
         //name on window
         n,
         //i chose the yes no option and replaced those values with the options array
         JOptionPane.YES_NO_OPTION,
         //displays the question mark whear the icon goes
         JOptionPane.QUESTION_MESSAGE,
         null,
         //area to specify the string arrays for button text
         options,
         //default selection
         options[0]);
      //if logic, if answer = yes boolean = true else quit
      if (answer == JOptionPane.YES_OPTION)
         Continue = true;
      else
         System.exit(0);
         //byebye
      
    }//end while    
   
   }
}
   
