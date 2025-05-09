package baekJoon.tier.gold.five;

// (골드 5) 13023번 ABCDE
// 그래프 이론, 그래프 탐색, 깊이 우선 탐색, 백트래킹
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	512 MB	64429	20772	13793	29.303%
// 문제
// BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.
//
// 오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.
//
// A는 B와 친구다.
// B는 C와 친구다.
// C는 D와 친구다.
// D는 E와 친구다.
// 위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.
//
// 둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b) 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.
//
// 출력
// 문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.
//
// 예제 입력 1
// 5 4
// 0 1
// 1 2
// 2 3
// 3 4
// 예제 출력 1
// 1
// 예제 입력 2
// 5 5
// 0 1
// 1 2
// 2 3
// 3 0
// 1 4
// 예제 출력 2
// 1
// 예제 입력 3
// 6 5
// 0 1
// 0 2
// 0 3
// 0 4
// 0 5
// 예제 출력 3
// 0
// 예제 입력 4
// 8 8
// 1 7
// 3 7
// 4 7
// 3 4
// 4 6
// 3 5
// 0 4
// 2 7
// 예제 출력 4
// 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE {

	static boolean[] isVisited;
	static List<Integer>[] arr;
	static boolean result = false;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new ArrayList[n];
		isVisited = new boolean[n];

		for (int i = 0; i < n; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			arr[first].add(second);
			arr[second].add(first);
		}

		for (int i = 0; i < n; i++) {
			if (result) break;
			Arrays.fill(isVisited, false);
			dfs(i, 1);
		}

		if (result) {
			System.out.print(1);
		} else {
			System.out.print(0);
		}

	}

	private static void dfs(int index, int depth) {
		if (isVisited[index]) return;

		if (depth == 5) {
			result = true;
			return;
		}
		isVisited[index] = true;

		List<Integer> curList = arr[index];

		for (int i : curList) {

			if (!isVisited[i]) {
				dfs(i, depth + 1);
			}
		}
		isVisited[index] = false;
	}
}
