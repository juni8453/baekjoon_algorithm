package programmers.coding_test;

import java.util.HashMap;
import java.util.Map;

public class Test1_2 {
    public static void main(String[] args) {
//        String[] want = {"apple"};
//        int[] number = {10};
//        String[] discount = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(new Solution().solution(want, number, discount));
    }
}


 class Solution {
     public int solution(String[] want, int[] number, String[] discount) {
         int answer = 0;
         Map<String, Integer> wantMap = new HashMap<>();
         Map<String, Integer> window = new HashMap<>();

         // key = banana, value = 3
         for (int i = 0; i < want.length; i++) {
             wantMap.put(want[i], number[i]);
         }

         // 최초 윈도우 설정
         for (int i = 0; i < 10; i++) {
             window.put(discount[i], window.getOrDefault(discount[i], 0) + 1);
         }

//         if (wantMap.equals(window)) {
//            answer ++;
//         }

         // 초기 윈도우를 하나 씩 전진시키면서 want[] 와 비교한다.
         for (int i = 10; i < discount.length; i++) {
             // 1. 한 칸 뒤로 넘기면서 맨 뒤의 값 + 1
             window.put(discount[i], window.getOrDefault(discount[i], 0) + 1);

             // 2. 한 칸 뒤로 넘기면서 맨 앞의 값 - 1
             window.put(discount[i - 10], window.get(discount[i - 10]) - 1);

             // 위에서 value 를 하나 지우고 해당 value 가 0이 되었다면 window 에서 삭제한다.
             if (window.get(discount[i - 10]) == 0) {
                 window.remove(discount[i - 10]);
             }

             if (wantMap.equals(window)) {
                 answer ++;
             }
         }

         return answer;
     }
}
