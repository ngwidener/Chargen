import java.lang.Integer;
import java.lang.NumberFormatException;
import java.net.UnknownHostException;
import java.net.InetAddress;

/**
 * Created by Nicholas on 10/7/2015.
 */
public class ChargenClientDriver {
    public static void main (String[] args) {
        ChargenClient client = null;
        try {
            if (args[0].equals("UDP") || args[0].equals("udp")) {
                if (args.length == 2) {
                    client = new ChargenUdpClient(InetAddress.getByName(args[1]));
                }
                else if (args.length == 3) {
                    client = new ChargenUdpClient(InetAddress.getByName(args[1]),
                                                  Integer.parseInt(args[3]));
                }
            }
            else if (args[0].equals("TCP") || args[0].equals("tcp")) {
                if (args.length == 2) {
                    client = new ChargenTcpClient(InetAddress.getByName(args[1]));
                }
                else if (args.length == 3) {
                    client = new ChargenTcpClient(InetAddress.getByName(args[1]),
                                                  Integer.parseInt(args[3]));
                }
            }
            client.printToStream(System.out);
        }
        catch (NumberFormatException e) {
            System.out.println("Error: Your second argument doesn't seem to be a number.");
            System.out.println("usage: ChargenClientDriver <TCP | UDP> <hostname> [<port #>] [flags]");
            System.exit(1);
        }
        catch (UnknownHostException e) {
            System.out.println("Error: The IP address of " + args[1] + " could not be determined.");
            System.exit(1);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
