import java.util.ArrayList;

public class Writer extends Person {
    private ArrayList<Book> books;

    public Writer(int id, String firstName, String lastName, int age) {
        super(id, firstName, lastName, age);
        this.books = new ArrayList<>();
    }

    public void addBook(Book b) {
        books.add(b);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
