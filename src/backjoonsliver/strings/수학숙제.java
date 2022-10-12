package backjoonsliver.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 수학숙제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = new String[n];
        List<BigInteger> paper = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            line = br.readLine().split("\\D"); // 정규식 사용 \D 는 숫자가 아닌 문자를 걸러준다.
            for (int j = 0; j < line.length; j++) {
                if (!line[j].equals("")) {
                    paper.add(new BigInteger(line[j]));
                }
            }
        }

        Collections.sort(paper);
        for (int i = 0; i < paper.size(); i++) {
            System.out.println(paper.get(i));
        }
    }
}

// 숫자가 나오는 경우에 가능한 가장 큰 숫자를 찾아야한다.
// 각 줄에서 숫자를 찾고 낮은 숫자대로 오름차순으로 한 줄씩 출력한다.
// 숫자 앞에 0이 있는 경우 01,02 .. 에는 0을 생략한다. 000 이 여러개인 경우 0만 출력

// a ~ z = 97 ~ 122