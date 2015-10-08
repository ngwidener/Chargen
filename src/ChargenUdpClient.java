import java.io.PrintStream;
import java.net.InetAddress;

/**
 * Created by Nicholas on 10/7/2015.
 */
public class ChargenUdpClient extends AbstractChargenClient {

    public ChargenUdpClient(InetAddress host) {
        super(host);
    }

    public ChargenUdpClient(InetAddress host, int port) {
        super(host, port);
    }

    public void printToStream(PrintStream out) {

    }
}
