import java.util.Scanner;

public class p170_01 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("Input positive integer : ");
        int x = stdIn.nextInt();

        System.out.println(x + "! is " + factorial(x));
    }

    private static int factorial(int n){
        int factorial = 1;
        while(n > 0){
            factorial *= n--;
        }
        return  factorial;
    }

}
