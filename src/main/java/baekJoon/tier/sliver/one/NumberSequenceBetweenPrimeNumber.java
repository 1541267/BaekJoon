package baekJoon.tier.sliver.one;

// (실버 1) 3896번 소수 사이 수열
// 수학, 정수론, 이분 탐색, 소수 판정, 에라토스테네스의 체
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	128 MB	2877	1792	1510	63.312%
// 문제
// 연속한 소수 p와 p+n이 있을 때, 그 사이에 있는 n-1개의 합성수(소수나 1이 아닌 양의 정수)는 길이가 n인 소수 사이 수열라고 부른다.
//
// 양의 정수 k가 주어졌을 때, k를 포함하는 소수 사이 수열의 길이를 구하는 프로그램을 작성하시오. k를 포함하는 소수 사이 수열이 없을 때는 길이가 0이다.
//
// 예를 들어, 소수 23과 29의 소수 사이 수열은 {24, 25, 26, 27, 28}이고, 길이는 6이다.
//
// 입력
// 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 테스트 케이스는 한 줄로 이루어져 있고, 한 줄에 정수 k가 주어진다. 각각의 정수는 1보다 크고, 100000번째 소수(1299709)와 작거나 같다.
//
// 출력
// 각각의 테스트 케이스에 대해서 k가 합성수라면 k를 포함하는 소수 사이 수열의 길이를 출력한다. 그렇지 않으면 0을 출력한다.
//
// 예제 입력 1
// 5
// 10
// 11
// 27
// 2
// 492170
// 예제 출력 1
// 4
// 0
// 6
// 0
// 114

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 처음에 푼 방법은 소수를 찾고 베열에 저장해서 + binarySearch로 찾아서 시간이 더 걸림
// -> 소수 유무만 저장 해 두고 bs따로 할 필요 없이
// isPrime 배열에서 직접 인접 소수를 선형 탐색 -> 이진탐색 필요 X
// 128ms
public class NumberSequenceBetweenPrimeNumber {

	// static int[] primes = new int[100000];
	static boolean[] isPrime = new boolean[1299710];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		prime();
		for (int z = 0; z < t; z++) {
			int n = Integer.parseInt(br.readLine());

			if (isPrime[n]) {
				sb.append(0).append("\n");
			} else {
				int lowerIndex = n - 1;
				int upperIndex = n + 1;

				while (!isPrime[lowerIndex]) lowerIndex--;
				while (!isPrime[upperIndex]) upperIndex++;
				sb.append(upperIndex - lowerIndex).append("\n");
			}
		}
		System.out.println(sb);
	}

	// private static int bs(int left, int n) {
	//
	// 	int right = primes.length - 1;
	//
	// 	while (left <= right) {
	//
	// 		int mid = left + (right - left) / 2;
	//
	// 		if (primes[mid] > n) {
	// 			right = mid - 1;
	// 		} else if (primes[mid] < n) {
	// 			left = mid + 1;
	// 		}
	//
	// 	}
	//
	// 	return left;
	//
	// }

	private static void prime() {

		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i * i <= 1299709; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= 1299709; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}
}

// 처음 푼 것, 144ms
// public class NumberSequenceBetweenPrimeNumber {
//
// 	static int[] primes = new int[100000];
// 	static boolean[] isPrime = new boolean[1299710];
//
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringBuilder sb = new StringBuilder();
// 		int t = Integer.parseInt(br.readLine());
//
// 		prime();
// 		for (int z = 0; z < t; z++) {
// 			int n = Integer.parseInt(br.readLine());
//
// 			if (isPrime[n]) {
// 				sb.append(0).append("\n");
// 			} else {
// 				int index = bs(0, n);
// 				sb.append(primes[index] - primes[index - 1]).append("\n");
// 			}
// 		}
// 		System.out.println(sb);
// 	}
//
// 	private static int bs(int left, int n) {
//
// 		int right = primes.length - 1;
//
// 		while (left <= right) {
//
// 			int mid = left + (right - left) / 2;
//
// 			if (primes[mid] > n) {
// 				right = mid - 1;
// 			} else if (primes[mid] < n) {
// 				left = mid + 1;
// 			}
//
// 		}
//
// 		return left;
//
// 	}
//
// 	private static void prime() {
//
// 		Arrays.fill(isPrime, true);
//
// 		isPrime[0] = isPrime[1] = false;
//
// 		for (int i = 2; i * i <= 1299709; i++) {
// 			if (isPrime[i]) {
// 				for (int j = i * i; j <= 1299709; j += i) {
// 					isPrime[j] = false;
// 				}
// 			}
// 		}
// 		int index = 0;
// 		for (int i = 2; i <= 1299709; i++) {
// 			if (isPrime[i]) primes[index++] = i;
// 		}
// 	}
// }
