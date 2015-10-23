import java.io.DataOutput;
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

    ChargenSource source;

    /**
     * Constructor
     * @throws ChargenServerException
     */
    public ChargenTcpServer() throws ChargenServerException, IOException {
        super();
        welcomeSocket = new ServerSocket();

    }

    /**
     * Constructor; calls super.
     * @param port the port number.
     * @throws ChargenServerException
     */
    public ChargenTcpServer(int port) throws ChargenServerException, IOException {
        super(port);
        welcomeSocket = new ServerSocket(port);

    }

    /**
     * Constructor; calls super.
     * @param source the source.
     * @throws ChargenServerException
     */
    public ChargenTcpServer(ChargenSource source) throws ChargenServerException, IOException {
        super(source);
        welcomeSocket = new ServerSocket();
    }

    /**
     * Constructor; calls super.
     * @param port the port number.
     * @param source the source.
     * @throws ChargenServerException
     */
    public ChargenTcpServer(int port, ChargenSource source) throws ChargenServerException, IOException {
        super(port, source);
        welcomeSocket = new ServerSocket(port);
    }

    /**
     * Listens for the clients to make a request.
     *
     * @throws ChargenServerException
     * @throws IOException
     */
    public void listen() throws ChargenServerException, IOException{

        while (!Thread.interrupted()) {
            Socket connectionSocket = welcomeSocket.accept();

            Scanner clientIn = new Scanner(connectionSocket.getInputStream());

            DataOutputStream clientOut = new DataOutputStream(connectionSocket.getOutputStream());


        }
    }
}
