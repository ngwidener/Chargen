import java.io.PrintStream;
import java.io.IOException;
import java.net.InetAddress;

/**
 * An abstract class that implements the ChargenClient interface. This class includes
 * attributes that are common to all Chargen client implementations, as well as protected methods
 * that enable subclasses to access those attributes.
 *
 * @author Nicholas Widener
 * @author Jameson Burchette
 * @version 10/8/2015
 */
public abstract class AbstractChargenClient implements ChargenClient {

    /** The Chargen protocol port number specified in RFC 864 */
    protected static final int CHARGEN_PORT = 19;
    /** The number of milliseconds the socket will wait for a response */
    protected static final int TIME_OUT = 5000;
    /** The server running the Chargen protocol */
    private InetAddress host;
    /** The port number to connect to */
    private int port;

    /**
     * Constructor with only one argument. Calls full constructor.
     *
     * @param host The server running the Chargen protocol
     */
    public AbstractChargenClient(InetAddress host) {
        this(host, CHARGEN_PORT);
    }

    /**
     * Constructor; initializes fields
     *
     * @param host The server running the Chargen protocol
     * @param port The port number to connect to
     */
    public AbstractChargenClient(InetAddress host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * Returns the address of the server this client will connect to.
     *
     * @return The address of the server this client will connect to
     */
    protected InetAddress getHost() {
        return host;
    }

    /**
     * Returns the port number this client will connect to.
     *
     * @return The port number this client will connect to
     */
    protected int getPort() {
        return port;
    }

    /**
     * Prints the received character sequence to the supplied stream.
     *
     * @param out The stream to which the characters will be printed.
     * @throws IOException If an IO error occurs while connecting to the server
     *                     or reading the response.
     */
    public void printToStream(PrintStream out) throws IOException {

    }
}
