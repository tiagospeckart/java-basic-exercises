import java.util.Scanner;

public class BasicCodes1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("""
                Input (by item list) desired program:
                1) Arithmetic Operations: sum, subtraction, multiplication and division between two integers
                2) Is Even or Odd?: checks if a number is even or odd
                3) Is older than 18?: checks if an inputted age is bigger than 18
                4) Is String equal?: checks if two inputted text strings are equal to one another
                5) Is student with passing grade? Input three grades and the program will say if the student graduated
                """);
        String function = scanner.nextLine();

        switch (function) {
            case "1":
                System.out.print("Enter two integers separated by spaces: ");
                String[] andArgs = scanner.nextLine().split(" ");
                if (andArgs.length != 2) {
                    System.out.println("Error: Invalid number of arguments (it's 2)");
                    return;
                }
                int num1 = Integer.parseInt(andArgs[0]);
                int num2 = Integer.parseInt(andArgs[1]);
                arithmeticOperations(num1, num2);
                break;

            case "2":
                System.out.print("Enter an integer: ");
                String isEvenArg = scanner.nextLine();
                int num1IsEven = Integer.parseInt(isEvenArg);
                isEven(num1IsEven);
                break;

            case "3":
                System.out.print("Enter a age: ");
                String age = scanner.nextLine();
                int intAge = Integer.parseInt(age);
                olderEighteen(intAge);
                break;

            case "4":
                System.out.print("Enter the first string: ");
                String str1 = scanner.nextLine();

                System.out.print("Enter the second string: ");
                String str2 = scanner.nextLine();

                compareStrings(str1, str2);
                break;

            case "5":
                System.out.print("Enter the first grade: ");
                double grade1 = scanner.nextDouble();

                System.out.print("Enter the second grade: ");
                double grade2 = scanner.nextDouble();

                System.out.print("Enter the third grade: ");
                double grade3 = scanner.nextDouble();

                double average = calculateAverage(grade1, grade2, grade3);
                System.out.printf("The average is: %.2f\n", average);

                if (average >= 7) {
                    System.out.println("The student is approved.");
                } else {
                    System.out.println("The student is not approved.");
                }
                break;
        }
        scanner.close();
    }

    private static void arithmeticOperations(int num1, int num2) {
        int sum = num1 + num2;
        int subtraction = num1 - num2;
        int multiplication = num1 * num2;
        int division = num1 / num2;
        int module = num1 % num2;

        System.out.println("Sum: " + sum);
        System.out.println("Subtraction: " + subtraction);
        System.out.println("Multiplication: " + multiplication);
        System.out.println("Division: " + division);
        System.out.println("Module: " + module);
    }

    private static void isEven(int num1) {
        if ((num1 % 2) == 0) {
            System.out.println(num1 + " is Even");
        } else {
            System.out.println(num1 + " is Odd");
        }
    }

    private static void olderEighteen(int num1) {
        if (num1 >= 18) {
            System.out.println(num1 + " is older than 18");
        } else {
            System.out.println(num1 + " is younger than 18");
        }
    }

    private static void compareStrings(String string1, String string2) {
        if (string1.equals(string2)) {
            System.out.println("The strings are equal.");
        } else {
            System.out.println("The strings are not equal.");
        }
    }

    private static double calculateAverage(double grade1, double grade2, double grade3) {
        return (grade1 + grade2 + grade3) / 3;
    }
}





/*
* O que temos que fazer:

    Escreva um programa que leia dois números inteiros e exiba o resultado da soma, subtração, multiplicação, divisão e resto da divisão dos dois números.
    Escreva um programa que verifique se um número é par ou ímpar utilizando o operador módulo.
    Escreva um programa que leia a idade de uma pessoa e verifique se ela é maior ou igual a 18 anos utilizando o operador relacional de maior ou igual.
    Escreva um programa que leia duas strings e verifique se elas são iguais utilizando o operador lógico de igualdade.
    Escreva um programa que calcule a média de três notas e verifique se o aluno foi aprovado ou reprovado utilizando o operador lógico de comparação. Considere que a média para aprovação é 7.0.

Aumentando a complexidade:

    Escreva um programa que calcule a área de um círculo, dado o seu raio. Utilize a fórmula A = π * r^2 e o valor de π como 3.14.
    Escreva um programa que leia um número inteiro de três dígitos e exiba a soma dos seus dígitos.
    Escreva um programa que verifique se um número é primo ou não. Utilize o operador de resto da divisão para verificar se o número é divisível por algum outro número além de 1 e ele mesmo.
    Escreva um programa que leia três números inteiros e verifique se eles formam uma sequência aritmética. Caso afirmativo, exiba a razão da sequência.
    Escreva um programa que leia uma string e verifique se ela é um palíndromo, ou seja, se a string lida é a mesma lida de trás para frente.


Entregar o código, em um só arquivo, pode ser .java .txt enfim, seu critério.
Colocar cada atividade em um bloco e comentar o código dizendo respeito sobre qual atividade estamos falando.
Printar o resultado de cada operação.
Se tiver alguma ideia a mais, pode colocar, mas tem que ter no mínimo o que está descrito aqui.
*
* */