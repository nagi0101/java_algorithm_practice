import java.util.Scanner;

public class p239_13 {
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

        public int push(int x) throws IntStack.OverflowIntStackException {
            if (ptr >= max)
                throw new IntStack.OverflowIntStackException();
            return stk[ptr++] = x;
        }

        public int pop() throws IntStack.EmptyIntStackException {
            if (ptr <= 0)
                throw new IntStack.EmptyIntStackException();
            return stk[--ptr];
        }

        public int peek() throws IntStack.EmptyIntStackException {
            if (ptr <= 0)
                throw new IntStack.EmptyIntStackException();
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

    static void insertionSort(int[] a, int left, int right) {
        System.out.println("Insertion Sort!");
        for (int i = left; i < right; i++) {
            int j;
            int tmp = a[i];
            for (j = i; j > 0 && a[j - 1] > tmp; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    static void quickSort1(int[] a, int left, int right) {
        if ((right - left + 1) <= 9) {
            insertionSort(a, left, right);
            return;
        }
        int pl = left;
        int pr = right;
        int x = a[(pl + pr) / 2];

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if ((pr - left) > (right - pl)) {
            if (left < pr) quickSort1(a, left, pr);
            if (pl < right) quickSort1(a, pl, right);
        } else {
            if (pl < right) quickSort1(a, pl, right);
            if (left < pr) quickSort1(a, left, pr);
        }
    }

    static void quickSort2(int[] a, int left, int right) {
        if ((right - left + 1) <= 9) {
            insertionSort(a, left, right);
            return;
        }
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (!lstack.isEmpty()) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int x = a[(left + right) / 2];

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);

            if (left < pr) {
                lstack.push(left);
                rstack.push(pr);
            }
            if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
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
