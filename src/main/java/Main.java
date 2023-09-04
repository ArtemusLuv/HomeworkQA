public class Main {
    public static void main(String[] args) {
        // Task 2
        Employee [] employeesArray = new Employee[5];
        employeesArray[0] = new Employee("Nikolay Ivanov", "QA", "example@gmail.com", "+79001231234", 30000,21);
        employeesArray[1] = new Employee("Ivanov Ivan", "Engineer","ivivan@mailbox.com", "892312312", 30000, 30);
        employeesArray[2] = new Employee("Eva Alexandros", "Frontend", "eva1337@mail.ru","+79991234466", 45000, 25);
        employeesArray[3] = new Employee("Walter White", "Chemist", "willywonka1@gmail.com", "+3900242341",900000,49);
        employeesArray[4] = new Employee("Kit Harrington", "Team lead", "jonsnow2025@yaho.com", "+40990234", 60000, 40);

        for (Employee employee : employeesArray) {
            if (employee.getAge() > 40) {
                employee.getInformationAboutEmployee();
            }
        }

        // Task 3
        Park firstPark = new Park("Pushkina", "Wild train", 10, 2500);
        firstPark.getInfoAboutPark();

    }
}