package baekJoon.tier.sliver.one;

// (실버 1) 15723번 n단 논법
// 그래프 이론 | 탐색, 너비 | 깊이 우선 탐색, 최단 경로, 플로이드-워셜
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	128 MB	2806	1636	1386	58.754%
// 문제
// 모든 중앙대 컴퓨터공학부(소프트웨어학부) 학생들은 미인이다.
//
// 지무근은 중앙대 컴퓨터공학부 학생이다.
//
// 그러므로 지무근은 미인이다.
//
// 위 연역 논증은 대표적인 삼단논법의 예시이다. 삼단논법이란 전제 두 개와 결론 하나로 이루어진 연역 논증이다. 이것을 응용하면, n개의 전제가 있을 때 m개의 결론을 도출할 수 있을 것이다. 이때의 n과 m은 모든 의미에서 적절한 수라고 가정하자. 자세한 것은 입출력 예시를 확인하자.
//
// 입력
// 첫째 줄에 정수 n(2 ≤ n ≤ 26)이 주어진다.
//
// 둘째 줄부터 n개의 줄에 걸쳐 각 줄에 전제가 하나씩 주어진다. 전제는 모두 a is b의 형식으로 주어지며 a와 b는 서로 다른 임의의 알파벳 소문자이다. 특별한 명시는 없지만 모든 전제는 “모든 a는 b이다”라는 의미이다. 하지만 “모든 b는 a이다”의 의미는 될 수 없다. 또한 a는 b이면서 c일 수 없으나, a와 b가 동시에 c일 수는 있다.
//
// n + 2번째 줄에 정수 m(1 ≤ m ≤ 10)이 주어진다. 그 다음 m개의 줄에 걸쳐 각 줄에 하나의 결론이 전제와 같은 형식으로 주어진다.
//
// 출력
// m개의 줄에 걸쳐 각 줄에 결론이 참인지 거짓인지 출력하라. 참일 경우 T, 거짓일 경우 F를 출력하라. 알 수 없는 경우도 거짓이다. 답은 필히 대문자로 출력해야 한다.
//
// 예제 입력 1
// 3
// a is b
// b is c
// c is d
// 3
// a is d
// a is c
// d is a
// 예제 출력 1
// T
// T
// F

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NStageArgument {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		boolean[][] map = new boolean[26][26];

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");

			int x = input[0].charAt(0) - 97;
			int y = input[2].charAt(0) - 97;

			map[x][y] = true;
		}

		for (int k = 0; k < 26; k++) {    // 거치는 노드
			for (int i = 0; i < 26; i++) { // 시작 노드
				for (int j = 0; j < 26; j++) { // 끝 노드

					if (map[i][k] && map[k][j]) map[i][j] = true;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			String[] input = br.readLine().split(" ");

			int x = input[0].charAt(0) - 97;
			int y = input[2].charAt(0) - 97;

			if (map[x][y]) sb.append("T");
			else sb.append("F");
			sb.append("\n");

		}

		System.out.print(sb.deleteCharAt(sb.length() - 1));

	}
}
