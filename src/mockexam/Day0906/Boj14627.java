package mockexam.Day0906;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14627 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()); // 파의 갯수
        int c = Integer.parseInt(st.nextToken()); // 닭의 갯수
        int[] arr = new int[s]; // 각 파의 길이를 담은 배열

        int lt = 1;
        int rt = 1000000000;
        int sum = 0;
        for (int i = 0; i < s; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        // 이분탐색 실시
        // 항상 lt <= rt 조건문이 필요하다.
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int cnt = 0;

            for (int i = 0; i < s; i++) {
                cnt += arr[i] / mid; // 임의의 mid 값을 각 파의 길이와 나눠서 몇 개의 파닭을 만들 수 있는지 구한다.
            }

            // cnt 가 만들어야하는 파닭의 갯수와 일치하거나 더 많다면 파 길이가 너무 짧은거니까 더 늘여주기 위해 최소값을 mid + 1 로 갱신한다.
            // (오른쪽을 봐야하니까)
            // 파닭 갯수와 일치하지만 lt 를 늘려주는건 lt <= rt 조건을 충족시키기 위함이다.
            if (cnt >= c) {
                lt = mid + 1;

            // 그게 아니라면 mid 길이를 더 줄이기 위해 최대값을 mid - 1 로 갱신한다.
            // (왼쪽을 봐야하니까)
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(sum - rt * (long)c);
    }
}

// 닭에 항상 같은 양의 파를 넣는다.
// 라면에 파를 얼만큼 넣을 수 있는가 ?
// 파 3개, 만들어야하는 닭 5개
// 파의 총 길이 1020cm

//