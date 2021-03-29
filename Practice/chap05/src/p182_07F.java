import java.util.Scanner;

public class p182_07F {
    static void move(int no, int x, int y) {
        if (no > 1)
            move(no - 1, x, 6 - x - y);
        System.out.println("Move " + no + "'th plate from " + x + " to " + y);

        if (no > 1)
            move(no - 1, 6 - x - y, y);
    }

    static void moveNotRecur(int no, int x, int y){
        IntStack sNo = new IntStack(no);
        IntStack sX = new IntStack(no);
        IntStack sY = new IntStack(no);
        while (true) {
            if (no > 1) {
                sNo.push(--no);
                sX.push(x);
                sY.push(y);
                y = 6 - x - y;
                continue;
            }
            // no == 1;
            System.out.println("Move " + no + "'th plate from " + x + " to " + y);
            if (!sNo.isEmpty()) {
                int noTemp = no;
                int xTemp = x;
                int yTemp = y;
                no = sNo.pop();
                x = sX.pop();
                y = sY.pop();
                System.out.println("Move " + no + "'th plate from " + x + " to " + y);
                System.out.println("Move " + noTemp + "'th plate from " + yTemp + " to " + (6 - xTemp - yTemp));
            }

            break;
        }
    }

    static class IntStack {
        private int max;
        private int ptr;
        private int[] stk;

        public static class EmptyIntStackException extends RuntimeException {
            public EmptyIntStackException() {
            }

            ;
        }

        public static class OverflowIntStackException extends RuntimeException {
            public OverflowIntStackException() {
            }

            ;
        }

        public int push(int x) throws p182_07F.IntStack.OverflowIntStackException {
            if (ptr >= max)
                throw new p182_07F.IntStack.OverflowIntStackException();
            return stk[ptr++] = x;
        }

        public int pop() throws p182_07F.IntStack.EmptyIntStackException {
            if (ptr <= 0)
                throw new p182_07F.IntStack.EmptyIntStackException();
            return stk[--ptr];
        }

        public int peek() throws p182_07F.IntStack.EmptyIntStackException {
            if (ptr <= 0)
                throw new p182_07F.IntStack.EmptyIntStackException();
            return stk[ptr - 1];
        }

        public int indexOf(int x) {
            for (int i = ptr - 1; i >= 0; i--)
                if (stk[i] == x)
                    return i;
            return -1;
        }

        public void clear() {
            ptr = 0;
        }

        public int capacity() {
            return max;
        }

        public int size() {
            return ptr;
        }

        public boolean isEmpty() {
            return ptr <= 0;
        }

        public boolean isFull() {
            return ptr >= max;
        }

        public void dump() {
            if (ptr <= 0)
                System.out.println("스택이 비어 있습니다.");
            else {
                for (int i = 0; i < ptr; i++)
                    System.out.println(stk[i] + " ");
                System.out.println();
            }
        }

        public IntStack(int capacity) {
            ptr = 0;
            max = capacity;
            try {
                stk = new int[max];
            } catch (OutOfMemoryError e) {
                max = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수 : ");
        int n = stdIn.nextInt();

        move(n, 1, 3);
        System.out.println();
        moveNotRecur(n, 1, 3);
    }
}
