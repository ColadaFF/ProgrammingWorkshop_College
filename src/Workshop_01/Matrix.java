package Workshop_01;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private int[][] matrix;
    private int n;

    public Matrix(int n) {
        this.n = n;
    }

    public int[][] generateMatrix() {
        Random r = new Random();
        int vectorFill[] = new int[n * n];
        fillArray(vectorFill, 0);
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = 1 + r.nextInt(n * n * 3);
                if (linerSearch(vectorFill, tmp) >= 0) {
                    j--;
                    continue;
                }
                vectorFill[(i == 0 || j == 0) ? (i + j) : (i * j)] = tmp;
                bubbleSort(vectorFill);
                matrix[i][j] = tmp;
            }
        }
        return matrix;
    }

    public void orderByRows(int[][] matrix) {
        for (int[] row : matrix) {
            bubbleSort(row);
        }
    }

    public void orderByColumn(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] temp = new int[matrix.length];
            for (int j = 0; j < matrix[i].length; j++) {
                temp[j] = matrix[j][i];
            }
            bubbleSort(temp);
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][i] = temp[j];
            }
        }
    }

    public int[] searchValue(int[][] matrix, int value) {
        int rowIndex = 0;
        for (int[] row : matrix) {
            int tmpIndex = linerSearch(row, value);
            if (tmpIndex >= 0)
                return new int[]{rowIndex, tmpIndex};
            rowIndex++;
        }
        return null;
    }

    public int[][] copyMatrix(int[][] oldOne) {
        int[][] toCopy = new int[oldOne.length][];
        int ndx = 0;
        for (int[] row : oldOne) {
            toCopy[ndx++] = Arrays.copyOf(row, oldOne.length);
        }
        return toCopy;
    }

    public void printMatrix(int[][] toPrint) {
        for (int[] row : toPrint) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void bubbleSort(int[] arr) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    private void fillArray(int[] row, int number) {
        for (int i = 0; i < row.length; i++) {
            row[i] = number;
        }
    }

    private int  linerSearch(int[] arr, int key){
        int size = arr.length;
        for(int i=0;i<size;i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }


    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
