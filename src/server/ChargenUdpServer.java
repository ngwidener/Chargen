package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * The UDP server implementation for our Chargen Server.
 *
 * @author Nicholas Widener
 * @author Jameson Burchette
 *
 * @version October 2015
 */
public class ChargenUdpServer extends AbstractChargenServer {

    private static final int ITEMS_TO_SEND = 512;

    /**Socket to send data*/
    DatagramSocket serverSocket;

    /**
     * Constructor; calls super.
     * @throws ChargenServerException
     */
    public ChargenUdpServer() throws ChargenServerException {
        super(new DefactoSource(ITEMS_TO_SEND));

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
        super(port, new DefactoSource(ITEMS_TO_SEND));

        try {
            serverSocket = new DatagramSocket(getPort());
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
                ChargenSource source = getSource();
                DatagramPacket receivePacket = new DatagramPacket(new byte[0], 0);
                serverSocket.receive(receivePacket);

                int returnPort = receivePacket.getPort();
                InetAddress returnAdd = receivePacket.getAddress();

                String toSend = "";
                while (source.itemsToSend() > 0) {
                    toSend += source.next();
                }
                changeSource(new DefactoSource(ITEMS_TO_SEND));
                byte[] send = toSend.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(send, send.length, returnAdd, returnPort);
                serverSocket.send(sendPacket);
            }
            serverSocket.close();
        } catch (IOException ioe) {
            throw new ChargenServerException(ioe);
        }
    }
}
