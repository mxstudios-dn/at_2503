package vn.vti.academy;
import Exercise.ArrayListExercise;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       // Student list management
        // Create student list
        ArrayList<ArrayListExercise> student = new ArrayList<>();

        //add new student
        student.add(new ArrayListExercise(1, "Dung", 10.0));
        student.add(new ArrayListExercise(2, "An", 9.5));
        student.add(new ArrayListExercise(3, "Uyen", 9.0));

        //show student list
        for(ArrayListExercise stu : student){
            stu.displayStudent();
        }
    }
}
