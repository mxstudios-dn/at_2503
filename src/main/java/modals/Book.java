package modals;
public class Book {

    /**
     * Lớp Book (POJO) để lưu trữ thông tin của một cuốn sách.
     * (Yêu cầu 3)
     */
        private String id;
        private String author;
        private String title;
        private String genre;
        private double price;
        private String publishDate;
        private String description;

        // Constructor
        public Book(String id, String author, String title, String genre, double price, String publishDate, String description) {
            this.id = id;
            this.author = author;
            this.title = title;
            this.genre = genre;
            this.price = price;
            this.publishDate = publishDate;
            this.description = description;
        }

        // Getters
        public String getId() { return id; }
        public String getAuthor() { return author; }
        public String getTitle() { return title; }
        public String getGenre() { return genre; }
        public double getPrice() { return price; }
        public String getPublishDate() { return publishDate; }
        public String getDescription() { return description; }

        // Ghi đè phương thức toString() để in thông tin cho đẹp
        @Override
        public String toString() {
            return "Book [ID=" + id + "]\n" +
                    "  Title: " + title + "\n" +
                    "  Author: " + author + "\n" +
                    "  Genre: " + genre + "\n" +
                    "  Price: $" + price + "\n" +
                    "  Published: " + publishDate + "\n" +
                    "------------------------------------";
        }
    }

