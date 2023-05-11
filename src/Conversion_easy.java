import java.util.Scanner;

public class Conversion_easy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer value: ");
        int intValue = scanner.nextInt();

        System.out.print("Enter a float value: ");
        float floatValue = scanner.nextFloat();

        System.out.print("Enter a double value: ");
        double doubleValue = scanner.nextDouble();

        System.out.print("Enter a char value: ");
        char charValue = scanner.next().charAt(0);

        System.out.print("Enter another integer value: ");
        int anotherIntValue = scanner.nextInt();

        long longValue = intValue;
        double doubleFromFloat = floatValue;
        int intFromDouble = (int) doubleValue;
        int intFromChar = (int) charValue;
        String stringFromInt = Integer.toString(anotherIntValue);

        System.out.println("Int converted to Long: " + longValue);
        System.out.println("Float converted to Double: " + doubleFromFloat);
        System.out.println("Double converted to Int: " + intFromDouble);
        System.out.println("Char converted to Int: " + intFromChar);
        System.out.println("Int converted to String: " + stringFromInt);

        scanner.close();
    }
}