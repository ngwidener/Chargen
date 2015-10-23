import java.util.Scanner;

/**
 * Created by Jameson on 10/22/2015.
 */
public class Test {
    public static void main (String[] args) {
        //DefactoSource source = new DefactoSource(512);
        NonAlphanumericSource source = new NonAlphanumericSource(512);
        Scanner scanner = new Scanner(System.in);
        while (source.itemsToSend() > 0) {
            System.out.print(source.next());
        }
        System.out.println();
    }
}
