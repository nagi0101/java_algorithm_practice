import java.util.Scanner;

public class p182_07S {
    static void move(int no, int x, int y) {
        if (no > 1)
            move(no - 1, x, 6 - x - y);
        System.out.println("Move " + no + "'th plate from " + x + " to " + y);

        if (no > 1)
            move(no - 1, 6 - x - y, y);
    }

    static void moveX(int no, int x, int y) {
        PlateStack stack = new PlateStack(100);

        while (true) {
            stack.push(no, x, y, RecurState.RS_FIRST_RECUR);

            while (true) {
                if (stack.isEmpty()) {
                    break;
                }
                StackItem item = stack.pop();
                no = item.getPlateNum();
                x = item.getFrom();
                y = item.getTo();
                RecurState state = item.getState();

                switch (state) {
                    case RS_FIRST_RECUR -> {
                        stack.push(no, x, y, RecurState.RS_PRINT);
                        if (no > 1) {
                            stack.push(no - 1, x, 6 - x - y, RecurState.RS_FIRST_RECUR);
                        }
                    }
                    case RS_PRINT -> {
                        System.out.println("Move " + no + "'th plate from " + x + " to " + y);
                        if (no > 1)
                            stack.push(no, x, y, RecurState.RS_SECOND_RECUR);
                    }
                    case RS_SECOND_RECUR -> {
                        if (no > 1)
                            stack.push(no - 1, 6 - x - y, y, RecurState.RS_FIRST_RECUR);
                    }
                }
            }
            if (stack.isEmpty())
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

        public int push(int x) throws p182_07S.IntStack.OverflowIntStackException {
            if (ptr >= max)
                throw new p182_07S.IntStack.OverflowIntStackException();
            return stk[ptr++] = x;
        }

        public int pop() throws p182_07S.IntStack.EmptyIntStackException {
            if (ptr <= 0)
                throw new p182_07S.IntStack.EmptyIntStackException();
            return stk[--ptr];
        }

        public int peek() throws p182_07S.IntStack.EmptyIntStackException {
            if (ptr <= 0)
                throw new p182_07S.IntStack.EmptyIntStackException();
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

    static class StackItem {
        int plateNum;
        int from;
        int to;
        RecurState state;

        public StackItem(int plateNum, int from, int to, RecurState state) {
            this.plateNum = plateNum;
            this.from = from;
            this.to = to;
            this.state = state;
        }

        public int getPlateNum() {
            return plateNum;
        }

        public void setPlateNum(int plateNum) {
            this.plateNum = plateNum;
        }

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public RecurState getState() {
            return state;
        }

        public void setState(RecurState state) {
            this.state = state;
        }
    }

    enum RecurState {
        RS_NONE,
        RS_FIRST_RECUR,
        RS_PRINT,
        RS_SECOND_RECUR,
    }

    static class PlateStack {

        private int max;
        private int ptr;
        private StackItem[] stk;

        public class EmptyIntStackException extends RuntimeException {
            public EmptyIntStackException() {
            }
        }

        public class OverflowIntStackException extends RuntimeException {
            public OverflowIntStackException() {
            }
        }

        public StackItem push(int plateNum, int from, int to, RecurState state) throws OverflowIntStackException {
            if (ptr >= max)
                throw new OverflowIntStackException();
            return stk[ptr++] = new StackItem(plateNum, from, to, state);
        }

        public StackItem pop() throws EmptyIntStackException {
            if (ptr <= 0)
                throw new EmptyIntStackException();
            StackItem returnValue = stk[--ptr];
            stk[ptr] = null;
            return returnValue;
        }

        public StackItem peek() throws EmptyIntStackException {
            if (ptr <= 0)
                throw new EmptyIntStackException();
            return stk[ptr - 1];
        }

        public boolean isEmpty() {
            return ptr <= 0;
        }

        public boolean isFull() {
            return ptr >= max;
        }

        public PlateStack(int capacity) {
            ptr = 0;
            max = capacity;
            try {
                stk = new StackItem[max];
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
        moveX(n, 1, 3);
    }
}
