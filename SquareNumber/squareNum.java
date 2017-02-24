import javax.swing.*;


public class squareNum
{
   private static double x;
   private static int num;
   
   public static void main (String []args)
   {
     num = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                                      "Please enter a number",
                                                      "square it",
                                                      JOptionPane.PLAIN_MESSAGE));
      exampleReturn(num);
     
     JOptionPane.showMessageDialog(null,
                                  "now squared: " + num,
                                  "NOW SQUARED",
                                  JOptionPane.PLAIN_MESSAGE);
   }
   
   public static double squareNum( double x )
   {
      //x = x * x;
      return x * x;
   }
}

public void exampleReturn (int num)

{

        if (num > 0)

        {

              return;

         }

}
