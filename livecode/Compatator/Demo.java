import java.util.ArrayList;
import java.util.Collections;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Student> as=new ArrayList<Student>();
        as.add(new Student(1, "Tamil", 22));
        as.add(new Student(2, "Sathya", -10));
        as.add(new Student(3, "Praveen", 21));
         
        Collections.sort(as);

        for (Student student : as) {
            System.out.println(student.rollNo+" "+student.name+" "+student.age);
        }
        
        Collections.sort(as,new NameComparator());

        for (Student student : as) {
            System.out.println(student.rollNo+" "+student.name+" "+student.age);
        }
    }
}
