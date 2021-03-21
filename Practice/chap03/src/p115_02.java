import java.util.Scanner;

public class p115_02 {
    static private class seqSearchPrinter{
        static void printHeader(int[] a){
            System.out.print("   |");
            for (int i = 0; i < a.length ; i ++){
                System.out.printf("%3d", i);
            }
            System.out.println();

            System.out.print("---+---");
            for (int i = 0; i < a.length ; i ++){
                System.out.print("---");
            }
            System.out.println();
        }

        static void printRow(int[] a , int idx){
            System.out.print("   |");
            for (int i = 0; i < a.length ; i ++){
                if (i == idx)
                    System.out.print("  *");
                else
                    System.out.print("   ");
            }
            System.out.println();

            System.out.printf("%3d|", idx);
            for (int i = 0; i < a.length ; i ++){
                System.out.printf("%3d", a[i]);
            }
            System.out.println("\n   |");
        }
    }

    static int seqSearch(int[] a, int n, int key){
        seqSearchPrinter.printHeader(a);

        for(int i = 0 ; i < n; i++){
            seqSearchPrinter.printRow(a, i);
            if(a[i] == key)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++){
            System.out.print("x["+i+"] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();
        int idx = seqSearch(x, num, ky);

        if(idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky + "은(는) x["+idx+"]에 있습니다.");
    }
}
