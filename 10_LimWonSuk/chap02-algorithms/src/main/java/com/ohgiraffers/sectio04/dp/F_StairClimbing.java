package com.ohgiraffers.sectio04.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;

/* [계단 오르기]
* - n 개의 계단이 있고, 각 계단마다 점수가 있음
* - 계단을 올라가면서 밟은 계단의 점수를 합산
* - 최대 점수를 얻으면서 마지막 계단에 도달하는 것이 목표
* - 반환할 결과 값 : 최대 점수
*
* === 제약 조건 ===
* 1. 시작 지점은 무조건 지면 (0번 계단)
* 2. 연속된 3개의 계단을 밟을 수 없음 (!!중요!!)
* 3. 한 번에 1개 또는 2개의 계단을 오를 수 있음
* 4. 마지막 계단(n번 계단)은 반드시 밟아야 함
*
* */
public class F_StairClimbing {
    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));

        // 계단의 개수
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1]; // 계단별 점수
        // i : 계단 번호, arr[i] : 해당 계단의 점수

        int[] dp = new int[n + 1]; // 최적(최대) 값 누적

        /* 각 계단의 점수 입력 */
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        /* Base Case */
        // n == 1 -> 계단이 1개인 경우 -> 도착이라서 무조건 밟아야 함
        dp[1] = arr[1];

        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        /* DP : Bottom-Up
         * - 각 계단까지 도달하는데 얻을 수 있는 최대 값을
         *  DP[] 요소에 기록
         * */
        for (int i = 3; i <= n; i++) { // 층 반복
            // 계단을 1칸전에서 왔을때랑 2칸전에서 왔을때 2가지
             dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];



 /*        내가 접근한거
    dp[i] = Math.max(arr[i-1],arr[i-2]) + arr[i];
            if (arr[i] < arr[i-3]) arr = [i][3];*/






        }return dp[n];
    }
}