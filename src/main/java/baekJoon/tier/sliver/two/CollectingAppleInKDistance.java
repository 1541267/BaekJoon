package baekJoon.tier.sliver.two;

// (실버 2) 25516번 거리가 k이하인 트리 노드에서 사과 수확하기
// 그래프 이론, 그래프 탐색, 트리, 너비 우선 탐색, 깊이 우선 탐색
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	512 MB	1024	565	448	53.911%
// 문제
// n개의 정점과 n - 1개의 간선으로 구성된 트리 T가 있다. 정점 번호는 0부터 n - 1까지이고 0번 정점이 루트이다. 모든 간선의 길이는 1이다. 트리 T의 각 정점에는 사과가 0개 또는 1개 놓여있다. 루트 노드에서 거리가 k이하인 노드에 있는 사과를 수확하려고 한다. 수확할 수 있는 사과 개수를 출력하자.
//
// 입력
// 첫 번째 줄에 정점의 수 n과 정수 k가 공백을 사이에 두고 순서대로 주어진다.
//
// 두 번째 줄부터 n - 1개 줄에 걸쳐 간선의 정보가 주어진다. 한 줄에 하나의 간선 정보가 주어진다. 하나의 간선 정보는 부모 정점 번호 p와 자식 정점 번호 c가 공백을 사이에 두고 순서대로 주어진다.
//
// 다음 줄에는 0번 정점부터 n - 1번 정점까지 정점의 사과 정보를 나타내는 n개의 정수가 공백을 사이에 두고 순서대로 주어진다. i번째 수는 i - 1번 정점에 있는 사과의 수를 나타낸다. 사과의 수는 0 또는 1이다.
//
// 출력
// 첫 번째 줄에 수확할 수 있는 사과 개수를 출력한다.
//
// 제한
// 2 ≤ n ≤ 100,000
// 0 ≤ p, c ≤ n - 1, p ≠ c
// 간선들로 만들어진 그래프는 트리이다.
// 0 ≤ k ≤ n - 1
// 정점에 있는 사과의 수는 0 또는 1이다.
// 예제 입력 1
// 8 2
// 0 1
// 0 2
// 1 3
// 1 4
// 2 5
// 2 6
// 6 7
// 1 0 0 1 0 1 0 1
// 예제 출력 1
// 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CollectingAppleInKDistance {

	static int appleCount = 0;
	static int k;
	static List<Integer>[] tree;
	static int[] apples;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		tree = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			tree[index].add(Integer.valueOf(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		apples = new int[n];
		for (int i = 0; i < n; i++) {
			apples[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);

		System.out.println(appleCount);

	}

	private static void dfs(int index, int distance) {

		if (distance <= k) appleCount += apples[index];

		for (Integer child : tree[index]) {
			dfs(child, distance + 1);
		}
	}
}

// 처음 푼 것 484ms
// public class CollectingAppleInKDistance {
//
// 	static int appleCount = 0;
// 	static int k;
// 	static List<Integer>[] tree;
// 	static List<Integer> apples = new ArrayList<>();
// 	static boolean[] visited;
//
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringTokenizer st = new StringTokenizer(br.readLine());
// 		int n = Integer.parseInt(st.nextToken());
// 		k = Integer.parseInt(st.nextToken());
//
// 		tree = new ArrayList[n];
// 		visited = new boolean[n];
//
// 		for (int i = 0; i < n; i++) {
// 			tree[i] = new ArrayList<>();
// 		}
//
// 		for (int i = 0; i < n - 1; i++) {
// 			st = new StringTokenizer(br.readLine());
// 			int index = Integer.parseInt(st.nextToken());
// 			tree[index].add(Integer.valueOf(st.nextToken()));
// 		}
//
// 		st = new StringTokenizer(br.readLine());
// 		while (st.hasMoreTokens()) {
// 			apples.add(Integer.valueOf(st.nextToken()));
// 		}
//
// 		dfs(0, 0);
//
// 		System.out.print(appleCount);
// 	}
//
// 	private static void dfs(int index, int distance) {
//
// 		visited[index] = true;
//
// 		if (distance <= k && apples.get(index) != 0) appleCount += apples.get(index);
//
// 		for (Integer child : tree[index]) {
//
// 			if (!visited[child]) {
// 				dfs(child, distance + 1);
// 			}
// 		}
// 	}
// }
