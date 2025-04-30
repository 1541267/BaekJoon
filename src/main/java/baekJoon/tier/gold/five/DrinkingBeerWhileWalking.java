package baekJoon.tier.gold.five;

/*
(골드 5) 9205번 맥주 마시면서 걸어가기
그래프 이론 | 탐색, 너비 우선 탐색
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	39733	16830	12252	40.560%
문제
송도에 사는 상근이와 친구들은 송도에서 열리는 펜타포트 락 페스티벌에 가려고 한다. 올해는 맥주를 마시면서 걸어가기로 했다. 출발은 상근이네 집에서 하고, 맥주 한 박스를 들고 출발한다. 맥주 한 박스에는 맥주가 20개 들어있다. 목이 마르면 안되기 때문에 50미터에 한 병씩 마시려고 한다. 즉, 50미터를 가려면 그 직전에 맥주 한 병을 마셔야 한다.

상근이의 집에서 페스티벌이 열리는 곳은 매우 먼 거리이다. 따라서, 맥주를 더 구매해야 할 수도 있다. 미리 인터넷으로 조사를 해보니 다행히도 맥주를 파는 편의점이 있다. 편의점에 들렸을 때, 빈 병은 버리고 새 맥주 병을 살 수 있다. 하지만, 박스에 들어있는 맥주는 20병을 넘을 수 없다. 편의점을 나선 직후에도 50미터를 가기 전에 맥주 한 병을 마셔야 한다.

편의점, 상근이네 집, 펜타포트 락 페스티벌의 좌표가 주어진다. 상근이와 친구들이 행복하게 페스티벌에 도착할 수 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 t가 주어진다. (t ≤ 50)

각 테스트 케이스의 첫째 줄에는 맥주를 파는 편의점의 개수 n이 주어진다. (0 ≤ n ≤ 100).

다음 n+2개 줄에는 상근이네 집, 편의점, 펜타포트 락 페스티벌 좌표가 주어진다. 각 좌표는 두 정수 x와 y로 이루어져 있다. (두 값 모두 미터, -32768 ≤ x, y ≤ 32767)

송도는 직사각형 모양으로 생긴 도시이다. 두 좌표 사이의 거리는 x 좌표의 차이 + y 좌표의 차이 이다. (맨해튼 거리)

출력
각 테스트 케이스에 대해서 상근이와 친구들이 행복하게 페스티벌에 갈 수 있으면 "happy", 중간에 맥주가 바닥나서 더 이동할 수 없으면 "sad"를 출력한다.

예제 입력 1
2
2
0 0
1000 0
1000 1000
2000 1000
2
0 0
1000 0
2000 1000
2000 2000
예제 출력 1
happy
sad
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DrinkingBeerWhileWalking {

	static int[][] arr;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int z = 0; z < t; z++) {

			int n = Integer.parseInt(br.readLine());
			arr = new int[n + 2][2];
			StringTokenizer home = new StringTokenizer(br.readLine());

			arr[0][0] = Integer.parseInt(home.nextToken());
			arr[0][1] = Integer.parseInt(home.nextToken());

			for (int i = 1; i < n + 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			StringTokenizer dest = new StringTokenizer(br.readLine());
			arr[n + 1][0] = Integer.parseInt(dest.nextToken());
			arr[n + 1][1] = Integer.parseInt(dest.nextToken());

			isVisited = new boolean[n + 2];
			// dfs
			bw.write("===========DFS==========\n");
			bw.write(dfs(0) ? "happy\n" : "sad\n");

			isVisited = new boolean[n + 2];
			// bfs
			bw.write("===========BFS==========\n");
			bw.write(bfs() ? "happy\n" : "sad\n");
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	private static boolean dfs(int x) {

		isVisited[x] = true;

		if (x == arr.length - 1) return true;

		for (int i = 1; i < arr.length; i++) {

			if (!isVisited[i] && dist(arr[x], arr[i]) <= 1000) {
				if (dfs(i)) return true;
			}
		}

		return false;
	}

	private static boolean bfs() {

		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		isVisited[0] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == arr.length - 1) return true;

			for (int i = 1; i < arr.length; i++) {
				if (!isVisited[i] && dist(arr[cur], arr[i]) <= 1000) {
					isVisited[i] = true;
					q.offer(i);
				}
			}
		}
		return false;
	}

	public static int dist(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
}
