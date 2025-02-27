package baekJoon.tier.sliver.four;

// (실버 4) 13706번 제곱근
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	512 MB	6649	2008	1636	35.527%
// 문제
// 정수 N이 주어졌을 때, N의 제곱근을 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 양의 정수 N이 주어진다. 정수 N의 제곱근은 항상 정수이며, N의 길이는 800자리를 넘지 않는다.
//
// 출력
// 첫째 줄에 정수 N의 제곱근을 출력한다.
//
// 예제 입력 1
// 36
// 예제 출력 1
// 6
// 예제 입력 2
// 81
// 예제 출력 2
// 9
// 예제 입력 3
// 226576
// 예제 출력 3
// 476

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SquareRoot {

	// gpt 이진 탐색, 192ms
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();

		BigInteger N = new BigInteger(n);
		BigInteger low = BigInteger.ONE;
		BigInteger high = N;
		BigInteger two = BigInteger.TWO;

		while (low.compareTo(high) <= 0) {
			BigInteger mid = low.add(high).divide(two);
			BigInteger midSquared = mid.multiply(mid);

			int cmp = midSquared.compareTo(N);
			if (cmp == 0) {
				System.out.println(mid);
				return;
			} else if (cmp < 0) {
				low = mid.add(BigInteger.ONE);
			} else {
				high = mid.subtract(BigInteger.ONE);
			}
		}

		System.out.println(high); // high가 제곱근
	}
}


// 직접 푼 것, 110ms
// public class SquareRoot {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		String n = br.readLine();
//
// 		BigInteger a = new BigInteger(n);
//
// 		System.out.println(a.sqrt());
//
// 	}
// }
