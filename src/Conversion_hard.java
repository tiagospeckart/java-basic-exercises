import java.util.Scanner;

public class Conversion_hard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int inputInt = scanner.nextInt();
        System.out.println("Value converted to Double: " + (double) inputInt);

        scanner.nextLine();
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        try {
            int convertedInteger = Integer.parseInt(inputString);
            System.out.println("Value converted to Integer and multiplied by 2: " + (convertedInteger * 2));
        } catch (NumberFormatException e) {
            System.out.println("Error: the string cannot be converted to Integer.");
        }

        System.out.print("Enter another string: ");
        String inputBooleanString = scanner.nextLine();
        boolean wrappedBoolean = Boolean.parseBoolean(inputBooleanString);
        System.out.println("Value converted to Boolean: " + wrappedBoolean);

        System.out.print("Enter a decimal number: ");
        double inputDouble = scanner.nextDouble();
        try {
            int wrappedIntegerFromDouble = (int) inputDouble;
            System.out.println("Value converted to Integer: " + wrappedIntegerFromDouble);
        } catch (NumberFormatException e) {
            System.out.println("Error: the decimal number cannot be converted to Integer.");
        }

        scanner.nextLine();
        System.out.print("Enter a character: ");
        char inputChar = scanner.nextLine().charAt(0);
        System.out.println("Value converted to Integer in hexadecimal: " + Integer.toHexString((int) inputChar));

        scanner.close();
    }
}