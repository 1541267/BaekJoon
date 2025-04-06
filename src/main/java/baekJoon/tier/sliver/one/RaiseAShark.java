package baekJoon.tier.sliver.one;

// (실버 1) 30892번 상어 키우기
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1.5 초	1024 MB	1662	501	382	32.988%
// 문제
//
//
// 인천대학교의 앞바다에는
// $N$마리의 상어가 살고 있다고 한다. 각각의 상어는 서로 같거나 다른 크기의 몸집
// $A_i$를 가지고 있다. 상어의 세계는 완전한 약육강식의 세계로, 상어 자신의 크기보다 작은 상어는 전부 먹을 수 있다. 이때, 상어의 크기는 잡아먹힌 상어의 크기만큼 커지게 된다. 반면, 자신의 크기 이상인 상어는 전혀 잡아먹지 못한다.
//
// 어느 날 크기가
// $T$인 샼이라는 이름의 아기 상어는 인천대학교 앞바다에 존재하는
// $N$마리 상어들의 크기 정보를 모두 입수했다. 똑똑한 아기 상어 샼은 인천대학교 앞바다에 있는 상어들을 최대
// $K$마리까지 적절한 순서로 잡아먹고, 자신의 몸집을 최대로 키울 계획을 하고 있다.
//
// 샼이 최선의 선택으로 최대
// $K$마리의 상어를 적절한 순서로 잡아먹었을 때, 몸집이 최대 얼마까지 커질 수 있는지 구해보자.
//
// 입력
// 첫째 줄에 인천대학교 앞바다에 존재하는 상어의 마릿수
// $N$과, 샼이 먹을 수 있는 상어의 최대 마릿수
// $K$, 샼의 최초 크기를 나타내는 정수
// $T$가 공백으로 구분되어 주어진다.
// $(1\le K \leq N \le 200,000, \space 1 \le T \le 10^9)$ 
//
// 둘째 줄에는 인천대학교 앞바다에 존재하는
// $N$마리의 상어 크기를 나타내는 정수
// $A_i$가 각각 공백으로 구분되어 주어진다.
// $(1 \le A_i \le 10^9)$ 
//
// 출력
// 샼이 최선의 선택으로 최대
// $K$마리의 상어를 적절한 순서로 잡아먹었을 때, 몸집이 최대 얼마까지 커질 수 있는지 출력하시오.
//
// 정답은 32비트 정수 변수(int) 범위를 초과할 수 있기 때문에 64비트 정수 변수(C/C++ : long long, JAVA : long)를 사용해야 한다.
//
// 예제 입력 1
// 5 3 10
// 15 24 10 1 5
// 예제 출력 1
// 49
// 크기가 5, 10, 24인 상어를 순서대로 먹는 것이 최선이다.
//
// 예제 입력 2
// 5 3 1
// 15 24 10 1 5
// 예제 출력 2
// 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class RaiseAShark {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = (int) readNumber(br);
		long K = readNumber(br);
		long currentT = readNumber(br);

		long[] sharks = new long[N];
		for (int i = 0; i < N; i++) {
			sharks[i] = readNumber(br);
		}
		Arrays.sort(sharks);

		PriorityQueue<Long> candidates = new PriorityQueue<>(Collections.reverseOrder());

		int i = 0;
		int count = 0;
		while (count < K) {
			while (i < N && sharks[i] < currentT) {
				candidates.add(sharks[i]);
				i++;
			}

			if (candidates.isEmpty()) {
				break;
			}

			long best = candidates.poll();
			currentT += best;
			count++;
		}

		System.out.println(currentT);
	}

	private static long readNumber(BufferedReader br) throws IOException {
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
