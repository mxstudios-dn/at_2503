package model;

public class Person {
    private String name;
    private int age;
    private String email;
    private String environment;

    public Person(String name, int age, String email, String environment) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.environment = environment;
    }
    @Override
    public String toString() {
        return "Environment: " + environment +
                "\nName: " + name +
                "\nAge: " + age +
                "\nEmail: " + email +
                "\n---------------------------";
    }
}
