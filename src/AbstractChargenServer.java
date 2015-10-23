import java.io.IOException;

/**
 * Provides all the attributes that are common among all of our Chargen
 * server implementations.
 *
 * @author Jameson Burchette
 * @author Nicholas Widener
 *
 * @version October 2015
 */
public class AbstractChargenServer implements ChargenServer {

    private static final int DEFAULT_PORT = 9642;

    /**The port for the client to talk to*/
    private int port;

    /**The source of the data we want to send back*/
    private ChargenSource source;

    /**
     * Constructor; takes no arguments.
     * @throws ChargenServerException
     */
    public AbstractChargenServer() throws ChargenServerException{
        this(DEFAULT_PORT, new DefactoSource(Integer.MAX_VALUE));
    }

    /**
     * Constructor
     * @param port the port number
     * @throws ChargenServerException
     */
    public AbstractChargenServer(int port) throws ChargenServerException{
        this(port, new DefactoSource(Integer.MAX_VALUE));
    }

    /**
     * Constructor
     * @param source the source
     * @throws ChargenServerException
     */
    public AbstractChargenServer(ChargenSource source) throws ChargenServerException{
        this(DEFAULT_PORT, source);
    }

    /**
     * Constructor
     * @param port the port number
     * @param source the source
     * @throws ChargenServerException
     */
    public AbstractChargenServer(int port, ChargenSource source) throws ChargenServerException {
        this.port = port;
        this.source = source;
    }

    /**
     * Get the port number.
     * @return the port number.
     */
    protected int getPort() {
        return port;
    }

    /**
     * Get the source.
     * @return the source.
     */
    protected ChargenSource getSource() {
        return source;
    }

    /**
     * Change the source.
     * @param source the source we want to change.
     */
    protected void changeSource(ChargenSource source) {
        this.source = source;
    }

    /**
     * Listen for clients to talk to the server.
     */
    public void listen() throws ChargenServerException {

    }
}
