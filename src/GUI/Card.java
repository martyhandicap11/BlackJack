package GUI;

public class Card
{
    int cardValue;
    String cardSuit ;
    boolean cardUsed = false;
    String cardSymbol;
    String cardName;
    int cardID;
    int cardPrintedValue;

    public  Card (int cValue, String cSuit, int cID )
    {
        this.cardValue = cValue;
        this.cardSuit = cSuit;
        this.cardID = cID;

        if( cardValue < 11)
        {
            cardSymbol = Integer.toString(cValue);
            cardName   = Integer.toString(cValue);
            cardPrintedValue = cardValue;
        }
        else if (cardValue == 11)
        {
            cardSymbol = "J";
            cardName   = "Jack";
            cardPrintedValue = 10;
        }
        else if (cardValue == 12)
        {
            cardSymbol = "Q";
            cardName   = "Queen";
            cardPrintedValue = 10;
        }
        else if (cardValue == 13)
        {
            cardSymbol = "K";
            cardName   = "King";
            cardPrintedValue = 10;
        }
        else
        {
            cardSymbol = "A";
            cardName = "Ace";
            cardPrintedValue = 1;
        }
        //System.out.println("Card" + cardName + "of" + cardSuit
               // + "was created" +"card ID"+ this.cardID);

    }

}//end of class Card
