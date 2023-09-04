// Task 1
public class Employee {
    private String name, position, mail, numbers;
    private int salary, age;

    public Employee(String name, String position, String mail, String numbers, int salary, int age) {
        this.name = name;
        this.position = position;
        this.mail = mail;
        this.numbers = numbers;
        this.salary = salary;
        this.age = age;
    }

    public void getInformationAboutEmployee() {
        System.out.println("Name: " + name + "\n" +
                            "Position: " + position + "\n" +
                            "Mail: " + mail + "\n" +
                            "Numbers: " + numbers + "\n" +
                            "Salary: " + salary + "\n" +
                            "Age: " + age);
    }

    public int getAge() {
        return age;
    }
}
