package study.section7;

public class Section0706 {

    static int n;
    static int[] ch; // 체크 배열

    public static void main(String[] args) {
        n = 3;
        ch = new int[n + 1];
        DFS(1);
    }

    public static void DFS(int L) {
        // 종착점에 왔을 때, check 배열에서 1로 check 된 인덱스 번호를 출력하면 된다.
        if (L == n + 1) {
            StringBuilder tmp = new StringBuilder();

            for (int i = 1; i <= n; i++) {
                // 체크된 값일 경우,
                if (ch[i] == 1) {
                    tmp.append(i).append(" ");
                }
            }

            // 공집합 출력 X
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }

        } else {
            // 종작점이 아닐 때, 뎁스가 하나 늘어나며 이진트리 처럼 두 갈래로 뻡는다.
            // 사용하기 때문에 check 배열에 표기하기 위해 해당 레벨은 1로
            ch[L] = 1;
            DFS(L + 1);

            // 사용하지 않기 때문에 check 배열에 해당 레별은 0으로
            ch[L] = 0;
            DFS(L + 1);
        }
    }
}
