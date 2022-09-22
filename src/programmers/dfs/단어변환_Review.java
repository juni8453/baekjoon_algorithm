package programmers.dfs;

public class 단어변환_Review {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] word = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] word2 = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(new Solution().solution(begin, target, word));
        System.out.println(new Solution().solution(begin, target, word2));
    }
}

class Solution {

    static int answer;
    static boolean[] checked;

    public int solution(String begin, String target, String[] words) {
        checked = new boolean[words.length];
        DFS(begin, target, words, 0);

        return answer;
    }

    // 두 문자가 바꿀 수 있는 문자인지 확인하는 메소드
    public boolean checkDiff(String a, String b) {
        int count = 0;

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        for (int i = 0; i < aChars.length; i++) {
            if (aChars[i] != bChars[i]) {
                count++;
            }
        }

        if (count > 1) {
            return false;
        }

        return true;
    }

    public void DFS(String standardWord, String target, String[] word, int depth) {
        if (target.equals(standardWord)) {
            answer = depth;

        } else {
            for (int i = 0; i < word.length; i++) {
                if (checkDiff(standardWord, word[i]) && !checked[i]) {
                    checked[i] = true;
                    DFS(word[i], target, word, depth + 1);
                    checked[i] = false;
                }
            }
        }
    }
}
