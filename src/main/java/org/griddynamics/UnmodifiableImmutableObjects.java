package org.griddynamics;
import java.util.*;
import java.util.stream.Collectors;
public class UnmodifiableImmutableObjects {
        public static class MutablePerson {
            private String name;
            private int age;
            public MutablePerson(String name, int age) {
                this.name = name;
                this.age = age;
            }
            public String getName() { return name; }
            public int getAge() { return age; }
            public void setName(String name) { this.name = name; }
            public void setAge(int age) { this.age = age; }
            @Override
            public String toString() {
                return "MutablePerson{" + name + ", " + age + "}";
            }
        }
        public static final class Person {
            private final String name;
            private final int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public String getName() { return name; }
            public int getAge() { return age; }

            @Override
            public String toString() {
                return "Person{" + name + ", " + age + "}";
            }
        }
        public static List<Person> deepImmutableCopy(List<MutablePerson> input) {
            return input.stream()
                    .map(p -> new Person(p.getName(), p.getAge()))
                    .collect(Collectors.collectingAndThen(Collectors.toList(), List::copyOf));
        }

        public static class PersonService {
            private final List<Person> people;

            public PersonService(List<MutablePerson> inputPeople) {
                this.people = deepImmutableCopy(inputPeople);
            }

            public List<Person> getAllPeople() {
                return people; // fully safe to expose
            }
        }
//List<String>qwe=Collections.unmodifiableList(poi);

        public static void main(String[] args) {
            List<MutablePerson> input = new ArrayList<>();
            input.add(new MutablePerson("Alice", 30));
            input.add(new MutablePerson("Bob", 25));
            PersonService service = new PersonService(input);
            List<Person> ans = service.getAllPeople();
            System.out.println("Immutable People List:");
            ans.forEach(System.out::println);
            // ans.add(new Person("Eve", 40));
            // ans.get(0).name = "Charlie"; // Not allowed — name is final
        }
    }

