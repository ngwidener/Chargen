/**
 * Handles non alphanumeric characters for the server.
 *
 * @author Jameson Burchette
 * @author Nicholas Widener
 *
 * @version October 2015
 */
public class NonAlphanumericSource implements ChargenSource {

    /**
     * The next non alphanumeric character.
     * @return the next character.
     */
    @Override
    public Object next() {
        return null;
    }

    /**
     * The non alphanumeric characters to send.
     * @return the characters to send.
     */
    @Override
    public int itemsToSend() {
        return 0;
    }
}
