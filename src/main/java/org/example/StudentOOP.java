package org.example;

public class StudentOOP {
    //Khai báo các thuộc tính (biến đối tượng)
    String maSV;
    String firstName, lastName, address;
    double grade, softwareTesting, automatiionTesting;

    //Constructor
    public StudentOOP(String maSV, String firstName, String lastName, String address, double softwareTesting, double automatiionTesting) {
        this.maSV = maSV;  //Gán tham số vào biến đối tượng
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.softwareTesting = softwareTesting;
        this.automatiionTesting = automatiionTesting;
        calculatorGrade(); //Gọi hàm để tính điểm tổng

    }

    //Tính tổng điểm (private: chỉ dùng nội bộ trong class)
    private void calculatorGrade() {
        this.grade = 0.7*softwareTesting + 0.3*automatiionTesting;
    }
    //Get để trả về giá trị grade
    public double getGrade(){
        return this.grade;
    }
    //Hàm trả về họ tên in HOA
    public String studentName(){
        return this.firstName.toUpperCase() +" " + this.lastName.toUpperCase();
    }
}
