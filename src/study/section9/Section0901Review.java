package study.section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Body2 implements Comparable<Body2> {
    int h, w;

    public Body2(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Body2 o) {
        return o.h - this.h;
    }
}

public class Section0901Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Body> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Body(a, b));
        }

        int count = solution(list, n);
        System.out.println(count);
    }

    private static int solution(List<Body> list, int n) {
        int count = 0;
        int max = Integer.MIN_VALUE;

        for (Body body : list) {
            if (body.w > max) {
                max = body.w;
                count ++;
            }
        }

        return count;
    }
}

/*

“A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A 지원자 보다 높은(크고, 무겁다) 지원자가

존재하면 A 지원자는 탈락하고, 그렇지 않으면 선발된다.”

N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.

-> 즉, 몸무게, 키 하나라도 다른 지원자보다 뛰어나면 선발될 수 있다.
-> 이렇게 비교하기 위해서는 모든 참가자의 키 또는 몸무게를 내림차순 정렬을 실시한다.
-> 키 내림차순 정렬을 실시했다면, 몸무게를 기준으로 비교하면 되는데, 위에서 아래로 내려오면서 비교하므로 어짜피 키는 작기 때문에
   몸무게가 큰 사람들만 골라내면 된다.
* */