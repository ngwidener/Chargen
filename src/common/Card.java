package common;

import java.io.Serializable;

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
public class Card implements Serializable{


    /**The cards face face and value**/
    private Face face;

    /**The suit of the card**/
    private Suit suit;

    /**
     * Constructs a new card.
     * @param name The face of the card which is an instance of a common.Face enum
     * @param suit The suit of the card which is an instance of the suit enum.
     */
    public Card(Face name, Suit suit) {
        this.face = name;
        this.suit = suit;
    }

    /**
     * Get the face of the card, for example: Ace, Ten, Jack, Queen or King.
     * @return The face face.
     */
    public Face getFace() {
        return face;
    }

    /**
     * Set the face of the face
     * @param face face of the face
     */
    public void setFace(Face face) {
        this.face = face;
    }

    /**
     * Set the face of the suit
     * @param suit face of the suit
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
     * Get the suit face of the card.
     * @return The suit face.
     */

    public Suit getSuit() {
        return suit;
    }


    /**
     * Generate the face and suit of the card and return it.
     * @return The face and suit of the card.
     */
    public String toString() {
        return face.getName() + " of " +  suit.getName();
    }
}


