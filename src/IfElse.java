import java.time.Year;
import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("""
                Input (by item list) desired program:
                1) Largest of Two Numbers
                2) Can Vote by Birth Year?
                3) Password Validation
                4) Apple Purchase
                5) Sort Three Integers
                6) Ideal Weight
                7) Polygon area
                8) Largest of Three Integers
                9) Triangle type by side lengths
                10) Triangle type by angles
                """);

        String option = scanner.nextLine();

        switch (option) {
            case "1" -> {
                System.out.print("Enter two numbers: ");
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double biggerNumber = compareTwoNumbers(a, b);
                System.out.printf("The bigger number is: %.2f%n", biggerNumber);
            }
            case "2" -> {
                System.out.print("Input a birth year: ");
                int birthYear = scanner.nextInt();
                canVoteByBirthYear(birthYear);
            }

            case "3" -> {
                System.out.print("Enter password: ");
                int password = scanner.nextInt();
                boolean validPassword = passwordValidator(password);
                System.out.println(validPassword ? "ACCESS GRANTED" : "ACCESS DENIED");
            }
            case "4" -> {
                System.out.print("How many apples are you buying? ");
                int appleQuantity = scanner.nextInt();
                double[] prices = calculateApplePrice(appleQuantity);
                System.out.printf("Your total is R$%.2f, each apple costing R$%.2f.%n", prices[0], prices[1]);
            }
            case "5" -> {
                System.out.println("Type three integers: ");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();

                int[] sortedIntegers = sortThreeIntegers(a, b, c);
                System.out.println(sortedIntegers[0] + " " + sortedIntegers[1] + " " + sortedIntegers[2]);
            }
            case "6" -> {
                System.out.println("Enter a gender: 1 for female, 2 for male");
                int gender = scanner.nextInt();
                System.out.println("Now enter a height (in metric): ");
                double height = scanner.nextDouble();
                double idealWeight = calculateIdealWeight(gender, height);
                System.out.printf("Ideal weight is %.2f.%n", idealWeight);
            }
            case "7" -> {
                System.out.println("Enter the number of sides of a polygon (max allowed is 5): ");
                int numberOfSides = scanner.nextInt();
                System.out.println("Enter the side length (in cm): ");
                double sideLength = scanner.nextDouble();
                double area;

                boolean validPolygon = true;

                if (numberOfSides < 3) {
                    System.out.println("Not a polygon");
                    validPolygon = false;
                } else if (numberOfSides > 5) {
                    System.out.println("Unidentified polygon");
                    validPolygon = false;
                } else if (numberOfSides == 5) System.out.println("PENTAGON");

                if (validPolygon) {
                    if (numberOfSides == 3) {
                        area = calculateArea(numberOfSides, sideLength);
                        System.out.printf("Equilateral TRIANGLE area is: %.2f cm2.%n", area);
                    } else if (numberOfSides == 4) {
                        area = calculateArea(numberOfSides, sideLength);
                        System.out.printf("QUADRANGLE area is: %.2f cm2.%n", area);
                    }
                }
            }
            case "8" -> {
                System.out.print("Enter three integers: ");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                int biggerNumber = findBiggestInteger(a, b, c);
                System.out.println("The bigger number is: " + biggerNumber);
            }
            case "9" -> {
                System.out.print("Enter the first side length of a triangle: ");
                double a = scanner.nextDouble();
                System.out.print("Enter the second side: ");
                double b = scanner.nextDouble();
                System.out.print("And the third side: ");
                double c = scanner.nextDouble();
                System.out.println(triangleTypeBySideLengths(a, b, c));
            }
            case "10" -> {
                System.out.print("Enter the first angle of a triangle (total 180): ");
                int a = scanner.nextInt();
                System.out.print("Enter the second angle of a triangle (remaining " + (180 - a) + "): ");
                int b = scanner.nextInt();
                System.out.print("Enter the third angle of a triangle (remaining " + (180 - a - b) + "): ");
                int c = scanner.nextInt();
                if ((a + b +c) == 180) {
                    System.out.println(triangleTypeByAngles(a, b, c));
                } else System.out.println("It's not a triangle");
            }
        }

        scanner.close();
    }

    private static double compareTwoNumbers(double num1, double num2) {
        return Math.max(num1, num2);
    }

    private static void canVoteByBirthYear (int birthYear) {
        int currentYear = Year.now().getValue();

        if (birthYear < 1909) { // current oldest person alive was born at this year
            System.out.println("You are dead!");
        } else if ((currentYear - birthYear) < 16 ) {
            System.out.println("You can't vote!");
        } else {
            System.out.println("You can vote!");
        }
    }

    private static boolean passwordValidator(int password) {
        return 0b10011010010 == password;
        // IDE suggested another base for password validation
        // And I didn't know this kind of one line boolean conditional was possible, Nice!
    }

    private static double[] calculateApplePrice(int appleQuantity) {
        double pricePerApple;
        if (appleQuantity < 12) {
            pricePerApple = 0.30;
        } else {
            pricePerApple = 0.25;
        }
        double totalPrice = appleQuantity * pricePerApple;
        return new double[]{totalPrice, pricePerApple}; // a way to return two same type values in the same method
    }

    private static int[] sortThreeIntegers(int a, int b, int c){
        int first, second, third;

        if (a < b && a < c) {
            first = a;
            if (b < c) {
                second = b;
                third = c;
            } else {
                second = c;
                third = b;
            }
        } else if (b < a && b < c) {
            first = b;
            if (a < c) {
                second = a;
                third = c;
            } else {
                second = c;
                third = a;
            }
        } else {
            first = c;
            if (a < b) {
                second = a;
                third = b;
            } else {
                second = b;
                third = a;
            }
        }
        return new int[]{first, second, third};
    }

    private static double calculateIdealWeight (int gender, double height) {
        if (gender == 1){ // women
            return (62.1 * height) - 44.7;
        } else return (72.7 * height) - 58; // men
    }

    private static double calculateArea (int sides, double length) {
        if (sides == 3) {
            double squareRootOfThree = Math.sqrt(3);
            return (squareRootOfThree / 4) * (length * length);
        } else {
            return length * length;
        }
    }

    private static int findBiggestInteger(int num1, int num2, int num3) {
        int biggestInt;

        if (num1 > num2 && num1 > num3) {
            biggestInt = num1;
        } else if (num2 > num1 && num2 > num3) {
            biggestInt = num2;
        } else {
            biggestInt = num3;
        }

        return biggestInt;
    }
    private static String triangleTypeBySideLengths(double a, double b, double c) {
        if (a == b && b == c) {
            return "Equilateral";
        } else if (a == b || a == c || b == c) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }

    private static String triangleTypeByAngles(int a, int b, int c) {
        if (a == 90 || b == 90 || c == 90) {
            return "Right-angled";
        } else if (a > 90 || b > 90 || c > 90) {
            return "Obtuse-angled";
        } else {
            return "Acute-angled";
        }
    }
}