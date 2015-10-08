import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Nicholas on 10/7/2015.
 */
public class ChargenTcpClient extends AbstractChargenClient {


    public ChargenTcpClient(InetAddress host) {
        super(host);
    }

    public ChargenTcpClient(InetAddress host, int port) {
        super(host, port);
    }

    public void printToStream(PrintStream out) {

    }
}
