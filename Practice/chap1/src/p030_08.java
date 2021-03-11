import java.util.Scanner;

public class p030_08 {
    public static void main(String[] args) {
        int sum = 0;
        Scanner stdIn = new Scanner(System.in);

        System.out.println("bottom부터 top까지의 합을 출력합니다.");

        System.out.print("bottom : ");
        int bottom = stdIn.nextInt();

        System.out.print("top : ");
        int top = stdIn.nextInt();

        sum = gaussPlus(bottom, top);

        System.out.println(bottom + "부터 " + top + "까지의 합은 " + sum + "입니다.");

    }

    static int gaussPlus(int bottom, int top) {
        int distance = top - bottom + 1;
        int n = distance / 2;
        int sum = (bottom + top) * n;

        if (distance % 2 == 1) {
            // 중간의 하나의 숫자에게 쌍이 없는 경우
            // 가운데 숫자를 구해서 더해준다
            sum += (bottom + top) / 2;
        }

        return sum;
    }
}
