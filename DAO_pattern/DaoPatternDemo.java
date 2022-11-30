package DAO_pattern;

public class DaoPatternDemo {
   public static void main(String[] args) {
      Student student;
      StudentDao studentDao=new StudentDaoImpl();

   for (Student studen:studentDao.getAllStudents()) {
    System.out.println("Student: [RollNo : " + studen.getRollNo() + ", Name : " + studen.getName() + " ]");
   }
   student=studentDao.getAllStudents().get(0);
   student.setName("mani");
   studentDao.updateStudent(student);

   studentDao.getStudent(0);
   System.out.println("Student : [RollNo"+student.getRollNo() +",Name : "+student.getName()+"]");
   studentDao.createStudent();
   }
}
