package com.example.ind11colection.servis;

import com.example.ind11colection.exceptions.EmployeeStorageIsFullException;
import com.example.ind11colection.medal.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
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
            new Employee("test", "test_test", 10, 1),
            new Employee("test1", "test_test1", 20, 2),
            new Employee("test2", "test_test2", 30, 1),
            new Employee("test3", "test_test3", 40, 3),
            new Employee("test33", "test_test33", 5, 3),
            new Employee("test4", "test_test4", 50, 4),
            new Employee("test5", "test_test5", 60, 1)



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
    testWhenEmployeesIsEmpty(){
    when(employeeService.getAll().thenReturn(Collections.emptyList()));
    Assertions.assertThatThrownby(() -> departmentService.minSalary(1)).isIntanceof(EmployeeStorageIsFullException.class);
        Assertions.assertThatThrownby(() -> departmentService.maxSalary(1)).isIntanceof(EmployeeStorageIsFullException.class);
        Assertions.assertThat(departmentService.sum(1)).isEqualTo(0d);
    }
    @Test
    void testAllByDept(){
        var employees = departmentService.findAllByDept(4);
        Assertions.assertThat(employees.size()).isEqualTo(1);
        Assertions.assertThat(employees.get(0)).isEqualTo(new Employee("test4", "test_test4", 50, 4));
    }
    @Test
    testGroupByDept(){
    Map<Integer, List<Employee>> actual = departmentService.groupByDept();
        Assertions.assertThat(actual.keySet()).containsExactly(1, 2, 3, 4);
        Assertions.assertThat(actual.get(1)).containsExactly(
                new Employee("test", "test_test", 10, 1),
                new Employee("test2", "test_test2", 30, 1),
                new Employee("test5", "test_test5", 60, 1));

        Assertions.assertThat(actual.get(2)).containsExactly(
                new Employee("test1", "test_test1", 20, 2));

        Assertions.assertThat(actual.get(3)).containsExactly(
                new Employee("test3", "test_test3", 40, 3),
                new Employee("test33", "test_test33", 5, 3));

        Assertions.assertThat(actual.get(4)).containsExactly(
                new Employee("test4", "test_test4", 50, 4));
    }

}

