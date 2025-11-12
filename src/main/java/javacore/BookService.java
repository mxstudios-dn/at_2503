package javacore;

import modals.Book;
import utils.XMLHelper;
import utils.Constants;
import java.util.List;
import java.util.Scanner;

public class BookService {

    public void loadAndShowBooks() {
        // Gọi XMLHelper để đọc file XML
        List<Book> books = XMLHelper.loadBooks(Constants.CATALOG_PATH);
        Scanner scanner = new Scanner(System.in);

        // In danh sách sách ra màn hình
        System.out.println("Danh sách book:");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("----------------------------");
        //In danh sách có giá >20
        System.out.println("Sách có price >20: ");
        for (Book b : books) {
            if (b.getPrice() > 20) {
                System.out.println(b);
            }
        }
        System.out.println("----------------------------");
        //Search
        System.out.print("Nhập author: ");
        String input_author = scanner.nextLine();
        System.out.println("Kết quả tìm kiếm theo author " + input_author);
        boolean found = false;
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(input_author)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách của author: " + input_author);
        }
    }
}