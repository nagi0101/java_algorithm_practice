import java.util.Scanner;

public class p182_05 {
    static void recur3(int n) {
        if (n > 0) {
            recur3(n - 1);
            recur3(n - 2);
            System.out.print(n + " ");
        }
    }

    static void recurX3(int n) {
        IntStack s = new IntStack(n);

        while (true) {
            if (n > 0) {
//                System.out.println("push "+n+" to s");
                s.push(n--);
                continue;
            }
            if (!s.isEmpty()) {
                n = s.pop();
//                System.out.println("pop "+n+" from s");
                System.out.print(n + " ");
                n--;
                continue;
            }
            while (!s.isEmpty()){
                int i = s.pop();
                System.out.print(i + " ");
            }
            break;
        }
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        System.out.print("n : ");
        int n = stdin.nextInt();

        recur3(n);
        System.out.println();
        recurX3(n);
    }

    static class IntStack {
        private int max;
        private int ptr;
        private int[] stk;

        public class EmptyIntStackException extends RuntimeException {
            public EmptyIntStackException() {
            }

            ;
        }

        public class OverflowIntStackException extends RuntimeException {
            public OverflowIntStackException() {
            }

            ;
        }

        public int push(int x) throws OverflowIntStackException {
            if (ptr >= max)
                throw new OverflowIntStackException();
            return stk[ptr++] = x;
        }

        public int pop() throws EmptyIntStackException {
            if (ptr <= 0)
                throw new EmptyIntStackException();
            return stk[--ptr];
        }

        public int peek() throws EmptyIntStackException {
            if (ptr <= 0)
                throw new EmptyIntStackException();
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
}
