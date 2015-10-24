package server;

/**
 * Handles alphanumeric characters for the server.
 *
 * @author Jameson Burchette
 * @author Nicholas Widener
 *
 * @version October 2015
 */
public class AlphaNumericSource implements ChargenSource {

    private static final int ASCII_START = 48;
    private static final int ASCII_RANGE = 79;
    private static final int LINE_LEN = 72;
    private static final int CARRIAGE_RETURN = 13;
    private static final int LINE_FEED = 10;

    private int currentLen;
    private int lines;
    private int asciiBase;
    private int itemsToSend;

    public AlphaNumericSource(int itemsToSend) {
        currentLen = 0;
        lines = 0;
        asciiBase = 0;
        this.itemsToSend = itemsToSend;
    }

    /**
     * Gets the next character.
     * @return the next character.
     */
    @Override
    public Character next() {
        int charValue = ((asciiBase + lines) % ASCII_RANGE) + ASCII_START;
        if (currentLen >= LINE_LEN) {
            asciiBase = 0;
            charValue = CARRIAGE_RETURN;
            lines++;
            currentLen = -1;
        }
        else if (currentLen < 0) {
            charValue = LINE_FEED;
            currentLen++;
        }
        else {
            while (!Character.isLetterOrDigit((char)charValue)) {
                asciiBase++;
                charValue = ((asciiBase + lines) % ASCII_RANGE) + ASCII_START;
            }
            asciiBase++;
            itemsToSend--;
            currentLen++;
        }
        return new Character((char) charValue);
    }

    /**
     * The items to send.
     * @return the items to send.
     */
    @Override
    public int itemsToSend() {
        return itemsToSend;
    }
}
