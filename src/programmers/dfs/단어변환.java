package programmers.dfs;

public class 단어변환 {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] word = {"hot", "dot", "lot", "log", "cog"};

        System.out.println(new Solution5().solution(begin, target, word));
    }
}

class Solution5 {

    static boolean[] checked;
    static int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] word) {
        checked = new boolean[word.length];
        DFS(0, begin, target, word);

        if (answer == Integer.MAX_VALUE) {
            return 0;
        }

        return answer;
    }

    // 백트랙킹을 곁들인 완전탐색
    private void DFS(int depth, String begin, String target, String[] word) {

        // answer 값을 초과해서 depth 를 탈 필요가 없으므로 분기문으로 체크
        if (answer <= depth) {
            return;
        }

        if (begin.equals(target)) {
            answer = Math.min(answer, depth);
        }

        for (int i = 0; i < word.length; i++) {
            // 자기 자신을 서로 비교할 필욘 없음
            if (!begin.equals(word[i])) {

                // 바꿀 수 있는 단어면서, 아직 체크하지 않는 단어일 때
                if (checkDiff(begin, word[i]) && !checked[i]) {
                    checked[i] = true;
                    DFS(depth + 1, word[i], target, word);
                    checked[i] = false;
                }
            }
        }
    }

    private boolean checkDiff(String a, String b) {
        int count = 0;

        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        for (int i = 0; i < aArr.length; i++) {
            if (aArr[i] != bArr[i]) {
                count++;
            }
        }

        if (count > 1) {
            return false;
        }

        return true;
    }
}
