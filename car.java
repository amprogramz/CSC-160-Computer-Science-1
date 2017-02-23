//////////////////////////////
//ALEC                      //
//CSC 160                   //
//////////////////////////////
//   This class was created //
//to display car information//
//possibly could be used for//
//auto listings like on a   //
//site like auto tader.     //
//////////////////////////////

//don't need these
//actually meuss up my method i defined
/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
*/

//name
public class car
{

   
   //make of car
   private String model;
   private String Model;
   //year
   private String year;
   private int date;
   //color
   private String color;
   private String Color;
   //miles
   //i declared two so i could convert the in into a string so that i can print if there is an 
   //invalid input
   private String miles;
   private int mileage;
   //added a static signature
   private static String AutoSearch;
   
   //this is an experemental part to change the format printer but i didnt get it to work yet
   //private String format;
   
   
   //first constructor car
   public car()
   {
      model = "";
      date = -1;
      color = "";
      mileage = 0;   
   }
   //constructor to define car
   public car(String Model, int Date, String Color, int Mileage)
   {
      model = Model;
      date = Date;
      color = Color;
      mileage = Mileage; 
      
      //i found that i neded this for this part to execute, but what supprised me was it wasnt nessesary
      //to add getStatements() for the return statement to execute in the next set statement.
      setAutoSearchtext();
      setModel();
      setYear();
      setColor();
      setMiles();  
   
   }
   //static method to set signiture
   public static void setAutoSearchtext()
   {
      AutoSearch = "***Auto Search tm.***";  
   }
   //return signiture
   public String getAutoText()
   {
      return AutoSearch;
   }
   //i really did not see this part as nescessary, but i added it to easily upgrade the logic
   public void setModel()
   {
      model.equals( Model );
   }
   //returns the model value
   public String getModel()
   {
      return model;
   }
   //set the year with logic
   public void setYear()
   {
      // i chose this range based on the fact that the first engine wasent even invented before this time
      //by karyl benz so logicly no car could have existed befor this date.
      if(date >= 1879 && date <= 2014)
      {
         //format = "s";
         year = date + "";
         //getDate();
         //getDate();
         
      }
      else
      {
         //took it out because it diddnt work
         //format = "s";
         //i made year a string so i could do this
         year = "error ...INVALID INPUT...";       
      }   
   }
   //get the date
   public String getDate()
   {
     return year;
   } 
   
   //i also did not see this part as necessary, but maybe definitions could be added here
   public void setColor()
   {
      color.equals( Color );
   }
   public String getColor()
   {
      return color;
   } 
   
   //set miles constructor
   //does not allow for negative values
   public void setMiles()
   {
      if (mileage >= 0)
         miles = mileage + "";
      else 
         miles = "error...MILEAGE MUST BE A POSITIVE VALUE...";
   }
   //get results to output
   public String getMiles()
   {
      return miles;
   }
   
   //to string method to format output   
   public String toString()
   {
      return String.format( "%-20s %n%-10s%-20s %n%-10s%-7s %n%-10s%-20s %n%-10s%-7s", AutoSearch, "model: ", model, "year: ", year, "color: ", color, "mileage: ", miles );
   }
   
}
