/**
 * Serves as the interface for our server implementation.
 * Provides a listen() method that will be implemented in the
 * classes that implement the interface.
 *
 * @author Nicholas Widener
 * @author Jameson Burchette
 *
 * @version October 2015
 */
public interface ChargenServer {

    /**
     * Listens for requests to be made by the clients.
     */
    public void listen();
}
