public class p019_03 {
    public static void main(String[] args) {
        for (int a = 1; a <= 4; a++) {
            for (int b = 1; b <= 4; b++) {
                for (int c = 1; c <= 4; c++) {
                    for (int d = 1; d <= 4; d++) {
                        System.out.printf("%d %d %d %d | min: %d\n", a, b, c, d, min4(a, b, c, d));
                    }
                }
            }
        }
    }

    static int min4(int a, int b, int c, int d) {
        int min = a;

        if (b < min) min = b;
        if (c < min) min = c;
        if (d < min) min = d;

        return min;
    }
}
