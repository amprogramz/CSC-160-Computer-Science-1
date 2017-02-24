import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class test extends JFrame
{
   private static final int WIDTH = 400;
   private static final int HEIGHT = 300;
   
   private JLabel lengthL, widthL, areaL, peramiterL;
   private JTextField lengthTF, widthTF, areaTF, peramiterTF;
   
   private JButton calculateB, exitB;
   
   private CalculateButtonHandeler cbHandeler;
   private ExitButtonHandeler ebHandeler;
   
   public test()
   {
      //title
      setTitle("Area and Peramiter of a rectangle");
      
      //labels
      lengthL = new JLabel("enter the length: ", SwingConstants.RIGHT);
      widthL = new JLabel("enter the width: ", SwingConstants.RIGHT);
      areaL = new JLabel("Area: ", SwingConstants.RIGHT);
      peramiterL = new JLabel("peramiter: ", SwingConstants.RIGHT);
      
      //text fields, enter data here
      lengthTF = new JTextField(10);
      widthTF = new JTextField(10);
      areaTF = new JTextField(10);
      peramiterTF = new JTextField(10);
      
      //buttons
      //calc
      calculateB = new JButton("Calculate");
      cbHandeler = new CalculateButtonHandeler();
      calculateB.addActionListener(cbHandeler);
      
      //exit
      exitB = new JButton("Exit");
      ebHandeler = new ExitButtonHandeler();
      exitB.addActionListener(ebHandeler);
      
      //declare pane as content pane
      Container pane = getContentPane();
      pane.setLayout(new GridLayout(5, 2));
      
      pane.add(lengthL);
      pane.add(lengthTF);
      pane.add(widthL);
      pane.add(widthTF);
      pane.add(areaL);
      pane.add(areaTF);
      pane.add(peramiterL);
      pane.add(peramiterTF);
      pane.add(calculateB);
      pane.add(exitB);
      
      pane.setBackground(new Color(255, 255, 255));
      
      setSize(WIDTH, HEIGHT);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
   }
   
   private class CalculateButtonHandeler implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         double width, length, area, peramiter;
         
         length = Double.parseDouble(lengthTF.getText());
         width = Double.parseDouble(widthTF.getText());
         
         area = length * width;
         peramiter = 2 * ( length + width );
         
         areaTF.setText("" + area);
         peramiterTF.setText("" + peramiter);
      }
   }
   
   private class ExitButtonHandeler implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
         System.exit(0);
      }
   }
   
   
   public static void main(String[] args)
   {
      test testObj = new test();
   }
}
