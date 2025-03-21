package baekJoon.tier.sliver.two;

// (실버 2) 11724번 연결 요소의 개수
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 3 초	512 MB	157335	71433	46695	42.227%
// 문제
// 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
//
// 출력
// 첫째 줄에 연결 요소의 개수를 출력한다.
//
// 예제 입력 1
// 6 5
// 1 2
// 2 5
// 5 1
// 3 4
// 4 6
// 예제 출력 1
// 2
// 예제 입력 2
// 6 8
// 1 2
// 2 5
// 5 1
// 3 4
// 4 6
// 5 4
// 2 4
// 2 3
// 예제 출력 2
// 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountConnectiedElements {

	static int count = 0;
	static boolean[] visited;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = readNumber(br);
		int m = readNumber(br);

		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int a = readNumber(br);
			int b = readNumber(br);

			list[a].add(b);
			list[b].add(a);
		}

		for (int i = 1; i < n + 1; i++) {
			if(!visited[i]) {
				dfs(i);
				count++;
			}
		}

		System.out.println(count);
	}

	private static void dfs(int node) {
		visited[node] = true;

		for (int number : list[node]) {
			if (!visited[number]) {
				dfs(number);
			}
		}
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
