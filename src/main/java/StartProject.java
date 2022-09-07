import java.util.List;
import java.util.Scanner;

/**
 * Java Pro. MiniProject #1
 * @author Igor Cijov
 * @version 08 sept. 2022
 */

public class StartProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database(InitDb.getInitData());


        boolean exit = false;
        String name, position;
        int salary, age, index;


        while (!exit) {
            System.out.println("PLEASE SELECT");
            System.out.println("c = create new employe" + "\n" + "r = read database" + "\n" + "u = update employe" + "\n" +
                    "d = delete employe" + "\n" + "f = find employe" + "\n" + "p = show position" + "\n" + "s = save data" +
                    "\n" + "x = exit");
            System.out.print("db> ");

            String command = scanner.next();
            switch (command) {
                case "x":
                    exit = true;
                    break;
                case "c":
                    System.out.println("create>");
                    database.create(Employee.scanEmployee());
                    break;
                case "r":
                    List<Employee> employees = database.read();
                    employees.forEach(System.out::println);
                    break;
                case "u":
                    System.out.println("update> Enter the name: ");
                    String oldname = scanner.next();
                    database.update(oldname, Employee.scanEmployee());

                    break;
                case "d":
                    System.out.println("delete> Enter the name: ");
                    name = scanner.next();
                    database.delete(name);
                    break;
                case "f":
                    System.out.println("find> Enter the name: ");
                    name = scanner.next();
                    Employee employee = database.find(name);
                    System.out.println(employee != null ? employee + "\n" : "Not found");
                    break;
                case "p":
                    System.out.println("position> Enter position: ");
                    database.showPosition(scanner.next());
                    break;
                case "s":
                    InitDb.saveDb(database.getEmployees());
            }
        }
    }
}