package programmers.hash;

import java.util.*;

public class BestAlbum_Review {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        String[] genres2= {"classic", "pop", "classic", "classic", "pop"};
        int[] plays2 = {3000, 600, 150, 800, 2500};

        int[] solution = new Solution4_1().solution(genres, plays);
        int[] solution2 = new Solution4_1().solution(genres2, plays2);

        Arrays.stream(solution)
            .forEach(i -> System.out.print(i + ","));

        Arrays.stream(solution2)
            .forEach(i -> System.out.print(i + ","));
    }
}

class Solution4_1 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        // Value 기준으로 내림차순 정렬.
        // Collections.sort() 첫 번째 인자로 List 를 받아야하기 때문에 변환한다.
        List<String> keys = new ArrayList<>(map.keySet());
        keys.sort((o1, o2) -> map.get(o2) - map.get(o1));

        // 장르별로 가장 많이 들은 genres 인덱스, 두 번째로 많이 들은 genres 인덱스를 찾아내 List<Integer> 에 넣어준다.
        List<Integer> returnList = new ArrayList<>();
        for (String genre : keys) {
            int max = 0; // 최대 값 찾아줘야 하니까
            int firstIdx = 0;

            for (int j = 0; j < genre.length(); j++) {
                // 두 개 배열의 길이가 같으니 장르가 같고 해당 인덱스의 재생 횟수를 체크해서 max 값을 추출한다.
                if (genre.equals(genres[j]) && plays[j] > max) {
                    max = plays[j];
                    firstIdx = j;
                }
            }

            max = 0;
            int secondIdx = 0;

            for (int j = 0; j < genre.length(); j++) {
                if (genre.equals(genres[j]) && plays[j] > max) {
                    // j 가 firstIdx 가 아니여야 두 번째로 큰 값이 추출된다.
                    if (j != firstIdx) {
                        max = plays[j];
                        secondIdx = j;
                    }
                }
            }


            returnList.add(firstIdx);

            // 장르에 속한 곡이 하나라면, 하나의 곡만 선택한다라는 제한사항
            if (secondIdx != 0) {
                returnList.add(secondIdx);
            }
        }

        answer = new int[returnList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = returnList.get(i);
        }

        return answer;
    }
}

// genres[i]는 고유번호가 i인 노래장르이다.
// plays[i]는 고유번호가 i인 노래가 재생된 횟수이다.
// genres.length == plays.length
// 장르에 속한 곡이 하나라면 하나의 곡만 선택한다.


