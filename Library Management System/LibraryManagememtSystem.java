import java.util.Scanner;

public class LibraryManagememtSystem {
    private static Library library = new Library();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add New Book");
            System.out.println("2. Add New Borrower");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. List All Books");
            System.out.println("6. List All Borrowers");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewBook(scanner);
                    break;
                case 2:
                    addNewBorrower(scanner);
                    break;
                case 3:
                    issueBook(scanner);
                    break;
                case 4:
                    returnBook(scanner);
                    break;
                case 5:
                    library.listBooks();
                    break;
                case 6:
                    library.listBorrowers();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addNewBook(Scanner scanner) {
        System.out.println("Enter Book ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Book Title:");
        String title = scanner.nextLine();

        System.out.println("Enter Book Author:");
        String author = scanner.nextLine();

        Book book = new Book(id, title, author);
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void addNewBorrower(Scanner scanner) {
        System.out.println("Enter Borrower ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Borrower Name:");
        String name = scanner.nextLine();

        Borrower borrower = new Borrower(id, name);
        library.addBorrower(borrower);
        System.out.println("Borrower added successfully.");
    }

    private static void issueBook(Scanner scanner) {
        System.out.println("Enter Book ID:");
        int bookId = scanner.nextInt();

        System.out.println("Enter Borrower ID:");
        int borrowerId = scanner.nextInt();

        library.issueBook(bookId, borrowerId);
    }

    private static void returnBook(Scanner scanner) {
        System.out.println("Enter Book ID:");
        int bookId = scanner.nextInt();

        library.returnBook(bookId);
    }
}
