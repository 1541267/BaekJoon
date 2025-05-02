package baekJoon.tier.sliver.three;

/*
(실버 3) 17124번 두 개의 배열
정렬, 이분 탐색
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	512 MB	1750	664	497	36.815%
문제
정수 배열 A 와 B가 있다. A는 총 n개의 서로 다른 양의 정수를 포함하고 B는 총 m개의 서로 다른 양의 정수를 포함한다.

A, B를 이용해서 길이가 n인 새로운 배열 C를 만들어보자.

C[i] 는 배열 B에 있는 값 중 A[i] 에 가장 가까운 값 (절대값 차이가 가장 작은 값)으로 정의 된다.
만약 이 조건을 만족하는 값들이 여럿 있는 경우, 그 중 가장 크기가 작은 값으로 정의 된다.
예를 들어 A = [20, 5, 14, 9] 그리고 B = [16, 8, 12] 라고 해보자.

C[1] = 16 이다 - 왜냐하면 B[1] = 16이 A[1] = 20에 가장 가깝기 때문이다.
C[2] = 8 이다 - 왜냐하면 B[2] = 8이 A[2] = 5에 가장 가깝기 때문이다.
C[3] = 12 이다 - 왜냐하면 B[1] = 16 와 B[3] = 12 모두 A[3] = 14에 가장 가깝지만, B[3]의 값이 더 작기 때문이다.
C[4] = 8이다.
이 예제의 경우 C = [16, 8, 12, 8]으로 정의된다.

두 배열 A와 B가 주어졌을 때, 새로운 배열 C를 계산하여 배열 C에 포함된 값들의 합을 구하는 프로그램을 작성하시오.

입력
첫 줄에 테스트 케이스의 수 T (1 <= T <= 10)가 주어진다.

각 테스트 케이스는 세 줄에 걸쳐서 주어진다.

첫 줄에는 n과 m이 공백으로 구분되어 주어진다 (1 <= n, m <= 10^6).

두 번째 줄에는 공백으로 구분된 n개의 정수가 주어지며, A[1] 부터 A[n]을 나타낸다 (각각의 값은 1이상 10^9 이하이다).

세 번째 줄에는 공백으로 구분된 m개의 정수가 주어지며, B[1] 부터 B[m]을 나타낸다 (각각의 값은 1이상 10^9 이하이다).

앞서 언급한대로, A와 B는 각각 서로 다른 양의 정수들을 포함한 배열들이다.

출력
각 테스트 케이스에 대해 배열 C를 구하고 해당 배열의 모든 원소 합을 한 줄에 출력하시오.

예제 입력 1
3
4 3
20 5 14 9
16 8 12
3 4
16 8 12
20 5 14 9
3 3
1 2 3
2 3 4
예제 출력 1
44
37
7
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1016ms
public class TwoArray {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int z = 0; z < t; z++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			StringTokenizer firstArr = new StringTokenizer(br.readLine());

			int[] arr = new int[m];

			for (int i = 0; i < m; i++) {
				arr[i] = readNumber(br);
			}
			Arrays.sort(arr);
			long sum = 0;
			while (firstArr.hasMoreTokens()) {
				sum += bs(arr, Integer.parseInt(firstArr.nextToken()));

			}
			sb.append(sum).append("\n");
		}
		System.out.print(sb);
	}

	private static int bs(int[] arr, int target) {
		int left = 0, right = arr.length - 1;
		int best = arr[0];
		int minDiff = Math.abs(arr[0] - target);

		while (left <= right) {
			int mid = left + (right - left) / 2;
			int diff = Math.abs(arr[mid] - target);

			if (diff < minDiff || (diff == minDiff && arr[mid] < best)) {
				best = arr[mid];
				minDiff = diff;
			}

			if (arr[mid] > target) {
				right = mid - 1;
			} else if (arr[mid] < target) {
				left = mid + 1;
			} else {
				return arr[mid];
			}
		}

		return best;
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

// 1308ms
// public class TwoArray {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringBuilder sb = new StringBuilder();
//
// 		int t = Integer.parseInt(br.readLine());
//
// 		for (int z = 0; z < t; z++) {
// 			StringTokenizer st = new StringTokenizer(br.readLine());
//
// 			int n = Integer.parseInt(st.nextToken());
// 			int m = Integer.parseInt(st.nextToken());
// 			// 첫 배열
// 			StringTokenizer firstArr = new StringTokenizer(br.readLine());
//
// 			int[] arr = new int[m];
// 			StringTokenizer secondArr = new StringTokenizer(br.readLine());
//
// 			int index = 0;
// 			while (secondArr.hasMoreTokens()) {
// 				arr[index++] = Integer.parseInt(secondArr.nextToken());
// 			}
// 			Arrays.sort(arr);
// 			int sum = 0;
// 			while (firstArr.hasMoreTokens()) {
// 				sum += bs(arr, Integer.parseInt(firstArr.nextToken()));
// 			}
// 			sb.append(sum).append("\n");
// 		}
// 		System.out.print(sb);
// 	}
//
// 	private static int bs(int[] arr, int target) {
// 		int left = 0, right = arr.length - 1;
//
// 		while (left <= right) {
// 			int mid = left + (right - left) / 2;
//
// 			if (arr[mid] > target) {
// 				right = mid - 1;
// 			} else if (arr[mid] < target) {
// 				left = mid + 1;
// 			} else {
// 				return arr[mid];
// 			}
// 		}
//
// 		// left -> target보다 크거나 같은 첫 위치
// 		// right -> target 보다 작은 마지막 위치
//
// 		int num1 = (left < arr.length) ? arr[left] : Integer.MAX_VALUE;
// 		int num2 = (right >= 0) ? arr[right] : Integer.MAX_VALUE;
//
// 		int diff1 = Math.abs(num1 - target);
// 		int diff2 = Math.abs(num2 - target);
//
// 		if (diff1 < diff2) return num1;
// 		else if (diff1 > diff2) return num2;
// 		else return Math.min(num1, num2);
// 	}
// }
