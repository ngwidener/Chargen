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

    /**
     * Constructor; calls super.
     * @throws ChargenServerException
     */
    public ChargenUdpServer() throws ChargenServerException, IOException {
        super();

        serverSocket = new DatagramSocket(getPort());
    }

    /**
     * Constructor; calls super.
     * @param port the port number.
     * @throws ChargenServerException
     */
    public ChargenUdpServer(int port) throws ChargenServerException, IOException {
        super(port);
        serverSocket = new DatagramSocket(port);
    }

    /**
     * Constructor; calls super.
     * @param source the source.
     * @throws ChargenServerException
     */
    public ChargenUdpServer(ChargenSource source) throws ChargenServerException, IOException {
        super(source);
        serverSocket = new DatagramSocket(getPort());
    }

    /**
     * Constructor; calls super.
     * @param port the port number.
     * @param source the source.
     * @throws ChargenServerException
     */
    public ChargenUdpServer(int port, ChargenSource source) throws ChargenServerException, IOException {
        super(port, source);
        serverSocket = new DatagramSocket(getPort());
    }

    /**
     * Listens for the clients to make a request.
     */
    public void listen() throws ChargenServerException, IOException{

        while (!Thread.interrupted()) {
            byte[] receiveData = new byte[512];

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            serverSocket.receive(receivePacket);


        }
    }
}
