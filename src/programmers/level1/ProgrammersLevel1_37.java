package programmers.level1;

import java.util.*;

public class ProgrammersLevel1_37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("보드의 세로 사이즈 입력");
        int boardRowSize = sc.nextInt();

        System.out.println("보드의 가로 사이즈 입력");
        int boardColumnSize = sc.nextInt();

        System.out.println("크레인을 몇 번 작동합니까 ?");
        int moveOrder = sc.nextInt();

        int[][] initBoard = new int[boardRowSize][boardColumnSize];
        int[] moves = new int[moveOrder];

        for (int i = 0; i < initBoard.length; i++) {
            for (int j = 0; j < initBoard[i].length; j++) {
                initBoard[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < moves.length; i++) {
            moves[i] = sc.nextInt();
        }


        int answer = solution(initBoard, moves);

        System.out.println("터진 인형의 갯수는 몇 개 입니까 ?");
        System.out.println(answer);
    }

    public static int solution(int[][] board, int[] moves) {
        int boomDollCount = 0;
        Stack<Integer> box = new Stack<>();
        box.push(0);

        int[][] rearrangeBoard = new int[board.length][board.length];

        for (int i = 0; i < rearrangeBoard.length; i++) {
            for (int j = 0; j < rearrangeBoard[i].length; j++) {
                rearrangeBoard[i][j] = board[j][i];
            }
        }

        // todo board[board의 행 인덱스][행 인덱스 내의 가로 값]
        //  board[move - 1][반복 인덱스 ?]
        //  0 인지 0이 아닌 숫자인지 체크
        //  만약 0일 경우, 같은 행의 다음 열 인덱스 탐색
        //  만약 0이 아닌 경우, 바구니에 add -> 꺼내간 위치를 0으로 바꾼다.

        // 0 [0,0,0,4,3]
        // 1 [0,0,2,2,5]
        // 2 [0,1,5,4,1]
        // 3 [0,0,0,4,3]
        // 4 [0,3,1,2,1]


        for (int move : moves) {
            int boardIndexCheck = move - 1;

            for (int i = 0; i < rearrangeBoard[boardIndexCheck].length; i++) {
                if (rearrangeBoard[boardIndexCheck][i] != 0) {
                    int peek = box.peek();

                    if (peek == rearrangeBoard[boardIndexCheck][i]) {
                        box.pop();
                        boomDollCount += 2;
                    }

                    else {
                        box.push(rearrangeBoard[boardIndexCheck][i]);
                    }
                    // 인형 하나를 뽑았으면 0으로 바꿔서 밑의 인형을 뽑을 수 있도록 하고, 더 뽑을 수 없도록 break 한다.
                    rearrangeBoard[boardIndexCheck][i] = 0;
                    break;
                }
            }
        }

        return boomDollCount;
    }
}

// 이차원 배열로 이루어진 게임 화면
// 모든 인형들은 격자의 가장 아래 칸부터 차곡차곡 쌓여 있다.
// 사용자는 크레인을 이용해 가장 위의 인형을 집어 바구니의 가장 아래부터 차곡차곡 쌓을 수 있다.
// 만약 같은 모양의 인형이 바구니에 연속으로 쌓이게 되면, 두 인형은 터지면서 바구니에서 사라진다.
// 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않는다.
// 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정한다.

// 크레인을 모두 작동시킨 후 터뜨려져 사라진 인형의 개수를 return 해라.


/*  입출력 예시
*  board = [ [0,0,0,0,0], [0,0,1,0,3], [0,2,5,0,1], [4,2,4,4,2], [3,5,1,3,1] ]
*  moves = [1,5,3,5,1,2,1,4]
*  result = 4
* */
