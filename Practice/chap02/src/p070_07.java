import java.util.Scanner;

public class p070_07 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        char[] ld = new char[100];
        char[] d = new char[100];

        System.out.println("10진수를 기수 변환합니다.");
        System.out.print("10진수 : ");
        int x = stdIn.nextInt();
        System.out.print("변환할 기수 : ");
        int r = stdIn.nextInt();

        long startTime = System.nanoTime();
        int digits = cardConv(x, r, d);
        long endTime = System.nanoTime();

        long logStartTime = System.nanoTime();
        int logDigits = logCardConv(x, r, ld);
        long logEndTime = System.nanoTime();

        System.out.println("cardConv() runtime : " + (endTime - startTime));
        System.out.println("logCardConv() runtime : " + (logEndTime - logStartTime));

        for (char c : d) {
            System.out.print(c);
        }
        System.out.println();
        System.out.println("총 " + digits + "자리 수 입니다.");
        System.out.println("총 " + logDigits + "자리 수 입니다.");

    }

    static int cardConv(int x, int r, char[] d) {
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        while (true) {
            d[digits++] = dchar.charAt(x % r);
            if (digits == 1) {
                // 처음 실행된다.
                // 맨 윗 줄을 출력한다.
                System.out.printf(
                        "%3d |        %3d\n", r, x);
            } else {
                // 두 번째 이후부터 실행된다.
                // 맨 윗 줄을 출력할 때 나머지를 출력하지 않았기에 여기서는 d[digits-2]를 출력한다.
                System.out.printf(
                        "%3d |        %3d ... %c\n", r, x, d[digits - 2]);
            }
            System.out.println("    +-----------");
            x /= r;
            if (x == 0) {
                // 마지막 줄을 출력한 후 반복문을 탈출한다.
                System.out.printf(
                        "             %3d ... %c\n", x, d[digits - 1]
                );
                break;
            }
        }

        for (int i = 0; i < digits / 2; i++) {
            // 기수 변환한 결과를 역순 배열한다.
            char temp = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = temp;
        }

        return digits;
    }

    static int logCardConv(int x, int r, char[] d) {
        int logDigits = (int) (Math.log((double) x) / Math.log((double) r)) + 1;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = logDigits - 1; i >= 0; i--) {
            d[i] = dchar.charAt(x % r);
            if (i == logDigits - 1) {
                // 처음 실행된다.
                // 맨 윗 줄을 출력한다.
                System.out.printf(
                        "%3d |        %3d\n", r, x);
            } else {
                // 두 번째 이후부터 실행된다.
                // 맨 윗 줄을 출력할 때 나머지를 출력하지 않았기에 여기서는 d[i + 1]를 출력한다.
                System.out.printf(
                        "%3d |        %3d ... %c\n", r, x, d[i + 1]);
            }
            System.out.println("    +-----------");
            x /= r;
            if (x == 0) {
                // 마지막 줄을 출력한 후 반복문을 탈출한다.
                System.out.printf(
                        "             %3d ... %c\n", x, d[i]
                );
                break;
            }
        }

        return logDigits;
    }
}
