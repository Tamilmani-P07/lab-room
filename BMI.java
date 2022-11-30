import java.util.Scanner;
public class BMI {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        CalculateBMI calculateBMI=new CalculateBMI();
        float height=sc.nextFloat();
        float weight=sc.nextFloat();
        calculateBMI.setHeight((height/100)*(height/100));
        calculateBMI.setWeight(weight);
        System.out.println(calculateBMI.getBMI());
    }
   
}
