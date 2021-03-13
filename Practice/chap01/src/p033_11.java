import java.util.Scanner;

public class p033_11 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("양의 정수를 입력하세요.");
        System.out.print("n : ");
        int n = stdIn.nextInt();

        System.out.printf("그 함수는 %d 자리입니다.", (int)Math.log10(n) + 1);
    }
}
