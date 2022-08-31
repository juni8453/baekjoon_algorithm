package programmers.hash;

import java.util.*;

class SolutionTest {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        /* map
        *  key      value
        *  classic  1,450
        *  pop      3,100
        * */

        // 1. 가장 많이 재생된 장르 순으로 선정
        // 2. 장르 내 가장 많이 재생된 순서로 최대 2곡 수록
        // 2-1. 장르 내 곡이 하나라면 해당 곡만 수록
        // 2-2. 장르 내 재생횟수가 같다면 고유번호 순으로 수록

        /* map
         *  key      value
         *  pop      3,100
         *  classic  1,450
         * */
        // value 를 내림차순하려면 Key 를 List 로 만들고 sort 를 진행해야 한다.
        // 이제 가장 많이 재생된 장르 순으로 먼저 선정할 수 있다.
        // keys = {"pop", "classic"}
        List<String> keys = new ArrayList<>(map.keySet());
        keys.sort((o1, o2) -> map.get(o2) - map.get(o1));

        // 장르 내 가장 많이 재생된 순서로 수록
        List<Integer> result = new ArrayList<>();
        for (String key : keys) {
            int max = 0;
            int first = 0;

            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(key) && plays[i] > max) {
                    max = plays[i];
                    first = i;
                }
            }

            int secondMax = 0;
            int second = -1;

            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(key) && plays[i] > secondMax) {
                    if (i != first) {
                        secondMax = plays[i];
                        second = i;
                    }
                }
            }

            // 2-1. 장르 내 곡이 하나라면 해당 곡만 수록
            // 2-2 장르 내 재생횟수가 같다면 고유번호 순으로 수록
            result.add(first);

            if (second != -1) {
                result.add(second);
            }
        }

        answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}

public class Test {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
                     // 0    1    2    3     4 (고유번호)

        System.out.println(Arrays.toString(new SolutionTest().solution(genres, plays)));
    }
}
