package com.ohgiraffers.sectio04.dp;

import com.ohgiraffers.section01.sorting.B_SelectionSort;

import java.io.BufferedReader;
import java.io.IOException;/* 정수 삼각형 최대 합 경로
* - 삼각형 형태로 배치된 숫자들이 주어짐
* - 맨 위에서 시작하여 아래로 내려가면서 숫자 선택
* - 인접한 칸만 이동 가능
* - 선택한 숫자들의 합이 최대가 되는 경로 찾기
* - 결과로 누적된 최대 가중치 구하기
* */
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E_TriangleMaxSum {
    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));

        int n = Integer.parseInt(br.readLine()); // int 값 가져오기
        /* 그래프를 기록할 인접 행렬(2차원 배열) 생성 */
        int[][] t = new int[n + 1][n + 1];

        /* (1,1)부터 마지막 층 까지 내려옴변서 가지는 최대 값을 기록할 배열 */
        int[][] dp = new int[n + 1][n + 1];

        /* DP : Bottom-Up (Tabulation) */
        StringTokenizer st;
        for (int i = 1; i <= n; i++) { // 층 반복
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= i; j++) { // 각 층의 정수 반복

                // 삼각형 데이터를 입력
                t[i][j] = Integer.parseInt(st.nextToken());
            }
            /* 삼각형 값 세팅 확인 (디버깅) */
            System.out.println(Arrays.toString(t[i]));
        }
        System.out.println("\n==============================\n");
        // 위층으로 올라가는 방법
        // 방법1 : 위층으로 1개만 올라가기 -> [i-1][j]
        // 방법2 : 위층으로 1개만 올라가서 왼쪽1 이동 -> [i-1][j-1]
        for (int i = 1; i <= n; i++) { // 층 반복

            for (int j = 1; j <= i; j++) { // 각 층의 정수 반복
                // 바로 윗층 두 경로 중 큰 값을 선택
                // 현재 방문한 정수 t[i][j] 값을 더해서 dp에 입력
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + t[i][j];
            }
            /* 삼각형 값 세팅 확인 (디버깅) */
          //  System.out.println(Arrays.toString(t[i])); // t를 넣어서 같은거 나옴
            System.out.println(Arrays.toString(dp[i]));
        }
        // 가중치가 기록된 dp[][]에서 마지막 줄 중 가장 큰 값 찾기
        int answer = 0;
        for(int i = 1 ; i <= n ; i++){
            // 최대 값이 answer에 자징되게 하는 코드
            if(answer < dp[n][i]) answer = dp[n][i];
        }

  return answer;
    }

}
/*
     for(int i = 6 ; i <= n ; i++){
dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;*/

