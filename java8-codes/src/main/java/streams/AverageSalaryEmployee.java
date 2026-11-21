package streams;

import dto.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageSalaryEmployee {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", "IT", 80000),
                new Employee(2, "Alice", "IT", 90000),
                new Employee(3, "Bob", "IT", 70000),
                new Employee(4, "David", "HR", 50000),
                new Employee(5, "Emma", "HR", 60000),
                new Employee(6, "Mike", "Finance", 100000),
                new Employee(7, "Sarah", "Finance", 80000)
        );

        try {
            // Average salary by department
            Map<String, Double> avgSalaryDept = employees.stream()
                    .collect(Collectors.groupingBy(
                            Employee::getDepartment,
                            Collectors.averagingDouble(Employee::getSalary)
                    ));

            //Employees earning more than department average
            List<Employee> result = employees.stream()
                    .filter(emp -> emp.getSalary() > avgSalaryDept.get(emp.getDepartment()))
                    .collect(Collectors.toList());

            result.forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
