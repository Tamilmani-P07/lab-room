package DAO_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDaoImpl implements StudentDao{
    public List<Student> students;
    public Scanner sc=new Scanner(System.in);
    
    public StudentDaoImpl() {
        students = new ArrayList<Student>();
        Student student1 = new Student("Tamil",69);
        Student student2 = new Student("sathya",79);
        students.add(student1);
        students.add(student2);
    }

    @Override
    public List<Student> getAllStudents() {
        
        return students;
    }

    @Override
    public void updateStudent(Student student) {
        students.get(student.getRollNo()).setName(student.getName());
      System.out.println("Student: Roll No " + student.getRollNo() + ", updated in the database");
        
    }

    @Override
    public void deleteStudent(Student student) {
        students.remove(student.getRollNo());
      System.out.println("Student: Roll No " + student.getRollNo() + ", deleted from database");
        
    }

    @Override
    public void createStudent() {
        String n=sc.next();
        int i=sc.nextInt();
        Student student=new Student(n,i);
        students.add(student);
    }

    @Override
    public Student getStudent(int rollNo) {
        return students.get(rollNo);
        
    }
    
}
