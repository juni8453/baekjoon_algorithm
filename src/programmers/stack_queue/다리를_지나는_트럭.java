package programmers.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        int bridge_length2 = 100;
        int weight2 = 100;
        int[] truck_weights2 = {10};

        System.out.println(new Solution4().solution(bridge_length, weight, truck_weights));
        System.out.println(new Solution4().solution(bridge_length2, weight2, truck_weights2));
    }
}

class Solution4 {
    public int solution(int bridge_length, int weight, int[] truck_wight) {
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int sum = 0;

        for (int i = 0; i < truck_wight.length; i++) {
            int readyTruck = truck_wight[i];

            while (true) {
                // 1. 다리 큐가 비어있는 경우
                if (queue.isEmpty()) {
                    queue.offer(readyTruck);
                    sum += readyTruck;
                    time++;
                    break; // 다음 트럭 확인해야하니까 break;

                    // 2. 다리 큐가 다리 길이만큼 가득 찬 경우
                } else if (queue.size() == bridge_length) {
                    sum -= queue.poll();

                    // 3. 다리 큐가 다리 길이만큼 가득 차지 않은 경우
                } else {
                    if (sum + readyTruck <= weight) { //  이러면 다리에 추가
                        queue.offer(readyTruck);
                        sum += readyTruck;
                        time++;
                        break; // 다음 트럭 확인해야하니까 break;

                    } else { // 다리에 추가 못함
                        queue.add(0);
                        time++;
                    }
                }
            }
        }

        // 마지막 트럭에서 반복문이 종료되기 때문에 해당 트럭도 다리를 지나가기위해 다리 길이만큼 값을 더해준 뒤 반환한다.
        return time + bridge_length;
    }
}



// 3가지의 경우로 분기해 생각할 수 있다.
// 1. 다리 큐가 비어있는 경우.
//  -> 현재 트럭을 다리에 올려주면서 다리 무게 += 현재 올린 트럭 무게로 갱신한다.

// 2. 다리 큐가 다리 길이만큼 가득 차지 않은 경우
//  -> 현재 트럭이 다리에 올라갈 수 있는 하중이라면 다리에 올리고 다리 무게 += 현재 올린 트럭 무게로 갱신한다.
//  -> 다리에 올라갈 수 없는 하중이라면 다리 무게 그대로 놔두고

// 3. 다리 큐가 가득 찬 경우
//  -> 큐 맨 앞의 트럭은 도착했다는 뜻이므로 poll() 해준다.
