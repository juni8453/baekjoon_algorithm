package mockexam.Day0927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기_10 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];



    }

    public static void DFS(int x, int y, int n) {

    }
}

// n이 3보다 클 경우 패턴은 (n / 3) * (n / 3) 의 정사각형을 크기 n / 3 의 패턴으로 둘러싼 형태

// 크기 3 -> 크기 1의 패턴이 8개 + 공백 1개
/*  ***
    * *
    ***
* */

// 크기 9 -> 크기 3의 패턴이 8개 + 공백 1개
/*
    *********
    * ** ** *
    *********
    ***   ***
    * *   * *
    ***   ***
    *********
    * ** ** *
    *********
* */