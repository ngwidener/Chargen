/**
 * The UDP server implementation for our Chargen Server.
 *
 * @author Nicholas Widener
 * @author Jameson Burchette
 *
 * @version October 2015
 */
public class ChargenUdpServer extends AbstractChargenServer {

    /**
     * Constructor; calls super.
     * @throws ChargenServerException
     */
    public ChargenUdpServer() throws ChargenServerException {
        super();
    }

    /**
     * Constructor; calls super.
     * @param port the port number.
     * @throws ChargenServerException
     */
    public ChargenUdpServer(int port) throws ChargenServerException {
        super(port);
    }

    /**
     * Constructor; calls super.
     * @param source the source.
     * @throws ChargenServerException
     */
    public ChargenUdpServer(ChargenSource source) throws ChargenServerException {
        super(source);
    }

    /**
     * Constructor; calls super.
     * @param port the port number.
     * @param source the source.
     * @throws ChargenServerException
     */
    public ChargenUdpServer(int port, ChargenSource source) throws ChargenServerException {
        super(port, source);
    }

    /**
     * Listens for the clients to make a request.
     */
    public void listen() {

    }
}
