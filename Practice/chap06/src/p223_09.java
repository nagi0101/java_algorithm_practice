import java.util.Arrays;
import java.util.Scanner;

public class p223_09 {
    static void shellSort1(int[] a, int n) {
        int moveCount = 0;
        for (int h = n / 2; h > 0; h /= 2)
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    moveCount++;
                    a[j + h] = a[j];
                }
                moveCount++;
                a[j + h] = tmp;
            }
        System.out.println("shellSort1 moveCount : " + moveCount);
    }

    static void shellSort2(int[] a, int n) {
        int moveCount = 0;
        int h;
        for (h = 1; h < n / 9; h = h * 3 + 1) ;

        for (; h > 0; h /= 3)
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    moveCount++;
                    a[j + h] = a[j];
                }
                moveCount++;
                a[j + h] = tmp;
            }
        System.out.println("shellSort2 moveCount : " + moveCount);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("Shell Sort(v1, v2)");
        System.out.print("Number of items : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

//        for (int i = 0; i < nx; i++) {
//            System.out.print("x[" + i + "] : ");
//            x[i] = stdIn.nextInt();
//        }
        for(int i = 0; i < nx; i++){
            x[i] = (int)(Math.random()*100);
        }

        int[] y = Arrays.copyOf(x, nx);

        shellSort1(x, nx);
        shellSort2(y, nx);

        System.out.println("Ascending ordered.");
//        for (int i = 0; i < nx; i++)
//            System.out.println("x[" + i + "] = " + x[i]);
    }
}
