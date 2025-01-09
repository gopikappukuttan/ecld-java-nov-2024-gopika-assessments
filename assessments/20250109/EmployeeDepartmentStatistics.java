import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;
    private List<String> skills;

    public Employee(String name, String department, double salary, List<String> skills) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public List<String> getSkills() {
        return skills;
    }

}

class DepartmentStats {
    private double averageSalary;
    private long employeeCount;
    private Set<String> uniqueSkills;

    public DepartmentStats(Set<String> uniqueSkills, long employeeCount, double averageSalary) {
        this.uniqueSkills = uniqueSkills;
        this.employeeCount = employeeCount;
        this.averageSalary = averageSalary;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public long getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(long employeeCount) {
        this.employeeCount = employeeCount;
    }

    public Set<String> getUniqueSkills() {
        return uniqueSkills;
    }

    public void setUniqueSkills(Set<String> uniqueSkills) {
        this.uniqueSkills = uniqueSkills;
    }
}

public class EmployeeDepartmentStatistics {
    public static Map<String, DepartmentStats> analyzeDepartments(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() > 2)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            //collecting average salary
                            double avgSalary = entry.getValue().stream()
                                    .collect(Collectors.averagingDouble(Employee::getSalary));
                            //count employees
                            long employeeCount = entry.getValue().stream()
                                    .collect(Collectors.counting());
                            //collect unique skills
                            Set<String> uniqueSkills = entry.getValue().stream()
                                    .flatMap(employee -> employee.getSkills().stream())
                                    .collect(Collectors.toSet());
                            return new DepartmentStats(uniqueSkills, employeeCount, avgSalary);
                        }
                ));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", "IT", 75000, Arrays.asList("Java", "SQL")),
                new Employee("Alice", "IT", 82000, Arrays.asList("Python", "Java")),
                new Employee("Bob", "HR", 65000, Arrays.asList("Communication")),
                new Employee("Charlie", "IT", 78000, Arrays.asList("Java", "AWS"))
        );
        Map<String, DepartmentStats> departmentStats = analyzeDepartments(employees);

        departmentStats.forEach((department, statistics) -> {
            System.out.println("Department: " + department);
            System.out.println("Average Salary: " + statistics.getAverageSalary());
            System.out.println("Employee Count: " + statistics.getEmployeeCount());
            System.out.println("Unique Skills: " + statistics.getUniqueSkills());
            System.out.println();
        });
    }
}
