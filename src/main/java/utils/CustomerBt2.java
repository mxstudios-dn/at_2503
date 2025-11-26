package utils;

import model.CustomerBT2;

import java.util.List;

public class CustomerBt2 extends XMLHelper{
    private List<CustomerBT2> customers;

    //tạo hàm dựng
    public CustomerBt2 (String filePath){
        try {
            this.customers = readCustomersFromXml(filePath); // gọi hàm từ class cha
        } catch (Exception e) {
            System.err.println("Lỗi đọc file XML: " + e.getMessage());
        }
    }

    //hiển thị danh sách
    public void printAllCustomers() {
        for (CustomerBT2 c : customers) {
            System.out.println(c);
        }
    }

    //hàm tạo mới
    public void createCustomer(int id, String firstName, String lastName, String email, String customerRole, String dateOfBirth, String phoneNumber, boolean isActive) {
        CustomerBT2 newCustomer = new CustomerBT2(id, firstName, lastName, email, customerRole, dateOfBirth, phoneNumber, isActive);
        customers.add(newCustomer);
        System.out.println("Đã thêm customer mới: " + newCustomer);
    }

    //
    public void updateCustomer(int id, String newName, String newEmail) {
        for (CustomerBT2 c : customers) {
            if (c.getId() == id) {
                System.out.println("Trước khi sửa: " + c);
                c.setFirstName(newName);
                c.setEmail(newEmail);
                System.out.println("Sau khi sửa: " + c);
                return;
            }
        }
        System.out.println("Không tìm thấy customer với ID: " + id);
    }


}
