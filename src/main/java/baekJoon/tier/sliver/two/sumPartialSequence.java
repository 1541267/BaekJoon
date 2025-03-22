package baekJoon.tier.sliver.two;

// (실버 2) 1182번 부분수열의 합
// 브루트포스 알고리즘, 백트래킹, 비트마스킹
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	256 MB	101345	45867	29908	43.318%
// 문제
// N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 주어지는 정수의 절댓값은 100,000을 넘지 않는다.
//
// 출력
// 첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
//
// 예제 입력 1
// 5 0
// -7 -3 -2 5 8
// 예제 출력 1
// 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sumPartialSequence {
	static int n;
	static int m;
	static int count = 0;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = readNumber(br);
		m = readNumber(br);

		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = readNumber(br);
		}

		int sum = 0;

		findSubSequence(0, sum);
		if(m == 0) count--;

		System.out.print(count);

	}

	private static void findSubSequence(int index, int sum) {
		if (index == n) {
			if (sum == m) {
				count++;
			}
			return;
		}

		findSubSequence(index + 1, sum + arr[index]);
		findSubSequence(index + 1, sum);
	}

	private static int readNumber(BufferedReader br) throws IOException {
		int value = 0;
		int sign = 1;
		int c = br.read();

		if (c == '-') {
			sign = -1;
			c = br.read();
		}

		while (c == ' ') {
			c = br.read();
		}

		do {
			value = value * 10 + (c - '0');
		} while ((c = br.read()) >= '0' && c <= '9');

		return value * sign;
	}
}

// 비트마스킹, 216ms
// public class sumPartialSequence {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		int n = readNumber(br);
// 		int m = readNumber(br);
//
// 		int[] arr = new int[n];
//
// 		for (int i = 0; i < n; i++) {
// 			arr[i] = readNumber(br);
// 		}
//
// 		int count = 0;
// 		for (int i = 1; i < (1 << n); i++) {
// 			int sum = 0;
// 			for (int j = 0; j < n; j++) {
// 				if ((i & (1 << j)) != 0) {
// 					sum += arr[j];
// 				}
// 			}
//
// 			if (sum == m)
// 				count++;
// 		}
//
// 		System.out.print(count);
//
// 	}
//
// 	private static int readNumber(BufferedReader br) throws IOException {
// 		int value = 0;
// 		int sign = 1;
// 		int c = br.read();
//
// 		if (c == '-') {
// 			sign = -1;
// 			c = br.read();
// 		}
//
// 		while (c == ' ') {
// 			c = br.read();
// 		}
//
// 		do {
// 			value = value * 10 + (c - '0');
// 		} while ((c = br.read()) >= '0' && c <= '9');
//
// 		return value * sign;
// 	}
// }
