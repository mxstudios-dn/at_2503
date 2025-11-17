package utlis;
import modals.Address;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Address> addressList = XMLHelper.loadAddresses(Constants.XML_FILE_PATH);

        if (addressList.isEmpty()) {
            System.out.println("Không tải được dữ liệu địa chỉ.");
            return;
        }

        System.out.println("=============== IN TẤT CẢ ĐỊA CHỈ ===============");
        printAllAddresses(addressList);

        System.out.println("\n========= IN ĐỊA CHỈ THEO INDEX (Vị trí 1) =========");
        printAddressByIndex(addressList, 1);

        System.out.println("\n========= IN ĐỊA CHỈ THEO INDEX (Vị trí 3) =========");
        printAddressByIndex(addressList, 3);
    }

    public static void printAllAddresses(List<Address> addresses) {
        if (addresses.isEmpty()) {
            System.out.println("Danh sách địa chỉ trống.");
            return;
        }
        for (Address addr : addresses) {
            System.out.println(addr);
        }
    }

    public static void printAddressByIndex(List<Address> addresses, int index) {
        if (index >= 0 && index < addresses.size()) {
            Address addr = addresses.get(index);
            System.out.println(addr);
        } else {
            System.out.println("Lỗi: Index " + index + " không hợp lệ hoặc không tìm thấy.");
        }
    }
}