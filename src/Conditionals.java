import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Conditionals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("""
                Input (by item list) desired program:
                1) Is Even or Odd?
                2) Is Positive, Negative, or Zero?
                3) Is Prime?
                4) Is Leap Year?
                5) Is Multiple of 3 and 5?
                6) Is Divisible by 2, 3, or 5?
                7) Is legally adult?
                8) Can Vote?
                9) What Triangle Type? (equilateral, isosceles, or scalene)
                10) Largest of Three Numbers
                """);

        String option = scanner.nextLine();

        switch (option) {
            case "1" -> {
                System.out.println("Enter a number: ");
                int examinedNumber = scanner.nextInt();
                isEvenOrOdd(examinedNumber);
            }
            case "2" -> {
                System.out.println("Enter a number: ");
                int examinedNumber = scanner.nextInt();
                isPositiveNegativeOrZero(examinedNumber);
            }
            case "3" -> {
                System.out.print("Enter a number: ");
                int examinedNumber = scanner.nextInt();
                boolean isPrime = isPrime(examinedNumber);
                System.out.println(isPrime ? "The number is prime." : "The number is not prime.");
            }

            case "4" -> {
                System.out.print("Enter a year: ");
                int year = scanner.nextInt();
                scanner.nextLine();

                boolean isLeapYear = new GregorianCalendar().isLeapYear(year);

                if (isLeapYear) {
                    System.out.println(year + " is a leap year.");
                } else {
                    System.out.println(year + " is not a leap year.");
                }
            }

            case "5" -> {
                System.out.print("Enter a number: ");
                int examinedNumber = scanner.nextInt();
                scanner.nextLine();

                if (examinedNumber % 5 == 0 && examinedNumber % 3 == 0) {
                    System.out.println(examinedNumber + " is multiple of 5 and 3");
                } else System.out.println(examinedNumber + " is not a multiple of 5 and 3");
            }
            case "6" -> {
                System.out.print("Enter a number: ");
                int examinedNumber = scanner.nextInt();
                scanner.nextLine();

                if (examinedNumber % 2 == 0) {
                    System.out.println(examinedNumber + " is divisible by 2");
                } else if (examinedNumber % 3 == 0) {
                    System.out.println(examinedNumber + " is divisible by 3");
                } else if (examinedNumber % 5 == 0) {
                    System.out.println(examinedNumber + " is divisible by 5");
                } else {
                    System.out.println(examinedNumber + " is not divisible by 2, 3, or 5");
                }
            }
            case "7" -> {
                System.out.print("Enter a age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.println(age >= 18 ? "Is an adult" : "Is a child");
            }

            case "8" -> {
                System.out.print("Enter a age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.println(age >= 16 ? "Can vote" : "Can't vote");
            }

            case "9" -> {
                System.out.print("Enter the first triangle side: ");
                int side1 = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter the second triangle side: ");
                int side2 = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter the third triangle side: ");
                int side3 = scanner.nextInt();
                scanner.nextLine();

                if (side1 == side2 && side2 == side3) {
                    System.out.println("It's an equilateral triangle");
                } else if (side1 == side2 || side1 == side3 || side2 == side3) {
                    System.out.println("It's an isosceles triangle");
                } else {
                    System.out.println("It's a scalene triangle");
                }
            }

            case "10" -> {
                System.out.print("Enter the first number: ");
                int number1 = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter the second number: ");
                int number2 = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter the third number: ");
                int number3 = scanner.nextInt();
                scanner.nextLine();

                int largestNumber;

                if (number1 >= number2 && number1 >= number3) {
                    largestNumber = number1;
                } else if (number2 >= number1 && number2 >= number3) {
                    largestNumber = number2;
                } else {
                    largestNumber = number3;
                }

                System.out.println("The largest number is: " + largestNumber);
            }
        }
        scanner.close();
    }
    private static void isEvenOrOdd(int examinedNumber) {
        System.out.println((examinedNumber % 2) == 0 ? examinedNumber + " is Even" : examinedNumber + " is Odd");
    }

    private static void isPositiveNegativeOrZero(int examinedNumber) {
        System.out.println(examinedNumber > 0 ? examinedNumber + " is positive" : examinedNumber < 0 ? examinedNumber + " is negative" : examinedNumber + " is 0");
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
}