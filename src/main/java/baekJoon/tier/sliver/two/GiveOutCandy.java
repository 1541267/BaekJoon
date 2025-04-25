package baekJoon.tier.sliver.two;

// (실버 2) 28357번 사탕 나눠주기
// 이분 탐색, 매개 변수 탐색
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초 (추가 시간 없음)	1024 MB (추가 메모리 없음)	1085	367	307	35.166%
// 문제
// 소수전공 수업을 마무리한 찬우는 축하의 의미로 학생들에게 사탕을 나누어 주려 한다. 구체적으로, 기준이 되는 음이 아닌 정수
// $X$를 정한 뒤 최종 점수가
// $X$점을 넘는 학생들에게 점수가 높은 만큼 많은 사탕을 줄 것이다. 즉,
// $X+1$점을 받은 학생은
// $1$개,
// $X+2$점을 받은 학생은
// $2$개,
// $T$(
// $T > X$)점을 받은 학생은
// $T - X$개의 사탕을 받게 된다.
//
// 찬우는 학생들에게 최대한 많은 사탕을 나누어주고 싶기 때문에 기준 점수
// $X$를 가능한 한 낮게 정하려 한다. 하지만, 지금 가지고 있는 돈으로는 사탕을
// $K$개까지만 살 수 있기 때문에 사탕의 총 개수가
// $K$개를 넘으면 안 된다.
//
// 찬우의 수업은 총
// $N$명이 수강했고,
// $i$번째 학생은
// $A_i$점을 받았다. 수강생의 수와 각 학생의 점수, 사탕의 최대 개수
// $K$가 주어질 때 찬우를 위해 가능한
// $X$의 최솟값을 구하는 프로그램을 작성해 주자.
//
// 입력
// 첫째 줄에 정수
// $N$,
// $K$가 공백으로 구분되어 주어진다.
// $(1 \leq N \leq 5\times 10^5;$
// $0 \leq K \leq 10^{12})$ 
//
// 둘째 줄에
// $N$개의 정수
// $A_1, A_2, \dotsm, A_N$이 공백으로 구분되어 주어진다.
// $(0 \leq A_i \leq 10^{12})$ 
//
// 출력
// 첫째 줄에 가능한 기준
// $X$의 최솟값을 출력한다.
//
// 예제 입력 1
// 4 80
// 80 100 50 40
// 예제 출력 1
// 50
// 예제 입력 2
// 4 61
// 80 100 50 40
// 예제 출력 2
// 60

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GiveOutCandy {
	// 484ms
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long k = Long.parseLong(st.nextToken());

		long[] arr = new long[n];

		st = new StringTokenizer(br.readLine());
		int index = 0;
		long max = 0;
		while (st.hasMoreTokens()) {
			long input = Long.parseLong(st.nextToken());
			arr[index++] = input;
			max = Math.max(max, input);
		}

		bs(arr, k, max);

	}

	private static void bs(long[] arr, long maxCandy, long inputMax) {

		long left = 0, right = inputMax;
		long result = right;

		while (left <= right) {
			long mid = left + (right - left) / 2;
			long sum = 0;

			for (long i : arr) {
				if (i > mid) {
					sum += i - mid;
					if (sum > maxCandy) break;
				}
			}

			if (sum <= maxCandy) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(result);
	}
}

// 처음 시도, 실패
// public class Main {
//
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringTokenizer st = new StringTokenizer(br.readLine());
// 		int n = Integer.parseInt(st.nextToken());
// 		long k = Long.parseLong(st.nextToken());
//
// 		long[] arr = new long[n];
//
// 		st = new StringTokenizer(br.readLine());
// 		int index = 0;
// 		while (st.hasMoreTokens()) {
// 			arr[index++] = Long.parseLong(st.nextToken());
// 		}
//
// 		bs(arr, k);
//
// 	}
//
// 	private static void bs(long[] arr, long maxCandy) {
//
// 		long left = 0, right = maxCandy;
//
// 		while (left <= right) {
// 			long mid = left + (right - left) / 2;
// 			long sum = 0;
// 			for (long i : arr) {
// 				if (i - mid > 0) sum += i - mid;
// 			}
//
// 			if (sum == maxCandy) {
// 				left = mid;
// 				break;
// 			}
// 			if (sum > maxCandy) {
// 				left = mid + 1;
// 			} else {
// 				right = mid - 1;
// 			}
// 		}
// 		System.out.println(left);
// 	}
// }