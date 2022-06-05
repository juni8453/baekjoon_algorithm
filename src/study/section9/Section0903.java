package study.section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Times implements Comparable<Times> {

    public int s, e;

    public Times(int s, int e) {
        this.s = s;
        this.e = e;
    }

    // 시작 시간을 기준으로 오름차순 정렬
    @Override
    public int compareTo(Times times) {
        return this.s - times.s;
    }
}

public class Section0903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Times> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.add(new Times(s, e));
        }

        Collections.sort(arr);

        int count = 0;


        for (Times time : arr) {

        }
    }
}

// 현수는 피로연을 3일 연속으로 계획했다. (첫날 0시 ~ 3일째 72시 까지)
// 피로연장에 동시에 존재하는 최대 인원수를 출력해라.
// 만약 (13, 15) 라면 15시 정각에는 존재하지 않는 사람이다.
// TODO 동시에 존재하려면 ? 한 사람의 시작 ~ 종료 시간 사이에 다른 사람이 있어야 한다.
//  근데 한 사람 기준을 잡고 기준을 옮기는 식으로 하면 2중 for 문하고 똑같지 않나 ?
//

// 시작시간 기준 오름차순 정렬
// 5  14
// 12 15
// 14 18
// 15 20
// 20 30
