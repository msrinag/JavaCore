import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void displayEmployees() {
        System.out.println("\nDepartment: " + name);
        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }

    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee emp : employees) {
            totalSalary += emp.getSalary();
        }
        return totalSalary;
    }
}

class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void displayCompanyDetails() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.displayEmployees();
            System.out.println("Total Salary for " + dept.calculateTotalSalary());
        }
    }
}

// Main class
public class Main2 {
    public static void main(String[] args) {
        
        Company company = new Company("softland");

        // Create dep
        Department it = new Department("IT");
        Department biz = new Department("Business");

        // Create emp
        Employee e1 = new Employee(101, "sri", 50000);
        Employee e2 = new Employee(102, "nag", 60000);
        Employee e3 = new Employee(103, "marni", 55000);

        // emp to dep
        it.addEmployee(e1);
        it.addEmployee(e2);
        biz.addEmployee(e3);

        // dep to cmp
        company.addDepartment(it);
        company.addDepartment(biz);

        // Display details
        company.displayCompanyDetails();
    }
}


