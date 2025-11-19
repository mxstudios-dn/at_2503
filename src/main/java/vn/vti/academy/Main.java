package vn.vti.academy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CustomerManager service = new CustomerManager(Constant.XML_PATH, Constant.CSV_PATH);

        service.printAllCustomer();
    }
}
