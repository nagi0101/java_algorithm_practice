import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {
    static class PhyscData {
        String name;    // 이름
        int height;     // 키
        double vision;  // 시력

        PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return name + " " + height + " " + vision;
        }

        public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhyscData> {
            @Override
            public int compare(PhyscData o1, PhyscData o2) {
                return (o1.height > o2.height) ? 1 :
                        (o1.height < o2.height) ? -1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        PhyscData[] x = {
                new PhyscData("박현규", 162, 0.3),
                new PhyscData("이수진", 168, 0.4),
                new PhyscData("박용규", 169, 0.8),
                new PhyscData("홍연의", 171, 1.5),
                new PhyscData("함진아", 173, 0.7),
                new PhyscData("김영준", 174, 1.2),
                new PhyscData("최윤미", 175, 2.0),
        };
        System.out.print("몇 cm인 사람을 찾고 있나요? : ");
        int height = stdIn.nextInt();
        int idx = Arrays.binarySearch(
                x,
                new PhyscData("", height, 0.0),
                PhyscData.HEIGHT_ORDER
        );

        if (idx < 0)
            System.out.println("요소가 없습니다.");
        else {
            System.out.println("x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터 : " + x[idx]);
        }
    }
}
