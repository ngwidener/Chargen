package common;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;

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
public enum Face implements Serializable{

    /**The possible names of a card */
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

    /**The name of the card**/
    private String name;

    /**
     * Constructor; sets the name of the card.
     * @param name The name of the card.
     */
    private Face(String name) {
        this.name = name;
    }


    /**
     * Return the name name of the card
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
