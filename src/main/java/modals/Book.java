package modals;

public class Book {
    //Khởi tạo thuộc tính
    private String id;
    private String author;
    private String title;
    private String genre;
    private double price;
    private String publishDate;
    private String description;
    //Constructors
    public Book(String id, String author, String title, String genre, double price, String publishDate, String description){
        this.id = id;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.publishDate = publishDate;
        this.description= description;
    }
    @Override
    public String toString(){
        return String.format(
                "Book{id='%s';author='%s';title='%s';genre='%s';price='%s'}"
                ,id, author, title, genre, price, description);
    }
    public String getId(){
        return id;
    }
    public String getAuthor(){
        return author;
    }
    public String getTitle(){
        return title;
    }
    public String getGenre(){
        return genre;
    }
    public String getPublishDate(){
        return publishDate;
    }
    public String getDescription(){
        return description;
    }

    public double getPrice() {
        return price;
    }
}
