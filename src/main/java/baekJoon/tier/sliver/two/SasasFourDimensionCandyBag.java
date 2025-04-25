package baekJoon.tier.sliver.two;

// (실버 2) 27968번 사사의 사차원 사탕 봉지
// 이분 탐색, 누적 합
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	1024 MB	871	422	361	48.522%
// 문제
// 사사는 사탕이 무한히 들어있는 사차원 사탕 봉지를 가지고 있다. 사사는 사탕을 먹고 싶어 하는
// $N$명의 아이들에게 순서대로 사탕을 주려고 한다.
//
// 사사는 손이 작기 때문에 한 번에 많은 사탕을 쥘 수 없어서, 여러 번에 걸쳐 사탕을 꺼내려고 한다. 한 명의 아이가 새로 올 때마다 사사는 사탕을 최대
// $M$번 꺼내며, 꺼낼 때 차례로
// $A_1$개,
// $A_2$개,
// $A_3$개,
// $\cdots$,
// $A_M$개씩 꺼낸다. 이때, 사사가 사탕을 꺼낼 땐 반드시 하나 이상을 꺼낸다.
//
//  
// $i$번째로 오는 아이는 사탕을
// $B_i$개 받고 싶어 한다.
// $i$번째 아이에게 사탕을 줄 때, 도중에 꺼낸 사탕 개수의 총합이
// $B_i$개 이상이 되면 그 아이는 사사가 꺼낸 모든 사탕을 받고 떠난다. 만약
// $M$번 사탕을 꺼냈음에도 아이가 원하는 만큼의 사탕을 꺼내지 못한다면, 사사는 그 아이를 쫓아낸다.
//
//  
// $N$명의 아이가 원하는 사탕의 개수가 순서대로 주어질 때, 각 아이가 사탕을 받고 떠날 때까지 사사가 사탕을 꺼내야 하는 횟수를 구하시오.
//
// 입력
// 첫 번째 줄에 아이의 수
// $N$과 사사가 사탕을 꺼내주려고 하는 최대 횟수
// $M$이 공백으로 구분되어 주어진다. (
// $1 \le N \le 300 \, 000$,
// $1 \le M \le 300 \, 000$)
//
// 두 번째 줄에 사사가 한 번에 사탕을 꺼내는 횟수
// $A_1, A_2, \cdots, A_M$이 공백으로 구분되어 주어진다. (
// $1 \le j \le M$,
// $1 \le A_j \le {10}^9$)
//
// 세 번째 줄부터
// $N$개의 줄에 걸쳐 각 아이가 받고 싶어하는 사탕의 개수
// $B_1, B_2, \cdots, B_N$이 한 줄에 하나씩 주어진다. (
// $1 \le i \le N$,
// $1 \le B_i \le {10}^{12}$)
//
// 입력으로 주어지는 수는 모두 정수이다.
//
// 출력
//  
// $N$개의 줄에 걸쳐,
// $i$번째 아이에게 사탕을 원하는 만큼 주기 위해 사사가 사탕을 꺼내야 하는 횟수를
// $i$번째 줄에 출력한다. 만약 사사가
// $i$번째 아이를 쫓아낸다면
// $i$번째 줄에 Go away!를 출력한다.
//
// 예제 입력 1
// 10 10
// 1 2 3 4 5 6 7 8 9 10
// 3
// 6
// 10
// 15
// 21
// 28
// 37
// 45
// 55
// 66
// 예제 출력 1
// 2
// 3
// 4
// 5
// 6
// 7
// 9
// 9
// 10
// Go away!
// 예제 입력 2
// 4 10
// 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000
// 1000000000
// 1000000000000
// 10000000001
// 10000000000
// 예제 출력 2
// 1
// Go away!
// Go away!
// 10

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 468ms
public class SasasFourDimensionCandyBag {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = (int)readNumber(br);
		int m = (int)readNumber(br);

		long[] pickUpCount = new long[m + 1];
		long sumAndTotal = 0;

		for (int i = 1; i <= m; i++) {
			long input = readNumber(br);
			sumAndTotal += input;
			pickUpCount[i] = sumAndTotal;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			long result = bs(pickUpCount, sumAndTotal, readNumber(br));

			if (result == -1) sb.append("Go away!\n");
			else sb.append(result).append("\n");
		}

		System.out.print(sb);
	}

	private static long bs(long[] arr, long max, long target) {

		if (target == max) {
			return arr.length - 1;

		} else if (target > max) {
			return -1;
		}

		int left = 1;
		int right = arr.length - 1;
		int correct = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] >= target) {
				correct = mid;
				right = mid - 1;
			} else if (arr[mid] < target) {
				left = mid + 1;
			}
		}
		return correct;
	}

	private static long readNumber(BufferedReader br) throws IOException {
		long value = 0;
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

// 불필요한 전역변수 제거, bs 값 반환으로 바로 사용. 520ms
// public class SasasFourDimensionCandyBag {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
// 		int n = (int)readNumber(br);
// 		int m = (int)readNumber(br);
//
// 		long[] pickUpCount = new long[m + 1];
// 		long sumAndTotal = 0;
//
// 		for (int i = 1; i <= m; i++) {
// 			long input = readNumber(br);
// 			sumAndTotal += input;
// 			pickUpCount[i] = sumAndTotal;
// 		}
//
// 		for (int i = 1; i <= n; i++) {
// 			long result = bs(pickUpCount, sumAndTotal, readNumber(br));
//
// 			if (result == -1) bw.write("Go away!\n");
// 			else bw.write(result + "\n");
// 		}
// 		bw.flush();
// 		bw.close();
// 		br.close();
// 	}
//
// 	private static long bs(long[] arr, long max, long target) {
//
// 		if (target == max) {
// 			return arr.length - 1;
//
// 		} else if (target > max) {
// 			return -1;
// 		}
//
// 		int left = 1;
// 		int right = arr.length - 1;
// 		int correct = -1;
//
// 		while (left <= right) {
// 			int mid = left + (right - left) / 2;
//
// 			if (arr[mid] >= target) {
// 				correct = mid;
// 				right = mid - 1;
// 			} else if (arr[mid] < target) {
// 				left = mid + 1;
// 			}
// 		}
// 		return correct;
// 	}
//
// 	private static long readNumber(BufferedReader br) throws IOException {
// 		long value = 0;
// 		int c = br.read();
//
// 		while (c == ' ') {
// 			c = br.read();
// 		}
//
// 		do {
// 			value = value * 10 + (c - '0');
// 		} while ((c = br.read()) >= '0' && c <= '9');
//
// 		return value;
// 	}
// }

// 처음 푼 것, 544ms
// public class SasasFourDimensionCandyBag {
//
// 	static long[] result;
// 	static int index = 0;
//
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
// 		int n = (int)readNumber(br);
// 		int m = (int)readNumber(br);
//
// 		long[] pickUpCount = new long[m + 1];
// 		long sumAndTotal = 0;
//
// 		for (int i = 1; i <= m; i++) {
// 			long input = readNumber(br);
// 			sumAndTotal += input;
// 			pickUpCount[i] = sumAndTotal;
// 		}
// 		result = new long[n + 1];
//
// 		for (int i = 1; i <= n; i++) {
//
// 			bs(pickUpCount, sumAndTotal, readNumber(br));
// 		}
//
// 		for (long l : result) {
// 			if (l == -1) {
// 				bw.write("Go away!\n");
// 			} else if (l != 0) {
// 				bw.write(l + "\n");
// 			}
// 		}
//
// 		bw.flush();
// 		bw.close();
// 		br.close();
//
// 	}
//
// 	private static void bs(long[] arr, long max, long target) {
//
// 		index++;
//
// 		if (target == max) {
// 			result[index] = arr.length - 1;
// 			return;
// 		} else if (target > max) {
// 			result[index] = -1;
// 			return;
// 		}
//
// 		int left = 1;
// 		int right = arr.length - 1;
// 		int correct = -1;
//
// 		while (left <= right) {
// 			int mid = left + (right - left) / 2;
//
// 			if (arr[mid] >= target) {
// 				correct = mid;
// 				right = mid - 1;
// 			} else if (arr[mid] < target) {
// 				left = mid + 1;
// 			}
// 		}
//
// 		result[index] = correct;
// 	}
//
// 	private static long readNumber(BufferedReader br) throws IOException {
// 		long value = 0;
// 		int c = br.read();
//
// 		while (c == ' ') {
// 			c = br.read();
// 		}
//
// 		do {
// 			value = value * 10 + (c - '0');
// 		} while ((c = br.read()) >= '0' && c <= '9');
//
// 		return value;
// 	}
// }
