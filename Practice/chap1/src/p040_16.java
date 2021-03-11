import java.util.Scanner;

public class p040_16 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("피라미드를 출력합니다.");
        System.out.print("단 수 : ");

        int n = stdIn.nextInt();

        spira(n);
    }
    static void spira(int n){
        for(int i = 1; i <= n; i++){
            printSpace(n-i);
            printStar((i * 2) - 1);
            printSpace(n-i);
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
