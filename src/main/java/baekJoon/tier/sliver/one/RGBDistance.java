package baekJoon.tier.sliver.one;

// (실버1) 1149번 RGB 거리
// 다이나믹 프로그래밍
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 0.5 초 (추가 시간 없음)	128 MB	128025	73606	54521	56.496%
// 문제
// RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
//
// 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
//
// 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
// N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
// i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
// 입력
// 첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
//
// 출력
// 첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
//
// 예제 입력 1
// 3
// 26 40 83
// 49 60 57
// 13 89 99
// 예제 출력 1
// 96
// 예제 입력 2
// 3
// 1 100 100
// 100 1 100
// 100 100 1
// 예제 출력 2
// 3
// 예제 입력 3
// 3
// 1 100 100
// 100 100 100
// 1 100 100
// 예제 출력 3
// 102
// 예제 입력 4
// 6
// 30 19 5
// 64 77 64
// 15 19 97
// 4 71 57
// 90 86 84
// 93 32 91
// 예제 출력 4
// 208
// 예제 입력 5
// 8
// 71 39 44
// 32 83 55
// 51 37 63
// 89 29 100
// 83 58 11
// 65 13 15
// 47 25 29
// 60 66 19
// 예제 출력 5
// 253


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBDistance {
	// dp[][]는 각 색으로 칠할 시 이전 색을 제외한 코스트들
	// dp[1][0]은 dp[0][0]을 제외한 요소의 비용의 최소 + dp[1][0]의 비용
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] dp = new int[n][3];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dp[i][0] = Integer.parseInt(st.nextToken());
			dp[i][1] = Integer.parseInt(st.nextToken());
			dp[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + dp[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + dp[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + dp[i][2];
		}

		System.out.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
	}

}
