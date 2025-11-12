package vn.vti.academy;

import utils.Book;
import utils.Constants;
import utils.XMLHelper;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Book> books = XMLHelper.loadBooks(Constants.path);

        System.out.print("Nhập n: ");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        switch (n) {

            //In ra tất cả book
            case 1:
                for (Book b : books) {
                    System.out.println(b);
                }
                break;

            //In ra ds cuốn sách có giá > 20
            case 2:
                for (Book b : books) {
                    if (b.getPrice() > 20) {
                        System.out.println(b);
                    }
                }
                break;

            //Search book
            //Nhập tên sách cần tìm
            case 3:
                scanner.nextLine();
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
                break;


        }
    }
}
