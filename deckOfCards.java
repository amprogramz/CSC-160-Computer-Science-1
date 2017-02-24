//alec
//csc 160

//this programs only supposed to display the cards
//but it is still in development


import java.util.*;
//unfortunantly i had to do this here;/
import java.util.Random;

//the deck main method
public class deckOfCards
{
   public static void main(String []args)
   {  
       //initalize array
       String[] RealDeckOfCards = new String[52];
       int index = 0;
      //for (index = 0; index < 13; index++)
         //String card[] = ;
         //System.out.print(Cards());
        // String deckOfCards = new String[52];
        
        //initialize cards 
        Cards deckOfCards = new Cards(); 
        //stores and prints deck
        for (index = 0; index <= 51; index++)
        {   
           RealDeckOfCards[index] = (deckOfCards.getString(index));
           System.out.print(RealDeckOfCards[index]);
        }
        //system.out.printdeckOfCards.shuffle();
        //unfortunantly i had to do this here, random wouldent work in my user defined methods;/
       int indexR;
       Random rnd = new Random();
       System.out.print("\n\n" + "Shuffling...\n\n");
        for (index = 0; index <= 51; index++)
        {   
            //indexR = rand.getrand(51);
            indexR = rnd.nextInt(51);
            
            String temp = RealDeckOfCards[index];
            RealDeckOfCards[index] = RealDeckOfCards[indexR];
            RealDeckOfCards[indexR] = temp;

           //RealDeckOfCards[index] = (rand.getrand(51));
           //System.out.print(deckOfCards.shuffle());
          // RealDeckOfCards[index] = (deckOfCards.shuffle);
        }
        //prints new array values
        for (index = 0; index <= 51; index++)
        {   
            System.out.print(RealDeckOfCards[index]);
        }

        
   }
   
}