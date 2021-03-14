import java.util.Scanner;

public class p070_06 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        char[] d = new char[100];

        System.out.println("10진수를 기수 변환합니다.");
        System.out.print("10진수 : ");
        int x = stdIn.nextInt();
        System.out.print("변환할 기수 : ");
        int r = stdIn.nextInt();

        int digits = cardConv(x, r, d);

        for (char c : d) {
            System.out.print(c);
        }
        System.out.println();
        System.out.println("총 " + digits + "자리 수 입니다.");

    }

    static int cardConv(int x, int r, char[] d) {
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);

        for (int i = 0; i < digits / 2; i++) {
            char temp = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = temp;
        }

        return digits;
    }
}
