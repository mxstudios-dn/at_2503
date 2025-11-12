package javacore;
import modals.Customer;
import utils.Constants;
import utils.XmlHelper;
import java.util.List;
public class CustomerManage {

    /**
     * Parse file customers.xml và trả về List<Customer>
     */
    public static void getCustomer(){
        System.out.println("--- CUSTOMER XML ---");
        try {
            // 1. Load XML vào ArrayList<Customer>
            List<Customer> customerList = XmlHelper.parseCustomers(Constants.CUSTOMER_FILE_PATH);
            System.out.println(">>> Đã load thành công " + customerList.size() + " khách hàng.");
            System.out.println("\n============================================\n");

            // 2.In ra khách hàng ở bang "CA" (California)
            System.out.println(" 2. KHÁCH HÀNG Ở BANG 'CA' ");
            customerList.stream()
                    // Lọc khách hàng (c) nào có BẤT KỲ địa chỉ (a) nào có bang là "CA"
                    .filter(c -> c.getAddresses().stream().anyMatch(a -> a.getState().equals("CA")))
                    .forEach(System.out::println);

            System.out.println("\n============================================\n");

            // 3. Tìm khách hàng theo tên
            String searchName = "Global Tech Corp";
            System.out.println(" 3. TÌM KHÁCH HÀNG: '" + searchName + "'");
            customerList.stream()
                    .filter(c -> c.getName().equals(searchName))
                    .forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}