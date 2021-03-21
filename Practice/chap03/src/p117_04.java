import java.util.Scanner;

public class p117_04 {
    static private class binSearchPrinter{
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

        static void printRow(int[] a , int pc, int pl, int pr){
            System.out.print("   |");
            for (int i = 0; i < a.length ; i ++){
                if (i == pc)
                    System.out.print("  +");
                else if(i == pl)
                    System.out.print(" <-");
                else if(i == pr){
                    System.out.print("  ->");
                    break;
                }
                else
                    System.out.print("   ");
            }
            System.out.println();

            System.out.printf("%3d|", pc);
            for (int i = 0; i < a.length ; i ++){
                System.out.printf("%3d", a[i]);
            }
            System.out.println("\n   |");
        }
    }

    static int binSearch(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        binSearchPrinter.printHeader(a);

        do {
            int pc = (pl + pr) / 2;
            binSearchPrinter.printRow(a, pc, pl, pr);
            if (a[pc] == key)
                return pc;
            else if (a[pc] < key)
                pl = pc + 1;
            else
                pr = pc - 1;
        } while (pl <= pr);

        return -1;
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

        int idx = binSearch(x, num, ky);

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
    }
}
