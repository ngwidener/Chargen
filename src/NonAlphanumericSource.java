/**
 * Handles non alphanumeric characters for the server.
 *
 * @author Jameson Burchette
 * @author Nicholas Widener
 *
 * @version October 2015
 */
public class NonAlphanumericSource implements ChargenSource {

    private static final int OFFSET = 32;
    private static final int ASCII_MAX = 95;
    private static final int LINE_MAX = 72;
    private static final int CARRIAGE_RETURN = 13;
    private static final int LINE_FEED = 10;

    private int lines;
    private int lineLength;
    private int itemsToSend;

    public NonAlphanumericSource(int itemsToSend) {
        lines = 1;
        lineLength = 0;
        this.itemsToSend = itemsToSend;
    }


    /**
     * The next non alphanumeric character.
     * @return the next character.
     */
    @Override
    public Character next() {
        int ascii = 0;
        if (lineLength > LINE_MAX) {
            lines++;
            lineLength = -2;
        }
        else if (lineLength < 0) {
            ascii = LINE_FEED;
        }
        else {
            ascii = lines + OFFSET;
            itemsToSend--;
        }
        lineLength++;
        return (char)ascii;
    }

    /**
     * The non alphanumeric characters to send.
     * @return the characters to send.
     */
    @Override
    public int itemsToSend() {
        return itemsToSend;
    }
}
