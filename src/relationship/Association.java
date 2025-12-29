package relationship;

import java.util.ArrayList;
import java.util.List;

class Passport{
    private String passportNumber;

    public Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }
    public String getPassportNumber() {
        return passportNumber;
    }

}

class Student{
    private String name;
    private Passport passport;  //  Aggregation

    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public Student(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }

    public Student(String name, String passportNumber) { // composition - strong relationship
        this.name = name;
        this.passport = new Passport(passportNumber);
    }

    public String getName(){
        return name;
    }

    public void addCourses(Course course){
        courses.add(course);
    }

    public void studentDetails(){
        System.out.println("student name : "+name);
        System.out.println("passport number : "+passport.getPassportNumber());
    }
}

class College{
    private String name;

    private List<Student> students;

    public College(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public void addStudents(Student student){
        students.add(student);
    }

    public void printAllStudents(){
        for (Student student:students){
            System.out.println("Name " + student.getName());
        }
    }
}

class Course{
    private String name;
    private List<Student> students;

    public Course(String name){
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudents(Student student){
        students.add(student);
    }
}

public class Association {
    public static void main(String[] args) {
        Passport passport = new Passport("638372");
        Student student = new Student("Raj",passport);
        student.studentDetails();

        Student student1 = new Student("Rahul");
        Student student2 = new Student("Rohan");

        College college = new College("IIT Madras");
        college.addStudents(student1);
        college.addStudents(student2);

        college.printAllStudents();
    }
}
