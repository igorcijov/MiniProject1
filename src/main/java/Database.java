import java.util.*;
import java.util.stream.Collectors;

public class Database {
    List<Employee> employees = new ArrayList<>();
    Map<String, Employee> employeeMap = new HashMap<>();
    Map<String, Employee> sortedMap = new TreeMap<>();
    Set<String> position = new HashSet<>();

    public void init() {
        employees.addAll(InitDb.getInitData());

        for (Employee employee : employees) {
            employeeMap.put(employee.getName(), employee);
            sortedMap.put(employee.getName(), employee);
            position.add(employee.getPosition());
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void create(Employee employee) {
        employees.add(employee);
        employeeMap.put(employee.getName(), employee);
        position.add(employee.getPosition());

    }

    public String read() {
        StringBuffer sb = new StringBuffer();
        for (Employee employee : employeeMap.values()) {
            sb.append("" + employee + "\n");
        }

        return sb.toString();
    }

    public void update(String name, Employee employee) {
        delete(name);
        create(employee);
    }

    public boolean delete(String name) {
        Employee employee = employeeMap.get(name);
        if (employee != null) {
            employeeMap.remove(employee.getName());
            employees.remove(employee);
        }
        return false;
    }

    public String find(String name) {
        Employee employee = employeeMap.get(name);
        if (employee != null) {
            return "" + employee + "\n";
        }
        return "Not found";
    }

    public void showPosition(String position) {
        List<Employee> printPosition = employees.stream()
                .filter(p -> p.getPosition().equals(position))
                .collect(Collectors.toList());
        printPosition.forEach(System.out::println);
    }
}