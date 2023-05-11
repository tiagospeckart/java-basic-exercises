import java.util.Scanner;

public class BasicCodes2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("""
                Input (by item list) desired program:
                1) Calculate circle area: given a radius, calculate the area of a circle
                2) Sum of digits: read a three-digit integer and display the sum of its digits
                3) Is prime: check if a number is prime or not
                4) Arithmetic sequence: read three integers and check if they form an arithmetic sequence, and display the common difference
                5) Palindrome: read a string and check if it's a palindrome
                """);

        String option = scanner.nextLine();

        switch (option) {
            case "1" -> {
                System.out.print("Enter the radius: ");
                double radius = scanner.nextDouble();
                double area = calculateCircleArea(radius);
                System.out.printf("Area of the circle: %.2f\n", area);
            }
            case "2" -> {
                System.out.print("Input a three digit integer: ");
                int number = scanner.nextInt();
                int sumDigits = sumDigits(number);
                System.out.println("Sum of digits: " + sumDigits);
            }
            case "3" -> {
                System.out.print("Enter a number: ");
                int examinedNumber = scanner.nextInt();
                boolean isPrime = isPrime(examinedNumber);
                System.out.println(isPrime ? "The number is prime." : "The number is not prime.");
            }
            case "4" -> {
                System.out.print("Type three integers: ");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                verifyArithmeticSequence(a, b, c);
            }
            case "5" -> {
                System.out.println("Type a string: ");
                String inputString = scanner.nextLine();
                boolean isPalindrome = isPalindrome(inputString);
                System.out.println(isPalindrome ? "The string is a palindrome" : "The string isn't a palindrome");
            }
        }

        scanner.close();
    }

    private static double calculateCircleArea(double radius) {
        final double PI = 3.14;
        return PI * Math.pow(radius, 2);
    }

    private static int sumDigits (int number) {
        int digit1 = number % 10;
        number = number / 10;
        int digit2 = number % 10;
        number = number / 10;
        int digit3 = number % 10;

        return digit1 + digit2 + digit3;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void verifyArithmeticSequence(int a, int b, int c){
        if (b - a == c - b) {
            System.out.println("The numbers are an arithmetic sequence with the ratio " + (b - a) + ".");
        } else {
            System.out.println("These numbers aren't an arithmetic sequence");
        }
    }

    private static boolean isPalindrome (String inputString) {
        int left = 0;
        int right = inputString.length() - 1;

        while (left < right) {
            if (inputString.charAt(left) != inputString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


/*
* O que temos que fazer:

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