
public class Main {
    public static int min(int a, int b, int c, int d) {
        if (a>b) return b;
        else if (b>a) return a;
        else if (c>a) return a;
        else if (b>c) return c;
        else if (a>c) return c;
        else if (c>b) return b;
        else if (a>d) return d;
        else if (c>d) return d;
        else if (b>d) return d;
        else return 0;
    }

    public static int min(int a, int b) {
        if (a>b) return b;
        else if (b>a) return a;
        else return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(min(-20, -10));
        System.out.println(min(-40, -10, -30, 40));
        System.out.println(min(-20, -40, -30, 40));
        System.out.println(min(-20, -10, -40, 40));
        System.out.println(min(-20, -10, -30, -40));
    }
}
