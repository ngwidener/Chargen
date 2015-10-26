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


    private int asciiBase;
    private int linePos;
    private int lines;
    private int itemsToSend;

    public AlphaNumericSource(int itemsToSend) {
        asciiBase = 0;
        linePos = 0;
        lines = 0;
        this.itemsToSend = itemsToSend;
    }

    /**
     * Gets the next character.
     * @return the next character.
     */
    @Override
    public Character next() {
        int charValue;
        if (linePos >= LINE_LEN) {
            charValue = CARRIAGE_RETURN;
            asciiBase = 0;
            linePos = -2;
            lines++;
        }
        else if (linePos < 0) {
            charValue = LINE_FEED;
        }
        else {
            charValue = ((asciiBase + linePos + lines) % ASCII_RANGE) + ASCII_START;
            while (!Character.isLetterOrDigit((char) charValue)) {
                asciiBase++;
                charValue = ((asciiBase + linePos + lines) % ASCII_RANGE) + ASCII_START;
            }
            itemsToSend--;
        }
        linePos++;
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
