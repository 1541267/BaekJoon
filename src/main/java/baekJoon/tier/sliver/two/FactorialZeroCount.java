package baekJoon.tier.sliver.two;

// (실버 1) 11687번 팩토리얼 0의 개수
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 0.5 초 (추가 시간 없음)	256 MB	2679	1092	871	45.650%
// 문제
// 가장 끝의 0의 개수가 M개인 N! 중에서 가장 작은 N을 찾는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 M (1 ≤ M ≤ 100,000,000)이 주어진다.
//
// 출력
// 가장 끝의 0의 개수가 M개인 N! 중에서 가장 작은 N을 출력한다. 그러한 N이 없는 경우에는 -1을 출력한다.
//
// 예제 입력 1
// 1
// 예제 출력 1
// 5
// 예제 입력 2
// 2
// 예제 출력 2
// 10
// 예제 입력 3
// 3
// 예제 출력 3
// 15
// 예제 입력 4
// 4
// 예제 출력 4
// 20
// 예제 입력 5
// 5
// 예제 출력 5
// -1
// 예제 입력 6
// 6
// 예제 출력 6
// 25
// 예제 입력 7
// 7
// 예제 출력 7
// 30

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactorialZeroCount {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = readNumber(br);

		int left = 0, right = m * 5;
		int answer = -1;
		while (left <= right) {

			int mid = left + (right - left) / 2;
			int temp = mid;
			int sum = 0;

			while (temp > 0) {
				temp /= 5;
				sum += temp;
			}

			if (sum >= m) {
				if (sum == m) answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}

	private static int readNumber(BufferedReader br) throws IOException {
		int value = 0;
		int c = br.read();

		while (c == ' ') {
			c = br.read();
		}

		do {
			value = value * 10 + (c - '0');
		} while ((c = br.read()) >= '0' && c <= '9');

		return value;
	}
}
