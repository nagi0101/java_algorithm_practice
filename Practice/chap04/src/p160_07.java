import java.util.Scanner;

class IntDeque {
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

    public IntDeque(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enqueAtRear(int x) throws IntDeque.OverflowIntQueueException {
        if (num >= max)
            throw new IntDeque.OverflowIntQueueException();

        que[rear++] = x;
        num++;
        if (rear == max)
            rear = 0;
        return x;
    }

    public int enqueAtFront(int x) throws IntDeque.OverflowIntQueueException {
        if (num >= max)
            throw new IntDeque.OverflowIntQueueException();
        if (front <= 0)
            front = max;
        que[--front] = x;
        num++;
        return x;
    }

    public int dequeAtFront() throws IntDeque.EmptyIntQueueException {
        if (num <= 0)
            throw new IntDeque.EmptyIntQueueException();
        int x = que[front++];
        num--;
        if (front == max)
            front = 0;
        return x;
    }

    public int dequeAtRear() throws IntDeque.EmptyIntQueueException {
        if (num <= 0)
            throw new IntDeque.EmptyIntQueueException();
        if (rear <= 0)
            rear = max;
        int x = que[--rear];
        num--;
        return x;
    }

    public int peekFront() throws IntDeque.EmptyIntQueueException {
        if (num <= 0)
            throw new IntDeque.EmptyIntQueueException();
        return que[front];
    }

    public int peekRear() throws IntDeque.EmptyIntQueueException {
        if (num <= 0)
            throw new IntDeque.EmptyIntQueueException();
        return que[rear - 1];
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

public class p160_07 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntDeque s = new IntDeque(64);

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
                        System.out.print("(1)front (2)rear : ");
                        int subMenu = stdIn.nextInt();
                        switch (subMenu) {
                            case 1:
                                s.enqueAtFront(x);
                                break;

                            case 2:
                                s.enqueAtRear(x);
                                break;
                        }
                    } catch (IntQueue.OverflowIntQueueException e) {
                        System.out.println("Queue is FULL");
                    }
                    break;

                case 2:
                    try {
                        System.out.print("(1)front (2)rear : ");
                        int subMenu = stdIn.nextInt();
                        switch (subMenu) {
                            case 1:
                                x = s.dequeAtFront();
                                break;

                            case 2:
                                x = s.dequeAtRear();
                                break;

                            default:
                                continue;
                        }
                        System.out.println("Dequeued data is " + x);
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("Queue is EMPTY");
                    }
                    break;

                case 3:
                    try {
                        System.out.print("(1)front (2)rear : ");
                        int subMenu = stdIn.nextInt();
                        switch (subMenu) {
                            case 1:
                                x = s.peekFront();
                                break;

                            case 2:
                                x = s.peekRear();
                                break;

                            default:
                                continue;
                        }
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
