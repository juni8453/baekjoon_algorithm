package programmers.greedy;

public class 조이스틱 {
    public static void main(String[] args) {
        String name = "JEOAAAE";
        String name2 = "JAN";

        System.out.println(new Solution4().solution(name));
        System.out.println(new Solution4().solution(name2));
    }
}

class Solution4 {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int move = length - 1; // 우측으로만 이동한다고 가정했을 때 몇 칸 움직여야하는지 카운트

        for (int i = 0; i < length; i++) {
            if (name.charAt(i) < 'N') { // N 이전이면 앞으로 전진하는게 최소 이동
                answer += name.charAt(i) - 'A';

            } else { // N 이후인 경우
                answer += 'Z' - name.charAt(i) + 1;
            }

            // 'A' 를 찾아준다.
            int checkIndex = i + 1; // 현재 위치 다음 위치를 확인하기 위해 설정
            while (checkIndex < length && name.charAt(checkIndex) == 'A') { // 다음이 끝이 문자열의 끝이 아니고 'A' 인 경우라면,
                checkIndex++;
            }

            // 우측으로 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동횟수가 더 적은 것 선택
            move = Math.min(move, i + i + length - checkIndex);

            // 우측으로 순서대로 가는 것과, 처음부터 뒷부분을 먼저 선입력하는 것 중 이동횟수가 더 적은 것 선택
            move = Math.min(move, (length - checkIndex) * 2 + i);
        }

        return answer + move;
    }
}
