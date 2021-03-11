import java.util.Scanner;

public class p030_07 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 출력합니다.");
        System.out.print("n : ");

        int n = stdIn.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (i != n) {
                System.out.print(i + " + ");
            } else {
                System.out.print(i + " ");
            }
            sum += i;
        }

        System.out.print("= " + sum);
    }
}
