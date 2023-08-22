package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployees {

    public static void main(String[] args) {
        Employee[] employees = {
                           new Employee("Jason", "Red", 5000, "IT"),
                          new Employee("Ashley", "Green", 7600, "IT"),
                           new Employee("Matthew", "Indigo", 3587.5, "Sales"),
                           new Employee("James", "Indigo", 4700.77, "Marketing"),
                            new Employee("Luke", "Indigo", 6200, "IT"),
                            new Employee("Jason", "Blue", 3200, "Sales"),
                         new Employee("Wendy", "Brown", 4236.4, "Marketing")};

        List<Employee> list = Arrays.asList(employees);
        System.out.println("Complete Employee list:");
        list.stream().forEach(System.out::println);

        Predicate<Employee> fourToSixThousand = e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);
        System.out.printf("%n Employees eaning 4000 - 6000 per month sorted by salary: %n");
        list.stream()
                .filter(fourToSixThousand)
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        System.out.printf("%nFirst Employee who earns 4000 - 6000: %n%s%n", list.stream()
                .filter(fourToSixThousand)
                .findFirst()
                .get());

        Function<Employee,String> byFirstName = Employee::getFirstName;
        Function<Employee,String> byLastName = Employee::getLastName;

        Comparator<Employee> lastThenFirst = Comparator.comparing(byLastName).thenComparing(byFirstName);

        System.out.printf("%n Employees in ascending order by lastName then first: %n");
        list.stream()
                .sorted(lastThenFirst)
                .forEach(System.out::println);

        System.out.printf("%n Employees in descending order by last name, then first name: %n");
        list.stream()
                .sorted(lastThenFirst.reversed())
                .forEach(System.out::println);

        System.out.printf("%n Unique employee last names: %n");
        list.stream()
                .map(Employee::getLastName)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.printf("%n Employee names in order by last name the first name: %n");
        list.stream()
                .sorted(lastThenFirst)
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.printf("%n Employees by department: %n");
        Map<String,List<Employee>> groupedByDepartment =
                list.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));
        groupedByDepartment.forEach(
                (department, employeeInDepartment) ->{
                    System.out.printf("%n%s%n",department);
                    employeeInDepartment.forEach(
                            employee -> System.out.printf("   %s%n",employee)
                    );
                }
        );

        System.out.printf("%n Employees by department count: %n");
        Map<String,Long> groupedByDepartmentCount =
                list.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));

        groupedByDepartmentCount.forEach(
                (department,count) ->{
                    System.out.printf("%s has %d employees%n", department,count);
                }
        );
    }
}
