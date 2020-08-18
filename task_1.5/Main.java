import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите температуру в градусах Цельсия");
        float temp = scanner.nextFloat();
        float calc = (9*temp/5+32) ;
        System.out.println(calc+" */");
    }
}
