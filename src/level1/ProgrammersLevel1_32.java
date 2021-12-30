package level1;

import java.util.*;
import java.util.stream.Collectors;

public class ProgrammersLevel1_32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int lostCount = sc.nextInt();
        int reserveCount = sc.nextInt();

        int[] lost = new int[lostCount];
        int[] reserve = new int[reserveCount];

        for (int i = 0; i < lostCount; i++) {
            lost[i] = sc.nextInt();
        }

        for (int i = 0; i < reserveCount; i++) {
            reserve[i] = sc.nextInt();
        }

        int answer = solution(n, lost, reserve);
        System.out.println(answer);

    }

    private static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 키포인트는 여벌을 가져왔던 친구가 도난당하면 그친구는 1벌은 갖게 된다는 것이다.
        // 즉, 여벌이 도난당하므로 자신이 입을 체육복만 소지한 채 일반 학생이 되어
        // answer의 값에서 +1 해주어야 한다.
        // (잃어버린줄 알고 answer 값에서 뺐더니 한 벌 남아있기 때문에 자기는 수업에 나갈 수 있으므로)

        // 여벌 체육복을 가져온 학생이 도난당한 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        // 도난당한 학생에게 체육복 빌려주는 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}

// 바로 앞 번호의 학생이나 바로 뒷 번호의 학생에게만 체육복을 빌려줄 수 있다.
// 예를 들어 4번 학생은 3번 또는 5번에게만 체육복을 빌려줄 수 있다.
// 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 수업을 들을 수 있어야 한다.
// 여별 체육복을 가져온 학생이 체육복을 도난당했을 수도 있다. 이러면 체육복을 하나만 도난당했다고 하고 남은 체육복이 하나이기에 다른 학생에게 체육복을 빌려줄 수 없다.

// n = 전체 학생 수
// lost[] = 체육복을 도난당한 학생들의 번호가 담긴 배열
// reserve[] = 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열
// return = 체육수업을 들을 수 있는 학생의 최댓값

// 5	[2, 4]	[1, 3, 5]	5
// 5	[2, 4]	[3]	        4
// 3    [3]	    [1]	        2
