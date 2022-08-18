package programmers.coding_test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test1_3 {
    public static void main(String[] args) {
        int[] order1 = {4, 3, 1, 2, 5};
        int[] order2 = {5, 4, 3, 2, 1};
        int[] order3 = {2, 1, 4, 3, 5};

        System.out.println(new Solution3().solution(order3));
    }
}

class Solution3 {
    public int solution(int[] orders) {
        int count = 0;
        Queue<Integer> comingBox = new LinkedList<>();
        Stack<Integer> stackBox = new Stack<>();

        for (int i = 0; i < orders.length; i++) {
            comingBox.offer(i + 1);
        }

        // 1. order 기준을 잡는다.
        // 2-1. comingBox 를 확인 후, order 과 맞지 않으면 poll() -> stack.push();
        // 2-1-1. stack.push() 후 order 이동하지 않고 다음 comingBox 와 다시 order 비교
        // 2-2. comingBox 를 확인 후, order 과 맞다면 poll() -> count ++;
        // 2-2-1. count ++ 후 order 기준 이동

        // 1 ~ 2의 과정을 모두 거친 뒤 comingBox 가 비었고 stack 이 빈 상태가 아니라면 다시 확인
        // 1. order 기준 이동
        // 2. stack.peek() 과 order 비교 후 맞다면 stack.pop(), count ++;
        // 2-1 아니라면 바로 for 문 종료
        // order = {5,4,3,2,1}
        // order = {4,3,1,2,5};
        int orderIndex = 0;

//        for (int i = 0; i < orders.length; i++) { // for 문으로 하면 5번만 호출되기 때문에 모든 경우의 수를 구해낼 수 없다.
        while(!comingBox.isEmpty()) {
            Integer checkOrder = orders[orderIndex];

            if (!comingBox.peek().equals(checkOrder)) {
                if (!stackBox.isEmpty() && stackBox.peek().equals(checkOrder)) {
                    stackBox.pop();
                    count++;
                    orderIndex += 1;
                    continue;
                }
                stackBox.push(comingBox.poll());
            } else {
                comingBox.poll();
                count++;
                orderIndex += 1;
            }
        }

        if (!stackBox.isEmpty()) {
            int stackLength = stackBox.size();
            for (int i = 0; i < stackLength; i++) {
                int checkOrder = orders[orderIndex];

                if (stackBox.peek().equals(checkOrder)) {
                    stackBox.pop();
                    count++;
                    orderIndex += 1;
                }
            }
        }

        return count;
    }
}
