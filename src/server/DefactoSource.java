package server;

/**
 * Handles the standard character sequence produced by the Chargen servers.
 *
 * @author Jameson Burchette
 * @author Nicholas Widener
 *
 * @version October 2015
 */
public class DefactoSource implements ChargenSource {

    private static final int OFFSET = 32;
    private static final int ASCII_RANGE = 95;
    private static final int LINE_LEN = 72;
    private static final int CARRIAGE_RETURN = 13;
    private static final int LINE_FEED = 10;

    private int lines;
    private int linePos;
    private int itemsToSend;

    public DefactoSource(int itemsToSend) {
        lines = 0;
        linePos = 0;
        this.itemsToSend = itemsToSend;
    }

    /**
     * Gets the next character.
     * @return the next character.
    */
    @Override
    public Character next() {
        int ascii;
        if (linePos >= LINE_LEN) {
            lines++;
            linePos = -2;
            ascii = CARRIAGE_RETURN;
        }
        else if (linePos < 0) {
            ascii = LINE_FEED;
        }
        else {
            ascii = ((linePos + lines) % ASCII_RANGE) + OFFSET;
            itemsToSend--;
        }
        linePos++;
        return new Character((char)ascii);
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
