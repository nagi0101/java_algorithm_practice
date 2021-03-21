import java.util.Scanner;

public class p117_05 {
    static int binSearchX(int[] a, int n, int key) {
        int bottom = 0;
        int top = n - 1;
        int index;

        while (true) {
            int middle = (bottom + top) / 2;

            if (a[middle] < key)
                bottom = middle + 1;
            else if (a[middle] > key)
                top = middle - 1;
            else { // a[middle] == key
                while (a[middle] == a[--middle]) ;
                index = middle + 1;
                break;
            }

            if (bottom > top) {
                index = -1;
                break;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요 : ");

        System.out.print("x[0] : ");
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);
        }

        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();

        int idx = binSearchX(x, num, ky);

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
    }
}

