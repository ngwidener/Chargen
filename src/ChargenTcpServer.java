import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * The TCP server implementation for our Chargen Server.
 *
 * @author Nicholas Widener
 * @author Jameson Burchette
 *
 * @version October 2015
 */
public class ChargenTcpServer extends AbstractChargenServer {

    ServerSocket welcomeSocket;

    private static final int ITEMS_TO_SEND = Integer.MAX_VALUE;

    ChargenSource source;

    /**
     * Constructor
     * @throws ChargenServerException
     */
    public ChargenTcpServer() throws ChargenServerException {
        super();
        try {
            welcomeSocket = new ServerSocket();
            source = new DefactoSource(ITEMS_TO_SEND);

        } catch (IOException ioe) {
            throw new ChargenServerException(ioe);
        }
    }

    /**
     * Constructor; calls super.
     * @param port the port number.
     * @throws ChargenServerException
     */
    public ChargenTcpServer(int port) throws ChargenServerException {
        super(port);
        try {
            welcomeSocket = new ServerSocket();
            source = new DefactoSource(ITEMS_TO_SEND);

        } catch (IOException ioe) {
            throw new ChargenServerException(ioe);
        }

    }

    /**
     * Constructor; calls super.
     * @param source the source.
     * @throws ChargenServerException
     */
    public ChargenTcpServer(ChargenSource source) throws ChargenServerException {
        super(source);
        try {
            welcomeSocket = new ServerSocket();
            this.source = getSource();

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
    public ChargenTcpServer(int port, ChargenSource source) throws ChargenServerException {
        super(port, source);
        try {
            welcomeSocket = new ServerSocket();
            port = getPort();
            this.source = getSource();

        } catch (IOException ioe) {
            throw new ChargenServerException(ioe);
        }
    }

    /**
     * Listens for the clients to make a request.
     *
     * @throws ChargenServerException
     */
    public void listen() throws ChargenServerException {

        try {
            while (!Thread.interrupted()) {
                Socket connectionSocket = welcomeSocket.accept();

                Scanner clientIn = new Scanner(connectionSocket.getInputStream());

                DataOutputStream clientOut = new DataOutputStream(connectionSocket.getOutputStream());


            }
        } catch (IOException ioe) {
            throw new ChargenServerException(ioe);
        }
    }
}
