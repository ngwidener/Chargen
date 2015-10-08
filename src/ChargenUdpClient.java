import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.IOException;

/**
 * Created by Nicholas on 10/7/2015.
 */
public class ChargenUdpClient extends AbstractChargenClient {

    /** The length of the byte array that will receive the server's response */
    private static final int BYTE_ARRAY_LENGTH = 1024;

    public ChargenUdpClient(InetAddress host) {
        super(host);
    }

    public ChargenUdpClient(InetAddress host, int port) {
        super(host, port);
    }

    public void printToStream(PrintStream out) throws IOException {
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
