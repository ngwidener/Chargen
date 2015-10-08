import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.IOException;
import java.net.SocketException;

/**
 * A concrete implementation of AbstractChargenClient that uses the UDP version of the
 * Chargen protocol described int RFC 864.
 *
 * @author Nicholas Widener
 * @author Jameson Burchette
 * @version 10/8/2015
 */
public class ChargenUdpClient extends AbstractChargenClient {

    /** The length of the byte array that will receive the server's response */
    private static final int BYTE_ARRAY_LENGTH = 1024;

    /**
     * Constructor; calls super constructor
     *
     * @param host The server running the Chargen protocol
     */
    public ChargenUdpClient(InetAddress host) {
        super(host);
    }

    /**
     * Constructor; calls super constructor
     *
     * @param host The server running the Chargen protocol
     * @param port The port number to connect to
     */
    public ChargenUdpClient(InetAddress host, int port) {
        super(host, port);
    }

    /**
     * Retrieves a character sequence from the server and writes it to a PrintStream.
     *
     * @param out The stream to which the characters will be printed.
     * @throws SocketException If a socket cannot be opened
     * @throws IOException May be thrown by the socket if something goes wrong sending or
     *                     receiving a packet
     */
    public void printToStream(PrintStream out) throws SocketException, IOException {
        DatagramSocket socket = new DatagramSocket();
        socket.setSoTimeout(TIME_OUT);
        byte[] response = new byte[BYTE_ARRAY_LENGTH];
        DatagramPacket packet = new DatagramPacket(response, 0, getHost(), getPort());
        socket.send(packet);
        packet.setLength(BYTE_ARRAY_LENGTH);
        socket.receive(packet);
        socket.close();
        out.write(response);
    }
}
