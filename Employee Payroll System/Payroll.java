public class Payroll {
    public static String generatePaySlip(Employee employee) {
        StringBuilder paySlip = new StringBuilder();
        paySlip.append("Pay Slip for ").append(employee.getName()).append("\n");
        paySlip.append("Employee ID: ").append(employee.getId()).append("\n");
        paySlip.append("Hours Worked: ").append(employee.getHoursWorked()).append("\n");
        paySlip.append("Hourly Rate: $").append(employee.getHourlyRate()).append("\n");
        paySlip.append("Gross Pay: $").append(employee.calculateGrossPay()).append("\n");
        paySlip.append("Net Pay: $").append(employee.calculateNetPay()).append("\n");
        return paySlip.toString();
    }
}
