package streams;

public class Employee {

    private String firstName;
    private String lastName;
    private double salary;
    private String department;

    public Employee(String firstName, String lastName, double salary, String department){
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName(){
        return String.format("%s %s", getFirstName(),getLastName());
    }

    @Override
    public String toString() {
        return String.format("%-8s %-8s %8.2f %s",getFirstName(),getLastName(),getSalary(),getDepartment());
    }
}
