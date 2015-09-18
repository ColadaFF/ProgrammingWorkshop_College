package DisperseMatrix;

/**
 * Created by cs2kn on 15/09/2015.
 */
public class Tripleta {
    private int mat[][], quantFs, quantCl, quantUV, matTriple[][];

    public Tripleta(int[][] mat) {
        this.mat = mat;
        quantFs = mat.length;
        quantCl = mat[0].length;

        matTriple = new int[quantUV][3];
    }

    private void utilValuesCalc() {
        for (int i = 0; i < quantFs; i++) {
            for (int j = 0; j < quantCl; j++) {
                if (mat[i][j] != 0) {
                    quantUV++;
                }
            }
        }
    }

    private void fillTriple() {
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mat[i][j] != 0) {
                    matTriple[k][0] = i;
                    matTriple[k][1] = j;
                    matTriple[k][2] = mat[i][j];
                    k++;
                }
            }
        }
    }

    public String toString() {
        String line = "";
        for (int i = 0; i < quantUV; i++) {
            for (int j = 0; j < 3; j++) {
                line += matTriple[i][j] + "\t";
            }
            line += "\n";
        }
        return line;
    }
}
