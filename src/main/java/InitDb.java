import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class InitDb {

    private final static String FILE_NAME = "DataBaseFile.txt";

    public static Collection<Employee> getInitData() {
        File readFile = new File("DataBaseFile.txt");
        if (!readFile.exists()) {
            try {
                readFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Collection<Employee> result = new ArrayList<>();
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(FILE_NAME), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : lines) {
            String[] field = line.split(",");
            result.add(new Employee(field[0], field[1], Integer.parseInt(field[2]), Integer.parseInt(field[3])));
        }
        return result;
    }

    public static void saveDb(List<Employee> modifiedList) {
        try {
            PrintWriter pw = new PrintWriter(FILE_NAME);
            for (Employee employe : modifiedList) {
                pw.println(employe.getName() + "," + employe.getPosition() + ","
                        + employe.getSalary() + "," + employe.getAge());
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}