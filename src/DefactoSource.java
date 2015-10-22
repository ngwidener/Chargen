/**
 * Handles the standard character sequence produced by the Chargen servers.
 *
 * @author Jameson Burchette
 * @author Nicholas Widener
 *
 * @version October 2015
 */
public class DefactoSource implements ChargenSource {

    private static final int ASCII_LIMIT = 126;
    private static final int LINE_LIMIT = 71;
    private static final int CARRIAGE_RETURN = 13;
    private static final int LINE_FEED = 10;

    private int ascii;
    private int lineLength;
    private int lineStart;

    public DefactoSource() {
        ascii = 32;
        lineLength = 0;
        lineStart = 33;
    }

    /**
     * Gets the next character.
     * @return the next character.
     */
    @Override
    public Character next() {
        if (ascii > ASCII_LIMIT) {
            ascii = 32;
        }
        if (lineLength > LINE_LIMIT) {
            if (ascii != CARRIAGE_RETURN && ascii != LINE_FEED) {
                ascii = CARRIAGE_RETURN;
            }
            else if (ascii == CARRIAGE_RETURN) {
                ascii = LINE_FEED;
            }
            else {
                ascii = lineStart;
                lineLength = 1;
                if (lineStart == ASCII_LIMIT) {
                    lineStart = 32;
                }
                else {
                    lineStart++;
                }
            }
        }
        Character character = new Character((char)ascii);
        if (lineLength <= LINE_LIMIT) {
            ascii++;
            lineLength++;
        }
        return character;
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
