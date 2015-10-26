package server;

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

    private static final int ITEMS_TO_SEND = Integer.MAX_VALUE;

    ServerSocket welcomeSocket;
    Socket connectionSocket;

    /**
     * Constructor
     * @throws ChargenServerException
     */
    public ChargenTcpServer() throws ChargenServerException {
        super();
        try {
            welcomeSocket = new ServerSocket(getPort());

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
            welcomeSocket = new ServerSocket(getPort());

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
            welcomeSocket = new ServerSocket(getPort());

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
            welcomeSocket = new ServerSocket(getPort());

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
            Scanner clientIn;
            DataOutputStream clientOut;
            String next;
            while (!Thread.interrupted()) {
                connectionSocket = welcomeSocket.accept();
                clientIn = new Scanner(connectionSocket.getInputStream());

                if (clientIn.hasNext()) {
                    String flag = clientIn.next();
                    if (flag.equals("NAN")) {
                        changeSource(new NonAlphanumericSource(ITEMS_TO_SEND));
                    }
                    else if (flag.equals("AN")) {
                        changeSource((new AlphaNumericSource(ITEMS_TO_SEND)));
                    }
                    else if (flag.equals("N")) {
                        changeSource((new NumericSource(ITEMS_TO_SEND)));
                    }
                }

                clientOut = new DataOutputStream(connectionSocket.getOutputStream());
                ChargenSource source = getSource();
                while (source.itemsToSend() > 0) {
                    next = source.next().toString();
                    clientOut.writeBytes(next);
                }
                connectionSocket.close();
            }
            welcomeSocket.close();
        } catch (IOException ioe) {
            throw new ChargenServerException(ioe);
        }
    }
}
