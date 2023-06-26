package Ejercicio2;

class Book {
    private String title;
    private String author;
    private int sales;
    private int rating;
    private String specialty;
    private String comments;

    public Book(String title, String author, int sales, int rating, String specialty, String comments) {
        this.title = title;
        this.author = author;
        this.sales = sales;
        this.rating = rating;
        this.specialty = specialty;
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}