package baekJoon.tier.sliver.three;

// (실버 3) 11561번 징검 다리
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	256 MB	4681	1571	1094	31.646%
// 문제
// 승택이는 강을 건너려 한다.
//
// 승택이는 수영을 못하기 때문에, 강에 놓인 징검다리를 밟고 건너갈 것이다.
//
// 승택이는 수영은 못하지만 제자리뛰기는 정말 잘한다. 원하는 어느 곳으로든지 점프해서 바로 갈 수가 있다.
//
// 승택이는 이제 강의 한쪽 변 앞에 서 있다.
//
// 강엔 1번부터 시작해 2번, 3번, ... , N번 징검다리가 차례대로 놓여 있다.
//
// 강의 폭이 넓은 탓에 징검다리의 수는 엄청나게 많다.
//
// 이 징검다리를 모두 밟고 싶지는 않았던 승택이는 제자리뛰기 실력을 발휘해 적절한 개수의 징검다리만을 밟고 가기로 했다.
//
// 물론 강 건너편으로 바로 점프하는 것도 가능하지만, 더 재미있게 강을 건너기 위해 승택이는 다음과 같은 규칙을 정했다.
//
// 첫 징검다리는 점프해서 아무 것이나 밟을 수 있다. 이 점프가 첫 점프이다.
// 두 번째 점프부터는 이전에 점프한 거리보다 1 이상 더 긴 거리를 뛰어야만 한다.
// N번 징검다리는 반드시 밟아야 한다.
// N번 징검다리를 밟은 후 강 건너로 이동할 땐 점프를 하지 않으므로 위의 규칙이 적용되지 않는다.
// 승택이가 위의 규칙을 지키며 강을 건널 때, 밟을 수 있는 징검다리의 최대 수는 몇 개일까?
//
// 입력
// 첫째 줄에 테스트 케이스의 수 T가 주어진다.
//
// 각 테스트 케이스는 정수 한 개로 이루어져 있으며, 징검다리의 총 수 N을 의미한다. (1 ≤ N ≤ 1016)
//
// 출력
// 각 테스트 케이스마다 한 줄에 승택이가 밟을 수 있는 최대 징검다리 수를 출력한다.
//
// 예제 입력 1
// 4
// 1
// 2
// 100
// 1000000
// 예제 출력 1
// 1
// 1
// 13
// 1413

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// n의 범위가 10^16, 반복문으론 시간 초과
// 점프 거리의 합은 s = k * (k + 1) / 2 -> ex) s = 1 + 2 + 3 + 4 + 5 = 10, s = 4(4+1)/2 = 10, 가우스의 덧셈
public class SteppingStones {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long t = readNumber(br);

		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			long n = readNumber(br);

			long m = (long)((-1 + Math.sqrt(1 + 8.0 * n)) / 2);

			sb.append(m).append("\n");
		}

		System.out.print(sb);
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
