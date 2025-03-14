package baekJoon.tier.sliver.three;

// (실버 3) 2606번 바이러스
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	128 MB	207352	98726	65216	46.200%
// 문제
// 신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
//
// 예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다. 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.
//
//
//
// 어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다. 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
//
// 출력
// 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
//
// 예제 입력 1
// 7
// 6
// 1 2
// 2 3
// 1 5
// 5 2
// 5 6
// 4 7
// 예제 출력 1
// 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// dfs, 이해는 됐음
// 			list[a].add(b);
// 			list[b].add(a); 
// 로 연결된 노드 생성, 
// bfs는 항상 queue사용, dfs는 항상 스택 | 재귀 사용
public class Virus {
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

		dfs(1);

		System.out.println("list = " + Arrays.toString(list));
		System.out.print(count);
	}

	private static void dfs(int node) {
		visited[node] = true;
		System.out.println("node = " + node);

		for (int connected : list[node]) {
			if (!visited[connected]) {
				count++;
				dfs(connected);
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

