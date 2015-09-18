package tester;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * Created by cs2kn on 10/09/2015.
 */
public class Runner {
    public static void main(String[] args) {
        int totalToGenerate = 5;
        Object[] pols = new Object[5];
        int f1 = 0;
        int f2 = 0;
        Random rdn = new Random();
        for (int i = 0; i < totalToGenerate; i++) {
            Boolean whichOne = whichOne();
            if (whichOne) {
                pols[i] = new PolF1(rdn.nextInt(10) + 1);
                f1++;
            } else {
                pols[i] = new PolF2(rdn.nextInt(10) + 1);
                f2++;
            }
        }

        System.out.println(printer(pols, f1, f2));
    }

    public static boolean whichOne() {
        return Math.random() > 0.5;
    }

    public static String printer(Object[] vector, int f1, int f2) {
        String buffer = "";


        /**
         * Instances of the pols
         */
        PolF1[] vt1 = new PolF1[f1];
        PolF2[] vt2 = new PolF2[f2];
        int added1 = 0;
        int added2 = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] instanceof PolF1) {
                vt1[added1] = (PolF1) vector[i];
                added1++;
            } else {
                vt2[added2] = (PolF2) vector[i];
                added2++;
            }
        }

        /*Build string buffer*/
        buffer += "PolF1\n\tHow Many: " + vt1.length;

        for (int i = 0; i < vt1.length; i++) {
            buffer += "\n\tN: " + (i + 1) + "\n\tPol String: " + vt1[i].toString() + "\n\tPol Array" + Arrays.toString(vt1[i].toArray()) + "\n";
        }

        buffer += "PolF2\n\tHow Many: " + vt2.length;
        for (int i = 0; i < vt2.length; i++) {
            buffer += "\n\tN: " + (i + 1) + "\n\tPol String: " + vt2[i].toString() + "\n\tPol Array" + Arrays.toString(vt2[i].toArray()) + "\n";
        }
        /**
         * End instances
         */

        PolF1 totalSum1 = vt1[0];
        if (vt1.length > 1) {
            for (int i = 1; i < vt1.length; i++) {
                totalSum1 = totalSum1.sumar(vt1[i]);
            }
        }

        buffer += "\nSum PolF1: \n\tString: " + totalSum1.toString() + "\n\tArray: " + Arrays.toString(totalSum1.toArray()) + "\n";

        PolF2 totalSum2 = vt2[0];
        if (vt2.length > 1) {
            for (int i = 1; i < vt2.length; i++) {
                totalSum2 = totalSum2.sumar(vt2[i]);
            }
        }

        buffer += "\nSum PolF2: \n\tString: " + totalSum2.toString() + "\n\tArray: " + Arrays.toString(totalSum2.toArray());


        return buffer;
    }
}
