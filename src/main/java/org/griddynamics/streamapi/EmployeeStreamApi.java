package org.griddynamics.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class EmployeeStreamApi {
    public static class Employee {
        private String name;
        private int salary;
        private String department;

        // constructor, getters
        public Employee(String name, int salary, String department) {
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 35000, "HR"),
                new Employee("Bob", 25000, "HR"),
                new Employee("Charlie", 40000, "HR"),
                new Employee("David", 42000, "Finance"),
                new Employee("Eve", 31000, "HR"),
                new Employee("Frank", 36000, "HR"),
                new Employee("Grace", 38000, "HR"),
                new Employee("Heidi", 39000, "HR"),
                new Employee("Ivan", 32000, "HR"),
                new Employee("Jack", 34000, "HR"),
                new Employee("Kathy", 33000, "HR"),
                new Employee("Leo", 50000, "Engineering")
        );
        employees.stream()
                .filter(e -> e.getDepartment() == "HR" && e.getSalary() > 30000)
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .limit(10)
                .map(e -> e.getName())
                .forEach(System.out::println);

        employees.stream()
                .filter(e->e.getDepartment().equalsIgnoreCase("HR")&&e.getSalary()>30000)
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .limit(10)
                .map(e->e.getName())
                .forEach(System.out::println);

        List<String> strings = Arrays
                .asList("apple", "banana", "cherry", "date", "grapefruit");
        Optional<String> ans = strings.stream()
                .max(Comparator.comparingInt(String::length));
        System.out.println(ans);
        class Person {
            String name;
            int age;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }
        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );

        double avgAge = persons.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
        System.out.println(avgAge);
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
        List<Integer> qwe = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
        List<Integer> ans2 = numbersWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());


    }
}
