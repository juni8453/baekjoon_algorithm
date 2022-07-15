package studyReview.section04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Section0403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(firstLine.nextToken());
        int k = Integer.parseInt(firstLine.nextToken());

        StringTokenizer secondLine = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(secondLine.nextToken());
        }

        List<Integer> answer = solution(arr, n, k);
        answer.stream().forEach(s -> System.out.print(s + " "));
    }

    private static List<Integer> solution(int[] arr, int n, int k) {
        int lt = 0;
        int rt = k - 1;
//        int rt = k;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        // rt = 3 이므로, 인덱스 0, 1, 2 까지만 최초 윈도우로 만들어준다.
        // 최초 윈도우의 크기는 항상 -1 해서 만들어주자. k 값 그대로 사용하면 rt 움직이면서 윈도우 움직일 때 망함
        // rt = k 해버리면 하나 곂쳐버림.
        for (int i = 0; i < rt; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = rt; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            answer.add(map.size()); // i = rt 자체가 최초 윈도우에서 rt 가 뒤로 하나 더 간거니까, 사이즈 더해주고,
            map.put(arr[lt], map.get(arr[lt]) - 1); // 다시 rt 를 뒤로 보내야 하니까 그전에 lt 값은 하나 빼주자.

            // 그리고 value 가 0 인 key 값이 있는지 검증 들어간다.
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }

            lt ++; // 그리고 lt 를 한 칸 뒤로 밀어준다.
        }

        return answer;
    }
}
