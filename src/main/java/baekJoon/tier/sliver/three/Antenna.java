package baekJoon.tier.sliver.three;

// 실버(3) 18310번 안테나
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	256 MB	21469	7806	6195	36.260%
// 문제
// 일직선 상의 마을에 여러 채의 집이 위치해 있다. 이중에서 특정 위치의 집에 특별히 한 개의 안테나를 설치하기로 결정했다. 효율성을 위해 안테나로부터 모든 집까지의 거리의 총 합이 최소가 되도록 설치하려고 한다. 이 때 안테나는 집이 위치한 곳에만 설치할 수 있고, 논리적으로 동일한 위치에 여러 개의 집이 존재하는 것이 가능하다.
//
// 집들의 위치 값이 주어질 때, 안테나를 설치할 위치를 선택하는 프로그램을 작성하시오.
//
// 예를 들어 N=4이고, 각 위치가 1, 5, 7, 9일 때를 가정하자.
//
//
//
// 이 경우 5의 위치에 설치했을 때, 안테나로부터 모든 집까지의 거리의 총 합이 (4+0+2+4)=10으로, 최소가 된다.
//
// 입력
// 첫째 줄에 집의 수 N이 자연수로 주어진다. (1≤N≤200,000) 둘째 줄에 N채의 집에 위치가 공백을 기준으로 구분되어 1이상 100,000이하의 자연수로 주어진다.
//
// 출력
// 첫째 줄에 안테나를 설치할 위치의 값을 출력한다. 단, 안테나를 설치할 수 있는 위치 값으로 여러 개의 값이 도출될 경우 가장 작은 값을 출력한다.
//
// 예제 입력 1
// 4
// 5 1 7 9
// 예제 출력 1
// 5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 계수정렬(Counting Sort) 180ms
public class Antenna {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = readNumber(br);

		if (n == 1) {
			System.out.println(readNumber(br));
			return;
		}

		int[] numArr = new int[100_001];  // 1 ~ 100,000

		for (int i = 0; i < n; i++) {
			numArr[readNumber(br)]++;
		}

		int sum = 0;
		for (int i = 1; i <= 100_000; i++) {
			sum += numArr[i];

			if (sum >= (n + 1) / 2) {
				System.out.println(i);
				return;
			}
		}
	}

	private static int readNumber(BufferedReader br) throws IOException {
		int value = 0;
		int sign = 1;
		int c = br.read();

		if (c == '-') {
			sign = -1;
			c = br.read();
		}

		do {
			value = value * 10 + (c - '0');
		} while ((c = br.read()) >= '0' && c <= '9');

		return value * sign;
	}
}

// // 정렬을 하지 않고 우선순위 큐로 중앙 인덱스의 값 출력 300ms
// public class Antenna {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		int n = readNumber(br);
//
// 		if (n == 1) {
// 			System.out.println(readNumber(br));
// 			return;
// 		}
//
// 		PriorityQueue<Integer> queue = new PriorityQueue<>();
//
// 		for (int i = 0; i < n; i++) {
// 			queue.add(readNumber(br));
// 		}
//
// 		for (int i = 0; i < (n - 1) / 2; i++) {
// 			queue.poll();
// 		}
//
// 		System.out.println(queue.poll());
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
// 		do {
// 			value = value * 10 + (c - '0');
// 		} while ((c = br.read()) >= '0' && c <= '9');
//
// 		return value * sign;
// 	}
// }
// 처음에 푼 것, 전체 정렬 후, n이 짝수 = 중앙값, 홀수 일 경우 중앙의  더 작은 앞의 값
// 412ms
// public class Antenna {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		int n = readNumber(br);
//
// 		int[] arr = new int[n];
//
// 		for (int i = 0; i < n; i++) {
// 			arr[i] = readNumber(br);
// 		}
//
// 		Arrays.sort(arr);
//
// 		if (n % 2 == 0) {
// 			System.out.println(arr[n / 2 - 1]);
// 		} else if (n == 1) {
// 			System.out.println(arr[0]);
// 		} else {
// 			System.out.println(arr[n / 2]);
// 		}
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
// 		do {
// 			value = value * 10 + (c - '0');
// 		} while ((c = br.read()) >= '0' && c <= '9');
//
// 		return value * sign;
// 	}
// }
 