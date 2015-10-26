import common.*;
import server.CardSource;

/**
 * Created by Jameson on 10/22/2015.
 */
public class Test {
    public static void main (String[] args) {
        CardSource source = new CardSource(Integer.MAX_VALUE);
        while (source.itemsToSend() > 0) {
            System.out.println(source.next().toString());
        }
    }
}
