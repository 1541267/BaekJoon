package baekJoon.tier.sliver.three;

// (실버 3) 31575번 도시와 비트코인
// 다이나믹 프로그래밍, 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	512 MB	2238	736	617	32.819%
// 문제
// 전날에 비해 비트코인의 시세가 백만원이나 오른 어느 아침, 진우는 거래소에 가서 비트코인을 매도하려고 한다. 현재 비트코인의 시세가 점점 떨어지고 있기 때문에 진우는 최대한 빨리 거래소에 가야 한다.
//
// 도시는 가로
// $N$, 세로
// $M$ 크기의 격자 모양으로 이루어졌다. 진우는 북서쪽 끝에 있고 거래소는 남동쪽 끝에 있다. 도시의 일부 구역은 공터 또는 도로라서 진우가 지나갈 수 있지만, 어떤 구역은 건물이 있어서 진우가 갈 수 없다.
//
// 진우는 최대한 빨리 거래소에 가야 하므로, 동쪽(오른쪽) 또는 남쪽(아래쪽)으로만 이동하여 거래소로 도착할 수 있어야 한다. 진우를 도와 거래소로 갈 수 있는지 구하는 프로그램을 작성하여라. 진우의 현재 위치가 거래소일 수 있다.
//
// 입력
// 첫 번째 줄에 도시의 가로 크기
// $N$과 세로 크기
// $M$ (
// $1 \le N, M \le 300$)이 주어진다.
//
// 두 번째 줄부터
// $M$개의 줄에는 도시의 형태를 나타내는
// $N$개의 정수가 공백을 사이에 두고 주어진다. 각 칸이 1인 경우 진우가 갈 수 있는 칸을 의미하고 0인 경우 진우가 갈 수 없는 칸을 의미한다.
//
// 왼쪽 위의 끝 칸과 오른쪽 아래의 끝 칸은 모두 1이다.
//
// 출력
// 첫 번째 줄에 진우가 거래소로 갈 수 있으면 Yes를, 그렇지 않으면 No를 출력한다.
//
// 예제 입력 1
// 5 4
// 1 1 1 1 1
// 0 1 0 0 1
// 1 0 0 0 1
// 0 0 0 1 1
// 예제 출력 1
// Yes

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dfs, 208ms
public class CityAndBitcoin {

	static int[][] arr;
	static boolean[][] isVisited;
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};
	static int m;
	static int n;
	static boolean result = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m][n];
		isVisited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		System.out.print(result ? "Yes" : "No");
	}

	private static void dfs(int x, int y) {

		if (result) return;
		isVisited[x][y] = true;

		if (x == m - 1 && y == n - 1) {
			result = true;
			return;
		}

		for (int i = 0; i < 2; i++) {
			if (result) return;
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < m && ny >= 0 && ny < n && !isVisited[nx][ny] && arr[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}
}

// bfs, 252ms
// public class CityAndBitcoin {
//
// 	static int[][] arr;
// 	static boolean[][] isVisited;
// 	static int[] dx = {1, 0};
// 	static int[] dy = {0, 1};
// 	static int m, n;
//
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringTokenizer st = new StringTokenizer(br.readLine());
//
// 		n = Integer.parseInt(st.nextToken());
// 		m = Integer.parseInt(st.nextToken());
//
// 		arr = new int[m][n];
// 		isVisited = new boolean[m][n];
// 		for (int i = 0; i < m; i++) {
// 			st = new StringTokenizer(br.readLine());
// 			for (int j = 0; j < n; j++) {
// 				arr[i][j] = Integer.parseInt(st.nextToken());
// 			}
// 		}
//
// 		if (arr[0][0] == 0 || arr[m - 1][n - 1] == 0) {
// 			System.out.print("No");
// 			return;
// 		}
//
// 		System.out.print(bfs(0, 0) ? "Yes" : "No");
// 	}
//
// 	private static boolean bfs(int x, int y) {
//
// 		if (arr[x][y] == 0) return false;
//
// 		Queue<int[]> queue = new LinkedList<>();
// 		queue.add(new int[] {x, y});
// 		isVisited[x][y] = true;
//
// 		while (!queue.isEmpty()) {
//
// 			int[] cur = queue.poll();
//
// 			assert cur != null;
// 			int cx = cur[0];
// 			int cy = cur[1];
//
// 			if (cx == m - 1 && cy == n - 1) return true;
//
// 			for (int i = 0; i < 2; i++) {
//
// 				int nx = cx + dx[i];
// 				int ny = cy + dy[i];
//
// 				if (nx >= 0 && nx < m && ny >= 0 && ny < n && !isVisited[nx][ny] && arr[nx][ny] == 1) {
// 					queue.add(new int[] {nx, ny});
// 					isVisited[nx][ny] = true;
// 				}
// 			}
// 		}
// 		return false;
// 	}
// }
