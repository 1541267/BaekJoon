package baekJoon.tier.sliver.one;

// (실버 1) 2156번 포토주 시식
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	128 MB	157559	54202	39258	32.824%
// 문제
// 효주는 포도주 시식회에 갔다. 그 곳에 갔더니, 테이블 위에 다양한 포도주가 들어있는 포도주 잔이 일렬로 놓여 있었다. 효주는 포도주 시식을 하려고 하는데, 여기에는 다음과 같은 두 가지 규칙이 있다.
//
// 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
// 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
// 효주는 될 수 있는 대로 많은 양의 포도주를 맛보기 위해서 어떤 포도주 잔을 선택해야 할지 고민하고 있다. 1부터 n까지의 번호가 붙어 있는 n개의 포도주 잔이 순서대로 테이블 위에 놓여 있고, 각 포도주 잔에 들어있는 포도주의 양이 주어졌을 때, 효주를 도와 가장 많은 양의 포도주를 마실 수 있도록 하는 프로그램을 작성하시오.
//
// 예를 들어 6개의 포도주 잔이 있고, 각각의 잔에 순서대로 6, 10, 13, 9, 8, 1 만큼의 포도주가 들어 있을 때, 첫 번째, 두 번째, 네 번째, 다섯 번째 포도주 잔을 선택하면 총 포도주 양이 33으로 최대로 마실 수 있다.
//
// 입력
// 첫째 줄에 포도주 잔의 개수 n이 주어진다. (1 ≤ n ≤ 10,000) 둘째 줄부터 n+1번째 줄까지 포도주 잔에 들어있는 포도주의 양이 순서대로 주어진다. 포도주의 양은 1,000 이하의 음이 아닌 정수이다.
//
// 출력
// 첫째 줄에 최대로 마실 수 있는 포도주의 양을 출력한다.
//
// 예제 입력 1
// 6
// 6
// 10
// 13
// 9
// 8
// 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WineTasting {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] wineArr = new int[n];
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			wineArr[i] = Integer.parseInt(br.readLine());
		}

		// int[] wineArr = {6, 10, 13, 9, 8, 1};

		if (n == 1) {
			System.out.println(wineArr[0]);
		} else if (n == 2) {
			System.out.println(wineArr[0] + wineArr[1]);
		} else {
			dp[0] = wineArr[0];
			dp[1] = dp[0] + wineArr[1];
			dp[2] = Math.max(Math.max(dp[1], wineArr[0] + wineArr[2]), wineArr[1] + wineArr[2]);
			for (int i = 3; i < n; i++) {
				// dp[i - 1]
				// 이번 포도주를 마시지 않음
				// 연속 3잔 마시기 제한을 피하기 위한 선택 일 수도 있음

				// dp[i - 2] + wineArr[i]
				// 현재 포도주를 마시지만, 직전 포도주는 건너뛴 경우
				// 한 칸 띄고 마실때

				// dp[i - 3] + wineArr[i - 1] + wineArr[i]
				// 현재 포도주와 직전 포도주를 마시지만, 그 전 포도주는 건너뛴 경우
				dp[i] = Math.max(Math.max(dp[i - 1], (dp[i - 2] + wineArr[i])),	(dp[i - 3] + wineArr[i - 1] + wineArr[i]));
			}
			// System.out.println("dp = " + Arrays.toString(dp));
			System.out.println(dp[n - 1]);
		}
	}
}
