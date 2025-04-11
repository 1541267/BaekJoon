package baekJoon.tier.sliver.three;

// (실버 3) 26169번 세 번 이내에 사과를 먹자
// 그래프 이론, 그래프 탐색, 깊이 우선 탐색, 백트래킹
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	512 MB	2967	971	725	32.643%
// 문제
// 5 x 5 크기의 보드가 주어진다. 보드는 1 x 1 크기의 정사각형 격자로 이루어져 있다. 보드의 격자는 사과가 1개 있는 격자, 장애물이 있는 격자, 빈칸으로 되어 있는 격자로 구분된다. 격자의 위치는 (r, c)로 표시한다. r은 행 번호, c는 열 번호를 나타낸다. 행 번호는 맨 위 위치가 0이고 아래 방향으로 1씩 증가한다. 열 번호는 맨 왼쪽 위치가 0이고 오른쪽으로 1씩 증가한다. 즉, 맨 왼쪽 위 위치가 (0, 0), 맨 아래 오른쪽 위치가 (4, 4)이다.
// 
// 현재 한 명의 학생이 (r, c) 위치에 있고 한 번의 이동으로 상, 하, 좌, 우 방향 중에서 한가지 방향으로 한 칸 이동할 수 있다. 학생이 사과가 있는 칸으로 이동하면 해당 칸에 있는 사과를 1개 먹는다. 장애물이 있는 칸으로는 이동할 수 없다. 학생이 지나간 칸은 학생이 해당 칸을 떠나는 즉시 장애물이 있는 칸으로 변경된다. 즉, 학생이 해당 칸에서 상, 하, 좌, 우 방향으로 한 칸 이동하는 즉시 해당 칸은 장애물이 있는 칸으로 변경된다.
// 
// 학생이 현재 위치 (r, c)에서 세 번 이하의 이동으로 사과를 2개 이상 먹을 수 있으면 1을 출력하고, 그렇지 않으면 0을 출력하자.
// 
// 입력
// 첫 번째 줄부터 다섯 개의 줄에 걸쳐 보드의 정보가 주어진다. i번째 줄의 j번째 수는 보드의 (i - 1)번째 행, (j - 1)번째 열의 정보를 나타낸다. 보드의 정보가 1이면 해당 칸은 사과가 1개 있는 격자임을 나타내고, 0이면 빈칸이 있는 격자를 나타내고, -1이면 장애물이 있는 격자임을 나타낸다.
// 
// 다음 줄에 학생의 현재 위치 r, c가 빈칸을 사이에 두고 순서대로 주어진다.
// 
// 출력
// 첫 번째 줄에 학생이 현재 위치 (r, c)에서 세 번 이하의 이동으로 사과를 2개 이상 먹을 수 있으면 1을 출력하고, 먹을 수 없으면 0을 출력한다.
// 
// 제한
// 0 ≤ r, c ≤ 4
// 현재 위치 (r, c)는 빈칸이다.
// 예제 입력 1 
// 0 0 1 0 0
// 0 0 -1 0 0
// 0 0 1 0 0
// 1 1 -1 1 0
// 0 0 0 -1 0
// 4 1
// 예제 출력 1 
// 1
// (4, 1) -> (3, 1) -> (3, 0)으로 이동하면 사과를 2개 먹을 수 있다.
// 
// 예제 입력 2 
// 0 0 1 0 0
// 0 0 -1 0 0
// 0 0 1 0 0
// 1 0 -1 1 0
// 0 0 0 -1 0
// 2 3
// 예제 출력 2 
// 0

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EatAppleInThreeTime {

	static int[][] arr = new int[5][5];
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean result = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] isVisited = new boolean[5][5];

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == -1) {
					isVisited[i][j] = true;
				}
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int moveCount = 0;
		int appleCount = 0;

		dfs(r, c, moveCount, appleCount, isVisited);

		System.out.print(result ? "1" : "0");
	}

	private static void dfs(int x, int y, int moveCount, int appleCount, boolean[][] isVisited) {

		if (result)	return;

		isVisited[x][y] = true;
		if (arr[x][y] == 1)
			appleCount++;

		if (moveCount > 3) {
			isVisited[x][y] = false;
			return;
		}
		if (appleCount >= 2) {
			result = true;
			isVisited[x][y] = false;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !isVisited[nx][ny]) {
				dfs(nx, ny, moveCount + 1, appleCount, isVisited);
			}
		}
		isVisited[x][y] = false;
	}
}
