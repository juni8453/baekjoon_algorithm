package programmers.etc.dev_matching_pratice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 다단계_칫솔_판매 {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        String[] enroll2 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral2 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller2 = {"sam", "emily", "jaimie", "edward"};
        int[] amount2 = {2, 3, 5, 4};

        System.out.println(Arrays.toString(new Solution3().solution(enroll, referral, seller, amount)));
        System.out.println(Arrays.toString(new Solution3().solution(enroll2, referral2, seller2, amount2)));
    }
}

class Person {
    String name;
    Person parent;
    int profit;

    public Person(String name) {
        this.name = name;
        this.parent = null;
        this.profit = 0;
    }
}

class Solution3 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Person> people = new HashMap<>();
        people.put("-", new Person("-"));

        for (int i = 0; i < enroll.length; i++) {
            people.put(enroll[i], new Person(enroll[i]));
        }

        for (int i = 0; i < referral.length; i++) {
            people.get(enroll[i]).parent = people.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            addProfit(people.get(seller[i]), amount[i] * 100);
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = people.get(enroll[i]).profit;
        }

        return answer;
    }

    // 이익률 계산 재귀 메서드
    private static void addProfit(Person person, int profit) {
        int profitForParent = profit / 10;

        if (profitForParent != 0 && person.parent != null) {
            person.profit += profit - profitForParent;
            addProfit(person.parent, profitForParent);

        } else {
            person.profit += profit;
        }
    }
}

