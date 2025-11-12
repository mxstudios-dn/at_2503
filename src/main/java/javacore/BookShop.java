package javacore;
import modals.Book;
import utils.Constants;
import utils.XmlHelper;
import java.util.List;
import java.util.stream.Collectors;

public class BookShop  {

    /**
     * Phương thức chính để parse XML file và trả về List<Book>
     */
    public static void getBook(){
        System.out.println("--- BookShop XML ---");
        try {
            // Yêu cầu 1 & 2: Load XML file vào ArrayList<Book>
            List<Book> bookList = XmlHelper.parseBooks(Constants.BOOK_FILE_PATH);

            System.out.println(">>> Đã load thành công " + bookList.size() + " cuốn sách.");
            System.out.println("\n============================================\n");

            // Yêu cầu 4: In ra danh sách các cuốn sách có giá > 20
            System.out.println("4. DANH SÁCH SÁCH CÓ GIÁ > $20 ");
            bookList.stream()
                    .filter(book -> book.getPrice() > 20)
                    .forEach(System.out::println);

            System.out.println("\n============================================\n");

            // Yêu cầu 5: Search cuốn sách theo author và in ra
            String searchAuthor = "Corets, Eva";
            System.out.println("5. TÌM KIẾM SÁCH THEO TÁC GIẢ: '" + searchAuthor + "'");

            List<Book> foundBooks = bookList.stream()
                    .filter(book -> book.getAuthor().equals(searchAuthor))
                    .collect(Collectors.toList()); // (Dùng toList() hoặc collect)

            if (foundBooks.isEmpty()) {
                System.out.println("Không tìm thấy cuốn sách nào của tác giả: " + searchAuthor);
            } else {
                foundBooks.forEach(System.out::println);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}