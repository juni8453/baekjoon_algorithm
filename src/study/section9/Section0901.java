package study.section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Body implements Comparable<Body2>{
    public int h, w;

    public Body(int h, int w) {
        this.h = h;
        this.w = w;
    }

    // 키를 기준으로 내림차순 (인자 - this)
    @Override
    public int compareTo(Body2 o) {
        return o.h - this.h;
    }
}

public class Section0901 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Body2> bodyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            bodyList.add(new Body2(h, w));
        }

        int count = solution(bodyList, n);
        System.out.println(count);
    }

    // List<Body> 에는 키 순 내림차순으로 Body List 가 저장되어있다.
    // 기준을 잡기 위해 키가 가장 큰 body 를 선발하고 탐색을 실시 -> 새로 선발된 인원이 있다면 그 인원으로 다시 탐색 -> 반복
    static int solution(List<Body2> bodyList, int n) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        Collections.sort(bodyList);

        for (Body2 body : bodyList) {
            if (body.w > max) {
                max = body.w;
                count ++;
            }
        }

        return count;
    }
}

// 키가 가장 크고 몸무게가 가장 무거우면 선발
// 지원자가 다른 지원자보다 키 또는 몸무게가 우수하다면 일단 선발
/* 키 순으로 정렬
* 183 65 키가 가장 크므로 선발
* 181 60 183, 65 보다 작고 가벼우므로 탈락
* 180 70 183 보다 키는 작지만 몸무게가 무거우므로 선발
* 172 67 180, 70 보다 작고 가벼우므로 탈락
* 170 72 몸무게가 가장 무거우므로 선발
*
* -> (183, 65), (180, 70), (170, 72) 선발
* */