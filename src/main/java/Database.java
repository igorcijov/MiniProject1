import java.util.*;
import java.util.stream.Collectors;

public class Database {
    List<Employee> employees = new ArrayList<>();
    Map<String, Employee> employeeMap = new HashMap<>();
    Set<String> position = new HashSet<>();
    private boolean testMode = false;

    public Database(Collection<Employee> employees){
        this.employees.addAll(employees);
        this.employees.forEach(e-> employeeMap.put(e.getName(),e));
    }

    public List<Employee> read() {
        return employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void create(Employee employee) {
        employees.add(employee);
        employeeMap.put(employee.getName(), employee);
        position.add(employee.getPosition());

    }

    public boolean update(String name, Employee employee) {
        if(delete(name)){
            create(employee);
            return true;
        }
        return false;
    }

    public boolean delete(String name) {
        Employee employee = employeeMap.get(name);
        if (employee != null) {
            employeeMap.remove(employee.getName());
            employees.remove(employee);
            return true;
        }
        return false;
    }

    public Employee find(String name) {
       return employeeMap.get(name);
    }

    public void showPosition(String position) {
        List<Employee> printPosition = employees.stream()
                .filter(p -> p.getPosition().equals(position))
                .collect(Collectors.toList());
        printPosition.forEach(System.out::println);
    }

    public void setTestMode() {
        testMode=true;
    }
}