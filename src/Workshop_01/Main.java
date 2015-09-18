package Workshop_01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Force on 06/08/2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número de N para generar la matriz");
        int n = sc.nextInt();

        Matrix matrix = new Matrix(n);
        int[][] mtx = matrix.generateMatrix();
        matrix.printMatrix(mtx);
        program:
        for (; ; ) {
            System.out.println("Menú:\nOpciones:\n\tPresione 1 para ordenar por fila\n\tPresione 2 para ordenar por columna\n\tPresione 3 para buscar un valor\n\tPresione 4 para generar una nueva matriz\n\tPresione cualquier otra tecla para finalizar");
            switch (sc.nextInt()) {
                case 1:
                    int[][] copyRows = matrix.copyMatrix(mtx);
                    matrix.orderByRows(copyRows);
                    matrix.printMatrix(copyRows);
                    break;
                case 2:
                    int[][] copyColumn = matrix.copyMatrix(mtx);
                    matrix.orderByColumn(copyColumn);
                    matrix.printMatrix(copyColumn);
                    break;
                case 3:
                    System.out.println("Ingrese el valor a buscar");
                    int data[] = matrix.searchValue(mtx, sc.nextInt());
                    System.out.println(data == null ? "No existe el valor" : Arrays.toString(data));
                    break;
                case 4:
                    System.out.println("Ingrese el número de N para generar la matriz");
                    n = sc.nextInt();
                    matrix.setN(n);
                    mtx = matrix.generateMatrix();
                    matrix.printMatrix(mtx);
                    break;
                default:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
            }
        }
    }
}
