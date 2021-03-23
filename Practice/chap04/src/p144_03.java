import java.util.Scanner;

class MultipleIntStack {
    private int max;
    private int ptrBrother;
    private int ptrSister;
    private int[] stk;

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
        }
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {
        }
    }

    public int capacity() {
        return max;
    }

    public int totalSize(){
        return ptrSister + ptrBrother;
    }

    public void printGauge(){
        for (int i = 0; i < ptrBrother; i++)
            System.out.print('■');
        System.out.print('|');
        for (int i = 0; i < max - this.totalSize(); i++)
            System.out.print('□');
        System.out.print('|');
        for (int i = 0; i < ptrSister; i++)
            System.out.print('■');
        System.out.println();
    }

    public int pushToBrother(int x) throws OverflowIntStackException {
        if (ptrBrother + ptrSister >= max)
            throw new OverflowIntStackException();
        return stk[ptrBrother++] = x;
    }

    public int popBrother() throws EmptyIntStackException {
        if (ptrBrother <= 0)
            throw new EmptyIntStackException();
        return stk[--ptrBrother];
    }

    public int peekBrother() throws EmptyIntStackException {
        if (ptrBrother <= 0)
            throw new EmptyIntStackException();
        return stk[ptrBrother - 1];
    }

    public int indexOfBrother(int x) {
        for (int i = ptrBrother - 1; i >= 0; i--)
            if (stk[i] == x)
                return i;
        return -1;
    }

    public void clearBrother() {
        ptrBrother = 0;
    }

    public int sizeOfBrother() {
        return ptrBrother;
    }

    public boolean isBrotherEmpty() {
        return ptrBrother <= 0;
    }

    public boolean isBrotherFull() {
        return ptrBrother >= max;
    }

    public void dumpBrother() {
        if (ptrBrother <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = 0; i < ptrBrother; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }

    public int pushToSister(int x) throws OverflowIntStackException {
        if (ptrBrother + ptrSister >= max)
            throw new OverflowIntStackException();
        return stk[max - ++ptrSister] = x;
    }

    public int popSister() throws EmptyIntStackException {
        if (ptrSister <= 0)
            throw new EmptyIntStackException();
        return stk[max - --ptrSister];
    }

    public int peekSister() throws EmptyIntStackException {
        if (ptrSister <= 0)
            throw new EmptyIntStackException();
        return stk[max - ptrSister];
    }

    public int indexOfSister(int x) {
        for (int i = ptrSister - 1; i >= 0; i--)
            if (stk[max - i - 1] == x)
                return i;
        return -1;
    }

    public void clearSister() {
        ptrSister = 0;
    }

    public int sizeOfSister() {
        return ptrSister;
    }

    public boolean isSisterEmpty() {
        return ptrSister <= 0;
    }

    public boolean isSisterFull() {
        return ptrSister >= max;
    }

    public void dumpSister() {
        if (ptrSister <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = 0; i < ptrSister; i++)
                System.out.print(stk[max - i - 1] + " ");
            System.out.println();
        }
    }

    public MultipleIntStack(int capacity) {
        ptrBrother = 0;
        ptrSister = 0;
        max = capacity;
        try {
            stk = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }
}

public class p144_03 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        MultipleIntStack s = new MultipleIntStack(7);

        while (true) {
            System.out.println("현재 데이터 수 : ");
            s.printGauge();
            System.out.println("Brother : "+s.sizeOfBrother() + " / " + s.capacity());
            System.out.println("Sister : "+s.sizeOfSister() + " / " + s.capacity());
            System.out.println("Total : "+s.totalSize() + " / " + s.capacity());




            System.out.print("(1)push (2)pop (3)peek (4)dump (5)clear (6)indexOf (0)exit : ");
            int menu = stdIn.nextInt();
            if (menu == 0)
                break;

            System.out.print("(1)Brother (2)Sister : ");
            int target = stdIn.nextInt();

            int x;
            switch (target){
                case 1:
                    switch (menu) {
                        case 1:
                            System.out.print("데이터 : ");
                            x = stdIn.nextInt();
                            try {
                                s.pushToBrother(x);
                            } catch (MultipleIntStack.OverflowIntStackException e) {
                                System.out.println("Stack is FULL!");
                            }
                            break;

                        case 2:
                            try {
                                x = s.popBrother();
                                System.out.println("Popped data is " + x);
                            } catch (MultipleIntStack.EmptyIntStackException e) {
                                System.out.println("Stack is EMPTY!");
                            }
                            break;

                        case 3:
                            try {
                                x = s.peekBrother();
                                System.out.println("Peeked data is " + x);
                            } catch (MultipleIntStack.EmptyIntStackException e) {
                                System.out.println("Stack is EMPTY!");
                            }
                            break;

                        case 4:
                            s.dumpBrother();
                            break;

                        case 5:
                            s.clearBrother();
                            break;

                        case 6:
                            System.out.print("데이터 : ");
                            x = stdIn.nextInt();
                            int result = s.indexOfBrother(x);
                            if(result >= 0){
                                System.out.println(x+" is in "+result);
                            }else{
                                System.out.println("해당하는 데이터가 없습니다.");
                            }
                    }
                    break;

                case 2:
                    switch (menu) {
                        case 1:
                            System.out.print("데이터 : ");
                            x = stdIn.nextInt();
                            try {
                                s.pushToSister(x);
                            } catch (MultipleIntStack.OverflowIntStackException e) {
                                System.out.println("Stack is FULL!");
                            }
                            break;

                        case 2:
                            try {
                                x = s.popSister();
                                System.out.println("Popped data is " + x);
                            } catch (MultipleIntStack.EmptyIntStackException e) {
                                System.out.println("Stack is EMPTY!");
                            }
                            break;

                        case 3:
                            try {
                                x = s.peekSister();
                                System.out.println("Peeked data is " + x);
                            } catch (MultipleIntStack.EmptyIntStackException e) {
                                System.out.println("Stack is EMPTY!");
                            }
                            break;

                        case 4:
                            s.dumpSister();
                            break;

                        case 5:
                            s.clearSister();
                            break;

                        case 6:
                            System.out.print("데이터 : ");
                            x = stdIn.nextInt();
                            int result = s.indexOfSister(x);
                            if(result >= 0){
                                System.out.println(x+" is in "+result);
                            }else{
                                System.out.println("해당하는 데이터가 없습니다.");
                            }
                    }
                    break;
            }

        }
    }
}
