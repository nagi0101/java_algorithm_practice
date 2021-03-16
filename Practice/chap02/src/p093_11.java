import java.util.Scanner;

public class p093_11 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("Year : ");
        int year = stdIn.nextInt();
        System.out.print("Month : ");
        int month = stdIn.nextInt();
        System.out.print("day : ");
        int day = stdIn.nextInt();
        System.out.print("gap : ");
        int gap = stdIn.nextInt();

        YMD today = new YMD(year, month, day);
        YMD afterDay = today.after(gap);
        YMD beforeDay = today.before(gap);

        System.out.println("today : " + today.getYMDString() );
        System.out.println("afterDay : "+ afterDay.getYMDString());
        System.out.println("beforeDay : "+ beforeDay.getYMDString());

    }


    static class YMD {
        private int y;
        private int m;
        private int d;

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getM() {
            return m;
        }

        public void setM(int m) {
            this.m = m;
        }

        public int getD() {
            return d;
        }

        public void setD(int d) {
            this.d = d;
        }
        
        public void printYMD(){
            System.out.printf("%d년 %d월 %d일", getY(), getM(), getD());
        }

        public String getYMDString() {
            return getY() + "년 " + getM() + "월 " + getD() + "일";
        }

        final protected static int[][] daysInMonth = {
                {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
        };

        final private static int isLeap(int year){
            return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0) ? 1 : 0;
        }

        public YMD(int y, int m, int d) {
            this.y = y;
            this.m = m;
            this.d = d;
        }

        final public YMD after(int n){
            int year = getY();
            int month = getM();
            int day = getD();

            for(int i = 0; i < n; i++){
                day++;
                if (day > daysInMonth[isLeap(year)][month - 1]){
                    month++;
                    day = 1;
                    if(month > daysInMonth[isLeap(year)].length){
                        year++;
                        month = 1;
                    }
                }
            }

            YMD afterYMD = new YMD(year, month, day);
            return afterYMD;
        }

        final public YMD before(int n) {
            int year = getY();
            int month = getM();
            int day = getD();

            for (int i = 0; i < n; i++) {
                day--;
                if (day == 0) {
                    month--;
                    if (month == 0) {
                        --year;
                        month = daysInMonth[isLeap(year)].length;
                    }
                    day = daysInMonth[isLeap(year)][month - 1];
                }
            }

            YMD beforeYMD = new YMD(year, month, day);
            return beforeYMD;
        }

    }
}
