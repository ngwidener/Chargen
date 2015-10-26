package common;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 *
 * Enumeration for the name of the card.
 *
 * @author Nicholas Widener
 * @author Jameson Burchette
 *
 * @version October 2015
 *
 */
public enum Suit implements Serializable {
    /** Defines the suits in a pack of cards**/
    SPADES ("Spades"),
    HEARTS ("Hearts"),
    CLUBS ("Clubs"),
    DIAMONDS ("Diamonds");

    /**The name of the suit */
    private String name;


    /**
     * A private constructor to define an enumeration object representing a suit
     * in a pack of cards.
     * @param name The name of the suit.
     */
    private Suit(String name) {
        this.name = name;
    }


    /**
     * Get he name of the name as a string.
     * @return The name of the name as a String.
     */
    public String getName() {
        return name;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }

    private void readObjectNoData() throws ObjectStreamException {

    }
}
