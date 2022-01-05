package bronze.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BaekJoon1076 {
    static Map<String, String> colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        colors = new HashMap<>();
        colors.put("black", "0_1");
        colors.put("brown", "1_10");
        colors.put("red", "2_100");
        colors.put("orange", "3_1000");
        colors.put("yellow", "4_10000");
        colors.put("green", "5_100000");
        colors.put("blue", "6_1000000");
        colors.put("violet", "7_10000000");
        colors.put("grey", "8_100000000");
        colors.put("white", "9_1000000000");

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        // 문자열 합치기
        String resultStr = colors.get(a).split("_")[0] + colors.get(b).split("_")[0];
        long resultAnswer = Long.parseLong(resultStr) * Long.parseLong(colors.get(c).split("_")[1]);

        System.out.println(resultAnswer);
    }
}

// 두 번째 풀이

// package bronze.implement;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Re1076 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String a = br.readLine();
//        String b = br.readLine();
//        String c = br.readLine();
//
//        String StrA;
//
//        switch(a) {
//            case "black" :
//                StrA = "0";
//                checkB(b, c, StrA);
//                break;
//
//            case "brown":
//                StrA = "1";
//                checkB(b, c, StrA);
//                break;
//
//            case "red":
//                StrA = "2";
//                checkB(b, c, StrA);
//                break;
//
//            case "orange":
//                StrA = "3";
//                checkB(b, c, StrA);
//                break;
//
//            case "yellow":
//                StrA = "4";
//                checkB(b, c, StrA);
//                break;
//
//            case "green":
//                StrA = "5";
//                checkB(b, c, StrA);
//                break;
//
//            case "blue":
//                StrA = "6";
//                checkB(b, c, StrA);
//                break;
//
//            case "violet":
//                StrA = "7";
//                checkB(b, c, StrA);
//                break;
//
//            case "grey":
//                StrA = "8";
//                checkB(b, c, StrA);
//                break;
//
//            case "white":
//                StrA = "9";
//                checkB(b, c, StrA);
//                break;
//        }
//    }
//
//    private static void checkB(String b, String c, String StrA) {
//        switch(b) {
//            case "black":
//                StrA += "0";
//                checkResult(StrA, c);
//                break;
//
//            case "brown":
//                StrA += "1";
//                checkResult(StrA, c);
//                break;
//
//            case "red":
//                StrA += "2";
//                checkResult(StrA, c);
//                break;
//
//            case "orange":
//                StrA += "3";
//                checkResult(StrA, c);
//                break;
//
//            case "yellow":
//                StrA += "4";
//                checkResult(StrA, c);
//                break;
//
//            case "green":
//                StrA += "5";
//                checkResult(StrA, c);
//                break;
//
//            case "blue":
//                StrA += "6";
//                checkResult(StrA, c);
//                break;
//
//            case "violet":
//                StrA += "7";
//                checkResult(StrA, c);
//                break;
//
//            case "grey":
//                StrA += "8";
//                checkResult(StrA, c);
//                break;
//
//            case "white":
//                StrA += "9";
//                checkResult(StrA, c);
//                break;
//        }
//    }
//
//    private static void checkResult(String strA, String c) {
//        long StrToLongA = 0L;
//
//        switch(c) {
//            case "black":
//                StrToLongA = Long.parseLong(strA);
//                System.out.println(StrToLongA);
//
//                break;
//
//            case "brown":
//                StrToLongA = Long.parseLong(strA);
//                System.out.println(StrToLongA * 10);
//
//                break;
//
//            case "red":
//                StrToLongA = Long.parseLong(strA);
//                System.out.println(StrToLongA * 100);
//
//                break;
//
//            case "orange":
//                StrToLongA = Long.parseLong(strA);
//                System.out.println(StrToLongA * 1000);
//
//                break;
//
//            case "yellow":
//                StrToLongA = Long.parseLong(strA);
//                System.out.println(StrToLongA * 10000);
//
//                break;
//
//            case "green":
//                StrToLongA = Long.parseLong(strA);
//                System.out.println(StrToLongA * 100000);
//
//                break;
//
//            case "blue":
//                StrToLongA = Long.parseLong(strA);
//                System.out.println(StrToLongA * 1000000);
//
//                break;
//
//            case "violet":
//                StrToLongA = Long.parseLong(strA);
//                System.out.println(StrToLongA * 10000000);
//
//                break;
//
//            case "grey":
//                StrToLongA = Long.parseLong(strA);
//                System.out.println(StrToLongA * 100000000);
//
//                break;
//
//            case "white":
//                StrToLongA = Long.parseLong(strA);
//                System.out.println(StrToLongA * 1000000000);
//
//                break;
//        }
//    }
//}
