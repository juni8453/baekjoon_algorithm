package study.section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Brick2 implements Comparable<Brick2> {

    int w;
    int h;
    int k;

    public Brick2(int w, int h, int k) {
        this.w = w;
        this.h = h;
        this.k = k;
    }

    // 가장 긴 벽돌이 아래가 가도록 가로 기준 내림차순 정렬
    @Override
    public int compareTo(Brick2 o) {
        return o.w - this.w;
    }
}

public class Section1004_Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] dy = new int[n];
        List<Brick2> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr.add(new Brick2(w, h, k));
        }

        Collections.sort(arr);


    }
}
