import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        double a = scanner.nextDouble();
        double calc = a+a*0.15 ;
        System.out.println(a+" + 15% = "+calc);
    }
}
