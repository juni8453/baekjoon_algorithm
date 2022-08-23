package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumbers_Review {
    public static void main(String[] args) {
        String[] phone_book1 = {"119", "97674223", "1195524421"}; // return false
        String[] phone_book2 = {"123", "456", "789"}; // return true
        String[] phone_book3 = {"12", "123", "1235", "567", "88"}; // return false
        String[] phone_book4 = {"12", "6789", "6"}; // return false

        System.out.println(new Solution2_1().solution(phone_book1));
        System.out.println(new Solution2_1().solution(phone_book2));
        System.out.println(new Solution2_1().solution(phone_book3));
        System.out.println(new Solution2_1().solution(phone_book4));
    }
}

class Solution2_1 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (String number : phone_book) {
            for (int i = 0; i < number.length(); i++) {
                if (map.containsKey(number.substring(0, i))) {
                    return false;
                }
            }
        }

        return answer;
    }
}

// 하나의 전화번호가 다른 번호의 접두사인가 ?
// str.subString(0, i); -> 0번째부터 i번째 전까지 문자열 split

