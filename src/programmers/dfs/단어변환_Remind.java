package programmers.dfs;

public class 단어변환_Remind {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(new Solution8().solution(begin, target, words));
    }
}

class Solution8 {

    static int answer = 0;
    static boolean[] checked;

    public int solution(String begin, String target, String[] words) {
        checked = new boolean[words.length];
        dfs(0, begin, target, words);

        return answer;
    }

    private static void dfs(int depth, String standWord, String target, String[] words) {
        // 노드가 가장 깊은 깊이까지 도달할 필요도 없이 갱신되는 standWord 가 target 과 일치한다면 answer 변수에 해당 depth 를 삽입한다.
        // 일치하지 않는다면 변환할 수 없는 경우므로 그대로 종료한다.
        if (standWord.equals(target)) {
            answer = depth;

        // 제공된 단어를 하나씩 비교한다. 가독성을 위해 checkDiff() 메서드를 작성
        // 비교를 했을 떄 바꿀 수 있는 단어이며 아직 체크가 안된 단어일 때 완전 탐색을 실시한다.
        } else {
            for (int i = 0; i < words.length; i++) {
                if (checkDiff(standWord, words[i]) && !checked[i]) {
                    checked[i] = true;
                    dfs(depth + 1, words[i], target, words);
                    checked[i] = false;
                }
            }
        }
    }

    private static boolean checkDiff(String standWord, String compareWord) {
        int count = 0;
        char[] a = standWord.toCharArray();
        char[] b = compareWord.toCharArray();

        // a 단어와 b 단어의 알파벳을 하나씩 비교하며 다른 알파벳이 나올 때 마다 카운팅한다.
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                count++;
            }
        }

        // 카운팅 결과가 1이 넘는다면 다른 알파벳이 1개가 넘는다는 의미이므로 변환할 수 없는 단어.
        if (count > 1) {
            return false;
        }

        // 그렇지 않을 경우 변환 가능한 단어이기 때문에 True 를 반환한다.
        return true;
    }
}

// 깊이 우선 탐색을 활용한 완전 탐색으로 진행한다.
// 방문 체크 배열을 적절하게 활용해 중복 탐색을 방지하도록 하자.
// target 으로 단어를 바꿀 수 없다면 0을 반환한다.
// 최소 몇 단계의 과정을 거쳐 begin 이 target 으로 변환될 수 있는가 ?