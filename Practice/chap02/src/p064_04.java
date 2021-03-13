public class p064_04 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int[] b = {10, 20, 30, 40, 50, 60};

        copy(a, b);

        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }

    static void copy(int[] a, int[] b) {
        int copyLength = a.length > b.length ? b.length : a.length;

        for (int i = 0; i < copyLength; i++)
            a[i] = b[i];
    }
}
