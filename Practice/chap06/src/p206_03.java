import java.util.Scanner;

public class p206_03 {
    enum PRINT_MODE{
        PM_NSWAP,
        PM_SWAP,
    }

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void printRow(int[] a, int idx, PRINT_MODE pm){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]);
            if(i == idx - 1){
                switch(pm){
                    case PM_NSWAP -> {
                        System.out.print(" - ");
                    }
                    case PM_SWAP -> {
                        System.out.print(" + ");
                    }
                }
            }else {
                System.out.print("   ");
            }
        }
        System.out.println();
    }

    static void bubbleSort(int[] a, int n) {
        int compareCounter = 0;
        int swapCounter = 0;
        for (int i = 0; i < n - 1; i++) {
            int exchg = 0;
            System.out.println("Pass "+ (i + 1));
            for (int j = n - 1; j > i; j--) {
                compareCounter++;
                if (a[j - 1] > a[j]) {
                    swapCounter++;
                    printRow(a, j, PRINT_MODE.PM_SWAP);
                    swap(a, j - 1, j);
                    exchg++;
                }else
                    printRow(a, j, PRINT_MODE.PM_NSWAP);
            }
            if (exchg == 0) break;
        }

        System.out.println(compareCounter+" times of comparing");
        System.out.println(swapCounter + " times of swapping");
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

        bubbleSort(x, nx);

        System.out.println("Ascending ordered.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
