import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("""
                Input (by item list) desired program:
                1) Product classification
                2) Grade calculator
                3) Arithmetic operations
                4) Fast food order
                """);

        String option = scanner.nextLine();

        switch (option) {
            case "1" -> {
                System.out.print("Enter the product code: ");
                int productCode = scanner.nextInt();

                String classification = "";
                if (productCode == 1) {
                    classification = "Non-perishable food";
                } else if (productCode >= 2 && productCode <= 4) {
                    classification = "Perishable food";
                } else if (productCode == 5 || productCode == 6) {
                    classification = "Clothing";
                } else if (productCode == 7) {
                    classification = "Personal hygiene";
                } else if (productCode >= 8 && productCode <= 15) {
                    classification = "Cleaning and household utensils";
                } else {
                    classification = "Invalid code";
                }

                System.out.println("The product classification is: " + classification);
            }
            case "2" -> {
                System.out.print("Enter two grades separated by space, and hit enter: ");
                double grade1 = scanner.nextDouble();
                double grade2 = scanner.nextDouble();

                double average = (grade1 + grade2) / 2;
                String result = "";

                if (average >= 0 && average <= 4.0) {
                    result = "Fail";
                } else if (average > 4.0 && average <= 7.0) {
                    result = "Exam";
                } else if (average > 7.0 && average <= 10.0) {
                    result = "Pass";
                }

                System.out.printf("The arithmetic mean is %.2f, and the result is: %s%n", average, result);
            }
            case "3" -> {
                System.out.print("Enter the first number: ");
                double number1 = scanner.nextDouble();
                System.out.print("Enter the second number: : ");
                double number2 = scanner.nextDouble();

                System.out.println("""
                Choose the operation:
                1) Average between the entered numbers
                2) Difference between the numbers
                3) Product between the entered numbers
                4) Division of the first by the second
                """);

                int operation = scanner.nextInt();
                double result = 0;
                boolean validOption = true;

                switch (operation) {
                    case 1 -> result = (number1 + number2) / 2;
                    case 2 -> result = number1 - number2;
                    case 3 -> result = number1 * number2;
                    case 4 -> {
                        if (number2 != 0) {
                            result = number1 / number2;
                        } else {
                            System.out.println("Error: Division by zero is not allowed.");
                            validOption = false;
                        }
                    }
                    default -> {
                        System.out.println("Error: Invalid option.");
                        validOption = false;
                    }
                }

                if (validOption) {
                    System.out.printf("The result of the operation is: %.2f%n", result);
                }
            }
            case "4" -> {
                System.out.print("Enter the item code: ");
                int itemCode = scanner.nextInt();
                System.out.print("Enter the quantity: ");
                int quantity = scanner.nextInt();

                double price;

                switch (itemCode) {
                    case 100 -> price = 1.70;
                    case 101 -> price = 2.30;
                    case 102 -> price = 2.60;
                    case 103 -> price = 2.40;
                    case 104 -> price = 2.50;
                    case 105 -> price = 1.00;
                    default -> {
                        System.out.println("Invalid item code.");
                        return;
                    }
                }

                double totalPrice = price * quantity;
                System.out.printf("The total price is: R$ %.2f%n", totalPrice);
            }
        }
    }
}