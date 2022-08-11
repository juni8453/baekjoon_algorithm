package programmers.level1;

import java.util.Scanner;

public class ProgrammersLevel1_34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        int answer = solution(nums);
        System.out.println(answer);
    }

    private static int solution(int[] nums) {
        int count = 0;
        int num = 0;
        boolean check = false;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    num = nums[i] + nums[j] + nums[k];

                    // 변수 check 가 소수인지 확인 (소수는 1보다 큰 자연수 중 1과 자기 자신만을 약수로 가지는 수)
                    // 1은 소수가 아니므로 2부터
                    if (num >= 2) {
                        check = sosu(num);

                        if (check) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    // 소수 인지 확인하는 메소드
    private static boolean sosu(int num) {
        boolean check = true;

        // 2 와 같거나 큰 수로 나눠떨어지면 소수가 아니므로 false 반환
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
               return false;
            }
        }

        return check;
    }
}
// 소수란 1과 자기 자신으로만 나눠지는 수


// 배열 nums 에서 3개의 수를 더해서 소수를 만들 수 있는 경우의 수를 return 해라
// ex)  nus	   result
//     [1,2,3,4]	1
//     [1,2,7,6,4]	4

// -> 입출력 예 #1
//[1,2,4]를 이용해서 7을 만들 수 있습니다.
// 경우의 수 1개니까 result 1 return

//입출력 예 #2
//[1,2,4]를 이용해서 7을 만들 수 있습니다.
//[1,4,6]을 이용해서 11을 만들 수 있습니다.
//[2,4,7]을 이용해서 13을 만들 수 있습니다.
//[4,6,7]을 이용해서 17을 만들 수 있습니다.
// 경우의 수 4개니까 result 4 return
