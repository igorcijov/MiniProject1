import java.util.Scanner;

public class Employee implements Comparable<Employee> {
    private String name;
    private String position;
    private int salary;
    private int age;

    public Employee(String name, String position, int salary, int age) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public Integer getAge() {
        return age;
    }

    public static Employee scanEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Name: ");
        String name = scanner.next();
        System.out.println("Enter position: ");
        String position = scanner.next();
        System.out.println("Enter salary: ");
        int salary = scanner.nextInt();
        System.out.println("Enter age: ");
        int age = scanner.nextInt();
        return new Employee(name, position, salary, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.getName().compareTo(o.getName());
    }
}