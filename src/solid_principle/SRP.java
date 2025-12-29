package solid_principle;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

// Class is responsible for only print the book
class PrintBook {
    public void printBook(Book book) {
        System.out.println("Title : " + book.getTitle() + ", Author : " + book.getAuthor());
    }
}

public class SRP {
    public static void main(String[] args) {
        Book book = new Book("Java Programming", "Devs");
        PrintBook printBook = new PrintBook();
        printBook.printBook(book);
    }
}
