import java.io.IOException;
import java.io.InputStream;
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

    public void printToStream(PrintStream out) throws IOException{
        Socket socket = new Socket(getHost(), getPort());
        socket.setSoTimeout(TIME_OUT);
        InputStream stream = socket.getInputStream();
        while (true) {
            out.write(stream.read());
        }
    }
}
