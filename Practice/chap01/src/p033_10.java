import java.util.Scanner;

public class p033_10 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("a의 값 : ");
        int a = stdIn.nextInt();

        int b;
        while (true) {
            System.out.print("b의 값 : ");
            b = stdIn.nextInt();
            if (b <= a) {
                System.out.println("a보다 큰 값을 입력하세요!");
            } else break;
        }

        System.out.printf("b - a는 %d입니다.", b - a);
    }
}
