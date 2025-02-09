package baekJoon.tier.sliver.three;

// (실버 3) 2579번 계단 오르기, DP 메모이제이션
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	128 MB	219124	76831	55456	34.364%
// 계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다. <그림 1>과 같이 각각의 계단에는 일정한 점수가 쓰여 있는데 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻게 된다.
//
//
//
// <그림 1>
//
// 예를 들어 <그림 2>와 같이 시작점에서부터 첫 번째, 두 번째, 네 번째, 여섯 번째 계단을 밟아 도착점에 도달하면 총 점수는 10 + 20 + 25 + 20 = 75점이 된다.
//
//
//
// <그림 2>
//
// 계단 오르는 데는 다음과 같은 규칙이 있다.
//
// 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
// 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
// 마지막 도착 계단은 반드시 밟아야 한다.
// 따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.
//
// 각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.
//
// 입력
// 입력의 첫째 줄에 계단의 개수가 주어진다.
//
// 둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수가 주어진다. 계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수이다.
//
// 출력
// 첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력한다.
//
// 예제 입력 1
// 6
// 10
// 20
// 15
// 25
// 10
// 20

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 100ms
public class ClimbingStairs {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		if (n == 0) {
			System.out.println(0);
			return;
		}

		// int[] stairs = {10, 20, 15, 25, 10, 20};
		int[] stairs = new int[n];
		for (int i = 0; i < n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}

		// 각 층의 최대 점수
		int[] dp = new int[n];
		// 첫 계단 밟는 경우
		dp[0] = stairs[0];

		if (n > 1) {
			dp[1] = dp[0] + stairs[1];
		}

		for (int i = 2; i < n; i++) {

			if (i == 2) {
				dp[i] = Math.max(stairs[0] + stairs[i], stairs[1] + stairs[i]);
			} else {
				dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
			}
		}
		System.out.println(dp[n - 1]);
	}
}

// 처음에 적은 것
// public class ClimbingStairs {
//
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		int n = Integer.parseInt(br.readLine());
//
// 		int[] stairs = new int[n];
// 		// int[] stairs = {10, 20, 15, 25, 10, 20};
//
// 		if (n == 0) {
// 			System.out.println(0);
// 			System.exit(0);
// 		}
//
// 		for (int i = 0; i < n; i++) {
// 			stairs[i] = Integer.parseInt(br.readLine());
// 		}
//
// 		// 각 층의 최대 점수
// 		int[] dp = new int[n];
// 		// int[] dp = new int[6];
//
// 		dp[0] = stairs[0];
// 		if (n >= 2) {
// 			dp[1] = dp[0] + stairs[1];
// 		}
//
// 		if (n == 1) {
// 			System.out.println(dp[0]);
// 		} else if (n == 2) {
// 			System.out.println(dp[1]);
// 		} else {
// 			dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
// 			for (int i = 3; i < n; i++) {
// 				dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
// 			}
// 			System.out.println("dp = " + Arrays.toString(dp));
// 			System.out.println(dp[n - 1]);
// 		}
// 	}
// }
//
