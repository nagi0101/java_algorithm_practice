import java.util.Scanner;

public class EuclidGCD {
    static int gdc(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gdc(y, x % y);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("Get greatest common divisor.");

        System.out.print("Input integer : "); int x = stdIn.nextInt();
        System.out.print("Input integer : "); int y = stdIn.nextInt();

        System.out.println("GCD is "+ gdc(x, y));
    }
}
