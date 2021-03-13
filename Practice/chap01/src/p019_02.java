public class p019_02 {
    public static void main(String[] args) {
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                for (int c = 1; c <= 3; c++) {
                    System.out.printf("%d %d %d | min: %d\n", a, b, c, min3(a, b, c));

                }
            }
        }
    }

    static int min3(int a, int b, int c) {
        int min = a;

        if (b < min) min = b;
        if (c < min) min = c;

        return min;
    }

}
