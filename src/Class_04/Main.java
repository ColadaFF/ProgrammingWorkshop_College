package Class_04;

import java.util.Scanner;

/**
 * Created by Force on 8/20/2015.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Object[] vector = new Object[3];
        PolF1 polF1;
        int level;

        for (int i = 0; i < 3; i++) {
            System.out.println("Grado: ");
            level = scanner.nextInt();

            polF1 = new PolF1(level);
            polF1.printPolF1();

            vector[i] = polF1;
        }
        
    }

}
