public class ArraySumForIn {
    public static void main(String[] args) {
        double[] a = {1.f, 2.f, 3.f, 4.f, 5.f};

        for (int i = 0; i < a.length; i++)
            System.out.println("a[" + i + "] = " + a[i]);

        double sum = 0;

        for (double i : a)
            sum += i;

        System.out.println("모든 요소의 합은 " + sum + "입니다.");
    }
}
