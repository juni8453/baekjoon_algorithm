package study.section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Member implements Comparable<Member> {

    int h;
    int w;

    public Member(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Member o) {
        return o.h - this.h;
    }
}

public class Section0901Review2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Member> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new Member(h, w));
        }

        int count = solution(n, list);
        System.out.println(count);
    }

    static int solution(int n, List<Member> list) {
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (Member m : list) {
            if (max < m.w) {
                max = m.w;
                count ++;
            }
        }

        return count;
    }
}

// 씨름선수로 뽑히는 최대 인원수를 구해라.
// 지원자 1명을 다른 지원자 모두와 비교해서 키와 몸무게 두 부분에서 자신보다 높은 키와 몸무게를 가진 지원자가 있다면 탈락한다.
// 기준 지원자를 찾고 완전 탐색을 실시한다.
// 아이디어) 키로 정렬을 해보자. 이렇게 하면 키를 따로 비교할 필요가 없어진다.
// 키와 몸무게 두 부분에서 모두 자신보다 우위에 있다면 탈락이기 때문에 키가 젤 큰 지원자는 무조건 선발된다.
// 키가 제일 큰 지원자 기준으로 2번째로 키가 큰 사람, 3번 째, 4번 쨰.. 순으로 몸무게를 비교하며 선발 인원을 증가하면 끝.
/*
* 183 65
* 181 60
* 180 70
* 172 67
* 170 72
* */