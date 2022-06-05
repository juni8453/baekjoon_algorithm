package study.section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Body implements Comparable<Body> {

    int high, weight;

    public Body(int high, int weight) {
        this.high = high;
        this.weight = weight;
    }

    // 자기 자신을 기준으로 삼아 들어오는 매개변수와 비교한다.
    // 그냥 외우는게 편하다.
    // 자기자신 - 인자 = 오름차순
    // 인자 - 자기자신 = 내림차순
    @Override
    public int compareTo(Body body) {
        return body.high - this.high;
    }
}

public class Section0901My {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Body> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int high = sc.nextInt();
            int weight = sc.nextInt();
            arr.add(new Body(high, weight));
        }

        Collections.sort(arr);

        int max = 0;
        int count = 0;

        for (Body body : arr) {
            if (body.weight > max) {
                max = body.weight;
                count++;
            }
        }

        System.out.println(count);
    }
}

// 1. 키, 몸무게를 2차원 배열로 세팅한다.
// 2. 키를 기준으로 내림차순 정렬 -> 키가 제일 큰 사람은 자동 선발 (자기보다 키 큰 사람은 없기 때문에)
// 3. 키가 제일 큰 사람의 몸무게를 기준으로 MAX 값을 저장하고, 몸무게를 쭉 비교한다.
/*
* 183 65
* 181 60
* 180 70
* 172 67
* 170 72
* */