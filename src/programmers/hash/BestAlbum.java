package programmers.hash;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        String[] genres2= {"classic", "pop", "classic", "classic", "pop"};
        int[] plays2 = {3000, 600, 150, 800, 2500};

        int[] solution = new Solution4().solution(genres, plays);
        int[] solution2 = new Solution4().solution(genres2, plays2);

        Arrays.stream(solution)
                .forEach(i -> System.out.print(i + ","));

        Arrays.stream(solution2)
            .forEach(i -> System.out.print(i + ","));
    }
}

class Solution4 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer =  {};

        Map<String, Integer> map = new HashMap<>();

        // key - 장르, value - 장르의 전체 재생 횟수
        // classic - 1,450
        // pop - 3,100
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        // Key 를 List 로 만들고 play(Value) 횟수를 기준으로 내림차순 정렬한다.
        List<String> keys = new ArrayList<>(map.keySet());
        keys.sort((o1, o2) -> map.get(o2) - map.get(o1));

        List<Integer> result = new ArrayList<>();

        // Key 를 정렬한 리스트에서 제일 많은 횟수를 재생한 장르부터, 장르별 첫 번째로 많은 횟수가 플레이된 인덱스,
        // 두 번째로 많이 플레이된 인덱스를 찾아 배열에 넣어준다.
        for (String key : keys) {
            int max = 0;
            int firstIdx = -1;

            for (int i = 0; i < genres.length; i++) {
                if (key.equals(genres[i]) && max < plays[i]) { // 장르가 맞다면 최대값을 찾아준다.
                    max = plays[i];
                    firstIdx = i; // genres 장르 배열의 최대값을 가지는 인덱스가 i 이므로 firstIdx 에 대입한다.
                }
            }

            max = 0;
            int secondIdx = -1;
            for (int i = 0; i < genres.length; i++) {
                // 위와 동일한 조건에 firstIdx 가 아니여야 두 번째로 큰 값이므로 이렇게 조건식을 달아준다.
                if (key.equals(genres[i]) && max < plays[i] && i != firstIdx) {
                    max = plays[i];
                    secondIdx = i;
                }
            }

            result.add(firstIdx);
            if (secondIdx >= 0) {
                result.add(secondIdx);
            }

            answer = new int[result.size()];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = result.get(i);
            }
        }

        return answer;
    }
}

// 장르 별로 가장 많이 재생된 노래를 두 곡씩 모아 베스트 앨범을 만들려고 한다.
// 노래의 장르를 나타내는 배열 genres
// 재생 횟수를 나타내는 plays
// 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하는 프로그램을 작성하라.

/*
* 1. 가장 많이 재생된 장르를 찾아서 먼저 수록한다.
* 2. 그 장르 내에서 더 많이 재생된 노래를 먼저 수록한다.
* 3. 그 장르 내에서 재생 횟수가 같다면 고유 번호가 낮은 노래를 먼저 수록한다.
* */