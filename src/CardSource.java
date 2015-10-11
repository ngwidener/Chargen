
/**
 *
 * @author Dr. Andrew Scott and Dr. William Kreahling
 * @version V1.1 Jab 2015
 *
 * This card models a playing card which can have the suit, Spade, Heart, Club or
 * Diamond. It can also be an ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen or
 * King.<br>
 *
 * The card are ranked 1 to 13 where Ace is 1 and King 13.<br>
 * The cards are valued a 1 to 10, with all picture cards (Royals) being worth
 * 10.
 *
 */
//#############################################################################
public class CardSource {


    /**The cards face name and value**/
    private Face name;

    /**The suit of the card**/
    private Suit suit;


    /**
     * Constructs a new card.
     * @param name The name of the card which is an instance of a Face enum
     * @param suit The suit of the card which is an instance of the suit enum.
     */
    public CardSource(Face name, Suit suit) {
        this.name = name;
        this.suit = suit;
    }

    /**
     * Get the name of the card for example, Ace, Ten, Jack, Queen or King.
     * @return The face name.
     */
    public Face getName() {
        return name;
    }

    /**
     * Set the name of the face
     * @param name name of the face
     */
    public void setName(Face name) {
        this.name = name;
    }

    /**
     * Set the name of the suit
     * @param suit name of the suit
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
     * Get the suit name of the card.
     * @return The suit name.
     */

    public Suit getSuit() {
        return suit;
    }


    /**
     * Get the rank number of the card. The rank is a number between 1 to 13
     * where 1 is an ace and 13 is a king.
     * @return The rank of the card.
     */
    public int rank() {
        return name.getRank();
    }


    /**
     * Get the card's value, that is a number between 1 to 10.<br>
     * All picture cards (royals) have the value 10, all others are the numbers
     * of suit symbols appearing on the card.
     * @return The value of a card.
     */
    public int getValue() {
        return name.value();
    }


    /**
     * Generate the name and suit of the card and return it.
     * @return The name and suit of the card.
     */
    public String toString() {
        return (name.toString() + " of " +  suit.toString());
    }


}

/**
 *
 * @author Dr. Andrew Scott and Dr. Whilliam Kreahling.
 * @Version v1.1 Jan 2015
 *
 * An enumeration to model the names and values of cards as well as their rank.
 * <br>
 * Values are 1 to 10 with all picture cards (royals) being worth 10.<br>
 * Ranks are 1 to 13 starting with the ace and ending on king.
 *
 */
enum Face {

    /**The names and value of each suit**/
    ACE     ("Ace",     1),
    DUECE   ("Duece",   2),
    THREE   ("Three",   3),
    FOUR    ("Four",    4),
    FIVE    ("Five",    5),
    SIX     ("Six",     6),
    SEVEN   ("Seven",   7),
    EIGHT   ("Eight",   8),
    NINE    ("Nine",    9),
    TEN     ("Ten",     10),
    JACK    ("Jack",    10),
    QUEEN   ("Queen",   10),
    KING    ("King",    10);

    /**The face name of the card**/
    private String  face;

    /**The value of the cards, all worth their numbers except pictures are worth 10.**/
    private int     value;

    /** The rank of the cards 1 (ace) to 13 king) for each one**/
    private int     rank;


    /**
     * A simple constructor or an enumerate object defining a single card not
     * including it's suit.
     * @param name The name of the card.
     * @param value The value the card is worth in points.
     */
    private Face(String name, int value) {
        face        = name;
        this.value  = value;
        this.rank  = value;


        switch(name) {
            case "King":
                rank++;
            case "Queen":
                rank++;
            case "Jack":
                rank++;
                break;
        }
    }


    /**
     * Return the face name of a card as a String
     *
     */
    public String toString() {
        return face;
    }


    /**
     * Get the value of a card.
     * @return The value of a card.
     */
    public int value() {
        return value;
    }


    /**
     * Gets the rank number of a card.
     * @return The rank.
     */
    public int getRank() {
        return rank;
    }

}


/**
 *
 * @author Dr. Andrew Scott and Dr. William Kreahling.
 * @version V1.1 Jan 2015
 *
 * A set of enumerate objects to define the suits in a pack of cards.
 *
 */
enum Suit {
    /** Defines the suits in a pack of cards**/
    SPADES("Spades"),
    HEARTS("Hearts"),
    CLUBS("Clubs"),
    DIAMONDS("Diamonds");

    /**The name of the suit**/
    private String name;


    /**
     * A private constructor to define an enumerate object representing a suit
     * in a pack of cards.
     * @param name The name of the suit.
     */
    private Suit(String name) {
        this.name = name;
    }


    /**
     * Get he name of the suit as a string.
     * @return The name of the suit as a String.
     */
    public String getName() {
        return this.toString();
    }


    /**
     * Get the name of the suit as a string.
     * @return The name of the suit as a String.
     */
    public String toString() {
        return name;
    }
}