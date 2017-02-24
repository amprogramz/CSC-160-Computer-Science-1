//alec
//csc 160
//i tried to create a class for random but somethings not working
//cant figure it our yet

import java.util.Random;


public class rand
{  
   public int randint;
   public static int num2;
   protected static Random rnd;
   
   public  rand()
   {  
      rnd = new Random();
      //int randing = new Math.random();
      //randing = Math.random();
      //randint = integer.parseInt( randing.nextInt(num) );
      //getrand();
   }
   public rand(int num)
   {
      num2 = rnd.nextInt(num);  
      //getrand();
   }
   public static int getrand(int num)
   {
      num2 = rnd.nextInt(num);
      return num2;
   }
   
}
