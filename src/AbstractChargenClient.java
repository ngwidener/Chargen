import java.io.PrintStream;
import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by Nicholas on 10/7/2015.
 */
public abstract class AbstractChargenClient implements ChargenClient {

    /** The Daytime protocol port number specified in RFC 864 */
    private static final int CHARGEN_PORT = 19;
    /** The number of milliseconds the socket will wait for a response */
    protected static final int TIME_OUT = 500;

    private InetAddress host;

    private int port;

    public AbstractChargenClient(InetAddress host) {
        this(host, CHARGEN_PORT);
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

    public void printToStream(PrintStream out) throws IOException {

    }
}
