package baekJoon.tier.sliver.one;

// (실버 1) 10844번 쉬운 계단 수
// 다이나믹 프로그래밍
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	256 MB	164766	53896	39476	31.151%
// 문제
// 45656이란 수를 보자.
//
// 이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
//
// N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.
//
// 입력
// 첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.
//
// 출력
// 첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
//
// 예제 입력 1
// 1
// 예제 출력 1
// 9
// 예제 입력 2
// 2
// 예제 출력 2
// 17

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EasyStairCount {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		if (n == 0) {
			System.out.println(0);
			return;
		} else if (n == 1) {
			System.out.println(9);
			return;
		}

		int[][] dp = new int[n + 1][10];
		Arrays.fill(dp[1], 1, 10, 1);
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j > 0)
					dp[i][j] += dp[i - 1][j - 1];  // j-1이 있을 때
				if (j < 9)
					dp[i][j] += dp[i - 1][j + 1];  // j+1이 있을 때
				dp[i][j] %= 1_000_000_000;  // 1,000,000,000으로 나눈 나머지
			}
		}

		int total = 0;

		for (int i = 0; i <= 9; i++) {
			total += dp[n][i];
			total %= 1_000_000_000;
		}
		System.out.println(total);
	}
}

