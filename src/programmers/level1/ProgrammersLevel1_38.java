package programmers.level1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProgrammersLevel1_38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int participantNum = sc.nextInt();
        String[] participant = new String[participantNum];
        String[] completion = new String[participantNum - 1];

        for (int i = 0; i < participant.length; i++) {
            participant[i] = sc.next();
        }

        for (int i = 0; i < completion.length; i++) {
            completion[i] = sc.next();
        }

        String answer = ProgrammersLevel1_38.solution(participant, completion);
        System.out.println(answer);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        // Todo 두 배열을 비교해서 participant 배열에 있지만 completion 배열에 없는 값을 찾아낸다.
        //  동명이인일 경우도 존재하니까 List 말고 Key 값으로 빠르게 찾을 수 있는 Map 을 사용해보자.
        //  동명이인은 Key의 중복이니까 찾고자 하는 키가 있으므로 1을 반환 후 +1 하면 2가 된다.

        Map<String, Integer> map = new HashMap<>();

        for (String name : participant) {
            // getOrDefault(Object key, V DefaultValue)
            // 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환한다.
            // key : 값을 가져와야 하는 요소의 키

            // 즉, name 이라는 키, name 이라는 키 값이 존재하면 name 을 넣어주고 없다면 0을 넣어줌, 그리고 + 1
            // eden 키가 없으면 eden 에 1이 들어가고 있다면 eden 값을 반환하며 거기에다가 + 1
            map.put(name, map.getOrDefault(name,0) + 1);
        }

        for (String name : completion) {
            // 지정된 키의 값에 -1 하고 다시 map.put
            map.put(name, map.get(name) - 1);
        }

        for (String name : map.keySet()) {
            // name key의 값이 0보다 크다면 ? (완주한 경우)
            if (map.get(name) > 0) {
                answer = name;
                break;
            }
        }

        return answer;
    }
}


// 마라톤에 참여한 선수들의 이름이 담긴 배열 participant
// 완주한 선수들의 이름이 담긴 배열 completion
// 완주하지 못한 선수의 이름을 return 하는 함수를 구현해라.

// 참가자 중 동명이인이 있을 수도 있다.
// completion 의 길이는 participant 의 길이보다 1 작다.
