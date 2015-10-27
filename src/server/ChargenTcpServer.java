package server;

import common.Card;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
    /** The number of items for TCP servers to send */
    private static final int ITEMS_TO_SEND = Integer.MAX_VALUE;

    /** The socket that will listen for incoming connections */
    ServerSocket welcomeSocket;
    /** Connection to a client created by the welcome socket */
    Socket connectionSocket;

    /**
     * Constructor; calls super and creates socket
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
     * Constructor; calls super and creates socket
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
     * Constructor; calls super and creates socket
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
     * Constructor; calls super and creates socket
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
     * Listens for the clients to make a request and sends data until the client disconnects
     *
     * @throws ChargenServerException
     */
    public void listen() throws ChargenServerException {
        try {
            Scanner flagScanner;
            DataOutputStream charOut;
            ObjectOutputStream cardOut;
            String next;
            String flag = "";
            while (!Thread.interrupted()) {
                connectionSocket = welcomeSocket.accept();
                flagScanner = new Scanner(connectionSocket.getInputStream());
                if (flagScanner.hasNext()) {
                    flag = flagScanner.next();
                    if (flag.equals("NAN") || flag.equals("nan")) {
                        changeSource(new NonAlphanumericSource(ITEMS_TO_SEND));
                    }
                    else if (flag.equals("AN") || flag.equals("an")) {
                        changeSource((new AlphaNumericSource(ITEMS_TO_SEND)));
                    }
                    else if (flag.equals("N") || flag.equals("n")) {
                        changeSource((new NumericSource(ITEMS_TO_SEND)));
                    }
                    else if (flag.equals("C") || flag.equals("c")) {
                        changeSource(new CardSource(ITEMS_TO_SEND));
                    }
                }

                ChargenSource source = getSource();
                if (flag.equals("C") || flag.equals("c")) {
                    cardOut = new ObjectOutputStream(connectionSocket.getOutputStream());
                    Card nextCard;
                    try {
                        while (source.itemsToSend() > 0) {
                            nextCard = (Card)source.next();
                            cardOut.writeObject(nextCard);
                        }
                    }
                    catch (IOException e) {
                        connectionSocket.close();
                    }
                }
                else {
                    charOut = new DataOutputStream(connectionSocket.getOutputStream());
                    try {
                        while (source.itemsToSend() > 0) {
                            next = source.next().toString();
                            charOut.writeBytes(next);
                        }
                    }
                    catch (IOException e) {
                        connectionSocket.close();
                    }
                }
            }
            welcomeSocket.close();
        } catch (IOException ioe) {
            throw new ChargenServerException(ioe);
        }
    }
}
