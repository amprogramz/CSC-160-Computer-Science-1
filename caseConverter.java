/////////////////////////////////////////
//alec*********************************//
//csc 160******************************//
/////////////////////////////////////////
// This program converts any lower case//
//letters to UPPERCASE.                //
// I am currently having issues with my//
//settings to change the color of the  //
//font and GUI background. It seems    //
//like when i change the values for the//
//window color it wont update the window,
//im shure im missed something or there//
//is another method to do this.        //
/////////////////////////////////////////



import javax.swing.*;
import java.awt.*;
//import java.awt.color;
import java.awt.event.*;


//method to extend JFrame from class
public class caseConverter extends JFrame
{
   //declared width and height of the window as constants
   private static final int WIDTH = 800;
   private static final int HEIGHT = 300;
   
   //this works when i put the switch under caseConverter()
   private String color;
  // i created this array to stor the values for the background color
   private int[] c = {0,
                      255,
                      0};
   //i created this array to store the values for the text color, but havent figured out how to implement it yet
   private int[] ct = {255,
                       255,
                       255};
   //enter lable            
   private JLabel enterL;
   //enter the text here
   private JTextField enterTF;
   //created three buttons the convert button, exit button, and settins button wich is still under development
   private JButton enterB, exitB, settingsB;
   
   //these are exception handlers to give the buttons there functions
   private EnterButtonHandeler ebHandeler;
   private ExitButtonHandeler exbHandeler;
   private SettingsButtonHandeler sbHandeler;
   
   //start of JFrame design
   public caseConverter()
   {
      //title
      setTitle("To Upper CASE");
      
      //color = "blue";
      /* switch (color) 
         {
            case "black":
               c[0] = 0;
               c[1] = 0;
               c[2] = 0;
               break;
            case "cyan":
               c[0] = 0;
               c[1] = 255;
               c[2] = 255;
               break;
            case "gray":
               c[0] = 128;
               c[1] = 128;
               c[2] = 128;
               break;
            case "lightGray":
               c[0] = 192;
               c[1] = 192;
               c[2] = 192;
            case "oarnge":
               c[0] = 255;
               c[1] = 200;
               c[2] = 0;
            case "red":
               c[0] = 255;
               c[1] = 0;
               c[2] = 0;
               break;
             case "yellow":
               c[0] = 255;
               c[1] = 255;
               c[2] = 0;
               break;
             case "blue":
               c[0] = 0;
               c[1] = 0;
               c[2] = 255;
               break;
             case "dark gray":
               c[0] = 64;
               c[1] = 64;
               c[2] = 64;
               break;
             case "green":
               c[0] = 0;
               c[1] = 255;
               c[2] = 0;
               break;
             case "magenta":
               c[0] = 255;
               c[1] = 0;
               c[2] = 255;
               break;
             case "pink":
               c[0] = 255;
               c[1] = 175;
               c[2] = 175;
               break;
             case "white":
               c[0] = 255;
               c[1] = 255;
               c[2] = 255;
               break;
          }    */ 
      
      //instantiate the enter lable and enter text field
      enterL = new JLabel("Please enter the text to \nbe converted to upper CASE.", SwingConstants.LEFT);
      enterTF = new JTextField(10);
      
      //convert to all caps
      enterB = new JButton("Convert");
      //instantiate button handler
      ebHandeler = new EnterButtonHandeler();
      //add an action listener
      enterB.addActionListener(ebHandeler);
      
      //exit button
      exitB = new JButton("Exit");
      exbHandeler = new ExitButtonHandeler();
      exitB.addActionListener(exbHandeler);
      
      //settings button
      settingsB = new JButton("Settings");
      sbHandeler = new SettingsButtonHandeler();
      settingsB.addActionListener(sbHandeler);
      
      //create a container
      Container pane = getContentPane();
      //im having isues with this too, no matter how many collums i add it only creates one
      pane.setLayout(new GridLayout( 6, 2 ));
      
      //add componets to pane
      pane.add(enterL);
      pane.add(enterTF);
      pane.add(enterB);
      pane.add(exitB);
      pane.add(settingsB);
      
      
      //This is cool, found it on pg 863
      //im trying to update this part with the switch in the settings
      //sets collor with array
      pane.setBackground(new Color(c[0], c[1], c[2]));
      //i am also trying to do this with the font
     // pane.setColor(new Color(ct[0], ct[1], ct[2]));
      
      //set size by pixles
      setSize(WIDTH, HEIGHT);
      //it is visible
      setVisible(true);
      //closes when you press on the red x
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      
      
   }
   //button handler to convert string from lower case to upper case
   private class EnterButtonHandeler implements ActionListener
   {
      public void actionPerformed (ActionEvent e)
      {
         //get the text input in the text field
         String output =(enterTF.getText());
         
         //and send the text back to upper case
         enterTF.setText( output.toUpperCase() );
      }
   }
   //exit button
   private class ExitButtonHandeler implements ActionListener
   {
      public void actionPerformed (ActionEvent e)
      {
         //exit
         System.exit(0);
      }
   }
   //PROBLEMED SETTINGS OPTION
   private class SettingsButtonHandeler implements ActionListener
   {
      public void actionPerformed (ActionEvent e)
      {
        //choose what you want to change the color of
        Object[] options = {"Background",
                            "Text"};
        int selection = JOptionPane.showOptionDialog(null,
                                      "Select what you wana change the color of.",
                                      "Settings",
                                      JOptionPane.INFORMATION_MESSAGE,
                                      JOptionPane.YES_NO_OPTION,
                                      null,
                                      options,
                                      options[0]);
        //colors array                              
        Object[] colors = {"black",
                           "cyan",
                           "gray",
                           "light gray",
                           "dark gray",
                           "orange",
                           "red",
                           "yellow", 
                           "blue",
                           "green",
                           "magenta",
                           "pink",
                           "white"};
                                                         
        color = (String)(JOptionPane.showInputDialog(null, 
                                    "Please select a color",
                                    "settings",
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    colors,
                                    "black"));
                                    
       //color.setText();
        //if the background is selected
        if (selection == JOptionPane.YES_OPTION)
        { 
        //switch converts the name to the color code                          
         switch (color) 
         {
            case "black":
               c[0] = 0;
               c[1] = 0;
               c[2] = 0;
               break;
            case "cyan":
               c[0] = 0;
               c[1] = 255;
               c[2] = 255;
               break;
            case "gray":
               c[0] = 128;
               c[1] = 128;
               c[2] = 128;
               break;
            case "lightGray":
               c[0] = 192;
               c[1] = 192;
               c[2] = 192;
            case "oarnge":
               c[0] = 255;
               c[1] = 200;
               c[2] = 0;
            case "red":
               c[0] = 255;
               c[1] = 0;
               c[2] = 0;
               break;
             case "yellow":
               c[0] = 255;
               c[1] = 255;
               c[2] = 0;
               break;
             case "blue":
               c[0] = 0;
               c[1] = 0;
               c[2] = 255;
               break;
             case "dark gray":
               c[0] = 64;
               c[1] = 64;
               c[2] = 64;
               break;
             case "green":
               c[0] = 0;
               c[1] = 255;
               c[2] = 0;
               break;
             case "magenta":
               c[0] = 255;
               c[1] = 0;
               c[2] = 255;
               break;
             case "pink":
               c[0] = 255;
               c[1] = 175;
               c[2] = 175;
               break;
             case "white":
               c[0] = 255;
               c[1] = 255;
               c[2] = 255;
               break; 

         }  
         //else if you select the text it should change the color of the text
         //i have not figured out this one yet either                                                           
        }else if (selection == JOptionPane.NO_OPTION)
        {
            switch (color) 
            {
            case "black":
               ct[0] = 0;
               ct[1] = 0;
               ct[2] = 0;
               break;
            case "cyan":
               ct[0] = 0;
               ct[1] = 255;
               ct[2] = 255;
               break;
            case "gray":
               ct[0] = 128;
               ct[1] = 128;
               ct[2] = 128;
               break;
            case "lightGray":
               ct[0] = 192;
               ct[1] = 192;
               ct[2] = 192;
            case "oarnge":
               ct[0] = 255;
               ct[1] = 200;
               ct[2] = 0;
            case "red":
               ct[0] = 255;
               ct[1] = 0;
               ct[2] = 0;
               break;
             case "yellow":
               ct[0] = 255;
               ct[1] = 255;
               ct[2] = 0;
               break;
             case "blue":
               ct[0] = 0;
               ct[1] = 0;
               ct[2] = 255;
               break;
             case "dark gray":
               ct[0] = 64;
               ct[1] = 64;
               ct[2] = 64;
               break;
             case "green":
               ct[0] = 0;
               ct[1] = 255;
               ct[2] = 0;
               break;
             case "magenta":
               ct[0] = 255;
               ct[1] = 0;
               ct[2] = 255;
               break;
             case "pink":
               ct[0] = 255;
               ct[1] = 175;
               ct[2] = 175;
               break;
             case "white":
               ct[0] = 255;
               ct[1] = 255;
               ct[2] = 255;
               break; 
             }
        }                            
     // pane.setBackground(new Color(c[0], c[1], c[2]));                                     
      }
   }
   
   public static void main(String[] args)
   {
      //run the case converter program
      caseConverter caseConverterObj = new caseConverter();
   }
}

      
   