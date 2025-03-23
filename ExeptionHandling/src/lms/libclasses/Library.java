package lms.libclasses;

import java.util.ArrayList;

import lms.exeptions.*;

public class Library {
    private ArrayList<Book> books = new ArrayList<Book>();

    public Library() {
    }

    public void addBook(Book book) throws InvalidBookException {
        if (book == null)
            throw new InvalidBookException("Book should not be null");
        books.add(book);
    }
    private Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title))
                return book;
        }
        return null;
    }

    public void borrowBook(String title) throws BookNotFoundException , EmptyLibraryException {
            if (books.isEmpty())
                throw new EmptyLibraryException("Library is empty, no books to borrow");
            if (findBook(title) == null)
                throw new BookNotFoundException("Book with title " + title + " not found");
            System.out.println("book: " + findBook(title).toString() + " borrowed!");
    }

    public void returnBook(String title) throws BookNotFoundException {
        if (findBook(title) == null)
            throw new BookNotFoundException("Cannot Found. Book with title " + title + " not found");
        System.out.println("book: " + findBook(title).toString() + " returned!");
    }
    public void listBooks() throws EmptyLibraryException {
        if (books.isEmpty())
            throw new EmptyLibraryException("Library is empty");
        System.out.println("Books in library:");
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }
}
