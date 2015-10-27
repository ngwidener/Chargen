package server;

import java.util.Random;

/**
 * Handles the standard character sequence produced by the Chargen servers.
 *
 * @author Jameson Burchette
 * @author Nicholas Widener
 *
 * @version October 2015
 */
public class DefactoSource implements ChargenSource {
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

    /** A random integer to randomize the start of the character sequence returned */
    private int asciiBase;
    /** The current line position */
    private int linePos;
    /** The number of lines of characters returned so far */
    private int lines;
    /** The number of characters remaining to send */
    private int itemsToSend;

    /**
     * Constructor, randomizes the starting position on the ascii table because
     * 512 characters is not enough to display every character with the standard
     * Chargen pattern.
     *
     * @param itemsToSend The number of characters to send.
     */
    public DefactoSource(int itemsToSend) {
        Random rand = new Random();
        asciiBase = rand.nextInt(ASCII_RANGE);
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
            charValue = ((asciiBase + linePos + lines) % ASCII_RANGE) + ASCII_START;
            itemsToSend--;
        }
        linePos++;
        return new Character((char) charValue);
    }

    /**
     * Gets the items left to send.
     * @return the items left to send.
     */
    @Override
    public int itemsToSend() {
        return itemsToSend;
    }
}
