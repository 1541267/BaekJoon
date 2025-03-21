package baekJoon.tier.sliver.two;

// (실버 2) 11725번 트리의 부모 찾기
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	256 MB	101897	46606	32633	43.316%
// 문제
// 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
//
// 출력
// 첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
//
// 예제 입력 1
// 7
// 1 6
// 6 3
// 3 5
// 4 1
// 2 4
// 4 7
// 예제 출력 1
// 4
// 6
// 1
// 3
// 1
// 4
// 예제 입력 2
// 12
// 1 2
// 1 3
// 2 4
// 3 5
// 3 6
// 4 7
// 4 8
// 5 9
// 5 10
// 6 11
// 6 12
// 예제 출력 2
// 1
// 1
// 2
// 3
// 3
// 4
// 4
// 5
// 5
// 6
// 6

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindParentNode {

	static List<Integer>[] tree;
	static int[] parent;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = readNumber(br);

		tree = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			int a = readNumber(br);
			int b = readNumber(br);

			tree[a].add(b);
			tree[b].add(a);
		}

		parent = new int[n + 1];
		isVisited = new boolean[n + 1];

		bfs(1);

		StringBuilder sb = new StringBuilder();
		for (int i : parent) {
			if (i == 0)
				continue;
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int root) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(root);
		isVisited[root] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int next : tree[node]) {
				if (!isVisited[next]) {
					parent[next] = node;
					isVisited[next] = true;
					queue.add(next);
				}
			}
		}

	}

	private static int readNumber(BufferedReader br) throws IOException {

		int value = 0;
		int c = br.read();

		do {
			value = value * 10 + (c - '0');
		} while ((c = br.read()) >= '0' && c <= '9');

		return value;
	}
}
