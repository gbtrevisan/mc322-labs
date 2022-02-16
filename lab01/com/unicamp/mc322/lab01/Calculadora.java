package com.unicamp.mc322.lab01;

import java.util.Scanner;

public class Calculadora {
    static Scanner calcInput = new Scanner(System.in);

    public static double soma(double operando1, double operando2) {
        return operando1 + operando2;
    }

    public static double subtrai(double operando1, double operando2) {
        return operando1 - operando2;
    }

    public static double multiplica(double operando1, double operando2) {
        return operando1 * operando2;
    }

    public static double divide(double operando1, double operando2) {
        if (operando2 == 0) {
            System.out.println("Divisao por 0! ...\nDigite um novo divisor:");
            operando2 = calcInput.nextDouble();
            return divide(operando1, operando2);
        }
        return operando1 / operando2;
    }

    public static double fatorial(int operando) {
        if (operando < 0) {
            System.out.println("Valor negativo ...\nDigite um novo operando:");
            operando = calcInput.nextInt();
            return fatorial(operando);
        }
        if (operando == 0)
            return 1;
        return operando * fatorial(operando - 1);
    }

    public static boolean primo(int operando) {
        for (int i = 2; i * i <= operando; i++) {
            if (operando % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("1) Digite 1 para somar;\n" +
                "2) Digite 2 para subtrair;\n" +
                "3) Digite 3 para multiplicar;\n" +
                "4) Digite 4 para dividir;\n" +
                "5) Digite 5 para calcular fatorial;\n" +
                "6) Digite 6 para verificar se um número é primo;\n" +
                "7) Qualquer outro valor para sair do programa.");

        Scanner input = new Scanner(System.in);
        int operador = input.nextInt();

        while (operador <= 6 && operador >= 1) {
            System.out.println("Insira operando(s):");

            if (operador == 1)
                System.out.println(soma(input.nextDouble(), input.nextDouble()));
            else if (operador == 2)
                System.out.println(subtrai(input.nextDouble(), input.nextDouble()));
            else if (operador == 3)
                System.out.println(multiplica(input.nextDouble(), input.nextDouble()));
            else if (operador == 4)
                System.out.println(divide(input.nextDouble(), input.nextDouble()));
            else if (operador == 5)
                System.out.println(fatorial(input.nextInt()));
            else
                if (primo(input.nextInt()))
                    System.out.println("É primo");
                else
                    System.out.println("Não é primo");

            System.out.println("Insira uma nova operacao:");
            operador = input.nextInt();

        }

    }

}
