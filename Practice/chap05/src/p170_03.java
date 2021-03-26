import java.util.Scanner;

public class p170_03 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("How long is your array? : ");
        int arrLen = stdIn.nextInt();

        int[] arr = new int[arrLen];

        for (int i = 0; i < arrLen; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = stdIn.nextInt();
        }

        System.out.println("GCD of Array : " + gcdArray(arr));
    }

    static int getIndexOfMinimumNumberExceptZero(int[] a) {
        int minIndex = 0;
        // Get index of first number not 0
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                minIndex = i;
                break;
            }
        }
        // Get index of minimum number except zero
        for (int i = minIndex + 1; i < a.length; i++) {
            if (a[i] < a[minIndex] && a[i] != 0) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    static int getIndexOfMaximumNumber(int[] a) {
        int maxIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > a[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }

    static int gcdArray(int[] a) {
        if (a.length < 2)
            return -1;

        // Initialize minIndex as index of minimum number not 0 in array
        // to avoid zero division error
        int minIndex = getIndexOfMinimumNumberExceptZero(a);
        int maxIndex = getIndexOfMaximumNumber(a);

        // If maxIndex == minIndex, indexed number is the only number not 0 in array
        if (maxIndex == minIndex) {
            return a[maxIndex];
        }else if(a[minIndex] == 1){
            // If a[minIndex] is 1, GCD is 1.
            return a[minIndex];
        }

        a[maxIndex] %= a[minIndex];

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        return gcdArray(a);
    }
}
