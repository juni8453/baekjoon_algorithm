package programmers.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터_Remind {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        int[] priorities2 = {2, 1, 3, 2};
        int location2 = 3;

        System.out.println(new Solution3_1().solution(priorities2, location2));
        System.out.println(new Solution3_1().solution(priorities, location));
    }
}

class Node {
    int index;
    int value;

    public Node (int index, int value) {
        this.index = index;
        this.value = value;
    }
}

class Solution3_1 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();

        // 초기 Queue 셋팅
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Node(i, priorities[i]));
        }

        int doPrint = 0; // 목표한 인쇄물이 몇 번째에 출력되는지 계속 갱신해주기 위한 변수
        while (!queue.isEmpty()) {
            boolean check = false;
            Node nowNode = queue.poll();

            for (Node node : queue) {
                if (nowNode.value < node.value) {
                    check = true;
                }
            }

            // 현재 출력물보다 더 큰 중요도를 가진 출력물이 있다면 현재 출력물을 뒤로 넘긴다.
            if (check) {
                queue.offer(nowNode);

                // 현재 출력물보다 더 큰 중요도를 가진 출력물이 없다면 출력한다.
            } else {
                doPrint++;

                if (location == nowNode.index) {
                    answer = doPrint;
                    break;
                }
            }
        }


        return answer;
    }
}

// // 다른 인쇄물 중 현재 인쇄물보다 중요도가 높은 인쇄물이 하나라도 있다면 Queue 뒤로 넘겨야한다.
//                if (nowNode.value < node.value) {
//                    queue.offer(nowNode);
//
//                // 현재 인쇄물이 가장 중요도가 높은 인쇄물이라면 출력해야 한다.
//                } else {
//                    doPrint++;
//
//                    if (nowNode.index == location) {
//                        answer = doPrint;
//                    }
//                }