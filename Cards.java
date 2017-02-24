//alec
//csc 160

//this program was created to create and shuffle
//a deck of cards.

//import java.util.Random.*;


//class cards
public class Cards
{
   //array for card type int
   private int [] card = new int[13];
   //array to hold card string type
   private String [] cards = new String[13];
   //array to hold the suit
   private String [] suit = new String[4];
   //array to hold the entire deck
   private String [] deckOfCards = new String[52];
    
   //cards constructor
   public Cards()
   {
      //initialize index
      int index = 0;
      
      //for to program card value
      for (index = 0; index < cards.length; index++)
      {
         card[index] = index + 1; 
      }
      //for loop to assign string to suit
      for (index = 0; index < suit.length; index++)
      {
         switch (index)
         {
            case 0:
               suit[index] = "Hearts";
               break;
            case 1:
               suit[index] = "Spades";
               break;
            case 2:
               suit[index] = "Diamonds";
               break;
            case 3:
               suit[index] = "Clubs";
               break;
            default:
               suit[index] = "Unexpected suit error!";
         }
         
      }
      //set cards method
      setCards();
                       
      
   }
   //set cards method
   public void setCards()
   {
      int index = 0;
      //sets cards to their string values
      for (index = 0; index < card.length; index++)
      {
         if (card[index] >= 2 && card[index] <= 10)
            cards[index] = card[index] + "";
         else
         {
             
            switch (card[index])
            {
               case 1:
                  cards[index] = "Ace";
                  break;
               case 11:
                  cards[index] = "Jack";
                  break;
               case 12:
                  cards[index] = "Queen";
                  break;
               case 13:
                  cards[index] = "king";
                  break;
               default:
                  cards[index] = "Card error";
            }
         }
      }
      //sets cards to full card string
      setCardsString();
   }
   
  /* public String getCards()
   {
      return cards.array;
   }
   public void setSuit()
   {
   
   }
   public String getSuit()
   {
   
   }*/
   //sets cards to be their full string
   public void setCardsString()
   {
      int indexA = 0;
      int indexB = 0;
      int index = 0;
      
      for (indexA = 0; indexA < suit.length; indexA++)
      {
         for (indexB = 0; indexB < cards.length; indexB++)
         {
            deckOfCards[index] = String.format("%s%n",cards[indexB] + " of " + suit[indexA]); 
            index++;
         }

      }
   }
   //returns the deck, i would like to know how to use a loop here
   public String getString(int index)
   {
      return deckOfCards[index];
   }
  // public Distrobution randomInt(int cardCount)
  // {
      //rnd = new Random()
      //new java.util.Random();
      //int indexR = Random(cardCount);
     // return indexR;
      //return Math.random(cardCount);
  // }
  //shuffle method, needs work i could only use random in main :/
  public String shuffle()
  {
     //Random gen = new Random();
     //create two indexes to shuffle
     int indexR = 0;
     int index = 0;
     int cardCount = 51;
     //shuffle loop
     for (index = 0; index < deckOfCards.length; index++)
     {
        //indexR = gen.nextInt(51);
        //indexR = Math.random(cardCount);
        
        //supposed to create a random int to use to swap with the index
        indexR = rand.getrand(cardCount);
        //indexR = randomInt(cardCount);
        
        //use a temporary string to hold original value
        String temp = deckOfCards[index];
        //makes the recently coppied index equal to the other index value
        deckOfCards[index] = deckOfCards[indexR];
        //the original value is now in the place of the other index value held in temp
        deckOfCards[indexR] = temp;
        //getString(index);
       // getString(indexR);
      }
     //math.random(52)
     //java.util.Collections.shuffle(deckOfCards);
     //getString
     
     //this is where im having a hard time, cant seem to move array with tostring method :/
     return deckOfCards[index];//getString();
  }
   
}