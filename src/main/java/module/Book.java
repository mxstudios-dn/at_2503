package module

public class Book {
    private String id;
    private String author;
    private String title;
    private String genre;
    private double price;
    private String publishDate;
    private String description;

    public Book(String id, String author, String title, String genre, double price, String publishDate, String description){
        this.id = id;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.publishDate = publishDate;
        this.description = description;
    }

    public String getAuthor(){ return author; }
    public  double getPrice(){ return  price;}

    @Override
    public String toString(){
        return "Book{"+
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", publishDate='" + publishDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}