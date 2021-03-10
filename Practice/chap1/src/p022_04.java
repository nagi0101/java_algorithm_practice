public class p022_04 {
    public static void main(String[] args) {
        for (int i = 1; i <=3 ; i++){
            for(int j = i; j<=3; j++){
                for(int k = 1; k <=3; k++){
                        System.out.printf("median(%d, %d, %d) = %d\n", i, j, k, median(i,j,k));
                }
            }
        }
    }

    static int median(int a, int b, int c) {
        int median;

        if (a > b) {
            if (c > a)
                median = a;
            else {
                if (b > c)
                    median = b;
                else
                    median = c;
            }
        } else {
            // b >= a
            if (c > b)
                median = b;
            else {
                // b > c
                if (a > c)
                    median = a;
                else
                    median = c;
            }
        }

        return median;
    }
}
