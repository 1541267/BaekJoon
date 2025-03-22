package baekJoon.tier.sliver.three;

// (실버 3) 1463번 1로 만들기
// 다이나믹 프로그래밍
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 0.15 초 (하단 참고)	128 MB	333074	115130	73402	33.239%
// 문제
// 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
//
// X가 3으로 나누어 떨어지면, 3으로 나눈다.
// X가 2로 나누어 떨어지면, 2로 나눈다.
// 1을 뺀다.
// 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
//
// 입력
// 첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
//
// 출력
// 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
//
// 예제 입력 1
// 2
// 예제 출력 1
// 1
// 예제 입력 2
// 10
// 예제 출력 2
// 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakingNumberOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];
		dp[1] = 0;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1; // 1을 뺄 때

			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}
		System.out.print(dp[n]);
	}
}
//
// 처음엔 단순 직접 계산으로 코딩 -> 테스트 케이스는 맞게 나오나 에러
// -> DP (다이나믹 프로그래밍) 문제.
// public class MakingNumberOne {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		int n = Integer.parseInt(br.readLine());
// 		int count = 0;
// 		do {
// 			if (n == 1) {
// 				break;
// 			}
//
// 			if (n % 3 == 0 && n % 2 == 0) {
// 				n = n / 3;
// 				count++;
// 			} else if (n % 2 == 0) {
// 				n = n / 2;
// 				count++;
// 			} else {
// 				n--;
// 			}
// 		} while (n != 1);
//
// 		System.out.print(count);
// 	}
// }
