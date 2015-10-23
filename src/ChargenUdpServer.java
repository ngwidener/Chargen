import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * The UDP server implementation for our Chargen Server.
 *
 * @author Nicholas Widener
 * @author Jameson Burchette
 *
 * @version October 2015
 */
public class ChargenUdpServer extends AbstractChargenServer {

    /**The source for our characters*/
    ChargenSource source;

    /**Socket to the internet*/
    DatagramSocket serverSocket;

    private static final int ITEMS_TO_SEND = 512;

    /**
     * Constructor; calls super.
     * @throws ChargenServerException
     */
    public ChargenUdpServer() throws ChargenServerException {
        super();
        source = new DefactoSource(ITEMS_TO_SEND);

        try {
            serverSocket = new DatagramSocket(getPort());
        } catch (IOException ioe) {
            throw new ChargenServerException(ioe);
        }
    }

    /**
     * Constructor; calls super.
     * @param port the port number.
     * @throws ChargenServerException
     */
    public ChargenUdpServer(int port) throws ChargenServerException {
        super(port);
        source = new DefactoSource(ITEMS_TO_SEND);

        try {
            serverSocket = new DatagramSocket(port);
        } catch (IOException ioe) {
            throw new ChargenServerException(ioe);
        }
    }

    /**
     * Constructor; calls super.
     * @param source the source.
     * @throws ChargenServerException
     */
    public ChargenUdpServer(ChargenSource source) throws ChargenServerException {
        super(source);
        this.source = source;

        try {
            serverSocket = new DatagramSocket(getPort());
        } catch (IOException ioe) {
            throw new ChargenServerException(ioe);
        }
    }

    /**
     * Constructor; calls super.
     * @param port the port number.
     * @param source the source.
     * @throws ChargenServerException
     */
    public ChargenUdpServer(int port, ChargenSource source) throws ChargenServerException {
        super(port, source);
        port = getPort();

        try {
            serverSocket = new DatagramSocket(getPort());
        } catch (IOException ioe) {
            throw new ChargenServerException(ioe);
        }
    }

    /**
     * Listens for the clients to make a request.
     */
    public void listen() throws ChargenServerException {
        try {
            while (!Thread.interrupted()) {
                byte[] receiveData = new byte[512];

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                serverSocket.receive(receivePacket);
            }
        } catch (IOException ioe) {
            throw new ChargenServerException(ioe);
        }
    }
}
