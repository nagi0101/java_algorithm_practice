import java.util.Arrays;
import java.util.Scanner;

public class p216_08 {
    static void printMarker(int[] a, int firstUnsortedItemIndex, int minimumItemIndex){
        for(int i = 0; i < a.length; i++) {
            if (i == firstUnsortedItemIndex) {
                System.out.print("*  ");
            } else if (i == minimumItemIndex) {
                System.out.print("+  ");
            } else {
                System.out.print("   ");
            }
        }
        System.out.println();
    }

    static void print(int[]a, int firstUnsortedItemIndex, int minimumItemIndex){
        printMarker(a, firstUnsortedItemIndex, minimumItemIndex);
        for (int i : a) {
            System.out.printf("%-3d", i);
        }
        System.out.println();
    }

    static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int tmp = a[i];
            int insertIdx =
                    -(Arrays.binarySearch(
                            Arrays.copyOfRange(a, 0, i), a[i]
                    ) + 1);
            insertIdx =  insertIdx < 0 ? -(insertIdx + 1) : insertIdx;
            print(a, i, insertIdx);

            for (int j = i; j > insertIdx; j--) {
                a[j] = a[j - 1];
            }
            a[insertIdx] = tmp;

        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("Bubble Sort(v1)");
        System.out.print("Number of items : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        insertionSort(x, nx);

        System.out.println("Ascending ordered.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
