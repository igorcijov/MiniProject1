

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestDatabase{
    private Database db;

    @BeforeEach
    public void init(){
        db = new Database(Arrays.asList(new Employee("Joy", "assistant", 750, 23)));
        db.setTestMode();
    }

    @Test
    public void testCreateAndRead(){
        List<Employee> employees = db.read();
        Assertions.assertEquals(employees.size(),1);

        Employee employee = new Employee("John", "director", 1250,45);
        db.create(employee);

        employees = db.read();
        Assertions.assertEquals(employees.size(),2);

        Employee found = db.find("John");
        Assertions.assertNotNull(found);
    }

    @Test
    public void testUpdate(){
        boolean result = db.update("Joy", new Employee("Mark", "engineer", 1050, 42));
        Assertions.assertTrue(result);

        Employee notFound = db.find("Joy");
        Assertions.assertNull(notFound);

        Employee found = db.find("Mark");
        Assertions.assertNotNull(found);
    }

    @Test
    public void testDelete(){
        boolean result = db.delete("Joy");
        Assertions.assertTrue(result);

        Employee notFound = db.find("Joy");
        Assertions.assertNull(notFound);

        List<Employee> employees = db.read();
        Assertions.assertEquals(employees.size(),0);
    }
}