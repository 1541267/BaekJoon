package baekJoon.tier.sliver.two;

// (실버 2) 1260번 DFS와 BFS
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	128 MB	329178	131841	77802	38.589%
// 문제
// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
//
// 입력
// 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
//
// 출력
// 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
//
// 예제 입력 1
// 4 5 1
// 1 2
// 1 3
// 1 4
// 2 4
// 3 4
// 예제 출력 1
// 1 2 4 3
// 1 2 3 4
// 예제 입력 2
// 5 5 3
// 5 4
// 5 2
// 1 2
// 3 4
// 3 1
// 예제 출력 2
// 3 1 2 5 4
// 3 1 4 2 5
// 예제 입력 3
// 1000 1 1000
// 999 1000
// 예제 출력 3
// 1000 999
// 1000 999

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 224ms
public class DFSAndBFS {

	static List<Integer>[] arr;
	static boolean[] isVisited;
	static List<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			arr[first].add(second);
			arr[second].add(first);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(arr[i]);
		}

		isVisited = new boolean[n + 1];
		dfs(v);
		for (Integer i : result) {
			bw.write(i + " ");
		}
		bw.newLine();

		result.clear();
		Arrays.fill(isVisited, false);
		bfs(v);

		for (Integer i : result) {
			bw.write(i + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(int node) {
		if (isVisited[node]) return;

		isVisited[node] = true;
		result.add(node);

		for (int next : arr[node]) {
			if (!isVisited[next]) {
				dfs(next);
			}
		}
	}

	private static void bfs(int root) {
		Queue<Integer> queue = new LinkedList<>();
		isVisited[root] = true;
		result.add(root);
		queue.add(root);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int next : arr[cur]) {
				if (!isVisited[next]) {
					result.add(next);
					isVisited[next] = true;
					queue.add(next);
				}
			}
		}
	}
}

// 214ms
// public class Main {
//
// 	static List<Integer>[] arr;
// 	static boolean[] isVisited;
// 	static Deque<Integer> queue;
// 	static List<Integer> dfsList = new ArrayList<>();
// 	static List<Integer> bfsList = new ArrayList<>();
//
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
// 		StringTokenizer st = new StringTokenizer(br.readLine());
//
// 		int n = Integer.parseInt(st.nextToken());
// 		int m = Integer.parseInt(st.nextToken());
// 		int v = Integer.parseInt(st.nextToken());
// 		arr = new ArrayList[n + 1];
//
// 		for (int i = 1; i <= n; i++) {
// 			arr[i] = new ArrayList<>();
// 		}
//
// 		for (int i = 1; i <= m; i++) {
// 			st = new StringTokenizer(br.readLine());
//
// 			int first = Integer.parseInt(st.nextToken());
// 			int second = Integer.parseInt(st.nextToken());
//
// 			arr[first].add(second);
// 			arr[second].add(first);
// 		}
//
// 		for (int i = 1; i <= n; i++) {
// 			Collections.sort(arr[i]);
// 		}
//
// 		isVisited = new boolean[n + 1];
// 		dfs(v);
//
// 		isVisited = new boolean[n + 1];
// 		bfs(v);
//
// 		for (Integer i : dfsList) {
// 			bw.write(i + " ");
// 		}
// 		bw.newLine();
//
// 		for (Integer i : bfsList) {
// 			bw.write(i + " ");
// 		}
//
// 		bw.flush();
// 		bw.close();
//
// 	}
//
// 	private static void dfs(int root) {
// 		if (isVisited[root]) return;
//
// 		isVisited[root] = true;
// 		dfsList.add(root);
//
// 		for (int next : arr[root]) {
// 			if (!isVisited[next]) {
// 				dfs(next);
// 			}
// 		}
// 	}
//
// 	private static void bfs(int root) {
// 		Queue<Integer> queue = new LinkedList<>();
// 		isVisited[root] = true;
// 		bfsList.add(root);
// 		queue.add(root);
//
// 		while (!queue.isEmpty()) {
// 			int cur = queue.poll();
// 			for (int next : arr[cur]) {
// 				if (!isVisited[next]) {
// 					bfsList.add(next);
// 					isVisited[next] = true;
// 					queue.add(next);
// 				}
// 			}
// 		}
// 	}
// }
