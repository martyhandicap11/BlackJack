package GUI;

public class Card
{
    int cardValue;
    String cardSuit;
    boolean cardUsed = false;
    String cardSymbol;
    String cardName;

    public  Card (int cValue, String cSuit )
    {
        this.cardValue = cValue;
        this.cardSuit = cSuit;

        if( cardValue < 11)
        {
            cardSymbol = Integer.toString(cValue);
            cardName   = Integer.toString(cValue);
        }
        else if (cardValue == 11)
        {
            cardSymbol = "J";
            cardName   = "Jack";
        }
        else if (cardValue == 12)
        {
            cardSymbol = "Q";
            cardName   = "Queen";
        }
        else if (cardValue == 13)
        {
            cardSymbol = "K";
            cardName   = "King";
        }
        else
        {
            cardSymbol = "A";
            cardName = "Ace";
        }
        System.out.println("Card" + cardName + "of" + cardSuit + "was created");

    }

}//end of class Card
