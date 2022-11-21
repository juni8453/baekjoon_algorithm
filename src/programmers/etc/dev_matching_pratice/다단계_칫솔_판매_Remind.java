package programmers.etc.dev_matching_pratice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 다단계_칫솔_판매_Remind {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        String[] enroll2 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral2 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller2 = {"sam", "emily", "jaimie", "edward"};
        int[] amount2 = {2, 3, 5, 4};

        System.out.println(Arrays.toString(new Solution5().solution(enroll, referral, seller, amount)));
        System.out.println(Arrays.toString(new Solution5().solution(enroll2, referral2, seller2, amount2)));
    }
}

class Node {
    String name;
    Node parent;
    int profit;

    public Node(String name) {
        this.name = name;
        this.parent = null;
        this.profit = 0;
    }
}

class Solution5 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Node> person = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            person.put(enroll[i], new Node(enroll[i]));
        }

        for (int i = 0; i < referral.length; i++) {
            person.get(enroll[i]).parent = person.get(referral[i]);
        }

        // 판매량에 따른 수익금 셋팅
        for (int i = 0; i < seller.length; i++) {
            addProfit(person.get(seller[i]), amount[i] * 100);
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = person.get(enroll[i]).profit;
        }

        return answer;
    }

    private static void addProfit(Node person, int profit) {
        int profitForParent = profit / 10; // 부모에게 전달할 이익금 계산

        if (person.parent != null && profitForParent != 0) { // 해당 노드의 부모가 있고, 부모에게 전달할 이익금이 있다면,
            person.profit += profit - profitForParent; // 자신의 이익은 부모에게 전달할 이익금만큼 뺴준 금액으로 갱신한다.
            addProfit(person.parent, profitForParent);

        } else {
            person.profit += profit; // 부모가 없거나 전달할 이익금이 없다면 자신의 원래 이익에서 현재 이익만큼 더한다.
        }
    }
}
