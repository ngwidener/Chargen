package server;

/**
 * Handles numeric characters for the server.
 *
 * @author Jameson Burchette
 * @author Nicholas Widener
 *
 * @version October 2015
 */
public class NumericSource implements ChargenSource {
    /** The point on the ascii table where the numeric characters start */
    private static final int ASCII_START = 48;
    /** The number of numeric ascii characters */
    private static final int ASCII_RANGE = 10;
    /** The length of each line of characters */
    private static final int LINE_LEN = 72;
    /** The ascii value of a carriage return */
    private static final int CARRIAGE_RETURN = 13;
    /** The ascii value of a line feed */
    private static final int LINE_FEED = 10;

    /** The current line position */
    private int linePos;
    /** The number of lines of characters returned so far */
    private int lines;
    /** The number of characters remaining to send */
    private int itemsToSend;

    /**
     * Constructor; initializes fields
     *
     * @param itemsToSend The number of characters to send.
     */
    public NumericSource (int itemsToSend) {
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
            linePos = -2;
            lines++;
        }
        else if (linePos < 0) {
            charValue = LINE_FEED;
        }
        else {
            charValue = ((linePos + lines) % ASCII_RANGE) + ASCII_START;
            itemsToSend--;
        }
        linePos++;
        return new Character((char)charValue);
    }

    /**
     * The items left to send.
     * @return the left items to send.
     */
    @Override
    public int itemsToSend() {
        return itemsToSend;
    }
}
