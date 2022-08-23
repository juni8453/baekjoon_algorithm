package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumbers {
    public static void main(String[] args) {
        String[] phone_book1 = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123", "456", "789"};
        String[] phone_book3 = {"12", "123", "1235", "567", "88"};
        String[] phone_book4 = {"12", "6789", "6"};

        System.out.println(new Solution3().solution(phone_book1));
        System.out.println(new Solution3().solution(phone_book2));
        System.out.println(new Solution3().solution(phone_book3));
        System.out.println(new Solution3().solution(phone_book4));
    }
}

class Solution3 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();

        //    key      value
        // "119"         0
        // "97674223"    1
        // "1195524421"  2
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        // j for 문을 돌면서 다른 단어가 자신의 단어 앞쪽에 포함되어 있는지 확인한다.
        for (String phoneNumber : phone_book) {
            for (int j = 0; j < phoneNumber.length(); j++) {
                String prefix = phoneNumber.substring(0, j);

                if (map.containsKey(prefix)) {
                    return false;
                }
            }
        }

        return answer;
    }
}
