
/**
 * Created by Jameson on 10/22/2015.
 */
public class Test {
    public static void main (String[] args) {
        ChargenSource source = new NumericSource(512);
        while (source.itemsToSend() > 0) {
            System.out.print(source.next());
        }
        System.out.println();
    }
}