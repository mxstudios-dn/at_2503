package javaExcersice;

public class Array {
    public static void ArrayExcersice(){
        String[] array = {"apple", "banana", "apple", "orange", "banana", "grape"};
        String max = "";
        String secondMax = "";
        for (String n : array) {
            if (n.length() > max.length()) {
                secondMax = max;
                max = n;
            } else if (n.length() > secondMax.length() && n.length() < max.length()) {
                secondMax = n;
            }
        }
        System.out.println("Chuỗi dài nhất (max): " + max + " (độ dài " + max.length() + ")");
        System.out.println("Chuỗi dài thứ hai (secondMax): " + secondMax + " (độ dài " + secondMax.length() + ")");
    }
}
