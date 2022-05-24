package study.section6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 좌표를 저장하는 클래스
class Point implements Comparable<Point> {

    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 정렬의 기준을 잡아주는 메서드 @Override 구현
    @Override
    public int compareTo(Point point) {

        // 10 20 30 ... 오름차순이라면 10 - 20 = -10 즉, 음수 값이 나와야한다.
        // 30 20 10 ... 내림차순이라면 20 - 10 = 10 즉, 양수 값이 나와야한다.
        // 만약 x 값이 같은게 있다면 y 값 기준으로 정렬한다.
        if (this.x == point.x) {
            return this.y - point.y;

        // 그렇지 않다면 그냥 x 값 기준으로 정렬한다.
        } else {
            return this.x - point.x;
        }
    }
}

public class PositionSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x, y));
        }

        Collections.sort(arr);

        for (Point point : arr) {
            System.out.println(point.x + " " + point.y);
        }
    }
}
