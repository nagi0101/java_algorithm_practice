import java.util.Scanner;

public class p040_15 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("직각 삼각형을 출력합니다.");
        System.out.print("단 수 : ");

        int n = stdIn.nextInt();

        System.out.println("LB-----------");
        triangleLB(n);
        System.out.println("LU-----------");
        triangleLU(n);
        System.out.println("RB-----------");
        triangleRB(n);
        System.out.println("RU-----------");
        triangleRU(n);
    }

    static void triangleLB(int n) {
        for (int i = 1; i <= n; i++) {
            printStar(i);
            printSpace(n - i);
            System.out.println();
        }
    }

    static void triangleLU(int n) {
        for (int i = 0; i < n; i++) {
            printStar(n - i);
            printSpace(i);
            System.out.println();
        }
    }

    static void triangleRB(int n) {
        for (int i = 1; i <= n; i++) {
            printSpace(n - i);
            printStar(i);
            System.out.println();
        }
    }

    static void triangleRU(int n) {
        for (int i = 0; i < n; i++) {
            printSpace(i);
            printStar(n - i);
            System.out.println();
        }
    }

    static void printStar(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("*");
    }

    static void printSpace(int n) {
        for (int i = 0; i < n; i++)
            System.out.print(" ");
    }
}
