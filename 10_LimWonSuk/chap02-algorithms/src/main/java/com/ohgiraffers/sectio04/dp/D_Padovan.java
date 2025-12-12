package com.ohgiraffers.sectio04.dp;

/* 파도반 수열(Padovan Sequence)
 * - 이탈리아 건축가 "리차드 파도반"이 발견한 수열
 * - 정삼각형을 나선형으로 배치할 때 나타나는 수열
 * - 피보나치와 비슷하지만 파도반은 3항 피보나치는 3항 관계식 사용
 *
 * - 수열 정의
 * P(1) = 1
 * P(2) = 1
 * P(3) = 1
 * P(4) = 2
 * P(5) = 2
 * P(6) = 3
 * P(n) = P(n-2) + P(n-3) (n >= 4)
 * */
public class D_Padovan {
    /* DP : Top-Down 방식 (Memoization + 재귀호출) */

    /* DP : Bottom-Down 방식 (Memoization + 반복문) */
    static Integer[] dp = new Integer[101];

    public static int solution(int n) {
        // Base Case 설정
        dp[1] = dp[2] = dp[3] = 1; // 3항 관계식이라3개

        // Top-Down 재귀 함수 호출
        //return padovan(n);

        // Bottom-Up  반복문 함수 호출
        return padovan2(n);

    }


    /**
     * Top-Down 방식의 재귀 함수
     *
     * @param n
     * @return
     */
    private static int padovan(int n) {

        // dp[n] == null == 계산되지 않은 값 ==> 계산 필요
        // dp[n] !== null == 계산된 값 ==> 더이상 계산 필요 X ==> 반환

        if (dp[n] == null) {// 참조형에서 null = 빈칸아님 아무것도 없는것
            dp[n] = padovan(n - 2) + padovan(n - 3); // n이 2칸전값 + n이 3칸전값
        }
        return dp[n];


    }

    // 오 ㅅ1ㅂ 드디어 풀었다 ㄹㅇ
    private static int padovan2(int n) {


        // table의 각 인덱스 == 순서
        // table[i] == i 순서까지 연산한 결과 값 == 삼각형 변의 길이
        int[] dp = new int[n + 1];  // 0번 인덱스 사용 x

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[1] = dp[2] = dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];


        }
        return dp[n];
    }
}

