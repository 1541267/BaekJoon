package baekJoon.tier.sliver.five;

// (실버 5) 14916번 거스름돈
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	512 MB	31611	14689	12117	46.876%
// 문제
// 춘향이는 편의점 카운터에서 일한다.
//
// 손님이 2원짜리와 5원짜리로만 거스름돈을 달라고 한다. 2원짜리 동전과 5원짜리 동전은 무한정 많이 가지고 있다. 동전의 개수가 최소가 되도록 거슬러 주어야 한다. 거스름돈이 n인 경우, 최소 동전의 개수가 몇 개인지 알려주는 프로그램을 작성하시오.
//
// 예를 들어, 거스름돈이 15원이면 5원짜리 3개를, 거스름돈이 14원이면 5원짜리 2개와 2원짜리 2개로 총 4개를, 거스름돈이 13원이면 5원짜리 1개와 2원짜리 4개로 총 5개를 주어야 동전의 개수가 최소가 된다.
//
// 입력
// 첫째 줄에 거스름돈 액수 n(1 ≤ n ≤ 100,000)이 주어진다.
//
// 출력
// 거스름돈 동전의 최소 개수를 출력한다. 만약 거슬러 줄 수 없으면 -1을 출력한다.
//
// 예제 입력 1
// 13
// 예제 출력 1
// 5
// 예제 입력 2
// 14
// 예제 출력 2
// 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 100ms
public class Change {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int count = 0;

		while (n > 0) {
			if (n % 5 == 0) {  // 5원으로 최대한 거슬러 줌
				count += n / 5;
				n = 0;
				break;
			}
			n -= 2;  // 5원으로 나눌 수 없으면 2원 사용
			count++;
		}

		System.out.println(n == 0 ? count : -1);
	}
}

// 처음에 적은 것 112ms
// public class Change {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		int n = Integer.parseInt(br.readLine());
//
// 		System.out.println(dp(n, 0));
// 	}
//
// 	private static int dp(int n, int count) {
//
// 		System.out.println("n = " + n);
//
// 		if ((n == 0 || n == 1 || n == 3) && count == 0) {
// 			return -1;
// 		}
//
// 		if (n == 0) {
// 			return count;
// 		}
//
// 		if (n % 5 == 0) {
// 			return (n / 5) + count;
// 		}
//
// 		if ((n - 5) % 2 == 0 && n - 5 > 0) {
// 			return dp(n - 5, count + 1);
// 		} else {
// 			return dp(n - 2, count + 1);
// 		}
// 	}
// }
