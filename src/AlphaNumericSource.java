/**
 * Handles alphanumeric characters for the server.
 *
 * @author Jameson Burchette
 * @author Nicholas Widener
 *
 * @version October 2015
 */
public class AlphaNumericSource implements ChargenSource {

    /**
     * Gets the next character.
     * @return the next character.
     */
    @Override
    public Character next() {
        return null;
    }

    /**
     * The items to send.
     * @return the items to send.
     */
    @Override
    public int itemsToSend() {
        return 0;
    }
}
