package org.griddynamics;
import java.util.*;
import java.util.stream.Collectors;
public class MaxSalaryGroupByDeptAndMonth {
        static class Employee {
            int id;
            int salary;
            String name;
            String month;
            String department;

            public Employee(int id, int salary, String name, String month, String department) {
                this.id = id;
                this.salary = salary;
                this.name = name;
                this.month = month;
                this.department = department;
            }

            public int getId() { return id; }
            public int getSalary() { return salary; }
            public String getName() { return name; }
            public String getMonth() { return month; }
            public String getDepartment() { return department; }

            @Override
            public String toString() {
                return id + " " + salary + " " + name + " " + month + " " + department;
            }
        }

        public static void main(String[] args) {
            List<Employee> employees = Arrays.asList(
                    new Employee(1, 100, "Anand", "Jan", "CS"),
                    new Employee(1, 200, "Anand", "Feb", "CS"),
                    new Employee(2, 300, "Bbbb", "Jan", "FB"),
                    new Employee(3, 300, "Ccc", "Jan", "ED")
            );

            Map<String, Map<String, Optional<Employee>>> result = employees.stream()
                    .collect(Collectors.groupingBy(
                            Employee::getDepartment,
                            Collectors.groupingBy(
                                    Employee::getMonth,
                                    Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))
                            )
                    ));

            result.forEach((dept, month) -> {
                System.out.println("Department: " + dept);
                month.forEach((Month, emp) -> {
                    System.out.println("  Month: " + Month + " -> " + emp);
                });
            });
        }
    }


//        SELECT id, name, salary, month, department FROM (
//        SELECT *, DENSE_RANK() OVER (PARTITION BY department, month ORDER BY salary DESC) AS rank FROM employees)
//        AS ranked_employees WHERE rank = 1;


