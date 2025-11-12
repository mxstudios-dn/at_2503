package vn.vti.academy;
import module.*;
import utils.*;
import org.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Create a Bookshop instance
        Bookshop shop = new Bookshop();

        // Load and handle everything
        String filePath = "src/catalog.xml";
        shop.loadAndDisplayBooks(filePath);
    }
}
