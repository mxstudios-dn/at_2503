package javacore;

import modals.Book;
import org.xml.sax.SAXException;
import utils.Constants;
import utils.XMLHelper;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookShop {
    List<Book> books;
    XMLHelper xmlHelper;

    /**
     * Constructor to initialize the BookShop by loading books from the XML file.
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public BookShop() throws ParserConfigurationException, IOException, SAXException {
        xmlHelper = new XMLHelper(Constants.BOOK_FILE_PATH);
        this.books = xmlHelper.getAllBooks();
    }

    /**
     * Get the list of all books in the shop.
     * @return
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Prints the titles and prices of books that exceed the specified price threshold.
     * @param priceThreshold
     */
    public void printBooksOverPrice(double priceThreshold) {
        for (Book book : books) {
            if (book.getPrice() > priceThreshold) {
                System.out.println(book.toString());
            }
        }
    }

    /**
     * Get a list of books by a specific author.
     * @param author
     * @return
     */
    public List<Book> getBookByAuthor(String author) {
        List<Book> books = new ArrayList<>();
        for (Book book : this.books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                books.add(book);
            }
        }
        return books;
    }
}
