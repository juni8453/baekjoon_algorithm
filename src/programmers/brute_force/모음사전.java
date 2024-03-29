package programmers.brute_force;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 모음사전 {
    public static void main(String[] args) {
        String answer4 = "EIO";

        System.out.println(new Solution6().solution(answer4));
    }
}

class Solution6 {

    static int answer;
    static char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    static boolean[] checked;
    static List<String> list = new ArrayList<>();

    public int solution(String word) {
        checked = new boolean[alphabet.length];
        DFS(0, "");
        Collections.sort(list);
        answer = list.indexOf(word) + 1;

        return answer;
    }

    private static void DFS(int depth, String str) {
        if (depth == alphabet.length) {
            return;
        }

        for (int i = 0; i < alphabet.length; i++) {
            list.add(str + alphabet[i]);
            DFS(depth + 1, str + alphabet[i]);
        }
    }
}
