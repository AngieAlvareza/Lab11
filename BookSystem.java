package Ejercicio2;
import java.util.*;
public class BookSystem {
    private Map<String, Book> booksByTitle;
    private Map<String, Book> booksByAuthor;
    private Map<String, List<Book>> booksBySpecialty;
    private Book bestBookByAuthor;

    public BookSystem() {
        booksByTitle = new HashMap<>();
        booksByAuthor = new HashMap<>();
        booksBySpecialty = new HashMap<>();
        bestBookByAuthor = null;
    }

    public void addBook(String title, String author, int sales, int rating, String specialty, String comments) {
        Book book = new Book(title, author, sales, rating, specialty, comments);
        booksByTitle.put(title, book);
        booksByAuthor.put(author, book);
        booksBySpecialty.computeIfAbsent(specialty, key -> new ArrayList<>()).add(book);

        if (bestBookByAuthor == null || rating > bestBookByAuthor.getRating()) {
            bestBookByAuthor = book;
        }
    }

//    public void modifyBook(String title, String author, int sales, int rating, String specialty, String comments) {
//        Book book = booksByTitle.get(title);
//        if (book == null) {
//            addBook(title, author, sales, rating, specialty, comments);
//        } else {
//            book.setAuthor(author);
//            book.setSales(sales);
//            book.setRating(rating);
//            book.setComments(comments);
//
//            // Check if it is the best book by the author
//            if (book.equals(bestBookByAuthor) || rating > bestBookByAuthor.getRating()) {
//                bestBookByAuthor = book;
//            }
//        }
//    }
    public void modifyBook(String title, String author, int sales, int rating, String specialty, String comments) {
        Book book = booksByTitle.get(title);
        if (book == null) {
            addBook(title, author, sales, rating, specialty, comments);
        } else {
            book.setAuthor(author);
            book.setSales(sales);
            book.setRating(rating);
            book.setComments(comments);

            // Restore the original specialty
            String originalSpecialty = book.getSpecialty();
            book.setSpecialty(specialty);

            // Check if it is the best book by the author
            if (book.equals(bestBookByAuthor) || rating > bestBookByAuthor.getRating()) {
                bestBookByAuthor = book;
            }

            // Update the booksBySpecialty map
            List<Book> specialtyBooks = booksBySpecialty.get(originalSpecialty);
            if (specialtyBooks != null) {
                specialtyBooks.remove(book);
                List<Book> updatedSpecialtyBooks = booksBySpecialty.computeIfAbsent(specialty, key -> new ArrayList<>());
                updatedSpecialtyBooks.add(book);
            }
        }
    }

    public Book getBestBookByAuthor(String author) {
        if (author.equals(bestBookByAuthor.getAuthor())) {
            return bestBookByAuthor;
        }
        return booksByAuthor.get(author);
    }

    public List<Book> getBooksBySpecialty(String specialty) {
        List<Book> books = booksBySpecialty.getOrDefault(specialty, new ArrayList<>());
        Collections.sort(books, Comparator.comparingInt(Book::getSales).reversed());
        return books;
    }

   
}
