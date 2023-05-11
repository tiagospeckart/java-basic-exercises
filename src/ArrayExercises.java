import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayExercises {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("""
                Input (by item list) desired program:
                1) Third Element of Integer Array
                2) First Letter of Second String
                3) Even Numbers in Random Array
                4) Arithmetic Mean of Integer Array
                5) Sum of Real Numbers Array
                6) Largest Number in User Input Array
                7) Count Vowels in User Input Text
                8) Sort Array Elements in Ascending Order
                9) Count Elements Greater Than M
                10) Find Second Largest Number in Real Numbers Array
                """);

        String option = scanner.nextLine();

        switch (option) {
            case "1" -> {
                int arrayLength = 5;
                int upperBound = 100;
                int[] intArray = randomIntArray(arrayLength, upperBound);

                System.out.println(Arrays.toString(intArray));
                System.out.println("Third element: " + intArray[2]);
            }
            case "2" -> {
                int arrayLength = 10;
                String[] randomStrArr = new String[3];
                randomStrArr[0] = randomString(arrayLength);
                randomStrArr[1] = randomString(arrayLength);
                randomStrArr[2] = randomString(arrayLength);

                System.out.println(Arrays.toString(randomStrArr));
                System.out.println(randomStrArr[1].charAt(0));
            }
            case "3" -> {
                int arrayLength = 10;
                int upperBound = 100;
                int[] intArray = randomIntArray(arrayLength, upperBound);

                System.out.println(Arrays.toString(intArray));
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayLength; i++) {
                    if (intArray[i] % 2 == 0) {
                        sb.append(intArray[i]).append(", ");
                    }
                }
                if (sb.length() > 0) {
                    sb.setLength(sb.length() - 2);
                }
                System.out.println(sb);
            }
            case "4" -> {
                int arrayLength = 6;
                int upperBound = 100;
                int[] intArray = randomIntArray(arrayLength, upperBound);

                int totalSum = 0;
                for (int num : intArray) totalSum = totalSum + num;

                int arithmeticMean = totalSum / arrayLength;

                System.out.println(Arrays.toString(intArray));
                System.out.println(arithmeticMean);
            }
            case "5" -> {
                int arrayLength = 4;
                double upperBound = 100.00;
                double lowerBound = -100.00;

                double[] randomDoubleArr = randomSignedDoubles(arrayLength, upperBound, lowerBound);

                double totalSum = 0;
                for (double num : randomDoubleArr) {
                    totalSum += num;
                }

                System.out.println(Arrays.toString(randomDoubleArr));
                System.out.println(totalSum);
            }
            case "6" -> {
                int arrLength = 5;
                int[] intArr = new int[arrLength];
                System.out.println("Type five integers: ");
                for (int i = 0; i < arrLength; i++) {
                    intArr[i] = scanner.nextInt();
                }

                int intLargest = intArr[0];
                for (int i = 1; i < arrLength; i++) {
                    if (intArr[i] > intLargest) {
                        intLargest = intArr[i];
                    }
                }
                System.out.println(Arrays.toString(intArr));
                System.out.println(intLargest);
            }
            case "7" -> {
                System.out.println("Type a word: ");
                String word = scanner.nextLine();
                char[] charArray = word.toLowerCase().toCharArray();

                char[] vowels = {'a', 'i', 'u', 'e', 'o'};

                int vowelCounter = 0;
                for (char letter:charArray) {
                    for (char vowel:vowels) {
                        if (letter == vowel){
                            vowelCounter++;
                        }
                    }
                }
                System.out.println(Arrays.toString(charArray));
                System.out.println(vowelCounter);
            }
            case "8" -> {
                System.out.println("Input the size of the array: ");
                int arrayLength = scanner.nextInt();
                int upperBound = 100;
                int[] intArray = randomIntArray(arrayLength, upperBound);

                Arrays.sort(intArray);

                System.out.println(Arrays.toString(intArray));
            }
            case "9" -> {
                System.out.println("Input the size of the array: ");
                int arrayLength = scanner.nextInt();
                System.out.println("Input the number to compare the array values to: ");
                int compareInt = scanner.nextInt();
                scanner.nextLine();

                int upperBound = 100;
                int[] intArray = randomIntArray(arrayLength, upperBound);
                ArrayList<Integer> greaterThanCompareInt = new ArrayList<>();

                for (int i = 0; i < arrayLength; i++) {
                    if (intArray[i] > compareInt){
                        greaterThanCompareInt.add(intArray[i]);
                    }
                }
                System.out.println(Arrays.toString(intArray));
                System.out.println(compareInt);
                System.out.println(greaterThanCompareInt);
            }
            case "10" -> {
                System.out.println("Input the size of the array: ");
                int arrayLength = scanner.nextInt();
                double upperBound = 100.00;
                double lowerBound = -100.00;

                double[] randomDoubleArr = randomSignedDoubles(arrayLength, upperBound, lowerBound);
                Arrays.sort(randomDoubleArr);

                System.out.println(Arrays.toString(randomDoubleArr));
                System.out.println(randomDoubleArr[arrayLength - 2]);
            }
        }
        scanner.close();
    }

    private static int[] randomIntArray(int arrayLength, int upperBound){
        int[] intArray = new int[arrayLength];
        var random = new Random();
        for (int i = 0; i < arrayLength; i++){
            intArray[i] = random.nextInt(upperBound);
        }

        return intArray;
    }

    private static String randomString(int stringLength) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(stringLength);
        Random random = new Random();

        for (int i = 0; i < stringLength; i++) {
            int index = random.nextInt(alphabet.length());
            sb.append(alphabet.charAt(index));
        }

        return sb.toString();
    }

    private static double[] randomSignedDoubles(int numberOfDoubles, double lowerBound, double upperBound) {
        double[] doublesArray = new double[numberOfDoubles];
        Random random = new Random();

        for (int i = 0; i < numberOfDoubles; i++) {
            double randomDouble = lowerBound + (random.nextDouble() * (upperBound - lowerBound));
            doublesArray[i] = randomDouble;
        }
        return doublesArray;
    }
}
