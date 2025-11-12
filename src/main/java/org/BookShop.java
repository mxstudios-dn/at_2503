package org


public class BookShop {
    public void loadAndPrint(String filePath){
        ArrayList<Book> books = XMLHelper.loadBooks(filePath);

        // Show all books
        System.out.println("== All books loaded ==");
        books.forEach(System.out::println);

        // Show books with price > 20
        System.out.println("\n== Books with price > 20 ==");
        books.stream()
                .filter(book -> book.getPrice() > 20)
                .forEach(System.out::println);

        // Search by author
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter author name to search: ");
        String searchAuthor = sc.nextLine().trim();

        System.out.println("\n== Search results ==");
        books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(searchAuthor))
                .forEach(System.out::println);
    }
}