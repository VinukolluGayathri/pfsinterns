import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Integer, Book> books;
    private Map<Integer, Borrower> borrowers;

    public Library() {
        books = new HashMap<>();
        borrowers = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void addBorrower(Borrower borrower) {
        borrowers.put(borrower.getId(), borrower);
    }

    public Book getBook(int id) {
        return books.get(id);
    }

    public Borrower getBorrower(int id) {
        return borrowers.get(id);
    }

    public void issueBook(int bookId, int borrowerId) {
        Book book = books.get(bookId);
        Borrower borrower = borrowers.get(borrowerId);

        if (book != null && borrower != null && !book.isIssued()) {
            book.setIssued(true);
            System.out.println("Book issued to " + borrower.getName());
        } else {
            System.out.println("Cannot issue book.");
        }
    }

    public void returnBook(int bookId) {
        Book book = books.get(bookId);

        if (book != null && book.isIssued()) {
            book.setIssued(false);
            System.out.println("Book returned.");
        } else {
            System.out.println("Cannot return book.");
        }
    }

    public void listBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void listBorrowers() {
        for (Borrower borrower : borrowers.values()) {
            System.out.println(borrower);
        }
    }
}
