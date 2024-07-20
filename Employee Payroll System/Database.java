import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<Integer, Employee> employees;

    public Database() {
        employees = new HashMap<>();
    }

    public void addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public Map<Integer, Employee> getAllEmployees() {
        return employees;
    }
}
