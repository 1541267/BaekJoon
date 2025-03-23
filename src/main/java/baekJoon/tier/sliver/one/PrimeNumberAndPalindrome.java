package baekJoon.tier.sliver.one;

// (실버 1) 1747번 소수&팰린드롬
// 수학, 브루트포스 알고리즘, 정수론, 소수 판정, 에라토스테네스의 체
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	256 MB	34446	11370	8399	31.133%
// 문제
// 어떤 수와 그 수의 숫자 순서를 뒤집은 수가 일치하는 수를 팰린드롬이라 부른다. 예를 들어 79,197과 324,423 등이 팰린드롬 수이다.
//
// 어떤 수 N (1 ≤ N ≤ 1,000,000)이 주어졌을 때, N보다 크거나 같고, 소수이면서 팰린드롬인 수 중에서, 가장 작은 수를 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 N이 주어진다.
//
// 출력
// 첫째 줄에 조건을 만족하는 수를 출력한다.
//
// 예제 입력 1
// 31
// 예제 출력 1
// 101


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// 처음에 푼 것, 168ms
public class PrimeNumberAndPalindrome {

	static PriorityQueue<Integer> queue = new PriorityQueue<>();
	static int maxNum = 2_000_000;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = readNumber(br);

		if (n == 0) {
			System.out.println(0);
			return;
		} else if (n == 1) {
			System.out.println(2);
			return;
		}

		isPrime(n);

	}

	private static void isPrime(int n) {

		boolean[] isPrime = new boolean[maxNum + 1];
		Arrays.fill(isPrime, true);

		isPrime[0] = false;
		isPrime[1] = false;

		for (int i = 2; i * i <= maxNum; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= maxNum; j += i) {
					isPrime[j] = false;
				}
			}
		}
		for (int i = n; i <= maxNum; i++) {
			if (isPrime[i] && isPalindrom(i)) {
				System.out.println(i);
				return;
			}
		}
	}

	private static boolean isPalindrom(int i) {

		String line = Integer.toString(i);
		int length = line.length();

		for (int j = 0; j < length / 2; j++) {
			if (line.charAt(j) != line.charAt(length - j - 1)) {
				return false;
			}
		}

		return true;
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
