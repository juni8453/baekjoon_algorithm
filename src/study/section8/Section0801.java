package study.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Section0801 {

    static int N, total = 0;
    static String result = "NO";
    static boolean flag = false;

    private static void DFS(int L, int sum, int[] arr) {
        if(flag) {
            return;
        }

        if (L == N) {
            if ((total - sum) == sum) {
                result = "YES";
                flag = true;
            }

        // else 로 두 가지의 부분 집합 완
        } else {
            // 해당 arr 배열 원소를 넣는다.
            DFS(L + 1, sum + arr[L], arr);

            // 안 넣는다.
            DFS(L + 1, sum, arr);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        DFS(0,0, arr);
        System.out.println(result);
    }
}

/*
    서로소 = 두 수의 최대 공약수가 1 이외에 곂치는 수가 없는 수 (14 = 2,7 / 15 = 3,5 == 서로소)
    N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
    두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
    둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어야 합니다.
    예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.
    6
    1 3 5 6 7 10
 */