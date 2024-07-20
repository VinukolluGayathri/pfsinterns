public class Employee {
    private int id;
    private String name;
    private double hourlyRate;
    private double hoursWorked;
    private double taxRate; // e.g., 0.20 for 20% tax

    public Employee(int id, String name, double hourlyRate, double taxRate) {
        this.id = id;
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.taxRate = taxRate;
        this.hoursWorked = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void addHoursWorked(double hours) {
        this.hoursWorked += hours;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double calculateGrossPay() {
        return hourlyRate * hoursWorked;
    }

    public double calculateNetPay() {
        double grossPay = calculateGrossPay();
        return grossPay - (grossPay * taxRate);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hourlyRate=" + hourlyRate +
                ", hoursWorked=" + hoursWorked +
                ", taxRate=" + taxRate +
                '}';
    }
}
