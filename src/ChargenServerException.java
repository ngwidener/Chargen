import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.rmi.ServerError;
import java.rmi.ServerException;
import java.rmi.server.ServerNotActiveException;

/**
 * @author Jameson Burchette
 * @author Nicholas Widener
 *
 * @version October 2015
 *
 * Exception class for chargen server.
 */
public class ChargenServerException extends java.lang.Exception {


    public ChargenServerException(Exception exception) {
        if (exception instanceof UnknownHostException) {
            System.out.println("Error: The IP address could not be determined.");
            System.exit(-1);
        }
        else if (exception instanceof ServerNotActiveException) {
            System.out.println("Error: The server is not active.");
            System.exit(-1);
        }
        else if (exception instanceof ServerError) {
            System.out.println("Error: The server could not be invoked.");
            System.exit(-1);
        }
        else if (exception instanceof ConnectException) {
            System.out.println("Error: The socket could not make a connection.");
            System.exit(-1);
        }
        else if (exception instanceof ServerException) {
            System.out.println("Error: The server could not connect.");
            System.exit(-1);
        }
        else if (exception instanceof IOException) {
            System.out.println("An IO error has occurred.");
            System.exit(-1);
        }

    }


}
