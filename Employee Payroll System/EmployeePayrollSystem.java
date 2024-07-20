import java.util.Scanner;

public class EmployeePayrollSystem {
    private static Database database = new Database();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add New Employee");
            System.out.println("2. Enter Time Worked");
            System.out.println("3. Calculate Salary");
            System.out.println("4. Generate Pay Slip");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewEmployee(scanner);
                    break;
                case 2:
                    enterTimeWorked(scanner);
                    break;
                case 3:
                    calculateSalary(scanner);
                    break;
                case 4:
                    generatePaySlip(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addNewEmployee(Scanner scanner) {
        System.out.println("Enter Employee ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Employee Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Hourly Rate:");
        double hourlyRate = scanner.nextDouble();

        System.out.println("Enter Tax Rate (e.g., 0.20 for 20%):");
        double taxRate = scanner.nextDouble();

        Employee employee = new Employee(id, name, hourlyRate, taxRate);
        database.addEmployee(employee);
        System.out.println("Employee added successfully.");
    }

    private static void enterTimeWorked(Scanner scanner) {
        System.out.println("Enter Employee ID:");
        int id = scanner.nextInt();

        Employee employee = database.getEmployee(id);
        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.println("Enter Hours Worked:");
        double hoursWorked = scanner.nextDouble();

        employee.addHoursWorked(hoursWorked);
        System.out.println("Hours worked updated successfully.");
    }

    private static void calculateSalary(Scanner scanner) {
        System.out.println("Enter Employee ID:");
        int id = scanner.nextInt();

        Employee employee = database.getEmployee(id);
        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.println("Net Pay: $" + employee.calculateNetPay());
    }

    private static void generatePaySlip(Scanner scanner) {
        System.out.println("Enter Employee ID:");
        int id = scanner.nextInt();

        Employee employee = database.getEmployee(id);
        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        String paySlip = Payroll.generatePaySlip(employee);
        System.out.println(paySlip);
    }
}
