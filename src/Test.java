import java.util.Scanner;

/**
 * Created by Jameson on 10/22/2015.
 */
public class Test {
    public static void main (String[] args) {
        DefactoSource source = new DefactoSource();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int input = scanner.nextInt();
            if (input == 0) {
                System.exit(0);
            }
            if (input == 1) {
                for (int i = 0; i < 512; i++) {
                    System.out.print(source.next());
                }
            }
        }
    }
}
