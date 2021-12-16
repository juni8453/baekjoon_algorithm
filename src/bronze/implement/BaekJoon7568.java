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

/*
* A의 몸무게 x, 키 y  덩치 (x,y) B의 몸무게 p, 키 q (p,q)
* 만약 x > p / y > q 라면 A는 B보다 덩치가 크다.
* ---
* 하지만 다른 덩치끼리 크기를 정할 수 없을 수도 있다.
* 만약 x < p / y > q 라면 누구도 상대방보다 더 크다고 할 수 없다.
* 즉, 몸무게나 키가 전부 상대방보다 크거나 작은 경우만 확실하게 나눌 수 있다.
* ---
* 몸무게, 키가 가장 큰 사람이 1등
* 몸무게, 키가 가장 작은 사람이 사람 수 만큼의 등수 (5명이면 5등)
* 이 사람보다 몸무게 키가 작으면 2등 ~ 사람 수
*
* */
