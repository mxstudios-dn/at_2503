package vn.vti.academy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String filePath = "src/ catalog.xml";
        ArrayList<Book> books = XMLHelper.loadBooks(filePath);

        System.out.println("== All books loaded ==");
        books.forEach(System.out::println);

        System.out.println("\n== Books with price > 20 ==");
        books.stream()
                .filter(book -> book.getPrice() > 20)
                .forEach(System.out::println);

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter author name to search: ");
        String searchAuthor = sc.nextLine();

        System.out.println("\n== Search results ==");
        books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(searchAuthor))
                .forEach(System.out::println);

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}
