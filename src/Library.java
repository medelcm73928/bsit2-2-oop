import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("System: Book added successfully!");
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("System: The library catalog is currently empty.");
            return;
        }

        System.out.println("\n--- Library Catalog ---");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    public void borrowBook(String title) {
        Book book = findBook(title);

        if (book == null) {
            System.out.println("System Error: Book '" + title + "' not found in our catalog.");
        } else if (book.isBorrowed()) {
            System.out.println("System Error: '" + title + "' is already checked out.");
        } else {
            book.borrow();
            System.out.println("System Success: You have successfully borrowed '" + book.getTitle() + "'.");
        }
    }

    public void returnBook(String title) {
        Book book = findBook(title);

        if (book == null) {
            System.out.println("System Error: Book '" + title + "' does not belong to this library.");
        } else if (!book.isBorrowed()) {
            System.out.println("System Error: '" + book.getTitle() + "' was not flagged as borrowed.");
        } else {
            book.returnBook();
            System.out.println("System Success: Thank you! '" + book.getTitle() + "' has been returned.");
        }
    }

    public void searchBook(String title) {
        Book book = findBook(title);

        if (book != null) {
            System.out.println("System Status: Match found! -> " + book);
        } else {
            System.out.println("System Status: Book '" + title + "' does not exist in this library.");
        }
    }

    private Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title.trim())) {
                return book;
            }
        }
        return null;
    }
}