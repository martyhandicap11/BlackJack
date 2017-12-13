package GUI;

public class Card
{
    int cardValue;
    String cardSuit;
    boolean cardUsed = false;

    public Card( int value, String suit)
    {
        this.cardValue = value;
        this.cardSuit = suit;
        System.out.println("Card" + cardValue  + "of" +cardSuit+ "was created");

    }//end of Card constructor

}// end of class Card
