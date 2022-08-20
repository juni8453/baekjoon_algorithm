package study.section10;

public class Section1003 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 8, 2, 9, 4};
        System.out.println(new Solution3().solution(arr));
    }
}

class Solution3 {
    public int solution(int[] arr) {
        int answer = 0;  
        int[] dy = new int[arr.length];
        dy[0] = 1;

        for (int i=1; i<dy.length; i++) {
            int max = 0;

            // arr[i] 앞 배열을 하나씩 탐색한다.
            for (int j = i - 1; j >= 0; j--) {

                // 앞 배열이 arr[i] 보다 작고 앞 배열에 해당하는 최대 증가 수열의 갯수가 max 보다 크다면 ?
                // 앞 배열끼리 최대 증가 수열의 갯수를 비교해 더 큰 값을 max 에 갱신한다.
                if (arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
            }
            // max 값에 + 1 한 값이 현재 dy[i] 의 최대 증가 수열 갯수이다.
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }
}

// dy[i] = arr 배열의 i 번째 인덱스 내부 값을 마지막 항으로 하는 최대 증가 수열의 길이
/*
    arr[8] = {5,3,7,8,6,2,9,4}
    dy[3] = 3 (5,7,8)
    항상 dy 초기 값은 1이다.
 */

// dy[j] > max 를 해주는 이유
/*
    arr = {5,3,7,8,6,2,9,4}
    dy  = {1,1,0,0,0,0,0,0} 인 상황

 */

