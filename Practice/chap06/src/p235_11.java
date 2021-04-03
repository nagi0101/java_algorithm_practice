import java.util.Scanner;

public class p235_11 {
    static class IntStack {
        private int max;
        private int ptr;
        private int[] stk;

        static public class EmptyIntStackException extends RuntimeException {
            public EmptyIntStackException() {
            }

            ;
        }

        static public class OverflowIntStackException extends RuntimeException {
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

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort2(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);
        System.out.printf("push {%d, %d}\n", left, right);

        while (!lstack.isEmpty()) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            System.out.printf("pop {%d, %d}\n", left, right);
            int x = a[(left + right) / 2];

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);
            System.out.printf("split [%d, %d], [%d, %d]\n", left, pr, pl, right);

            if (left < pr) {
                lstack.push(left);
                rstack.push(pr);
                System.out.printf("push {%d, %d}\n", left, pr);
            }
            if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
                System.out.printf("push {%d, %d}\n", pl, right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("Number of items : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            x[i] = (int) (Math.random() * 100);
        }

        System.out.print("Before : ");
        for (int i : x)
            System.out.printf("%2d ", i);
        System.out.println();

        quickSort2(x, 0, nx - 1);

        System.out.println("Ascending ordered.");
        System.out.print("After  : ");
        for (int i : x)
            System.out.printf("%2d ", i);
    }
}
