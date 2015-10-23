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
    private static final int ASCII_MAX = 95;
    private static final int LINE_MAX = 72;
    private static final int CARRIAGE_RETURN = 13;
    private static final int LINE_FEED = 10;

    private int lines;
    private int lineLength;
    private int itemsToSend;

    public DefactoSource(int itemsToSend) {
        lines = 0;
        lineLength = 0;
        this.itemsToSend = itemsToSend;
    }

    /**
     * Gets the next character.
     * @return the next character.
    */
    @Override
    public Character next() {
        int ascii = 0;
        if (lineLength >= LINE_MAX) {
            lines++;
            lineLength = -2;
            ascii = CARRIAGE_RETURN;
        }
        else if (lineLength < 0) {
            ascii = LINE_FEED;
        }
        else {
            ascii = ((lineLength + lines) % ASCII_MAX) + OFFSET;
            itemsToSend--;
        }
        lineLength++;
        return (char)ascii;
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
