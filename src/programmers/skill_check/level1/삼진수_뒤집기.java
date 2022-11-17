package programmers.skill_check.level1;

public class 삼진수_뒤집기 {
    public static void main(String[] args) {
        int n = 45;
        System.out.println(new Solution1().solution(n));
    }
}

class Solution1 {
    public int solution(int n) {
        int answer = 0;
        String ans = "";
        while(n != 0) {
            ans += n%3;
            n /= 3;
        }
        return Integer.parseInt(ans, 3);
    }
}

// n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.