package org.example;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

//Tạo danh sách List chứa các đối tượng Student
        List<StudentOOP> students = new ArrayList<>();
//Thêm 3 đối tượng Student vào danh sách
        students.add(new StudentOOP("SV001", "Ánh", "Lê", "Hà Nội", 9, 8));
        students.add(new StudentOOP("SV002", "Phương", "Trần", "Huế", 8.5, 7));
        students.add(new StudentOOP("SV003", "Hoàn", "Nguyễn", "Hồ Chí Minh", 7, 8.5));
//Duyệt danh sách và in thông tin sinh viên
        for (StudentOOP student : students) {
            System.out.println("student: " + student.studentName() + ",grade:" + student.getGrade());

        }

    }
}
