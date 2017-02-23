//////////////////////////////////
//alec**************************//
//csc 160***********************//
//////////////////////////////////
//THE NEW AND IMPROVED GPA CALC //
//   This is the gpa statistics //
//calculator program. It assums //
//that you create the text file //
//with this program to avoid user/
//error.                        // 
//To open txt file just enter   //
//the name of the institution   //
//and the rest is done for you. //
//////////////////////////////////


import javax.swing.*;
import java.util.*;
import java.io.*;

public class gpaStatistics2
{
   //declared these to use in methods
   private static String fstr, mstr, gender, output;
   
   private static double fGPA, mGPA, GPA;
   private static int fCount, mCount;
   //double GPA;
   
   //main method, tried to shorten this as much as possible
   //still had to use my loops for the menue system for now, may shorten with furthur developement
   public static void main(String []args)
                     throws FileNotFoundException
   {
      gender = "";
      //String output;
      String progName = "GPA Calculator"; 
      String school;
      String discard;
      double gpa = 0;
      fGPA = 0;
      mGPA = 0;
     //double fAverage = 0;
     //double mAverage = 0;
      fCount = 0;
      mCount = 0;
      String Mode = "";
      
      boolean edit = true;
    while (edit == true)
    {//master loop
      
      fGPA = 0;
      mGPA = 0;
      fCount = 0;
      mCount = 0;
      gender = "";
    
      //main menue
      //*create a new reccord or overwrite the existing one
      //*open an existing record
      //*System.exit
      Object[] options = {"New",
                          "Open",
                          "Exit"};
      int mode = JOptionPane.showOptionDialog( null,
                                               "Chose the mode.",
                                               progName,
                                               JOptionPane.YES_NO_CANCEL_OPTION,
                                               JOptionPane.PLAIN_MESSAGE,
                                               null,
                                               options,
                                               options[0]);
                                               
      switch (mode)
      {
         case JOptionPane.YES_OPTION:
            Mode = "manual";
            break;
         case JOptionPane.NO_OPTION:
            Mode = "open";
            break;
         default:
            System.exit(0);
      }
      
      
       
    //manual entry
    while ( Mode.equals( "manual" ) )
    {//while Mode = manual
      
      
      school = JOptionPane.showInputDialog( null,
                                                   "Please enter the schools name.",
                                                   progName,
                                                   JOptionPane.PLAIN_MESSAGE);
                                                   
            
      //create the .txt file                             
      PrintWriter outFile = new PrintWriter("e:\\" + school + "GPA_Averages.txt" );
      
               
                   
      
      //sentinal controlled loop
      while ( !gender.equalsIgnoreCase("q") )
      {//while not q
         
                  
         //input gender
         gender = JOptionPane.showInputDialog( null,
                                               "Please enter the students gender \n   either 'f' or 'm', 'q' if your done",
                                               progName,
                                               JOptionPane.QUESTION_MESSAGE );
                                               
         
                                            
         //shorter switch structure                          
         switch (gender)
         {
            //female case
            case "F":
            case "f":
               
               gpa = Double.parseDouble(JOptionPane.showInputDialog( null,
                                            "please enter the students gpa",
                                            progName,
                                            JOptionPane.QUESTION_MESSAGE ));
                  
               fGPA = sumGrades(gpa,fGPA, mGPA, gender); 
               //fCount++;  
               
               printGrades(outFile, gender, gpa);
                              
            break;
            //male case
            case "m":
            case "M":
              gpa = Double.parseDouble(JOptionPane.showInputDialog( null,
                                            "please enter the students gpa",
                                            progName,
                                            JOptionPane.QUESTION_MESSAGE ));
                  
              mGPA = sumGrades(gpa,fGPA, mGPA, gender); 
              //mCount++;  
              
              printGrades(outFile, gender, gpa);
              break;
            case "Q":
            case "q":
               printGrades(outFile, gender, gpa);
               //if q output q at end of file
               //output = String.format( "%s", gender);
               //outFile.print(output);
            break;
            default: JOptionPane.showMessageDialog( null,
                                                    "Invalid Input \n input value must be either m, f, or q.",
                                                    "error",
                                                    JOptionPane.ERROR_MESSAGE);
         }//end switch
        
       }//end while
      
      //replaces avg if statements
      averageGrade(fCount, fGPA, mCount, mGPA);         
      //output message
      JOptionPane.showMessageDialog( null,
                                     "Yor average GPA's are: \n    Female:  " + fstr +
                                     "\n    Male:       " + mstr,
                                     progName,
                                     JOptionPane.INFORMATION_MESSAGE );
                                     
    
       outFile.close();
       Mode = "";      
    }//end while 
      
      
      
      
      //open loop
      while ( Mode.equals("open") )
      {// mode = open
      school = JOptionPane.showInputDialog( null,
                                            "Please enter the name of the school \naverages you want to view.",
                                            progName,
                                            JOptionPane.PLAIN_MESSAGE);
                                   
       try
         {
            Scanner inFile = new Scanner(new FileReader("e:\\" + school + "GPA_Averages.txt" ));  
         
         
         gender = "";
         
         //added this if so that if a blank txt file is open or created data is non applicable
         if (!inFile.hasNext())
            gender = "q";
        
        while ( !gender.equalsIgnoreCase( "q" ))
         {//while gender != q
            gender = inFile.next();
            
           if (!gender.equalsIgnoreCase( "q" ) )
           {
               gpa = inFile.nextFloat();
                                      
            if ( gender.equalsIgnoreCase("f"))
            {
               fGPA = sumGrades(gpa,fGPA, mGPA, gender);
               //fCount++;
            }
            else if ( gender.equalsIgnoreCase( "m" ))
            {
               mGPA = sumGrades(gpa,fGPA, mGPA, gender);
               //mCount++;
            }           
           }
         }//endwhile
         
         //new average method
         averageGrade(fCount, fGPA, mCount, mGPA);
                    
        /*Object[] options2 = {"Again",
                           "Quit" };*/    
        /*int loop =*/ JOptionPane.showMessageDialog( null,
                                     "Yor average GPA's are: \n    Female:  " + fstr +
                                     "\n    Male:       " + mstr,
                                     progName,
                                     JOptionPane.INFORMATION_MESSAGE/*,
                                     JOptionPane.YES_NO_OPTION,
                                     null,
                                     options2,
                                     options2[0]*/);
                                     
        Mode = "";

        inFile.close();
            
        }catch (Exception e){
         System.out.println("error");
        }

       }//end while
   
    
      
      
     }//end while 
                                       
   }//end void
   
   //i was trying to overload this, but i couldent figure this out yet
   //public static void sumGrades()
   //public void sumGrades(double gpa, double fGPA, String gender)
   public static double sumGrades(double gpa, double fGPA, double mGPA, String gender)
   {
      
         if (gpa > 5)
               {
                  JOptionPane.showMessageDialog( null,
                                                 "invalid GPA value, \n GPA value is too hi.",
                                                 "error",
                                                 JOptionPane.ERROR_MESSAGE );
               } 
               else if (gpa >= 0)
               {
                    if (gender.equalsIgnoreCase("f"))
                    {
                       GPA = fGPA + gpa;
                       fCount++;
                    }
                    else if (gender.equalsIgnoreCase("m"))
                    {
                       GPA = mGPA + gpa;
                       mCount++;
                    }
                                     
               }                  
               else if (gpa < 0)
               {
                  JOptionPane.showMessageDialog( null,
                                                 "invalid GPA value, \n must be a positive value.",
                                                 "error",
                                                 JOptionPane.ERROR_MESSAGE );
               }
               
      return GPA; 
      
      
   }
   
   //average grade method returns a String
   public static String averageGrade(int fCount, double fGPA, int mCount, double mGPA )
   {//avg
         // prevents non aplicable fields from being displayed
         //ex. all male/female academy
         double fAverage, mAverage;
         
         if (fCount > 0)
         {
            fAverage = fGPA / fCount;
            fstr = String.format("%3.2f", fAverage);
         }
         else 
            fstr = "n/a";
         
         if (mCount > 0)
         {
            mAverage = mGPA / mCount;
            mstr = String.format("%3.2f", mAverage);
         }
         else 
            mstr = "n/a";
            
      return mstr;

   }//end avg grade
   
   //method to print grades gender and q
   public static void printGrades(PrintWriter outFile, String gender, double gpa)
   {
   if (gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("m"))
      output = String.format( "%s %2.2f%n", gender, gpa);
   else if (gender.equalsIgnoreCase("Q"))
      output = String.format( "%s", gender);
                     
   outFile.print(output);
   }
   
}//end class


            
            
            