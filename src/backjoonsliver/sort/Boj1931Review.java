package backjoonsliver.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Room implements Comparable<Room> {
    int startTime;
    int dueTime;

    public Room(int startTime, int dueTime) {
        this.startTime = startTime;
        this.dueTime = dueTime;
    }

    // 종료시간 기준으로 오름차순 정렬
    // 종료시간이 같다면 시작시간 기준으로 오름차순 정렬
    @Override
    public int compareTo(Room o) {
        if (o.dueTime == this.dueTime) {
            return this.startTime - o.startTime;
        } else {
            return this.dueTime - o.dueTime;
        }
    }
}

public class Boj1931Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int prevDueTime = 0;
        int count = 0;
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int dueTime = Integer.parseInt(st.nextToken());
            rooms.add(new Room(startTime, dueTime));
        }

        Collections.sort(rooms);

        for (Room room : rooms) {
            if (room.startTime >= prevDueTime) {
                prevDueTime = room.dueTime;
                count++;
            }
        }

        System.out.println(count);
    }
}
