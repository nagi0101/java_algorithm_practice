public class p146_04 {
    public class IntAryQueue{
        private int max;
        private int num;
        private int[] que;

        IntAryQueue(int max){
            num = 0;
            this.max = max;
            try {
                this.que = new int[this.max];
            }catch (OutOfMemoryError e){
                max = 0;
            }
        }

        public class EmptyIntQueueException extends RuntimeException{
            public EmptyIntQueueException(){}
        }
        public class OverflowIntQueueException extends RuntimeException{
            public OverflowIntQueueException(){}
        }

        public int enque(int num) throws OverflowIntQueueException{
            if(num >= max){
                throw new OverflowIntQueueException();
            }
            return this.que[num++] = num;
        }

        public int deque(){
            if(num <= 0){
                throw new EmptyIntQueueException();
            }
            int returnNum = que[0];
            for(int i = 1; i < num; i++){
                que[i - 1] = que[i];
            }
            num--;
            return returnNum;
        }

        public int peek(){
            if(num <= 0)
                throw new EmptyIntQueueException();
            return que[0];
        }

        public int indexOf(int k) {
            for (int i = 0; i < num; i++) {
                if (que[i] == k)
                    return i;
            }
            return -1;
        }

        public void clear(){
            num = 0;
        }

        public int capacity(){
            return max;
        }

        public int size(){
            return num;
        }

        public boolean isEmpty(){
            return num == 0;
        }

        public boolean isFull(){
            return num == max;
        }

        public void dump(){
            if(num == 0){
                System.out.println("Queue is EMPTY");
            }
            for(int i = 0; i < num; i++)
                System.out.print(que[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {

    }
}
