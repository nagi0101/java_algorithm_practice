import com.sun.tools.jconsole.JConsoleContext;

import javax.annotation.processing.Generated;
import java.util.Scanner;

public class p182_05S {
    static void recur3(int n) {
        if (n > 0) {
            recur3(n - 1);
            recur3(n - 2);
            System.out.print(n + " ");
        }
    }

    static void recurX3R(int n) {
        int[] nstk = new int[100];
        int[] sstk = new int[100];
        int ptr = -1;
        int sw = 0;

        while (true) {
            if (n > 0) {
                ptr++;
                nstk[ptr] = n;
                sstk[ptr] = sw;

                if (sw == 0)
                    n = n - 1;
                else if (sw == 1) {
                    n = n - 2;
                    sw = 0;
                }
                continue;
            }
            do {
                n = nstk[ptr];
                nstk[ptr] = Integer.MIN_VALUE;
                sw = sstk[ptr] + 1;
                sstk[ptr] = Integer.MIN_VALUE;
                ptr--;

                if (sw == 2) {
                    System.out.print(n + " ");
                    if (ptr < 0)
                        return;
                }
            } while (sw == 2);
        }
    }

    enum RecurState {
        RS_NONE,
        RS_FIRST_RECUR,
        RS_SECOND_RECUR,
        RS_PRINT
    }

    static void recurX3(int n) {
        IntStateStack s = new IntStateStack(100);

        while (n > 0) {
            s.push(n, RecurState.RS_FIRST_RECUR);
            n--;
        }

        while (true) {
            StackItem item = s.pop();

            int itemData = item.getData();
            RecurState itemState = item.getState();

            switch (itemState) {
                case RS_FIRST_RECUR -> {
                    if (itemData > 1) {
                        s.push(itemData, RecurState.RS_FIRST_RECUR);
                        s.push(itemData - 1, RecurState.RS_FIRST_RECUR);
                    } else {
                        s.push(itemData, RecurState.RS_PRINT);
                    }
                    continue;
                }
                case RS_SECOND_RECUR -> {
                    s.push(itemData, RecurState.RS_PRINT);
                    if (itemData > 2) {
                        s.push(itemData - 2, RecurState.RS_FIRST_RECUR);
                    }
                    continue;
                }
                case RS_PRINT -> {
                    if (itemData > 0)
                        System.out.print(itemData + " ");
                    if (s.isEmpty()) break;
                    item = s.pop();
                    itemData = item.getData();
                    itemState = item.getState();
                    itemState = (itemState == RecurState.RS_FIRST_RECUR) ? RecurState.RS_SECOND_RECUR : RecurState.RS_PRINT;
                    s.push(itemData, itemState);
                    continue;
                }
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
        recurX3R(n);
        System.out.println();
        recurX3(n);
    }

    static class StackItem {
        int data;
        RecurState state;

        StackItem(int data, RecurState state) {
            this.data = data;
            this.state = state;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public RecurState getState() {
            return state;
        }

        public void setState(RecurState state) {
            this.state = state;
        }
    }

    static class IntStateStack {

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

        public StackItem push(int x, RecurState state) throws OverflowIntStackException {
            if (ptr >= max)
                throw new OverflowIntStackException();
            return stk[ptr++] = new StackItem(x, state);
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

        public IntStateStack(int capacity) {
            ptr = 0;
            max = capacity;
            try {
                stk = new StackItem[max];
            } catch (OutOfMemoryError e) {
                max = 0;
            }
        }
    }
}
