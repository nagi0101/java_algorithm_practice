import java.util.Scanner;

public class p170_02 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("Get greatest common divisor.");

        System.out.print("Input integer : "); int x = stdIn.nextInt();
        System.out.print("Input integer : "); int y = stdIn.nextInt();

        System.out.println("GCD is " + gdc(x, y));
    }

    static private int gdc(int x, int y) {
        int gdc;

        while (true) {
            int remainder = x % y;
            if (remainder <= 0) {
                gdc = y;
                break;
            } else {
                int temp = y;
                y = x % y;
                x = temp;
            }
        }

        return gdc;
    }
}
