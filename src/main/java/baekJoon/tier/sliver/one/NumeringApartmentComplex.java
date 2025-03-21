package baekJoon.tier.sliver.one;

// (실버 1) 2667번 단지 번호 붙이기
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	128 MB	211461	96272	61089	43.323%
// 문제
// <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
//
//
//
// 입력
// 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
//
// 출력
// 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
//
// 예제 입력 1
// 7
// 0110100
// 0110101
// 1110101
// 0000111
// 0100000
// 0111110
// 0111000
// 예제 출력 1
// 3
// 7
// 8
// 9

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// bfs, 108ms
public class NumeringApartmentComplex {

	static boolean[][] visited;
	static int[][] arr;
	static int houseCount = 0;
	static int complexCount = 0;
	static int n;                // 맵 크기
	static List<Integer> list = new ArrayList<>();

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		visited = new boolean[n][n];

		arr = new int[n][n];
		String line;
		for (int i = 0; i < n; i++) {
			line = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = line.charAt(j) - '0' ;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {

					bfs(i, j);
					if (houseCount != 0) {
						list.add(houseCount);
					}
					houseCount = 0;
				}
			}
		}
		sb.append(list.size()).append("\n");

		list.sort(Integer::compareTo);

		for (Integer i : list) {
			sb.append(i).append("\n");
		}
		System.out.print(sb);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			houseCount++;

			int[] current = queue.poll();
			int cx = current[0];
			int cy = current[1];

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];  // x 방향 이동
				int ny = cy + dy[i];  // y 방향 이동
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && arr[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny});
				}
			}
		}
	}
}

// 처음에 푼 것. 104ms, dfs
// public class NumeringApartmentComplex {
//
// 	static boolean[][] visited;
// 	static int[][] arr;
// 	static int houseCount = 0;
// 	static int complexCount = 0;
// 	static int n;                // 맵 크기
// 	static List<Integer> list = new ArrayList<>();
//
// static int[] dx = {1, -1, 0, 0};
// static int[] dy = {0, 0, 1, -1};
//
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		StringBuilder sb = new StringBuilder();
//
// 		n = Integer.parseInt(br.readLine());
// 		visited = new boolean[n][n];
//
// 		arr = new int[n][n];
// 		String line;
// 		for (int i = 0; i < n; i++) {
// 			line = br.readLine();
// 			int j = 0;
// 			for (char c : line.toCharArray()) {
// 				arr[i][j] = Integer.parseInt(String.valueOf(c));
// 				j++;
// 			}
// 		}
//
// 		for (int i = 0; i < n; i++) {
// 			for (int j = 0; j < n; j++) {
//
// 				dfs(arr, i, j);
// 				if (houseCount != 0) {
// 					list.add(houseCount);
// 				}
// 				houseCount = 0;
// 			}
// 		}
// 		sb.append(list.size()).append("\n");
//
// 		list.sort(Integer::compareTo);
//
// 		for (Integer i : list) {
// 			sb.append(i).append("\n");
// 		}
// 		System.out.print(sb);
// 	}
//
// 	private static void dfs(int x, int y) {
// 		if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || arr[x][y] == 0)
// 			return;
//
// 		visited[x][y] = true;
// 		houseCount++;
//
// 		for (int i = 0; i < 4; i++) {
// 			int nx = x + dx[i];  // x 방향 이동
// 			int ny = y + dy[i];  // y 방향 이동
//
// 			dfs(nx, ny);
//
// 		}
// 	}
// 	private static void dfs(int[][] arr, int x, int y) {
// 		if (visited[x][y] || arr[x][y] == 0)
// 			return;
//
// 		visited[x][y] = true;
//
// 		if (arr[x][y] == 1)
// 			houseCount++;
//
// 	}
// }
