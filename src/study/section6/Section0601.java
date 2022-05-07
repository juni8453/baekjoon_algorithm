package study.section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Section0601 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] line = new int[N];

        for (int i = 0; i < line.length; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = solution(line);
        Arrays.stream(answer).forEach(s -> System.out.print(s + " "));
    }

    private static int[] solution(int[] line) {
        // 오름차순으로 line 을 정렬해서 List<Integer> 형태로 반환한다.
        // 정렬 방식은 선택 정렬 방식으로 정렬한다.
        int lineSize = line.length;
        int min = 0;
        int minIndexLocation = 0;

        // TODO 배열 내 맨 처음 인덱스의 값을 가장 작은 수로 지정한다.
        //  뒤의 인덱스를 탐색하다가 min 에 저장된 값 보다 더 작은 값이 있다면 새로 저장한다. (location 에는 인덱스, min 은 인덱스 내부 값)
        for (int location = 0; location < lineSize - 1; location++) {
            min = line[location];

            // 추가) 정렬하다 앞 인덱스 값이 뒷 인덱스 값에서 -1 값과 같다면 이미 정렬되어 있는거니까 그냥 지나가주도록 ..
            // 추가 검증 필요) 96, 97, 96 과 같은 상황 Validation 필요 (이 때 넘어가면 안됨;)
            // 삭제부분
//             if (location != 0 && line[location] == line[location - 1] + 1) {
//                 continue;
//             }

            for (int k = location + 1; k < lineSize; k++) {
                if (min > line[k]) {
                    min = line[k];
                    minIndexLocation = k;
                }
            }


            // 추가) min 값을 가지고 더 작은 값과 바꿔야하는데 현재 min 값 보다 더 작은 값이 없어서 min 값에 변동이 없다면 그냥 넘어가야한다.
            if (min == line[location]) {
                continue;
            }

            // TODO 모두 탐색했다면 location 인덱스 위치의 내부 값과 min 이 위치한 인덱스 위치의 내부 값을 서로 바꾼다.
            int[] tmp1 = line;

            int firstIndex = tmp1[location];
            line[location] = tmp1[minIndexLocation];
            line[minIndexLocation] = firstIndex;
        }

        return line;
    }
}

// min = 2
// location = 1
// minIndexLocation = 4
// line =  {1, 2, 9, 3, 8}


// line[] =  {9, 8, 1, 3, 2}
// location = 0 (고정 값 필요), min = 9 최초 저장 -> 다음 탐색
// location = 1, min = 8 -> 다음
// location = 2, min = 1 -> 모두 탐색해도 1보다 작은 수 없음.
// 비교가 모두 끝났으니, location = 0 위치의 값과 location = 2 위치의 값을 서로 바꿔준다.
