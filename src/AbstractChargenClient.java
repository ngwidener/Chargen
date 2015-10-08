import java.io.PrintStream;
import java.net.InetAddress;

/**
 * Created by Nicholas on 10/7/2015.
 */
public abstract class AbstractChargenClient implements ChargenClient {

    private InetAddress host;

    private int port;

    public AbstractChargenClient(InetAddress host) {
        this.host = host;
    }

    public AbstractChargenClient(InetAddress host, int port) {
        this.host = host;
        this.port = port;
    }

    protected InetAddress getHost() {
        return host;
    }

    protected int getPort() {
        return port;
    }

    public void printToStream(PrintStream out) {

    }
}
