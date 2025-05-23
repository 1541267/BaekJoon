package baekJoon.tier.sliver.two;

// (실버 2) 촌수 계산
// 그래프 이론, 그래프 탐색, 너비 | 깊이 우선 탐색
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	128 MB	63830	33236	24741	51.217%
// 문제
// 우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다. 이러한 촌수는 다음과 같은 방식으로 계산된다. 기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를 계산한다. 예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고, 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.
// 
// 여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.
// 
// 입력
// 사람들은 1, 2, 3, …, n (1 ≤ n ≤ 100)의 연속된 번호로 각각 표시된다. 입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고, 둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다. 그리고 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다. 넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다. 이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.
// 
// 각 사람의 부모는 최대 한 명만 주어진다.
// 
// 출력
// 입력에서 요구한 두 사람의 촌수를 나타내는 정수를 출력한다. 어떤 경우에는 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때가 있다. 이때에는 -1을 출력해야 한다.
// 
// 예제 입력 1 
// 9
// 7 3
// 7
// 1 2
// 1 3
// 2 7
// 2 8
// 2 9
// 4 5
// 4 6
// 예제 출력 1 
// 3
// 예제 입력 2 
// 9
// 8 6
// 7
// 1 2
// 1 3
// 2 7
// 2 8
// 2 9
// 4 5
// 4 6
// 예제 출력 2 
// -1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class CalculationOfNumberOfRelatives {

	static List<Integer>[] relatives;
	static boolean[] isVisited;
	static boolean isFound = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] target = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

		int m = Integer.parseInt(br.readLine());
		relatives = new LinkedList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			relatives[i] = new LinkedList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			relatives[first].add(second);
			relatives[second].add(first);
		}
		isVisited = new boolean[n + 1];
		int count = 0;

		isVisited = new boolean[n + 1];
		dfs(target[0], target[1], count);
		if (!isFound) {
			System.out.println(-1);
		}

		isFound = false;
		System.out.println(bfs(target[0], target[1]));
	}

	private static void dfs(int start, int target, int count) {

		if (start == target) {
			System.out.println(count);
			isFound = true;
			return;
		}
		if (isVisited[start]) return;

		isVisited[start] = true;

		for (int i = 0; i < relatives[start].size(); i++) {
			int next = relatives[start].get(i);
			if (!isVisited[next]) {
				dfs(next, target, count + 1);
			}
		}
		isVisited[start] = false;
	}

	private static int bfs(int start, int target) {

		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] {start, 0});
		while (!q.isEmpty()) {

			int[] cur = q.poll();
			int curStart = cur[0];
			int depth = cur[1];

			if (curStart == target) {
				return depth;
			}

			for (int next : relatives[curStart]) {

				if (!isVisited[next]) {
					isVisited[next] = true;
					q.offer(new int[] {next, depth + 1});
				}
			}
		}
		return -1;
	}
}
