import java.util.Scanner;

class GStack<E> {
    private int max;
    private int ptr;
    private E[] stk;


    public E push(E x) throws Exception {
        if (ptr >= max)
            throw new Exception("Stack in FULL");
        return stk[ptr++] = x;
    }

    public E pop() throws Exception {
        if (ptr <= 0)
            throw new Exception("Stack in EMPTY");
        return stk[--ptr];
    }

    public E peek() throws Exception {
        if (ptr <= 0)
            throw new Exception("Stack in EMPTY");
        return stk[ptr - 1];
    }

    public int indexOf(E x) {
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

    public GStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = (E[]) new Object[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }
}

public class p144_02 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        GStack<Integer> s = new GStack<>(64);

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
            if (s.isEmpty()) {
                System.out.println("Stack is EMPTY!");
            } else if (s.isFull()) {
                System.out.println("Stack is FULL");
            }

            System.out.print("(1)push (2)pop (3)peek (4)dump (5)clear (6)indexOf (0)exit : ");
            int menu = stdIn.nextInt();
            stdIn.nextLine();
            if (menu == 0)
                break;

            Integer x;
            switch (menu) {
                case 1:
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        x = s.pop();
                        System.out.println("Popped data is " + x);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("Peeked data is " + x);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    s.dump();
                    break;

                case 5:
                    s.clear();
                    break;

                case 6:
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    int result = s.indexOf(x);
                    if(result >= 0){
                        System.out.println(x+" is in "+result);
                    }else{
                        System.out.println("해당하는 데이터가 없습니다.");
                    }
            }
        }
    }
}
