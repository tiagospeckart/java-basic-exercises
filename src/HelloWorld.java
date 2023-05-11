import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter input (username, integer, or language code: pt, eng, jp, es, fr): ");
        String input = scanner.nextLine();

        if (input.matches("\\d+")) {
            int numHellos = Integer.parseInt(input);
            helloNTimes(numHellos);
        } else if (input.matches("eng|pt|jp|es|fr")) {
            helloWorldByLanguage(input);
        } else {
            helloUser(input);
        }

        scanner.close();
    }

    private static void helloUser(String name) {
        System.out.println("Hello, " + name + "!");
    }

    private static void helloNTimes(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Hello");
        }
    }

    private static void helloWorldByLanguage(String langCode) {
        switch (langCode) {
            case "eng" -> System.out.println("Hello, world!");
            case "pt" -> System.out.println("Olá, mundo!");
            case "jp" -> System.out.println("こんばんは、世界");
            case "es" -> System.out.println("Hola, mundo!");
            case "fr" -> System.out.println("Bonjour, monde!");
            default -> System.out.println("Invalid language code.");
        }
    }
}