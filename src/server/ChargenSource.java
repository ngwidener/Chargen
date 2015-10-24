package server;

/**
 * Interface for characters to be produced by the server.
 *
 * @author Jameson Burchette
 * @author Nicholas Widener
 *
 * @version October 2015
 */
public interface ChargenSource<T> {

    /**
     * The next character to be sent.
     * @return the character that is sent.
     */
    public T next();

    /**
     * The numeric characters that are sent.
     * @return the numeric characters sent.
     */
    public int itemsToSend();
}
