package baekJoon.tier.sliver.two;

// (실버 2) 5636번 소수 부분 문자열
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	128 MB	1451	675	574	48.033%
// 문제
// 숫자로 이루어진 문자열이 주어진다. 이때, 부분 문자열 중에서 가장 큰 소수를 찾는 프로그램을 작성하시오.
//
// 이 문제에서는 2보다 크거나 같고, 100,000보다 작거나 같은 소수만 소수이다.
//
// 입력
// 입력은 여러 개의 테스트 케이스로 이루어져 있다. 테스트 케이스의 개수는 1,000개를 넘지 않는다.
//
// 각 테스트 케이스는 길이가 255를 넘지 않는 숫자 문자열로 이루어져 있다. 입력의 마지막 줄에는 0이 하나 주어진다.
//
// 소수 부분 문자열이 최소 하나 이상 존재하는 입력만 주어진다.
//
// 출력
// 각 테스트 케이스에 대해서, 가장 큰 소수 부분 문자열을 출력한다.
//
// 예제 입력 1
// 11245
// 91321150448
// 1226406
// 0
// 예제 출력 1
// 11
// 1321
// 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrimeNumberInString {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringBuilder sb = new StringBuilder();

		while (!input.equals("0")) {
			int result = 0;

			for (int i = 1; i <= 5; i++) {
				for (int j = 0; i + j <= input.length(); j++) {
					int num = Integer.parseInt(input.substring(j, j + i));
					if(isPrime(num)) {
						result = Math.max(result, num);
					}
				}
			}

			sb.append(result).append("\n");
			input = br.readLine();
		}
		System.out.print(sb.deleteCharAt(sb.length() - 1));
	}

	private static boolean isPrime(int num) {

		boolean[] isPrime = new boolean[100_001];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i * i <= num; i++) {
			if(isPrime[i]) {
				for(int j = i * i; j <= num; j += i) {
					isPrime[j] = false;
				}
			}
		}
		return isPrime[num];
	}

}
