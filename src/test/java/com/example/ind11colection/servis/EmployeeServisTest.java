package com.example.ind11colection.servis;

import com.example.ind11colection.exceptions.EmployeeNotFoundException;
import com.example.ind11colection.exceptions.EmployeeStorageIsFullException;
import com.example.ind11colection.medal.Employee;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    EmployeeService employeeService = new EmployeeService();

    @Test
    void testAdd() {
        employeeService.addEmployee("test", "test2");
        Collection<Employee> allEmployees = employeeService.getAll();
        assertEquals(1, allEmployees.size());
        var employee = allEmployees.iterator().next();
        assertEquals("test", employee.getFirstname());
        assertEquals("test2", employee.getlastname());
        assertEquals(10_000, employee.getSalary());
        assertEquals(1, employee.getDepartment());
    }

    @Test
    void testAddWhenStorageIsFull() {
        for (int i = 0; i < 10; i++) {
            employeeService.addEmployee("test_" + i, "test_test_" + i, 0d, 0);
        }
        assertThrows(EmployeeStorageIsFullException.class, () -> employeeService.addEmployee("test", "test", 0, 0));
    }
    @Test
    void testAddWhenAlreadyExists(){
        employeeService.addEmployee("test", "test", 0, 0);
        assertThrows(EmployeeStorageIsFullException.class, () -> employeeService.addEmployee("test", "test", 0, 0));
    }
    @Test
    void testFind(){
        employeeService.addEmployee("test", "testtest", 10_000, 1);
        var actual =employeeService.findEmployee("test", "testtest");
        assertEquals("Test", actual.getFirstName());
        assertEquals("Testtest", actual.getLastName());
        assertEquals(10_000, actual.getSalary());
        assertEquals(1, actual.getDepartment());
    }
    @Test
    void testFindWhenNotExist(){
        assertThrows(EmployeeNotFoundException.class, assertThrows(EmployeeStorageIsFullException.class, () -> employeeService.findEmployee("test", "testtest"));
    }
    @Test
    void testRemove(){
        employeeService.addEmployee("test", "testtest", 10, 1);
        assertEquals(1, employeeService.getAll().size());

        assertTrue(employeeService.removeEmployee("test", "test"));
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.removeEmployee("not_exist", "not_exist"));
    }
    @Test
    void testGetAll(){
        employeeService.addEmployee("test_1", "test_test_1", 1000, 2);
        employeeService.addEmployee("test_2", "test_test_2", -1000, 1);
        employeeService.addEmployee("test_3", "test_test_3", 10, 3);
         var all = employeeService.getAll();
         assertEquals(3, all.size());
         assertTrue(all.contains(new Employee("test_1", "test_test_1", 1000, 2)));
        assertTrue(all.contains(new Employee("test_1", "test_test_1", 10, 1)));
        assertTrue(all.contains(new Employee("test_1", "test_test_1", 140, 1)));
    }
}