/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stresstest;

/**
 *
 * @author fernando.borovsak
 */
public class StressTest {

    public static void main(String[] args) {

        double[] array = new double[500000];

        long time_start, time_end;
        time_start = System.currentTimeMillis();
        System.out.println("Cargando...");

        ordenamientoASCBurbuja(autoCargarArray(array, 100));

        time_end = System.currentTimeMillis();
        System.out.println("Se Cargaron Y Ordenaron : " + array.length + " Numeros");
        System.out.println("Tiempo De Proceso Con Burbuja Y  : " + array.length + " Elementos : " + (time_end - time_start) + " ms");

        time_start = System.currentTimeMillis();
        System.out.println("Cargando...");
        ordenamientoQuicksort(autoCargarArray(array, 100), 0, array.length - 1);

        time_end = System.currentTimeMillis();
        System.out.println("Se Cargaron Y Ordenaron : " + array.length + " Numeros");
        System.out.println("Tiempo De Proceso Con QuickSort Y  : " + array.length + " Elementos : " + (time_end - time_start) + " ms");
    }

    public static double[] autoCargarArray(double[] array, int maximo) {

        for (int i = 0; i < array.length; i++) {
            double random = (double) (Math.random() * maximo);
            array[i] = random;
        }

        return array;
    }

    public static double[] ordenamientoASCBurbuja(double array[]) {
        //ORDEN ASCENDENTE
        //iteramos sobre los elementos del arreglo
        for (int i = 0; i < array.length - 1; i++) {
            int menor = i;

            //buscamos el menor número
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[menor]) {
                    menor = j;    //encontramos el menor número
                }
            }

            if (i != menor) {
                //permutamos los valores
                double aux = array[i];
                array[i] = array[menor];
                array[menor] = aux;
            }

        }

        return array;

    }

    public static double[] ordenamientoQuicksort(double[] array, int izq, int der) {
        /*Este metodo recibe un aray de numeroe enteros, y dos enteros que referencian el primer valor
            Y el ultimo del array*/

        //Se toma como pivote el primer valor
        double pivote = array[izq];

        //Se definen los dos lados y un auxiliar
        int i = izq;
        int j = der;
        double aux;

        while (i < j) {
            while (array[i] <= pivote && i < j) {
                i++;
            }

            while (array[j] > pivote) {
                j--;
            }

            if (i < j) {
                aux = array[i];
                array[i] = array[j];
                array[j] = aux;
            }
        }

        array[izq] = array[j];
        array[j] = pivote;

        if (izq < j - 1) {
            ordenamientoQuicksort(array, izq, j - 1);
        }

        if (j + 1 < der) {
            ordenamientoQuicksort(array, j + 1, der);
        }

        return array;
    }
    
}
