package client;

import java.io.PrintStream;
import java.io.IOException;

/**
 * Interface implemented by clients receiving the response from a Chargen server.
 *
 * @author Nicholas Widener
 * @author Jameson Burchette
 * @varsion 10/8/2015
 */
public interface ChargenClient {

    /**
     * Prints the received character sequence to the supplied stream.
     *
     * @param out The stream to which the characters will be printed.
     * @throws IOException If an IO error occurs while connecting to the server
     *                     or reading the response.
     */
    public void printToStream(PrintStream out) throws IOException;
}
