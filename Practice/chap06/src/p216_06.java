import java.util.Scanner;

public class p216_06 {
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


    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void selectionSort(int[] a, int n){
        for(int i = 0; i < n - 1; i++){
            int min = i;
            for(int j = i + 1; j < n; j++){
                if(a[j] < a[min])
                    min = j;
            }
            print(a, i, min);
            swap(a, i, min);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("Selection Sort");
        System.out.print("Number of items : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        selectionSort(x, nx);

        System.out.println("Ascending ordered.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
