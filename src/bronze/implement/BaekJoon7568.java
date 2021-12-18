package bronze.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[][] arr = new int[count][2];
        String[] strings;

        for (int i = 0; i < count; i++) {
            strings = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(strings[0]); // i번째 사람의 몸무게
            arr[i][1] = Integer.parseInt(strings[1]); // i번째 사람의 키

        }

        // 2중 for문으로 i 번째 사람부터 나머지 사람 쭉 비교하기
        for (int i = 0; i < count; i++) {
            int rank = 1;

            for (int k = 0; k < count; k++) {
                // 같은 사람은 비교할 필요가 없으므로 패스
                if (i == k) continue;

                // 비교당하는 상대방이 자신보다 덩치가 크면 순위에서 밀려나니까 랭크에 +1
                if (arr[i][0] < arr[k][0] && arr[i][1] < arr[k][1]) {
                    rank++;
                }
            }

            System.out.print(rank + " ");
        }
    }
}
