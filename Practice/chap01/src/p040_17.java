import java.util.Scanner;

public class p040_17 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("피라미드를 출력합니다.");
        System.out.print("단 수 : ");

        int n = stdIn.nextInt();

        npira(n);
    }
    static void npira(int n){
        for(int i = 1; i <= n; i++){
            printSpace(n-i);
            printN(i);
            printSpace(n-i);
            System.out.println();
        }
    }

    static void printN(int n) {
        for (int i = 0; i < (n * 2) - 1; i++)
            System.out.print(n);
    }

    static void printSpace(int n) {
        for (int i = 0; i < n; i++)
            System.out.print(" ");
    }
}
