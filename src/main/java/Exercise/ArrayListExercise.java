package Exercise;

public class ArrayListExercise {
    int id;
    String studentName;
    double score;

    public ArrayListExercise(int id, String studentName, double score) {
        this.id = id;
        this.studentName = studentName;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getScore() {
        return score;
    }

    //Display student list
    public void displayStudent(){
        System.out.println("ID: " + id + ", Name: " + studentName + ", Score: " + score);
    }
}
