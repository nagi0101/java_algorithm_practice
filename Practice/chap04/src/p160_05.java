import java.util.Scanner;

class IntQueue {
    private int max;
    private int front;
    private int rear;
    private int num;
    private int[] que;

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {
        }
    }

    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {
        }
    }

    public IntQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enque(int x) throws OverflowIntQueueException {
        if (num >= max)
            throw new OverflowIntQueueException();

        que[rear++] = x;
        num++;
        if (rear == max)
            rear = 0;
        return x;
    }

    public int deque() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        int x = que[front++];
        num--;
        if (front == max)
            front = 0;
        return x;
    }

    public int peek() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        return que[front];
    }

    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (que[idx] == x)
                return idx;
        }
        return -1;
    }

    public int search(int x) {
        int count = 1;
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (que[idx] == x)
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

public class p160_05 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntQueue s = new IntQueue(64);

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());

            System.out.print("(1)enqueue (2)dequeue (3)peek (4)dump (5)search (0)exit : ");
            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        s.enque(x);
                    } catch (IntQueue.OverflowIntQueueException e) {
                        System.out.println("Queue is FULL");
                    }
                    break;

                case 2:
                    try {
                        x = s.deque();
                        System.out.println("Dequeued data is " + x);
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("Queue is EMPTY");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("Peeked data is " + x);
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("Queue is EMPTY");
                    }
                    break;

                case 4:
                    s.dump();
                    break;

                case 5:
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        int result = s.search(x);
                        System.out.println("Searched data is at " + result);
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("Queue is EMPTY");
                    }
                    break;
            }
        }
    }
}
