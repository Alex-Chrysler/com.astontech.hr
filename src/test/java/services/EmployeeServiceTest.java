package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.services.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void employeeServiceTest(){

        Employee employee1 = new Employee();
        employee1.setFirstName("Alex");
        employee1.setLastName("Chrysler");
        employee1.setBackground("Java Devloper as well");


        assertNull(employee1.getId());
        employeeService.saveEmployee(employee1);
        assertNotNull(employee1.getId());

        //fetch
        Employee fetchedEmployee = employeeService.getEmployeeById(employee1.getId());
        assertNotNull(fetchedEmployee);
        assertEquals(employee1.getId(), fetchedEmployee.getId());

        //update
        fetchedEmployee.setFirstName("AlexTest");
        employeeService.saveEmployee(fetchedEmployee);

        Employee updatedEmployee = employeeService.getEmployeeById(fetchedEmployee.getId());
        assertEquals("AlexTest", updatedEmployee.getFirstName());


    }

}
