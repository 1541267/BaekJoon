package baekJoon.tier.gold.five;

// 1068번
// 첫째 줄에 트리의 노드의 개수 N이 주어진다. N은 50보다 작거나 같은 자연수이다. 둘째 줄에는 0번 노드부터 N-1번 노드까지, 각 노드의 부모가 주어진다. 만약 부모가 없다면 (루트) -1이 주어진다. 셋째 줄에는 지울 노드의 번호가 주어진다.
//
// 출력
// 첫째 줄에 입력으로 주어진 트리에서 입력으로 주어진 노드를 지웠을 때, 리프 노드의 개수를 출력한다.
//
// 예제 입력 1
// 5
// -1 0 0 1 1
// 2
// 예제 출력 1
// 2
// 예제 입력 2
// 5
// -1 0 0 1 1
// 1
// 예제 출력 2
// 1
// 예제 입력 3
// 5
// -1 0 0 1 1
// 0
// 예제 출력 3
// 0
// 예제 입력 4
// 9
// -1 0 0 2 2 4 4 6 6
// 4
// 예제 출력 4
// 2
// TODO DFS 구현 방법 좀 더 이해 하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Trees {
	static int[] parent;
	static int count, totalNodeQuantity;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		totalNodeQuantity = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int deleteNodeNum = Integer.parseInt(br.readLine());

		parent = new int[totalNodeQuantity];

		for (int i = 0; i < parent.length; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
		}

		deleteNode(deleteNodeNum);

		count = 0;
		for (int i = 0; i < totalNodeQuantity; i++) {
			if (parent[i] == -1) {
				dfsLeaf(i);
				break;
			}
		}

		System.out.println(count);
	}

	private static void deleteNode(int deleteNodeNum) {
		parent[deleteNodeNum] = -2; // -2는 삭제된 노드를 의미

		for (int i = 0; i < totalNodeQuantity; i++) {
			if (parent[i] == deleteNodeNum) {
				deleteNode(i);
			}
		}
	}

	private static void dfsLeaf(int num) {
		if (parent[num] == -2) return;

		boolean isLeaf = true;

		for (int i = 0; i < totalNodeQuantity; i++) {
			if (parent[i] == num) {
				dfsLeaf(i);
				isLeaf = false;
			}
		}

		if (isLeaf) {
			count++;
		}
	}
}
