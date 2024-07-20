import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class StudentRecordManager {
    private static final String FILE_NAME = "students.txt";
    private List<Student> students;
    public StudentRecordManager() {
        students = new ArrayList<>();
        loadFromFile();
    }
    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
    }
    public void viewStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
    public void updateStudent(int rollNumber, String newName, String newGrade) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                student.setName(newName);
                student.setGrade(newGrade);
                saveToFile();
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }
    public void deleteStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
        saveToFile();
    }
    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No existing records found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        StudentRecordManager manager = new StudentRecordManager();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n1. Add Student\n2. View Students\n3. Update Student\n4. Delete Student\n5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  
                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter roll number: ");
                        int rollNumber = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter grade: ");
                        String grade = scanner.nextLine();
                        manager.addStudent(new Student(name, rollNumber, grade));
                        break;
                    case 2:
                        manager.viewStudents();
                        break;
                    case 3:
                        System.out.print("Enter roll number of student to update: ");
                        int updateRollNumber = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new grade: ");
                        String newGrade = scanner.nextLine();
                        manager.updateStudent(updateRollNumber, newName, newGrade);
                        break;
                    case 4:
                        System.out.print("Enter roll number of student to delete: ");
                        int deleteRollNumber = scanner.nextInt();
                        manager.deleteStudent(deleteRollNumber);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
                
            }
        }
        
    }

}
