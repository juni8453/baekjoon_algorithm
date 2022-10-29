package groom.week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 고장난_핸드폰 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String inputNum = br.readLine();

        // 1. Map<Integer, List<String>> map 사용 풀이
        Map<Integer, List<String>> keypad = new HashMap<>();
        keypad.put(1, List.of("1", ".", ",", "?", "!"));
        keypad.put(2, List.of("2", "A", "B", "C"));
        keypad.put(3, List.of("3", "D", "E", "F"));
        keypad.put(4, List.of("4", "G", "H", "I"));
        keypad.put(5, List.of("5", "J", "K", "L"));
        keypad.put(6, List.of("6", "M", "N", "O"));
        keypad.put(7, List.of("7", "P", "Q", "R", "S"));
        keypad.put(8, List.of("8", "T", "U", "V"));
        keypad.put(9, List.of("9", "W", "X", "Y", "Z"));

        StringBuilder sb = new StringBuilder();
        int count = 0;
        String[] split = inputNum.split("");

        String stand = "";
        for (int i = 0; i < n - 1; i++) {
            if (split[i].equals(split[i + 1])) {
                stand = split[i];
                count++;

            } else {
                stand = split[i];
                // 해당 keypad 의 value 길이만큼 나눠줘야 한다.
                int valueSize = keypad.get(Integer.parseInt(stand)).size();
                if (count != valueSize) {
                    count %= valueSize;
                }

                sb.append(keypad.get(Integer.parseInt(stand)).get(count));
                count = 0;
            }

        }

        if (sb.length() == 0) {
            int valueSize = keypad.get(Integer.parseInt(stand)).size();
            if (count != valueSize) {
                count %= valueSize;
            }
        }

        stand = split[n - 1];
        sb.append(keypad.get(Integer.parseInt(stand)).get(count));
        System.out.println(sb);
    }
}

/**
 * n = 14
 * num = 44433355556666
 * return HELO
 */