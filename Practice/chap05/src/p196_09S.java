// Solved with key...
// Have to solve again

public class p196_09S {
    static boolean[] flag_a = new boolean[8];
    static boolean[] flag_b = new boolean[15];
    static boolean[] flag_c = new boolean[15];
    static int[] pos = new int[8];

    static void print() {
        for (int i = 0; i < 8; i++)
            System.out.printf("%2d", pos[i]);
        System.out.println();
    }


    static void setX(int ptr) {
        int counter = 0;
        int j;
        IntStack s = new IntStack(8);

        Start:
        while (true) {
            j = 0;
            while (true) {
                while (j < 8) {
                    if (!flag_a[j] && !flag_b[ptr + j] && !flag_c[ptr - j + 7]) {
                        pos[ptr] = j;
                        if (ptr == 7) {
                            counter++;
                            print();
                        } else {
                            flag_a[j] = flag_b[ptr + j] = flag_c[ptr - j + 7] = true;
                            s.push(j);
                            ptr++;
                            continue Start;
                        }
                    }
                    j++;
                }
                if (s.isEmpty()) {
                    System.out.println(counter);
                    return;
                }
                ptr--;
                j = s.pop();
                flag_a[j] = flag_b[ptr + j] = flag_c[ptr - j + 7] = false;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        setX(0);
    }

    static class IntStack {
        private int max;
        private int ptr;
        private int[] stk;

        public static class EmptyIntStackException extends RuntimeException {
            public EmptyIntStackException() {
            }
        }

        public static class OverflowIntStackException extends RuntimeException {
            public OverflowIntStackException() {
            }
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
}
