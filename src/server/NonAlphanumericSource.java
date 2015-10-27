package server;

/**
 * Handles non alphanumeric characters for the server.
 *
 * @author Jameson Burchette
 * @author Nicholas Widener
 *
 * @version October 2015
 */
public class NonAlphanumericSource implements ChargenSource {
    /** The point on the ascii table where the printable characters start */
    private static final int ASCII_START = 32;
    /** The number of printable ascii characters */
    private static final int ASCII_RANGE = 95;
    /** The length of each line of characters */
    private static final int LINE_LEN = 72;
    /** The ascii value of a carriage return */
    private static final int CARRIAGE_RETURN = 13;
    /** The ascii value of a line feed */
    private static final int LINE_FEED = 10;

    /** A starting point on the ascii table; incremented to move past alphanumeric characters */
    private int asciiBase;
    /** The current line position */
    private int linePos;
    /** The number of lines of characters returned so far */
    private int lines;
    /** The number of characters remaining to send */
    private int itemsToSend;

    /**
     * Constructor; initializes fields
     *
     * @param itemsToSend The number of characters to send
     */
    public NonAlphanumericSource(int itemsToSend) {
        asciiBase = 0;
        linePos = 0;
        lines = 0;
        this.itemsToSend = itemsToSend;
    }


    /**
     * The next non alphanumeric character.
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
            // Skips lines starting with alphanumeric characters to preserve formatting
            while (Character.isLetterOrDigit((char)(lines % ASCII_RANGE) + ASCII_START)) {
                lines++;
            }
        }
        else if (linePos < 0) {
            charValue = LINE_FEED;
        }
        else {
            charValue = ((asciiBase + linePos + lines) % ASCII_RANGE) + ASCII_START;
            while (Character.isLetterOrDigit((char)charValue)) {
                asciiBase++;
                charValue = ((asciiBase + linePos + lines) % ASCII_RANGE) + ASCII_START;
            }
            itemsToSend--;
        }
        linePos++;
        return new Character((char) charValue);
    }

    /**
     * The non alphanumeric left characters to send.
     * @return the characters left to send.
     */
    @Override
    public int itemsToSend() {
        return itemsToSend;
    }
}
