import java.io.IOException;

/**
 * The entry point of the application. Checks valid input and provides default
 * values for the port number if one is not supplied by the user.
 *
 * @author Nicholas Widener
 * @author Jameson Burchette
 * @version October 2015
 */
public class ChargenServerDriver {

    /**
     * Handles commands supplied via command line arguments.
     * Checks for valid input.
     * @param args command line arguments supplied by the user
     */
    public static void main(String[] args) throws ChargenServerException, IOException {

        ChargenTcpServer tcpServer = new ChargenTcpServer(1234);

        tcpServer.listen();

    }


}
