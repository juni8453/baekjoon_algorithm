package this_is_coding_test.prctice.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 모험가_길드 {

    static int count = 0;
    static int group = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> people = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            people.add(Integer.parseInt(st.nextToken()));
        }

        people.sort(Comparator.naturalOrder()); // 오름차순 정렬

        for (int i = 0; i < n; i++) {
            count += 1; // 그룹에 포함
            if (count >= people.get(i)) { // 현재 그룹에 포함된 사람 수가 현재 인원의 공포도보다 크거나 같다면 Grouping
                group += 1;
                count = 0;
            }
        }

        System.out.println(count);
    }
}

/**
 * 그리디 1번 문제 모험가 길드
 * 1. 공포도가 x 인 팀원은 반드시 x 명 이상의 그룹에 포함되어야한다.
 * 2. 굳이 모든 모험가가 그룹핑 될 필요는 없다.
 * 3. 1 <= n <= 100,000
 * -> 여행을 떠날 수 있는 그룹 수의 최대 값을 출력해라.
 */

/**
 * 정렬을 실시해서 풀이했을 때 항상 최적의 해를 보장받을 수 있는가 ?
 * 조건 중 각 공포도의 값은 항상 n 이하를 받아오기 때문에 최적의 해를 보장받을 수 있다.
 * 즉, 그리디 알고리즘으로 풀이가 가능할 듯.
 */