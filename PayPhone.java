//alec
//csc 160
//payphone calculator, calculates rates for payphone

//sorry i havent been online much, i will not have wifi until the 23 of june, we just moved to a new appartment but this week im going to use my slow mobile internet. 



import javax.swing.JOptionPane;


public class PayPhone
{

   public static void main (String[] args)
   {
      
      //declarations
      //final valies
      final double INITAL_CONNECTION = 1.99;
      final double FIRST_THREE_MINUTES = 2.00;
      final double EACH_ADITIONAL_MINUTE = 0.45;
      //program name
      final String NAME = "Pay Phone";
      //minutes string
      String minutesStr;
      //output
      String outputStr = new String();
      //num out
      double output;
      //minutes determine rate with logic
      minutesStr = new String(JOptionPane.showInputDialog( "Please enter the number of minutes, \nthat the call lasted." ));
      //convert minutes to num type
      int minutes = Integer.parseInt(minutesStr);
      
      //if its less than 0 its an invalid time
      if (minutes < 0)
         outputStr = "invalid entry, \nNegative time not accepted, \nand it must be a valid time \nfrom 0 to infinity d:";
      else
         //if minutes are 0 your call still gets the initial connection fee 
         if (minutes == 0)
           {
            output = INITAL_CONNECTION; 
            outputStr = "Your call lasted: " + minutes + " minutes. \nA total of $" + output + " will be charged";
           }            
         else
            //in minutes are less than equal to 3 the first three minutes fee is added
            if (minutes <= 3)
              {
               output = INITAL_CONNECTION + FIRST_THREE_MINUTES;
               outputStr = "Your call lasted: " + minutes + " minutes. \nA total of $" + output + " will be charged";
              }             
               else 
               //else each additional minute is added on
               if (minutes > 3)
                 {
                  output = INITAL_CONNECTION + FIRST_THREE_MINUTES + ((minutes - 3) * EACH_ADITIONAL_MINUTE);
                  outputStr =  "Your call lasted: " + minutes + " minutes. \nA total of $" + String.format("%.2f",output) + " will be charged";
                 } 
               
               
      //rating system, response is based on case for the grade 
      //it kinda gives this phone an attitude lol        
     JOptionPane.showMessageDialog(null, 
                  outputStr,
                  NAME,
                  JOptionPane.PLAIN_MESSAGE);
                  
     //still working on this part, im trying to create a drop down menue with this array
     Object[] grade = {"A",
                     "B",
                     "C",
                     "D",
                     "F"};             
     String rating = (String)JOptionPane.showInputDialog(null,
         "Please rate your experience: \nA B C D F?",         
         grade[0]);
    String Out = new String(); 
    
    //Switch controles outputs based on the users feedback  
    switch (rating)
    {
    case "A":
    case "B":
    case "C":
      Out = "Thank you, have a nice day!";
      break;
    case "D":
    case "F":
      Out = "Sorry, better luck next time!";
    }
    
    //Displays response to grade
    JOptionPane.showMessageDialog(null, 
      Out,
      NAME,
      JOptionPane.PLAIN_MESSAGE);  
    
    //forgot this
    System.exit(0);
      
         
    
               
   }
}
             
      
      //wanted to try something new but i changed my mind
      //switch (minutes)
      //{
      //case 1:
      //} 
      
      
      