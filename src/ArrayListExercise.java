import java.util.*;

public class ArrayListExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("""
                Input (by item list) desired program:
                1) Add elements to a string list
                2) Print elements of an integer list
                3) Calculate average of a double list
                4) Sort a list of Pessoa objects by age
                5) Remove elements containing 'a' from a string list
                6) Sort a list of Produto objects by price
                7) Calculate intersection of two integer lists
                8) Divide a list of Pessoa objects into two age-based lists
                9) Calculate average grade of a list of Aluno objects
                10) Sort a list of strings in reverse alphabetical order
                """);

        String option = scanner.nextLine();

        switch (option) {
            case "1" -> {
                List<String> fruits = new ArrayList<>();
                fruits.add("Apple");
                fruits.add("Banana");
                fruits.add("Orange");

                System.out.println(fruits);
            }
            case "2" -> {
                List<Integer> numbers = List.of(1,2,3,4,5);
                System.out.println(numbers);
            }
            case "3" -> {
                System.out.println("Input the size of the array: ");
                int arrayLength = scanner.nextInt();
                double upperBound = 100.00;
                double lowerBound = -100.00;

                List<Double> randomDoubleArr = randomSignedDoublesList(arrayLength, upperBound, lowerBound);

                double sumTotal = 0;
                for (double num : randomDoubleArr) {
                    sumTotal += num;
                }

                double mean = sumTotal / randomDoubleArr.size();

                System.out.println(randomDoubleArr);
                System.out.println(mean);
            }
            case "4" -> {
                List<Person> personList = new ArrayList<>();

                Person person1 = new Person("Martha", 23);
                personList.add(person1);
                Person person2 = new Person("Shirley", 45);
                personList.add(person2);
                Person person3 = new Person("Timothy", 12);
                personList.add(person3);

                personList.sort(Comparator.comparingInt(Person::getAge));

                for (Person person : personList) {
                    System.out.println(person.getName() + ", " + person.getAge());
                }
            }
            case "5" -> {
                int wordLength = 10;
                int listLength = 10;
                List<String> wordsInitial = new ArrayList<>();

                for (int i = 0; i < listLength; i++) {
                    wordsInitial.add(randomString(wordLength));
                }

                List<String> wordsFinal = new ArrayList<>(wordsInitial);

                Iterator<String> iterator = wordsFinal.iterator();
                while (iterator.hasNext()) {
                    String word = iterator.next();
                    boolean hasA = false;

                    for (char letter : word.toCharArray()) {
                        if (letter == 'a' || letter == 'A') {
                            hasA = true;
                            break;
                        }
                    }
                    if (hasA) {
                        iterator.remove();
                    }
                }

                System.out.println(wordsInitial);
                System.out.println(wordsFinal);
            }
            case "6" -> {
                List<Product> productListInitial = new ArrayList<>();

                Product product1 = new Product("Toy car", 50.50);
                productListInitial.add(product1);
                Product product2 = new Product("Drone", 450.30);
                productListInitial.add(product2);
                Product product3 = new Product("SSD", 250.00);
                productListInitial.add(product3);
                Product product4 = new Product("Battery", 10.50);
                productListInitial.add(product4);

                List<Product> productListFinal = new ArrayList<>(productListInitial);

                productListFinal.sort(Comparator.comparingDouble(Product::getPrice));

                for (Product product : productListInitial) {
                    System.out.printf("Product: %s - Price: $%.2f.\n", product.getName(), product.getPrice());
                }
                System.out.println(" --- Arranged List ---");

                for (Product product : productListFinal) {
                    System.out.printf("Product: %s - Price: $%.2f.\n", product.getName(), product.getPrice());
                }
            }
            case "7" -> {
                int arrayLength = 10;
                int upperBound = 10;

                List<Integer> randomNumberList1 = new ArrayList<>(randomIntList(arrayLength, upperBound));
                List<Integer> randomNumberList2 = new ArrayList<>(randomIntList(arrayLength, upperBound));
                Set<Integer> numberListIntersection = new HashSet<>();

                for (Integer num1:randomNumberList1) {
                    if (randomNumberList2.contains(num1)){
                        numberListIntersection.add(num1);
                    }
                }

                System.out.println(randomNumberList1);
                System.out.println(randomNumberList2);
                System.out.println(numberListIntersection);
            }
            case "8" -> {
                List<Person> personListInitial = new ArrayList<>(Arrays.asList(
                        new Person("Gustavo", 56),
                        new Person("Richarlison", 12),
                        new Person("Samantha", 15),
                        new Person("Felipe", 19)
                ));

                List<Person> personListMinors = new ArrayList<>();
                List<Person> personListAdults = new ArrayList<>();

                for (Person person : personListInitial) {
                    if ((person.getAge()) >= 18){
                        personListAdults.add(person);
                    } else personListMinors.add(person);
                }

                System.out.println(" --- Unsorted ---");
                personListInitial.forEach(person -> System.out.println(person.getName() + ", " + person.getAge()));

                System.out.println(" --- Adults ---");
                personListAdults.forEach(person -> System.out.println(person.getName() + ", " + person.getAge()));

                System.out.println(" --- Minors ---");
                personListMinors.forEach(person -> System.out.println(person.getName() + ", " + person.getAge()));
            }
            case "9" -> {
                List<Student> studentList = new ArrayList<>(Arrays.asList(
                        new Student("Hugo", 7.2),
                        new Student("Davidson", 2.3),
                        new Student("Carolina", 5.4),
                        new Student("Genevieve", 2.3)
                ));

                int listLength = studentList.size();

                double totalGrade = 0;
                for (Student student : studentList) {
                    double grade = student.getGrade();
                    totalGrade += grade;
                }

                double gradeMean = totalGrade / listLength;

                System.out.println(" --- Students ---");
                studentList.forEach(student -> System.out.println(student.getName() + ", " + student.getGrade()));

                System.out.println(" --- Mean ---");
                System.out.println(gradeMean);
            }
            case "10" -> {
                int wordLength = 4;
                int listLength = 10;
                List<String> wordsInitial = new ArrayList<>();

                for (int i = 0; i < listLength; i++) {
                    wordsInitial.add(randomString(wordLength));
                }

                List<String> reverseSortedWords = new ArrayList<>(wordsInitial);
                reverseSortedWords.sort(Collections.reverseOrder());

                System.out.println(wordsInitial);
                System.out.println(reverseSortedWords);
            }
        }

        scanner.close();
    }

    private static List<Double> randomSignedDoublesList(int numberOfDoubles, double lowerBound, double upperBound) {
        List<Double> doublesList = new ArrayList<>(numberOfDoubles);
        Random random = new Random();
        for (int i = 0; i < numberOfDoubles; i++) {
            double randomDouble = lowerBound + (random.nextDouble() * (upperBound - lowerBound));
            doublesList.add(randomDouble);
        }
        return doublesList;
    }

    private static List<Integer> randomIntList(int listLength, int upperBound){
        List<Integer> integerList = new ArrayList<>(listLength);
        Random random = new Random();
        for (int i = 0; i < listLength; i++){
            int randomInt = random.nextInt(upperBound);
            integerList.add(randomInt);
        }
        return integerList;
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

    public static class Person {
        private String name;
        private int age;

        public Person (String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName(){
            return name;
        }

        public int getAge(){
            return age;
        }
    }

    public static class Student {
        private String name;
        private double grade;

        public Student (String name, double grade) {
            this.name = name;
            this.grade = grade;
        }

        public String getName(){
            return name;
        }

        public double getGrade(){
            return grade;
        }
    }

    public static class Product {
        private String name;
        private double price;

        public Product (String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName(){
            return name;
        }

        public double getPrice(){
            return price;
        }
    }
}