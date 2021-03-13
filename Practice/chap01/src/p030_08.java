import java.util.Scanner;

public class p030_08 {
    public static void main(String[] args) {
        int sum = 0;
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 top까지의 합을 출력합니다.");

        // System.out.print("bottom : ");
        // int bottom = stdIn.nextInt();

        System.out.print("top : ");
        int top = stdIn.nextInt();

        sum = gaussPlus(top);

        System.out.println(1 + "부터 " + top + "까지의 합은 " + sum + "입니다.");

    }


    // gaussPlus for add {bottom} to {top}
    static int gaussPlus(int bottom, int top) {
        int distance = top - bottom + 1; // Count of numbers we have to calculate
        int sum = (bottom + top) * (distance / 2);

        if (distance % 2 == 1) {
            // If (median number has no pair) => add median number to sum.
            sum += (bottom + top) / 2;
        }

        return sum;
    }

    // gaussPlus for add 1 to {top}
    static int gaussPlus(int top) {
        int distance = top; // Count of numbers we have to calculate
        int sum = (1 + top) * (distance / 2);

        if (distance % 2 == 1) {
            // If (median number has no pair) => add median number to sum.
            sum += (1 + top) / 2;
        }

        return sum;
    }

}
