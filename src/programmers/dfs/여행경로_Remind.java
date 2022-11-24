package programmers.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 여행경로_Remind {
    public static void main(String[] args) {
        String[][] tickets = {
            {"ICN", "SFO"},
            {"ICN", "ATL"},
            {"SFO", "ATL"},
            {"ATL", "ICN"},
            {"ATL", "SFO"}
        };

        System.out.println(Arrays.toString(new Solution9().solution(tickets)));
    }
}

class Solution9 {
    static int length;
    static String[][] sTickets;
    static boolean[] checked;
    static List<String> list = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer;
        length = tickets.length;
        sTickets = tickets;
        checked = new boolean[length];

        dfs(0, "ICN", "ICN");

        Collections.sort(list);

        answer = list.get(0).split(" ");
        return answer;
    }

    // 다른 DFS 완전탐색 문제보다 아이디어가 요구되는 문제.
    // start 는 "ICN" 으로 설정하고, 모든 티켓을 소진한 즉, 탐색이 끝까지 되었을 때 콤마를 통해 경로를 누적한 path 를 List 에 넣는다.
    // 이후 List 를 사전순 배열해 반환하면 됨.
    private static void dfs(int depth, String start, String path) {
        // 깊이가 티켓 배열의 길이 - 1 라면 모든 티켓을 소진한 경우이므로 이 경우에 탈출할 수 있도록 조건문을 작성한다.
        if (depth == length) {
            list.add(path);
            return;

        } else {
            for (int i = 0; i < length; i++) {
                // 방문하지 않았으며 다음 여행경로의 출발지를 찾아준다.
                if (!checked[i] && start.equals(sTickets[i][0])) {
                    checked[i] = true;
                    dfs(depth + 1, sTickets[i][1], path + " "  + sTickets[i][1]);
                    checked[i] = false;
                }
            }
        }
    }
}