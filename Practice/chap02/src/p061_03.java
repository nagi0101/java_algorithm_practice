public class p061_03 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};

        System.out.println(sumOf(a));
    }

    static int sumOf(int[] a){
        int sum = 0;

        for(int i : a)
            sum += i;

        return sum;
    }
}
