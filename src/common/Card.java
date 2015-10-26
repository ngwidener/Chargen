package common;

import server.ChargenSource;

/**
 *
 * Models a playing card.
 *
 * @author Nicholas Widener
 * @author Jameson Burchette
 *
 * @version October 2015
 *
 */
public class Card implements ChargenSource {


    /**The cards face name and value**/
    private Face name;

    /**The suit of the card**/
    private Suit suit;

    private int itemsToSend;


    /**
     * Constructs a new card.
     * @param name The name of the card which is an instance of a common.Face enum
     * @param suit The suit of the card which is an instance of the suit enum.
     */
    public Card(Face name, Suit suit) {
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
     * Generate the name and suit of the card and return it.
     * @return The name and suit of the card.
     */
    public String toString() {
        return (name.toString() + " of " +  suit.toString());
    }

    @Override
    public Card next() {
        return null;
    }

    @Override
    public int itemsToSend() {
        return itemsToSend;
    }
}

/**
 *
 * Enumeration for the card values.
 *
 * @author Nicholas Widener
 * @author Jameson Burchette
 *
 * @version October 2015
 *
 */
enum Face {

    /**The names and value of each suit**/
    ACE     ("Ace"),
    DUECE   ("Duece"),
    THREE   ("Three"),
    FOUR    ("Four"),
    FIVE    ("Five"),
    SIX     ("Six"),
    SEVEN   ("Seven"),
    EIGHT   ("Eight"),
    NINE    ("Nine"),
    TEN     ("Ten"),
    JACK    ("Jack"),
    QUEEN   ("Queen"),
    KING    ("King");

    /**The face name of the card**/
    private String  face;


    /**
     * A simple constructor or an enumerate object defining a single card not
     * including it's suit.
     * @param name The name of the card.
     */
    private Face(String name) {
        face        = name;
    }


    /**
     * Return the face name of a card as a String
     *
     */
    public String toString() {
        return face;
    }



}


/**
 *
 * Enumeration for the suit of the card.
 *
 * @author Nicholas Widener
 * @author Jameson Burchette
 *
 * @version October 2015
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