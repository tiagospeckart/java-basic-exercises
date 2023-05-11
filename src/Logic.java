import java.util.Scanner;

public class Logic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please choose one of the following functions by typing the function name and the required arguments separated by spaces:\n" +
                "\n" +
                "- checkAnd num1 num2 num3 num4: checks if (num1 > num2) AND (num3 < num4)\n" +
                "- checkOr num1 num2 num3 num4: checks if (num1 == num2) OR (num3 > num4)\n" +
                "- checkNot num1 num2: checks if !(num1 < num2)\n" +
                "- checkMulti num1 num2 num3: checks if num1 * num2 >= num3\n" +
                "- checkIsEven num1: checks if num1 is even or odd\n" +
                "\n" +
                "Enter function: ");
        String function = scanner.nextLine();

        switch (function) {
            case "checkAnd":
                System.out.print("Enter four integers separated by spaces: ");
                String[] andArgs = scanner.nextLine().split(" ");
                if (andArgs.length != 4) {
                    System.out.println("Error: Invalid number of arguments for checkAnd");
                    return;
                }
                int num1 = Integer.parseInt(andArgs[0]);
                int num2 = Integer.parseInt(andArgs[1]);
                int num3 = Integer.parseInt(andArgs[2]);
                int num4 = Integer.parseInt(andArgs[3]);
                checkAnd(num1, num2, num3, num4);
                break;

            case "checkOr":
                System.out.print("Enter four integers separated by spaces: ");
                String[] orArgs = scanner.nextLine().split(" ");
                if (orArgs.length != 4) {
                    System.out.println("Error: Invalid number of arguments for checkOr");
                    return;
                }
                num1 = Integer.parseInt(orArgs[0]);
                num2 = Integer.parseInt(orArgs[1]);
                num3 = Integer.parseInt(orArgs[2]);
                num4 = Integer.parseInt(orArgs[3]);
                checkOr(num1, num2, num3, num4);
                break;

            case "checkNot":
                System.out.print("Enter two integers separated by spaces: ");
                String[] notArgs = scanner.nextLine().split(" ");
                if (notArgs.length != 2) {
                    System.out.println("Error: Invalid number of arguments for checkNot");
                    return;
                }
                num1 = Integer.parseInt(notArgs[0]);
                num2 = Integer.parseInt(notArgs[1]);
                checkNot(num1, num2);
                break;

            case "checkMulti":
                System.out.print("Enter three integers separated by spaces: ");
                String[] multiArgs = scanner.nextLine().split(" ");
                if (multiArgs.length != 3) {
                    System.out.println("Error: Invalid number of arguments for checkMulti");
                    return;
                }
                num1 = Integer.parseInt(multiArgs[0]);
                num2 = Integer.parseInt(multiArgs[1]);
                int num3Multi = Integer.parseInt(multiArgs[2]);
                checkMulti(num1, num2, num3Multi);
                break;

            case "checkIsEven":
                System.out.print("Enter an integer: ");
                String isEvenArg = scanner.nextLine();
                int num1IsEven = Integer.parseInt(isEvenArg);
                checkIsEven(num1IsEven);
                break;

            default:
                System.out.println("Error: Invalid function name");
        }
    }

    private static void checkAnd(int num1, int num2, int num3, int num4) {
        if ((num1 > num2) && (num3 < num4)) {
            System.out.println("(" + num1 + " > " + num2 + ") && (" + num3 + " < " + num4 + ") is true");
        } else {
            System.out.println("(" + num1 + " > " + num2 + ") && (" + num3 + " < " + num4 + ") is false");
        }
    }

    private static void checkOr(int num1, int num2, int num3, int num4) {
        if ((num1 == num2) || (num3 > num4)){
            System.out.println("(" + num1 + " == " + num2 + ") || (" + num3 + " > " + num4 + ") is true");
        } else {
            System.out.println("(" + num1 + " == " + num2 + ") || (" + num3 + " > " + num4 + ") is false");
        }
    }

    private static void checkNot(int num1, int num2) {
        if (!(num1 < num2)){
            System.out.println("!(" + num1 + " < " + num2 + ") is true -> NOT");
        } else {
            System.out.println("!(" + num1 + " < " + num2 + ") is false -> NOT");
        }
    }

    private static void checkMulti(int num1, int num2, int num3) {
        if ((num1 * num2) >= num3){
            System.out.println("(" + num1 + " * " + num2 + ") is equal or bigger than" + num3);
        } else {
            System.out.println("(" + num1 + " * " + num2 + ") is not equal or bigger than" + num3);
        }
    }

    private static void checkIsEven (int num1) {
        if ((num1 % 2) == 0) {
            System.out.println(num1 + "is Even");
        } else {
            System.out.println(num1 + "is Odd");
        }
    }
}

/* !(TRUE && FALSE)
!(TRUE || FALSE)
TRUE && TRUE
(TRUE && FALSE) || (FALSE && TRUE)
(TRUE || FALSE) && (FALSE && TRUE)

(5 > 3) && (2 < 4)
(7 == 5) || (3 > 1)
!(4 < 2)
(3 * 4) >= 10
(8 % 2) == 0
 */