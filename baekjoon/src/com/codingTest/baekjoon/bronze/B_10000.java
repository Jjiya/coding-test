package com.codingTest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10000 {
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split("\\s");

        System.out.println(Integer.parseInt(input[0]) + Integer.parseInt(input[1]));
    }

    public void ioTest() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Boolean repeatIo = Boolean.TRUE;
        while (repeatIo) {
            System.out.println("\n --입력 테스트를 원하는 종류를 입력하세요.--");
            System.out.println("stop(종료), line(한 줄 입력), lines(여러 줄 입력), number(숫자입력)");
            String kind = br.readLine().trim();
            if (kind.equals("stop")) {
                repeatIo = Boolean.FALSE;
                break;
            } else if (kind.equals("line")) {
                System.out.print("한 줄 입력 모드 ");
                String test = br.readLine();
                System.out.println("한줄 입력한 문장: " + test);
            } else if (kind.equals("lines")) {
                System.out.print("여러 줄 입력 모드 ");
                String totalStr = "";
                String tmpReader = "";
                while ((tmpReader = br.readLine()) != null) {
                    if (tmpReader.equals("stop!!")) break;
                    totalStr += tmpReader + "\n";
                    System.out.println("입력 중단 원할 시 stop!! 입력");
                }
                System.out.println("여러줄 입력한 문장: " + totalStr);
            } else if (kind.equals("number")) {
                System.out.print("숫자 입력 모드 ");
                try {
                    Integer number = null;
                    number = Integer.parseInt(br.readLine());


                    System.out.println("입력한 숫자는: " + number);
                } catch (Exception e) {
                    System.out.println("잘못된 입력이 발생하였습니다.");
                }
            }
        }
    }
}
