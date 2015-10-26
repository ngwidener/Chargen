package client;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.io.IOException;


/**
 * A concrete implementation of client.AbstractChargenClient that uses the TCP version of the
 * Chargen protocol described int RFC 864.
 *
 * @author Nicholas Widener
 * @author Jameson Burchette
 * @version 10/8/2015
 */
public class ChargenTcpClient extends AbstractChargenClient {

    private String flag;

    /**
     * Constructor; calls super constructor and sets flag
     *
     * @param host The server running the Chargen protocol
     */
    public ChargenTcpClient(InetAddress host) {
        super(host);
        flag = " flag ";
    }

    /**
     * Constructor; calls super constructor and sets flag
     *
     * @param host The server running the Chargen protocol
     * @param port The port number to connect to
     */
    public ChargenTcpClient(InetAddress host, int port) {
        super(host, port);
        flag = " flag ";
    }

    /**
     * Constructor; calls super constructor and sets flag
     *
     * @param host The server running the Chargen protocol
     * @param port The port number to connect to
     * @param flag The string to be sent to a modified chargen server
     */
    public ChargenTcpClient(InetAddress host, int port, String flag) {
        super (host, port);
        this.flag = " " + flag + " ";
    }

    /**
     * Writes characters to a PrintStream as they are received from the server.
     *
     * @param out The stream to which the characters will be printed.
     * @throws SocketException If a socket cannot be opened
     * @throws IOException May be thrown by the socket if something goes wrong sending or
     *                     receiving a packet
     */
    public void printToStream(PrintStream out) throws SocketException, IOException {
        Socket socket = new Socket(getHost(), getPort());
        socket.setSoTimeout(TIME_OUT);
        DataOutputStream flagOut = new DataOutputStream(socket.getOutputStream());
        flagOut.writeBytes(flag);
        InputStream inStream = socket.getInputStream();
        while (!socket.isInputShutdown()) {
            out.write(inStream.read());
        }
        inStream.close();
        flagOut.close();
        socket.close();
    }
}
