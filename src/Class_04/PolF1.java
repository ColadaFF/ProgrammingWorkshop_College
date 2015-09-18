package Class_04;

import java.util.Random;

/**
 * Created by Force on 8/20/2015.
 */
public class PolF1 {

    private int level;
    private int[] vector;

    public PolF1(int level) {
        this.level = level;
        vector = new int[level + 2];
        vector[0] = level;
        generatePolF1Random();
    }

    public int getLevel() {
        return level;
    }

    public int[] getVector() {
        return vector;
    }

    private void generatePolF1Random(){
        Random random = new Random();
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (random.nextInt(level) * Math.pow(-1, random.nextInt(level)));
        }
    }

    public void printPolF1(){
        for (int i = 1; i < vector.length; i++) {
            if ( !(vector[i] == 0) ){
                System.out.print( vector[i] + "X^" + (level + 1 - i) + " "  );
            }
        }
    }


}
