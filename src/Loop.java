import java.util.Collections;

import java.util.ArrayList;
import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("""
                Input (by item list) desired program:
                1) Print even numbers between 0 and given integer
                2) Calculate arithmetic mean of a sequence of numbers
                3) Sum of elements in an integer array
                4) Print odd numbers between 1 and given integer
                5) Find the longest word in a sequence of words
                6) Find the largest integer and its position in an array
                7) Count numbers above and below average in a sequence
                8) Calculate the Nth Fibonacci number with a loop
                9) Count word occurrences in a sequence of words
                10) Calculate median of elements in an integer array
                """);

        String option = scanner.nextLine();

        switch (option) {
            case "1" -> {
                System.out.print("Enter a positive integer: ");
                int targetInt = scanner.nextInt();
                ArrayList<Integer> evenList = evenToTarget(targetInt);

                StringBuilder evenNumbersOutput = new StringBuilder("The even numbers are: ");
                for (int i = 0; i < evenList.size(); i++) {
                    evenNumbersOutput.append(evenList.get(i));
                    if (i < evenList.size() - 1) { // checks if iterator is not yet last arraylist index
                        evenNumbersOutput.append(", ");
                    }
                }
                System.out.println(evenNumbersOutput);
            }
            case "2" -> {
                System.out.print("Input a sequence of numbers separated by space, and hit enter: ");
                String inputLine = scanner.nextLine();

                String[] inputNumbers = inputLine.split("\\s+");

                ArrayList<Double> doublesList = new ArrayList<>();

                for (String numStr : inputNumbers) {
                    double num = Double.parseDouble(numStr);
                    doublesList.add(num);
                }

                double arithmeticMean = calculateArithmeticMean(doublesList);
                System.out.printf("The arithmetic mean is %.2f.%n", arithmeticMean);
            }
            case "3" -> {
                System.out.print("Input a sequence of integers separated by space, and hit enter: ");
                String inputLine = scanner.nextLine();

                String[] inputNumbers = inputLine.split("\\s+");

                ArrayList<Integer> integerList = new ArrayList<>();
                for (String numStr : inputNumbers) {
                    int num = Integer.parseInt(numStr);
                    integerList.add(num);
                }

                int sumOfValues = 0;
                for (int num : integerList) {
                    sumOfValues += num;
                }

                System.out.printf("The total sum is %d.%n", sumOfValues);
            }
            case "4" -> {
                System.out.print("Enter a positive integer: ");
                int targetInt = scanner.nextInt();
                ArrayList<Integer> oddList = oddToTarget(targetInt);

                StringBuilder oddNumbersOutput = new StringBuilder("The odd numbers are: ");
                for (int i = 0; i < oddList.size(); i++) {
                    oddNumbersOutput.append(oddList.get(i));
                    if (i < oddList.size() - 1) {
                        oddNumbersOutput.append(", ");
                    }
                }
                System.out.println(oddNumbersOutput);
            }
            case "5" -> {
                System.out.println("Type some words separated by space: ");
                String inputLine = scanner.nextLine();

                String[] words = inputLine.split("\\s+");

                String biggestWord = findBiggestWord(words);

                System.out.printf("The biggest word is %s.%n", biggestWord);
            }
            case "6" -> {
                System.out.println("Type some numbers separated by space to create your number array: ");
                String inputLine = scanner.nextLine();

                String[] numberStrings = inputLine.split("\\s+");
                ArrayList<Integer> numbers = new ArrayList<>();
                for (String numberString : numberStrings) {
                    int number = Integer.parseInt(numberString);
                    numbers.add(number);
                }

                int maxNumberIndex = 0;
                int maxNumber = Integer.MIN_VALUE;

                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) > maxNumber) {
                        maxNumber = numbers.get(i);
                        maxNumberIndex = i;
                    }
                }
                System.out.printf("The biggest number is %d.%n", maxNumber);
                System.out.printf("Its index in the array is %d.%n", maxNumberIndex);
            }
            case "7" -> {
                System.out.print("Input a sequence of numbers separated by space, and hit enter: ");
                String inputLine = scanner.nextLine();

                String[] inputNumbers = inputLine.split("\\s+");

                ArrayList<Double> doublesList = new ArrayList<>();

                for (String numStr : inputNumbers) {
                    double num = Double.parseDouble(numStr);
                    doublesList.add(num);
                }

                double mean = mean(doublesList);
                ArrayList<Double> belowMean = belowMean(doublesList, mean);
                ArrayList<Double> overMean = overMean(doublesList, mean);

                System.out.println("Mean: " + mean);
                System.out.println("Numbers below mean: " + belowMean);
                System.out.println("Numbers over mean: " + overMean);
            }
            case "8" -> {
                System.out.print("Enter a integer: ");
                int targetInt = scanner.nextInt();
                int fibonacciNumber = fibonacciCalculator(targetInt);
                System.out.printf("The %dth Fibonacci number is %d.%n", targetInt, fibonacciNumber);
            }
            case "9" -> {
                System.out.println("Type some words separated by space: ");
                String inputLine = scanner.nextLine();

                String[] words = inputLine.split("\\s+");

                ArrayList<String> uniqueWords = new ArrayList<>();
                ArrayList<Integer> wordCounts = new ArrayList<>();

                for (String word : words) {
                    int index = uniqueWords.indexOf(word);
                    if (index != -1) { // If not at the end the words list
                        // Increment the count if the word is already in the uniqueWords list
                        wordCounts.set(index, wordCounts.get(index) + 1);
                    } else { // Add the word to the list and add at the end 1
                        uniqueWords.add(word);
                        wordCounts.add(1);
                    }
                }

                for (int i = 0; i < uniqueWords.size(); i++) {
                    System.out.println("Word: " + uniqueWords.get(i) + ", Count: " + wordCounts.get(i));
                }
            }
            case "10" -> {
                System.out.println("Type some numbers separated by space to create your number array: ");
                String inputLine = scanner.nextLine();

                String[] numberStrings = inputLine.split("\\s+");
                ArrayList<Integer> numbers = new ArrayList<>();
                for (String numberString : numberStrings) {
                    int number = Integer.parseInt(numberString);
                    numbers.add(number);
                }

                Collections.sort(numbers); // Need to sort integer ArrayList before mean calculation

                if (numbers.size() % 2 == 0) {
                    int middleIndex1 = (numbers.size() / 2) - 1;
                    int middleIndex2 = numbers.size() / 2;
                    int median = (numbers.get(middleIndex1) + numbers.get(middleIndex2)) / 2;
                    System.out.println("Median is: " + median);
                } else {
                    int middleIndex = numbers.size() / 2;
                    System.out.println("Middle element is: " + numbers.get(middleIndex));
                }
            }
        }
        scanner.close();
    }

    private static ArrayList<Integer> evenToTarget (int targetInt) {
        ArrayList<Integer> evenList = new ArrayList<>();
        // I was trying to use Array[] initially, but they are terrible to use when I don't know the final array size.
        for (int i = 0; i <= targetInt; i++) {
            if (i % 2 == 0){
                evenList.add(i);
            }
        }
        return evenList;
    }

    private static ArrayList<Integer> oddToTarget (int targetInt) {
        ArrayList<Integer> oddList = new ArrayList<>();
        for (int i = 0; i <= targetInt; i++) {
            if (i % 2 == 1){
                oddList.add(i);
            }
        }
        return oddList;
    }

    private static double calculateArithmeticMean (ArrayList<Double> doubleList) {
        int numberOfValues = doubleList.size();
        double sumOfValues = 0;

        for (double num : doubleList) {
            sumOfValues += num;
        }
        return sumOfValues / numberOfValues;
    }

    private static String findBiggestWord(String [] words) {
        String maxWord = "";
        int maxWordCounter = 0;

        for (String word : words) {
            int wordLength = word.length();
            if (wordLength > maxWordCounter) {
                maxWord = word;
                maxWordCounter = wordLength;
            }
        }

        return maxWord;
    }

    private static double mean(ArrayList<Double> numbers) {
        double sum = 0.0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }

    private static ArrayList<Double> belowMean(ArrayList<Double> numbers, double mean) {
        ArrayList<Double> belowMean = new ArrayList<>();
        for (double number : numbers) {
            if (number < mean) {
                belowMean.add(number);
            }
        }
        return belowMean;
    }

    private static ArrayList<Double> overMean(ArrayList<Double> numbers, double mean) {
        ArrayList<Double> overMean = new ArrayList<>();
        for (double number : numbers) {
            if (number > mean) {
                overMean.add(number);
            }
        }
        return overMean;
    }

    private static int fibonacciCalculator(int number) {
        int a = 0;
        int b = 1;
        int c;
        for (int i = 0; i < number; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return a;
    }
}