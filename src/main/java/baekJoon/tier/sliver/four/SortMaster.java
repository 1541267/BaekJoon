package baekJoon.tier.sliver.four;

// (실버 4) 20551번 Sort 마스터 배지훈의 후계자
// 자료 구조, 정렬, 이분 탐색
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	512 MB	4939	1775	1350	38.017%
// 문제
// 지훈이는 Sort 마스터다. 오랫동안 Sort 마스터 자리를 지켜온 지훈이는 이제 마스터 자리를 후계자에게 물려주려고 한다. 수많은 제자들 중에 후계자를 고르기 위해서 지훈이는 제자들에게 문제를 준비했다. 먼저 제자들에게
// $N$개의 원소를 가진 배열
// $A$를 주고,
// $A$의 원소들이 오름차순으로 정렬된 배열
// $B$를 만들게 한다. 그다음
// $M$개의 질문을 한다. 각 질문에는 정수
// $D$가 주어진다. 제자들은 주어진 정수
// $D$가
// $B$에서 가장 먼저 등장한 위치를 출력하면 된다. 단,
// $D$가
// $B$에 존재하지 않는 경우에는 -1를 출력한다. Sort 마스터의 자리를 너무나도 물려받고 싶은 창국이를 위해 지훈이의 문제를 풀 수 있는 프로그램을 만들어 주자.
//
// 입력
// 첫째 줄에 배열
// $A$의 원소의 개수
// $N$과 질문의 개수
// $M$이 공백으로 구분되어 주어진다.
//
// 다음 줄부터
// $N$줄에 걸쳐 정수
// $A_0, A_1, ... , A_{N-1}$이 주어진다.
//
// 다음 줄부터
// $M$줄에 걸쳐 정수
// $D$가 주어진다.
//
// 출력
//  
// $M$개의 질문에 대해서 주어진
// $D$가
// $B$에서 처음으로 등장한 위치를 출력한다. 단, 존재하지 않는다면 -1를 출력한다. (배열에서 가장 앞의 원소의 위치는 0이다.)
//
// 제한
// 1 ≤
// $N$ ≤ 2×105
// 1 ≤
// $M$ ≤ 2×105
// -109 ≤
// $A_i$ ≤ 109
// -109 ≤
// $D$ ≤ 109
// 예제 입력 1
// 5 5
// 9
// 0
// -1
// 3
// 2
// -1
// 10
// 5
// 9
// 0
// 예제 출력 1
// 0
// -1
// -1
// 4
// 1
// 예제 입력 2
// 8 4
// 3
// 3
// 4
// 9
// 2
// 5
// 3
// 4
// 3
// 10
// 4
// 2
// 예제 출력 2
// 1
// -1
// 4
// 0

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 처음에 푼 것, 이진 탐색, 756ms
public class SortMaster {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = readNumber(br);
		int m = readNumber(br);

		int[] arr = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = readNumber(br);
		}

		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			sb.append(binarySearch(arr, n, readNumber(br))).append("\n");
		}

		System.out.print(sb);
	}

	private static int binarySearch(int[] arr, int right, int target) {
		int left = 0;
		int mid = 0;
		int findIndex = 0;
		int length = arr.length;

		while (left <= right) {
			mid = left + (right - left) / 2;
			if (mid >= length) {
				return -1;
			}

			if (arr[mid] >= target) {
				findIndex = mid;
				right = mid - 1;
			} else if (arr[mid] < target) {
				left = mid + 1;
			}
		}

		if (arr[findIndex] != target) {
			return -1;
		}
		return findIndex;
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

// // 752ms 차이는 별로 없는듯
// public class SortMaster {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
// 		int n = readNumber(br);
// 		int m = readNumber(br);
//
// 		int[] arr = new int[n];
// 		int max = 0;
// 		for (int i = 0; i < n; i++) {
// 			arr[i] = readNumber(br);
// 			max = Math.max(arr[i], max);
// 		}
//
// 		Arrays.sort(arr);
// 		StringBuilder sb = new StringBuilder();
//
// 		for (int i = 0; i < m; i++) {
// 			sb.append(binarySearch(arr, readNumber(br))).append("\n");
// 		}
//
// 		bw.write(sb.toString());
// 		bw.flush();
// 		bw.close();
// 		br.close();
// 	}
//
// 	private static int binarySearch(int[] arr, int target) {
// 		int left = 0;
// 		int mid = 0;
// 		int right = arr.length;
//
// 		while (left < right) {
// 			mid = left + (right - left) / 2;
//
// 			if (mid > arr.length)
// 				return -1;
//
// 			if (arr[mid] >= target) {
// 				right = mid;
// 			} else {
// 				left = mid + 1;
// 			}
// 		}
//
// 		return (left < arr.length && arr[left] == target) ? left : -1;
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
// map으로 풀어본 것, 더 느려짐, 844ms
// public class SortMaster {
// 	static int n;
//
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		n = readNumber(br);
// 		int m = readNumber(br);
//
// 		int[] arr = new int[n];
// 		int max = 0;
// 		for (int i = 0; i < n; i++) {
// 			arr[i] = readNumber(br);
// 			max = Math.max(arr[i], max);
// 		}
//
// 		Arrays.sort(arr);
//
// 		HashMap<Integer, Integer> map = new HashMap<>();
//
// 		for (int i = 0; i < n; i++) {
// 			map.putIfAbsent(arr[i], i);
// 		}
//
// 		StringBuilder sb = new StringBuilder();
//
// 		for (int i = 0; i < m; i++) {
// 			sb.append(map.getOrDefault(readNumber(br), -1)).append("\n");
// 		}
// 		System.out.print(sb);
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
//