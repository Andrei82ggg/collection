package com.example.ind11colection.servis;

import com.example.ind11colection.medal.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @Mock
    EmployeeService employeeService;
    @InjectMocks
    DepartmentService departmentService;

@BeforeEach
    void setUp() {
    var employees = List.of(
            new Employee("test1", "test_test1", 10, 1),
            new Employee("test2", "test_test2", 20, 2),
            new Employee("test3", "test_test3", 30, 3),
            new Employee("test4", "test_test4", 50, 4)

    );
    when(employeeService.getAll()).thenReturn(employees);
    departmentService.sum(1);
}
    @Test
    testSum(){
    Assertions.assertThat(departmentService.sum(1)).isEqualTo(40d);

    }
    @Test
    void testMaxSalary(){
        Assertions.assertThat(departmentService.maxSalary(1)).isEqualTo(30d);
    }
    @Test
    void testMinSalary(){
        Assertions.assertThat(departmentService.minSalary(1)).isEqualTo(30d);
    }
    @Test
    void testAllByDept(){
        var employees = departmentService.findAllByDept(4);
        Assertions.asserThat(employees.size()).isEqualTo(1);
        Assertions.asserThat(employees.get()).isEqualTo(new Employee("test4", "test_test4", 50, 4));
    }

}