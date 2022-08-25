package programmers.greedy;

import java.util.Arrays;

public class GymSuit {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        System.out.println(new Solution1().solution(n, lost, reserve));
    }
}

class Solution1 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n + 2]; // 앞, 뒤를 모두 확인해야 하니까

        Arrays.sort(reserve);
        Arrays.sort(lost);

        for (int l : lost) {
            students[l] --; // 여분이 없는 인덱스는 -1
        }

        for (int r : reserve) {
            students[r] ++; // 여분이 있는 인덱스는 1
        }

        for (int i = 1; i <= n; i++) {
            // 1. 자신이 1 인지 확인한다.
            if (students[i] == 1) {
                // 2. 앞의 학생이 잃어버린 상태인지 확인한다.
                // 2-1. 잃어버렸다면 자신을 -1, 잃어버린 학생을 +1 해준다.
                if (students[i - 1] == -1) {
                    students[i]--;
                    students[i - 1]++;

                    // 3. 앞의 학생이 필요하지 않다면 뒤의 학생이 잃어버렸는지 확인한다.
                    // 3-1. 잃어버렸다면 2번과 동일하게 진행한다.
                } else if (students[i + 1] == -1) {
                    students[i]--;
                    students[i + 1]++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (students[i] >= 0) {
                answer ++;
            }
        }

        return answer;
    }
}

// 체육복
/*
* 바로 앞 또는 뒷 번호 학생에게만 체육복을 빌려줄 수 있다. 4번은 3번 또는 5번에게만 빌려줄 수 있다.
* 여벌을 가져온 학생이 도난당했을 수도 있다. 도난당했다면 하나만 도난 당했다고 가정한다.
* 이 때 이 학생이 남은 체육복은 하나이기에 체육복을 남에게 빌려줄 수 없다.
* */
