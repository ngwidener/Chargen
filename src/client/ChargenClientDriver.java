package client;

import java.io.IOException;
import java.lang.Integer;
import java.lang.NumberFormatException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.InetAddress;

/**
 * The entry point of the application. Checks valid input, creates either a TCP
 * or a UDP client using the command line arguments given, and calls its printToStream method.
 *
 * @author Nicholas Widener
 * @author Jameson Burchette
 * @version October 2015
 */
public class ChargenClientDriver {

    /**
     * Connects to a server running the Chargen protocol described in RFC 864 using either
     * TCP or UDP and prints the response.
     *
     * @param args Command line arguments; the protocol to use, the name or IP address of
     *             the server to connect to, and two optional arguments corresponding to
     *             the port number to use and one of the flags defined in the modified RFC 864.
     */
    public static void main (String[] args) {
        if (args.length < 2 || args.length > 4) {
            System.out.println("usage: client.ChargenClientDriver <TCP | UDP> <hostname> [<port #>] [flags]");
            System.exit(1);
        }
        if (!(args[0].equals("UDP") || args[0].equals("udp") || args[0].equals("TCP") || args[0].equals("tcp"))) {
            System.out.println("usage: client.ChargenClientDriver <TCP | UDP> <hostname> [<port #>] [flags]");
            System.exit(1);
        }
        if (args.length == 4 && !(args[3].equals("NAN") || args[3].equals("AN") ||
                args[3].equals("N") || args[3].equals("C") ||
                args[3].equals("nan") || args[3].equals("an") ||
                args[3].equals("n") || args[3].equals("c"))) {
            System.out.println("usage: client.ChargenClientDriver <TCP | UDP> <hostname> [<port #>] [flags]");
            System.out.println("flags include <CR><LF>, NAN, AN, N, and C");
            System.exit(1);
        }

        try {
            ChargenClient client;
            if (args[0].equals("UDP") || args[0].equals("udp")) {
                if (args.length == 2) {
                    client = new ChargenUdpClient(InetAddress.getByName(args[1]));
                }
                else {
                    client = new ChargenUdpClient(InetAddress.getByName(args[1]),
                                                  Integer.parseInt(args[2]));
                }
            }
            else {
                if (args.length == 2) {
                    client = new ChargenTcpClient(InetAddress.getByName(args[1]));
                }
                else if (args.length == 3){
                    client = new ChargenTcpClient(InetAddress.getByName(args[1]),
                                                  Integer.parseInt(args[2]));
                }
                else {
                    client = new ChargenTcpClient(InetAddress.getByName(args[1]),
                                                  Integer.parseInt(args[2]), args[3]);
                }
            }
            client.printToStream(System.out);
        }
        catch (NumberFormatException e) {
            System.out.println("Error: Your third argument doesn't seem to be a number.");
            System.out.println("usage: client.ChargenClientDriver <TCP | UDP> <hostname> [<port #>] [flags]");
            System.exit(1);
        }
        catch (UnknownHostException e) {
            System.out.println("Error: The IP address of " + args[1] + " could not be determined.");
            System.exit(1);
        }
        catch (SocketTimeoutException e) {
            System.out.println("Error: A response was not received within the allotted time.");
        }
        catch (SocketException e) {
            System.out.println("Error: Connection refused.");
            System.exit(1);
        }
        catch (IOException e) {
            System.out.println("Error: Something went wrong while sending or receiving data.");
            System.exit(1);
        }
    }
}
