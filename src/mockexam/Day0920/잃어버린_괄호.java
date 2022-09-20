package mockexam.Day0920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] split = str.split("-");
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < split.length; i++) {
            int plusSum = 0;
            String[] plusNums = split[i].split("\\+");

            // - 앞의 숫자들 모두 연산
            for (int j = 0; j < plusNums.length; j++) {
                int tmp = Integer.parseInt(plusNums[j]);
                plusSum += tmp;
            }

            if (answer == Integer.MAX_VALUE) {
                answer = plusSum; // 일단 맨 처음 값은 넣어줘야 할 듯 ?? answer 에 55 넣어주고,

            } else {
                answer -= plusSum; // - 뒤 연산 값하고 빼주기
            }
        }

        System.out.println(answer);
    }
}

// + 만 있으면 어딜 괄호쳐도 값이 똑같이 나옴 -> - 기준으로 괄호 치기
// 최소 또는 음수 값이 나오기 위해선 - 뒤로 괄호를 치고 앞 숫자의 + 를 먼저 연산한 뒤 앞에서 더한 값과 빼주면 됨
