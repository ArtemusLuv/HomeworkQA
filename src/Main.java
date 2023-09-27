import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Task 1
        int [] array = getArrayWithRandomNumbers(10);
        System.out.print("Task 1\nArray = [ ");
        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.print("]\n");
        System.out.println("Count even elements = " + getCount(array, (int element) -> element % 2 == 0));

        // Task 2
        System.out.println("\nTask 2");
        List<String> collection = new ArrayList<>(Arrays.asList("Highload", "High", "Load", "Highload", "High", "High"));
        List<String> collection2 = new ArrayList<>();
        System.out.println("Collection = " + collection);

        // 2.1
        System.out.println("2.1) Count \"High\" in collection = " +
                collection.stream().filter(c -> c.equals("High")).count());

        // 2.2
        try {
            System.out.println("2.2) First element in collection is " + getFirstElement(collection));
            //System.out.println("2.2) First element in collection is " + getFirstElement(collection2));
        } catch (NoSuchElementException e) {
            System.out.println("2.2) First element in collection is 0");
        }

        // 2.3
        try {
            System.out.println("2.3) Last element in collection is " + getLastElement(collection));
            //System.out.println("2.3) Last element in collection is " + getLastElement(collection2));
        } catch (NoSuchElementException e) {
            System.out.println("2.3) Last element in collection is 0");
        }

        // Task 3
        System.out.println("\nTask 3");
        List<String> collection3 = new ArrayList<>(Arrays.asList("f10", "f15", "f2", "f4", "f4"));
        String [] arr = collection3.stream().sorted().toArray(s -> new String[s]);
        System.out.println("Sorted array = " + Arrays.toString(arr));

        // Task 4
        System.out.println("\nTask 4");
        Collection<Student> students = Arrays.asList(new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина",20,Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN));
        // 4.1
        System.out.println("4.1) Average mans age = " + students.stream().
                filter(s -> s.getSex() == Gender.MAN).mapToInt(s -> s.getAge()).average().getAsDouble());

        // 4.2
        System.out.print("4.2) ");
        students.stream().filter(s -> s.getSex() == Gender.MAN && s.getAge() >= 18 && s.getAge() <= 27)
                .forEach(s -> System.out.println(s));

        // Task 5
        /*
            For example use correct login:
                fila@mail.ru
                garry@gmail.com
                suslikof@yhandex.ru
                ftyler@gmail.com
            Incorrect login:
                jojimail.com
                salter@fssd
         */
        System.out.println("\nTask 5");
        HashSet<String> login = new HashSet<>();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Write login = ");
            String loginAsString = scan.nextLine();
            if (loginAsString.contains("@") && (loginAsString.contains(".com") || loginAsString.contains(".ru"))) {
                login.add(loginAsString);
            } else if (loginAsString.isEmpty()) {
                break;
            } else {
                System.out.println("Mail must be like a example@mail.ru or example@gmail.com");
            }
        }
        System.out.println("Data login = " + login);
        login.stream().filter(s -> s.startsWith("f")).forEach(s ->
                System.out.println("Login in data witch starts with \"f\" is " + s));

    }

    // Task 1
    public static int[] getArrayWithRandomNumbers(int count) {
        int[] array;
        if (count <= 0) {
            System.out.println("Count elements of array must be > 0");
            return null;
        }
        array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(100);
        }
        return array;
    }

    public static int getCount(int[] array, EvenNumber even) {
        int count = 0;
        for (int element : array) {
            if (even.check(element)) count++;
        }
        return count;
    }

    // Task 2
    // 2.2
    public static <T> T getFirstElement(List<T> collection) {
        return collection.stream().findFirst().get();
    }

    // 2.3
    public static <T> T getLastElement(List<T> collection) {
        return collection.stream().filter(c -> c.equals(collection.get(collection.size() - 1))).findAny().get();
    }


    // Task 4
    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender sex;

        public Student(String name, Integer age, Gender sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Gender getSex() {
            return sex;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex=" + sex +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    sex == student.sex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, sex);
        }
    }

    private enum Gender {
        MAN,
        WOMAN
    }

}

