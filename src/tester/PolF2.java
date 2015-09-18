package tester;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class PolF2 {

    private int cantTerminos;
    private int[] vector;
    final int type = 2;

    public PolF2(int cantTerminos) {
        this.cantTerminos = cantTerminos;
        vector = new int[(cantTerminos * 2) + 1];
        vector[0] = cantTerminos;
        generarPolF2Aleatorio();
    }

    public void setCantTerminos(int cantTerminos) {
        this.cantTerminos = cantTerminos;
    }

    public int[] getVector() {
        return vector;
    }

    public int getVector(int pos) {
        return vector[pos];
    }

    private void generarPolF2Aleatorio() {
        Random r = new Random();
        int coef, exp, max, min;
        vector[1] = r.nextInt(cantTerminos) + cantTerminos;
        vector[2] = r.nextInt(10) + 1;

        for (int i = 3; i < cantTerminos * 2 + 1; i = i + 2) {
            //do{
            max = vector[i - 2];
            min = vector[i - 2] - 2;
            exp = (int) (Math.random() * (max - min)) + min;

            //}while(exp >= (vector[i-2]));

            vector[i] = exp;
            vector[i + 1] = r.nextInt(10) + 1;
        }
    }

    public void mostrarPolinomio() {
        for (int i = 0; i < vector[0] * 2 + 1; i++) {
            System.out.print(vector[i] + " | ");
        }

        System.out.println("\n");


    }

    public int obtenerDato(int p) {
        return this.vector[p];
    }

    public int obtenerN() {
        return this.cantTerminos;
    }

    public int obtenerGrado() {
        return this.vector[0];
    }

    public void asignarDato(int p, int d) {
        this.vector[p] = d;
    }

    public void insertarTermino(int coe, int exp) {
        int i = 1;
        while ((i < this.vector[0] * 2 + 1) && (this.vector[i] > exp)) {
            i += 2;
        }
        if ((i < this.vector[0] * 2 + 1) && (this.vector[i] == exp)) {
            int suma = this.vector[(i + 1)] + coe;
            if (suma != 0) {
                this.vector[(i + 1)] = suma;
            } else {
                for (int j = i + 2; j < this.vector[0] * 2 + 1; j++) {
                    this.vector[(j - 2)] = this.vector[j];
                }
                this.vector[0] -= 1;
            }
        } else {
            aumentarN();
            for (int j = this.vector[0] * 2; j >= i; j--) {
                this.vector[(j + 2)] = this.vector[j];
            }
            this.vector[i] = exp;
            this.vector[(i + 1)] = coe;
            this.vector[0] += 1;
        }
    }

    public void aumentarN() {
        if (this.vector[0] * 2 + 1 >= this.cantTerminos) {
            this.cantTerminos += 2;

            int[] aux = new int[this.cantTerminos];
            for (int i = 0; i < this.vector[0] * 2 + 1; i++) {
                aux[i] = this.vector[i];
            }
            this.vector = aux;
        }
    }

    public PolF2 sumar(PolF2 b) {
        PolF2 c = new PolF2(1);
        c.asignarDato(0, 0);

        int i = 1;
        int j = 1;
        while ((i < this.vector[0] * 2) && (j < b.obtenerDato(0) * 2)) {
            int expa = this.vector[i];
            int expb = b.obtenerDato(j);
            int coea = this.vector[(i + 1)];
            int coeb = b.obtenerDato(j + 1);
            if (expa == expb) {
                c.insertarTermino(coea + coeb, expa);

                i += 2;
                j += 2;
            } else if (expa > expb) {
                c.insertarTermino(coea, expa);

                i += 2;
            } else {
                c.insertarTermino(coeb, expb);

                j += 2;
            }
        }
        while (i < this.vector[0] * 2 + 1) {
            c.insertarTermino(this.vector[(i + 1)], this.vector[i]);
            i += 2;
        }
        while (j < b.obtenerDato(0) * 2 + 1) {
            c.insertarTermino(b.obtenerDato(j + 1), b.obtenerDato(j));

            j += 2;
        }
        return c;
    }

    @Override
    public String toString() {
        String respuesta = "";
        int i = 0;

        int exp = 0;
        respuesta += this.vector[2] + "X^" + this.vector[1];
        for (i = 3; i < this.vector[0] + 2; i++) {
            exp = this.vector[0] + 1 - i;
            if (this.vector[i] >= 0) {
                respuesta = respuesta + "  +  " + this.vector[i] + "X^" + exp;
            } else {
                respuesta = respuesta + "  -  " + this.vector[i] * -1 + "X^" + exp;
            }
        }
        return respuesta;    }

    public int[] toArray() {
        return vector.clone();
    }

}
