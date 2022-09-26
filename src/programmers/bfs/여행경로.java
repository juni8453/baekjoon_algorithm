package programmers.bfs;

import java.util.*;

public class 여행경로 {
    public static void main(String[] args) {
        String[][] tickets = {
            {"ICN", "JFK"},
            {"HND", "IAD"},
            {"JFK", "HND"}
        };

        String[][] tickets2 = {
            {"ICN", "SFO"},
            {"ICN", "ATL"},
            {"SFO", "ATL"},
            {"ATL", "ICN"},
            {"ATL", "SFO"}
        };

//        System.out.println(Arrays.toString(new Solution1().solution(tickets)));
        System.out.println(Arrays.toString(new Solution1().solution(tickets2)));
    }
}

class Solution1 {

    static boolean[] checked;
    static List<String> list = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        checked = new boolean[tickets.length];

        DFS(0, "ICN", "ICN", tickets);

        Collections.sort(list);
        answer = list.get(0).split(" ");

        return answer;
    }

    // 문자열을 따로 저장하기 마땅치 않다면 DFS() 메소드 인자로 계속 추가하고 나중에 한번에 컬렉션에 추가하는 방법이 있다.
    private void DFS(int depth, String begin, String path, String[][] tickets) {
        if (depth == tickets.length) {
            list.add(path);
            return;

        } else {
            for (int i = 0; i < tickets.length; i++) {
                // 방문하지 않았고 현재 도시가 다음 여행 경로의 출발지라면 ?
                if (begin.equals(tickets[i][0]) && !checked[i]) {
                    checked[i] = true;
                    DFS(depth + 1, tickets[i][1], path + "," + tickets[i][1], tickets);
                    checked[i] = false;
                }
            }
        }
    }
}
