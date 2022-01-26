package hackerrank;

import java.io.*;

class Result1 {
    public static String timeConversion(String s) {
        // TODO
        //  받아온 문자열에서 AM인지 PM인지 체크한다. (A라면 오전, P라면 오후)

        String timeStatus = s.substring(8, 10); // AM
        String[] hms = s.substring(0, 8).split(":"); // ex) [12, 01, 00]

        if (timeStatus.equals("AM")) {
            if (hms[0].equals("12")) {
                hms[0] = "00";
            }
        }

        if (timeStatus.equals("PM")) {
            if ( !(hms[0].equals("12")) ) {
                hms[0] = Integer.toString(Integer.parseInt(hms[0]) + 12);
            }
        }
        return hms[0] + ":" + hms[1] + ":" + hms[2];
    }
}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result1.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
// 12 시간 포맷으로 주어진 시간이 주어지면 24시간 포맷으로 바꿔서 출력
// input    12:01:00PM
// output   12:01:00

// input    12:01:00AM
// output   00:01:00
