import java.util.Scanner;

public class p208_05 {
    enum PRINT_MODE {
        PM_NSWAP,
        PM_SWAP,
    }

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void printRow(int[] a, int idx, PRINT_MODE pm) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%3d", a[i]);
            if (i == idx - 1) {
                switch (pm) {
                    case PM_NSWAP -> {
                        System.out.print(" - ");
                    }
                    case PM_SWAP -> {
                        System.out.print(" + ");
                    }
                }
            } else {
                System.out.print("   ");
            }
        }
        System.out.println();
    }

    static void bubbleSort(int[] a, int n) {
        int compareCounter = 0;
        int swapCounter = 0;
        int PassCounter = 0;
        int top = n - 1;
        int bottom = 0;
        while (top > bottom) {
            System.out.println("Pass " + ++PassCounter);
            int last;
            if (PassCounter % 2 == 1) {
                last = bottom;
                System.out.println(top + " to " + bottom);
                for (int j = top; j > bottom; j--) {
                    compareCounter++;
                    if (a[j - 1] > a[j]) {
                        swapCounter++;
                        printRow(a, j, PRINT_MODE.PM_SWAP);
                        swap(a, j - 1, j);
                        last = j;
                    } else
                        printRow(a, j, PRINT_MODE.PM_NSWAP);
                }
                if (bottom == last)
                    break;
                bottom = last;
            } else { // PassCounter % 2 == 0
                last = top;
                System.out.println(bottom + " to " + top);
                for (int j = bottom; j < top; j++) {
                    compareCounter++;
                    if (a[j + 1] < a[j]) {
                        swapCounter++;
                        printRow(a, j + 1, PRINT_MODE.PM_SWAP);
                        swap(a, j + 1, j);
                        last = j;
                    } else
                        printRow(a, j + 1, PRINT_MODE.PM_NSWAP);
                }
                if (top == last)
                    break;
                top = last;
            }
        }
        System.out.println(compareCounter + " times of comparing");
        System.out.println(swapCounter + " times of swapping");
    }

    static void bubbleSortClean(int[] a, int n) {
        int PassCounter = 0;
        int top = n - 1;
        int bottom = 0;
        while (top > bottom) {
            ++PassCounter;
            int last;
            if (PassCounter % 2 == 1) {
                last = bottom;
                for (int j = top; j > bottom; j--) {
                    if (a[j - 1] > a[j]) {
                        printRow(a, j, PRINT_MODE.PM_SWAP);
                        swap(a, j - 1, j);
                        last = j;
                    }
                }
                if (bottom == last)  // If none of items swapped
                    break;
                bottom = last;
            } else { // PassCounter % 2 == 0
                last = top;
                for (int j = bottom; j < top; j++) {
                    if (a[j + 1] < a[j]) {
                        swap(a, j + 1, j);
                        last = j;
                    }
                }
                if (top == last)     // If none of items swapped
                    break;
                top = last;
            }
        }
    }


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("Bubble Sort(v3)");
        System.out.print("Number of items : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, nx);

        System.out.println("Ascending ordered.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
