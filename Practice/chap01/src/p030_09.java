import java.util.Scanner;

public class p030_09 {
    public static void main(String[] args) {
        int sum = 0;
        Scanner stdIn = new Scanner(System.in);

        System.out.println("a부터 b까지의 합을 출력합니다.");

        System.out.print("a : ");
        int a = stdIn.nextInt();

        System.out.print("b : ");
        int b = stdIn.nextInt();

        sum = sumof(a, b);

        System.out.println(a + "부터 " + b + "까지의 합은 " + sum + "입니다.");
    }

    static int sumof(int a, int b) {
        int sum = 0;

        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        for (int i = a; i <= b; i++)
            sum += i;

        return sum;
    }
}
