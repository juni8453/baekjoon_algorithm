package study.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열구하기 {
    static int n;
    static int m;
    static int[] pm;
    static int[] check;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n]; // 입력되는 숫자 배열
        check = new int[n]; // 체크 배열
        pm = new int[m]; // 순열 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);

    }

    private static void DFS(int depth) {
        if (depth == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();

        } else {
            // 숫자 개수 만큼 뻗는다.
            for (int i = 0; i < n; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    pm[depth] = arr[i];
                    DFS(depth + 1);
                    check[i] = 0;
                }
            }
        }
    }
}

// n개의 숫자 중 서로 다른 m을 찾아 출력
// 순열은력중복을 허용하지 않는다.
