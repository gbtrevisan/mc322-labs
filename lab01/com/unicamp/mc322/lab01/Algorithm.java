package com.unicamp.mc322.lab01;

public class Algorithm {

    public static void main(String[] args) {

        int quantity = 10;
        int[] vector = new int[quantity];

        for (int i = 0; i < vector.length - 1; i++) {
            vector[i] = (int) (Math.random() * 100);
        }

        sort(vector);

        for (int i = 0; i < vector.length - 1; i++) { // for (int i = 1; i < vector.length; i++) { (+2 erros)
            System.out.println(vector[i]);
        }
    }

    private static void sort(int[] vector) {

        boolean switched = true;
        int aux;

        while (switched) {
            switched = false;
            for (int i = 0; i < vector.length - 2; i++) { // for (int i = 0; i < vector.length - 1; i++) { (+1 erro)
                if (vector[i] > vector[i + 1]) {
                    aux = vector[i];
                    vector[i] = vector[i + 1];
                    vector[i + 1] = aux; // vector[i - 1] = aux; (+1 erro)
                    switched = true; // switched = false; (+1 erro)
                }
            }
        }
    }

} // total: 5 erros
