import java.util.Scanner;

class Gqueue<E> {
    private int max;
    private int front;
    private int rear;
    private int num;
    private E[] que;

    public Gqueue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = (E[]) new Object[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public E enque(E x) throws Exception {
        if (num >= max)
            throw new Exception("Queue is FULL");

        que[rear++] = x;
        num++;
        if (rear == max)
            rear = 0;
        return x;
    }

    public E deque() throws Exception {
        if (num <= 0)
            throw new Exception("Queue is EMPTY");
        E x = que[front++];
        num--;
        if (front == max)
            front = 0;
        return x;
    }

    public E peek() throws Exception {
        if (num <= 0)
            throw new Exception("Queue is EMPTY");
        return que[front];
    }

    public int indexOf(E x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (que[idx] == x)
                return idx;
        }
        return -1;
    }

    public int search(E x) {
        int count = 1;
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (que[idx] == x)
                return count;
            count++;
        }
        return 0;
    }

    public int searchString(String x) {
        int count = 1;
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (x.equals(que[idx]))
                return count;
            count++;
        }
        return 0;
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int capacity() {
        return max;
    }


    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= max;
    }

    public void dump() {
        if (num <= 0)
            System.out.println("Queue is EMPTY");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(que[(i + front) % max] + " ");
            System.out.println();
        }
    }
}


public class p160_06 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Gqueue<String> s = new Gqueue(64);

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());

            System.out.print("(1)enqueue (2)dequeue (3)peek (4)dump (5)search (0)exit : ");
            int menu = stdIn.nextInt();
            stdIn.nextLine();
            if (menu == 0) break;

            String x;
            switch (menu) {
                case 1:
                    System.out.print("데이터 : ");
                    x = stdIn.nextLine();
                    try {
                        s.enque(x);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        x = s.deque();
                        System.out.println("Dequeued data is " + x);
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
                    System.out.print("데이터 : ");
                    x = stdIn.nextLine();
                    try {
                        int result = s.searchString(x);
                        System.out.println("Searched data is at " + result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}
