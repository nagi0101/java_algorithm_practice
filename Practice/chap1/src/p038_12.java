public class p038_12 {
    public static void main(String[] args) {
        printHeader();
        for (int i = 1; i <= 9; i++) printLine(i);
    }

    static void printHeader() {
        System.out.print("  |");
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        System.out.print("--+");
        for (int i = 0; i < 9; i++) System.out.print("---");
        System.out.println();
    }

    static void printLine(int n) {
        System.out.printf("%-2d|", n);
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%3d", i * n);
        }
        System.out.println();
    }
}
