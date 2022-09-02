package backjoonsliver.sliding_twoPointer;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st1.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(st2.nextToken());
        }

        List<Integer> answer = solution(a, b);
        int size = answer.size();

        for (int i = 0; i < size; i++) {
            bw.write(String.valueOf(answer.get(i)));
            bw.write(" ");
        }
        bw.flush();
        bw.close();
    }

    private static List<Integer> solution(int[] a, int[] b) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);

        int p1 = 0;
        int p2 = 0;

        while (p1 < a.length && p2 < b.length) {
            if (a[p1] < b[p2]) {
                answer.add(a[p1]);
                p1++;
            } else {
                answer.add(b[p2]);
                p2++;
            }
        }

        while (p1 < a.length) {
            answer.add(a[p1]);
            p1++;
        }

        while (p2 < b.length) {
            answer.add(b[p2]);
            p2++;
        }

        return answer;
    }
}


