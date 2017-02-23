//////////////////////////////////
//alec**************************//
//csc 160***********************//
//////////////////////////////////
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

public class gpaStatistics
{
   public static void main(String []args)
                     throws FileNotFoundException
   {
      
      //declarations
      //initialized gender to nothing to enter the loop
      String gender = "";
      String output;
      //
      //String str;
      //program name string literal
      String progName = "GPA Calculator" ;
      //female string
      String fstr;
      //male string
      String mstr;
      String school;
      String discard;
      
      //double to hold genderless gpa value
      double gpa = 0;
      //one female gpa
      double fGPA = 0;
      //one male gpa
      double mGPA = 0;
      //female total average
      double fAverage = 0;
      //male total average
      double mAverage = 0;
      //female count
      int fCount = 0;
      //male count
      int mCount = 0;
     
     //chose to make the boolean manual into String Mode to have more than 2 posibilities
     //i had an error where when the first loop became false it enters the next loop 
     //instead of returning to the beginning like i wanted it to
     // boolean manual = false;
      //mode is declared as empty
      String Mode = "";
      //edit is always true
      //master loop value
      boolean edit = true;
      
    //master loop
    while (edit == true)
    {//master loop
      //reset values to 0 for acuracy
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
      //switch to control options
      //i figured out that it works like this too in place of an if                                         
      switch (mode)
      {
         case JOptionPane.YES_OPTION:
            //manual = true;
            Mode = "manual";
            break;
         case JOptionPane.NO_OPTION:
            //manual = false;
            Mode = "open";
            break;
         default:
            System.exit(0);
      }
   //old unincluded lines, i left them incase i wana use them again   
   //boolean edit = true;   
    //while ( manual != false)
    
    //manual entry
    while ( Mode.equals( "manual" ) )
    {//while Mode = manual
      
      //chose a file
      school = JOptionPane.showInputDialog( null,
                                                   "Please enter the schools name.",
                                                   progName,
                                                   JOptionPane.PLAIN_MESSAGE);
                                                   
      //this if else structure diddnt work for me, cant open the outFile or inFile in if statements                                             
      //if ( manual != false)
      
      //create the .txt file                             
      PrintWriter outFile = new PrintWriter("e:\\" + school + "GPA_Averages.txt" );
      
      //else if ( manual != true)
      //{
         
              //}
      
      
      //sentinal controlled loop
      while ( !gender.equalsIgnoreCase("q") )
      {//while not q
         
         //excluded, left for  furthur development  
        // if ( manual == true )
         //{
         //gender = input either f, m, or q to quit
         
         //input gender
         gender = JOptionPane.showInputDialog( null,
                                               "Please enter the students gender \n   either 'f' or 'm', 'q' if your done",
                                               progName,
                                               JOptionPane.QUESTION_MESSAGE );
         //}
        // else if (manual != true)
        // {/
           //         }
                                               
         //outFile.print(gender);
         
                                                        
         //the gender switch, i decided to try something other than the nested if sice only 3 answers are possible
         //6 if you include both upper and lower case                               
         switch (gender)
         {
            //female case
            case "F":
            case "f":
               //if ( manual = true )
               //{
               
                  //get students gpa
                  gpa = Double.parseDouble(JOptionPane.showInputDialog( null,
                                            "please enter the students gpa",
                                            progName,
                                            JOptionPane.QUESTION_MESSAGE ));
               //}
               //else if ( manual != true )
                  //gpa = inFile.nextInt();
                  
               // if logic in switch to calculate gpa, so that invalid input is not accepted
               if (gpa > 5)
               {
                  JOptionPane.showMessageDialog( null,
                                                 "invalid GPA value, \n GPA value is too hi.",
                                                 "error",
                                                 JOptionPane.ERROR_MESSAGE );
               } 
               else if (gpa >= 0)
               {
                  fGPA += gpa;
                  fCount++;
                  //output gpa and gender
                  output = String.format( "%s %2.2f%n", gender, gpa);
                     
                  outFile.print(output);
               }   
               else if (gpa < 0)
               {
                  JOptionPane.showMessageDialog( null,
                                                 "invalid GPA value, \n must be a positive value.",
                                                 "error",
                                                 JOptionPane.ERROR_MESSAGE );
               }
               
            break;
            //male case
            case "m":
            case "M":
               //if ( manual == true )
               //{
                  gpa = Double.parseDouble(JOptionPane.showInputDialog( null,
                                            "please enter the students gpa",
                                            progName,
                                            JOptionPane.QUESTION_MESSAGE ));
               //}
               //else if ( manual != true )
                  //gpa = inFile.nextInt();
                                            
                              
               
               //calculates math only if the gpa has a positive value, else it shows an error message
               //also the value needs to be less than 5.0
               //this allows for the addition of extra credit to the gpa, but wont allow the user to 
               //enter 45 instead of 4.5 wich would throw off the average
               if (gpa > 5)
               {
                  JOptionPane.showMessageDialog( null,
                                                 "invalid GPA value, \n GPA value is too hi.",
                                                 "error",
                                                 JOptionPane.ERROR_MESSAGE );
               } 
               else if (gpa >= 0)
               {
                  
                  mGPA += gpa;
                  mCount++;
                  //i put this here to avoid invalid input to be wrote to the file.
                  output = String.format( "%s %2.2f%n", gender, gpa);
                     
                  outFile.print(output);
               }//wont allow for numbers less than 0 to be input   
               else if (gpa < 0)
                  JOptionPane.showMessageDialog( null,
                                                 "invalid GPA value, \n must be a positive value.",
                                                 "error",
                                                 JOptionPane.ERROR_MESSAGE );

               
            break;
            case "Q":
            case "q":
               //if q output q at end of file
               output = String.format( "%s", gender);
               outFile.print(output);
            break;
            default: JOptionPane.showMessageDialog( null,
                                                    "Invalid Input \n input value must be either m, f, or q.",
                                                    "error",
                                                    JOptionPane.ERROR_MESSAGE);
         }//end switch
        
       
       
       
 
         
      }//end while
      // the next two if statements were added to prevent an error when trying to divide a number by 0
      // i also added n/a when there are no male or female scores input
      //  *ex: all male/female school
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
         //made this a string so i could output n/a if this instance occurs
         mstr = String.format("%3.2f", mAverage);
      }
      else 
         mstr = "n/a";
         
      //output message
      JOptionPane.showMessageDialog( null,
                                     "Yor average GPA's are: \n    Female:  " + fstr +
                                     "\n    Male:       " + mstr,
                                     progName,
                                     JOptionPane.INFORMATION_MESSAGE );
                                     
    // if ( manual == true )
        outFile.close();
    // else if ( manual != false )
          
      
         
      Mode = "";      
      //manual = false;
      //system exit                               
      //System.exit(0);
      }//end while 
      
      
      
      
      //while ( manual != true )
      while ( Mode.equals("open") )
      {// mode = open
      school = JOptionPane.showInputDialog( null,
                                            "Please enter the name of the school \naverages you want to view.",
                                            progName,
                                            JOptionPane.PLAIN_MESSAGE);
      // public void();                             
       try
         {
            Scanner inFile = new Scanner(new FileReader("e:\\" + school + "GPA_Averages.txt" ));  
         
         
         gender = "";
         
         //added this if so that if a blank txt file is open or created data is non applicable
         if (!inFile.hasNext())
            gender = "q";
        // 
        //while ( inFile.hasNext() )
        while ( !gender.equalsIgnoreCase( "q" ))
         {//while gender != q
            gender = inFile.next();
            
           if (!gender.equalsIgnoreCase( "q" ) )
           {
               gpa = inFile.nextFloat();
               //discard = inFile.nextLine();
            

            
            //inFile.nextln();
             
            if ( gender.equalsIgnoreCase("f"))
            {
               fGPA += gpa;
               fCount++;
            }
            else if ( gender.equalsIgnoreCase( "m" ))
            {
               mGPA += gpa;
               mCount++;
            }
           
           //doesent work here
           // else if ( gender.equals("") )
              // gender = "q";
           }
            //scan.nextln();
         }//endwhile
      
         // prevents non aplicable fields from being displayed
         //ex. all male/female academy
         if (fCount > 0)
         {
            fAverage = fGPA / fCount;
            fstr = String.format("%3.2f", fAverage);
         }
         else //if ( gender.equals("") )
            fstr = "n/a";
         
         if (mCount > 0)
         {
            mAverage = mGPA / mCount;
            mstr = String.format("%3.2f", mAverage);
         }
         else //if ( gender.equals("") )
            mstr = "n/a";
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
                                     
        //if ( loop == JOptionPane.NO_OPTION )
           //System.exit(0);
           //manual = true;
           Mode = "";

        //closes inFile    
        inFile.close();
        //prints error when file not there    
        }catch (Exception e){
         System.out.println("error");
        }

       }//end while
   
    
      
      
     }//end while 
                                       
   }//end void
}//end class


            
            
            