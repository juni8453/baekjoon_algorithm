package programmers.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NotCompletion {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> pMap = new HashMap<>();

        for(String p : participant) {
            pMap.put(p, pMap.getOrDefault(p, 0) + 1);
        }

        for(String c : completion) {
            if(pMap.containsKey(c)) {
                pMap.put(c, pMap.getOrDefault(c, 0) - 1);
            }
        }

        // pMap 을 뒤지면서 value 값이 0이 아닌 key 값을 찾는다.
        for (int i = 0; i < pMap.values().size(); i++) {
            if (!pMap.get(participant[i]).equals(0)) {
                sb.append(participant[i]);
                break;
            }
        }

        System.out.println(sb);
    }
}
