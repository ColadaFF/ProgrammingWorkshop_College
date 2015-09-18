package tester;

import java.util.Arrays;
import java.util.Random;

public class PolF1 {

    private int grado;
    private int[] vector;
    final int type = 1;

    public PolF1() {
    }

    public PolF1(int grado) {
        this.grado = grado;
        vector = new int[grado + 2];
        vector[0] = grado;

        generarPolF1Aleatorio();
    }

    public int getGrado() {
        return grado;
    }

    public int[] getVector() {
        return vector;
    }

    private void generarPolF1Aleatorio() {
        Random r = new Random();
        for (int i = 1; i < vector.length; i++) {
            vector[i] = (int) (r.nextInt(grado) * Math.pow(-1, r.nextInt(grado)));
        }
    }

    public void mostrarPolF1() {
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] != 0) {
                if ((i != 1) && (vector[i] > 0)) {
                    System.out.print(" + ");
                }

                System.out.print(vector[i] + "X^" + (grado + 1 - i) + " ");
            }
        }
    }

    public int obtenerGrado() {
        return vector[0];
    }

    public void asignarDato(int p, int d) {
        vector[p] = d;
    }


    public int obtenerDato(int p) {
        return vector[p];
    }

    public void ajustar() {
        int cont = 0, i;
        if (vector[1] == 0) {

            i = 1;
            while (i < vector[0] + 2 && vector[i] == 0) {
                cont = cont + 1;
                i = i + 1;
            }
            for (int j = i; j < vector[0] + 2; j++) {
                vector[j - cont] = vector[j];
            }
            vector[0] = vector[0] - cont;
        }
    }

    public PolF1 sumar(PolF1 b) {
        PolF1 c;
        int may = vector[0];
        if (b.obtenerGrado() > may) {
            may = b.obtenerGrado();
        }
        c = new PolF1(may + 2);
        c.asignarDato(0, may);
        int i, j, expa, expb, expc, posc;
        i = 1;
        j = 1;
        while (i < vector[0] + 2 && j < b.obtenerDato(0) + 2) {
            expa = vector[0] + 1 - i;
            expb = b.obtenerDato(0) + 1 - j;
            if (expa == expb) {
                posc = c.obtenerDato(0) + 1 - expa;
                c.asignarDato(posc, vector[i] + b.obtenerDato(j));
                i = i + 1;
                j = j + 1;
            } else if (expa > expb) {
                posc = c.obtenerDato(0) + 1 - expa;
                c.asignarDato(posc, vector[i]);
                i = i + 1;

            } else {
                posc = c.obtenerDato(0) + 1 - expb;
                c.asignarDato(posc, b.obtenerDato(j));
                j = j + 1;

            }

        }
        c.ajustar();
        return c;
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (int i = 1; i < vector.length; i++) {
            toReturn += vector[i] + "X^" + (grado + 1 - i) + " ";
        }
        return toReturn;
    }

    public int[] toArray() {
        return vector.clone();
    }

}
