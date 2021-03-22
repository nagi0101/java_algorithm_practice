import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());

            System.out.print("(1)push (2)pop (3)peek (4)dump (0)exit : ");
            int menu = stdIn.nextInt();
            if (menu == 0)
                break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("Stack is FULL!");
                    }
                    break;

                case 2:
                    try {
                        x = s.pop();
                        System.out.println("Popped data is " + x);
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("Stack is EMPTY!");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("Peeked data is " + x);
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("Stack is EMPTY!");
                    }
                    break;

                case 4:
                    s.dump();
                    break;
            }
        }
    }
}
