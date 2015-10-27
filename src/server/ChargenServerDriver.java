package server;

/**
 * The entry point of the application. Checks valid input.
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
    public static void main(String[] args)  {
        if (args.length < 1 || args.length > 2) {
            System.out.println("usage: server.ChargenServerDriver <TCP | UDP> [<port #>]");
            System.exit(1);
        }
        if (!(args[0].equals("UDP") || args[0].equals("udp") || args[0].equals("TCP") || args[0].equals("tcp"))) {
            System.out.println("usage: server.ChargenServerDriver <TCP | UDP> [<port #>]");
            System.exit(1);
        }

        try {
            ChargenServer server;
            if (args[0].equals("UDP") || args[0].equals("udp")) {
                if (args.length == 2) {
                    server = new ChargenUdpServer(Integer.parseInt(args[1]));
                }
                else {
                    server = new ChargenUdpServer();
                }
            }
            else {
                if (args.length == 2) {
                    server = new ChargenTcpServer(Integer.parseInt(args[1]));
                }
                else {
                    server = new ChargenTcpServer();
                }
            }
            server.listen();
        }
        catch (NumberFormatException e) {
            System.out.println("Error: Your second argument doesn't seem to be a number.");
            System.out.println("usage: server.ChargenServerDriver <TCP | UDP> <hostname> [<port #>] [flags]");
            System.exit(1);
        }
        catch (ChargenServerException e) {
            System.out.println("Server Exception");
        }
    }


}
