public class p019_01 {
    public static void main(String[] args) {
        for (int a = 1; a <= 4; a++) {
            for (int b = 1; b <= 4; b++) {
                for (int c = 1; c <= 4; c++) {
                    for (int d = 1; d <= 4; d++) {
                        System.out.printf("%d %d %d %d | max: %d\n", a, b, c, d, max4(a, b, c, d));
                    }
                }
            }
        }
    }

    static int max4(int a, int b, int c, int d) {
        int max = a;

        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;

        return max;
    }

}
