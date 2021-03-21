import java.util.Scanner;

public class p117_03 {
    static int searchIdx(int[] a, int n, int key, int[] idxArr) {
        int idxArrIdx = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == key)
                idxArr[idxArrIdx++] = i;
        }
        return idxArrIdx;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];
        int[] idxArray = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();
        int idxNum = searchIdx(x, num, ky, idxArray);

        System.out.println(idxNum + "개의 일치하는 요소가 존재합니다.");
        for (int i = 0; i < idxNum; i++) {
            System.out.println(idxArray[i]);
        }
    }
}
