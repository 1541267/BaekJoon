package baekJoon.tier.sliver.three;

// (실버 3) 문제 2346번 풍선 터뜨리기
// 1번부터 N번까지 N개의 풍선이 원형으로 놓여 있고. i번 풍선의 오른쪽에는 i+1번 풍선이 있고, 왼쪽에는 i-1번 풍선이 있다. 단, 1번 풍선의 왼쪽에 N번 풍선이 있고, N번 풍선의 오른쪽에 1번 풍선이 있다. 각 풍선 안에는 종이가 하나 들어있고, 종이에는 -N보다 크거나 같고, N보다 작거나 같은 정수가 하나 적혀있다. 이 풍선들을 다음과 같은 규칙으로 터뜨린다.
//
// 우선, 제일 처음에는 1번 풍선을 터뜨린다. 다음에는 풍선 안에 있는 종이를 꺼내어 그 종이에 적혀있는 값만큼 이동하여 다음 풍선을 터뜨린다. 양수가 적혀 있을 경우에는 오른쪽으로, 음수가 적혀 있을 때는 왼쪽으로 이동한다. 이동할 때에는 이미 터진 풍선은 빼고 이동한다.
//
// 예를 들어 다섯 개의 풍선 안에 차례로 3, 2, 1, -3, -1이 적혀 있었다고 하자. 이 경우 3이 적혀 있는 1번 풍선, -3이 적혀 있는 4번 풍선, -1이 적혀 있는 5번 풍선, 1이 적혀 있는 3번 풍선, 2가 적혀 있는 2번 풍선의 순서대로 터지게 된다.
//
// 입력
// 첫째 줄에 자연수 N(1 ≤ N ≤ 1,000)이 주어진다. 다음 줄에는 차례로 각 풍선 안의 종이에 적혀 있는 수가 주어진다. 종이에 0은 적혀있지 않다.
//
// 출력
// 첫째 줄에 터진 풍선의 번호를 차례로 나열한다.
//
// 예제 입력 1
// 5
// 3 2 1 -3 -1
// 예제 출력 1
// 1 4 5 3 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class PopABallon {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		Deque<int[]> que = new ArrayDeque<>();

		int index = 1;
		while (st.hasMoreTokens()) {
			que.offer(new int[] {index++, Integer.parseInt(st.nextToken())});
		}


		while (!que.isEmpty()) {
			// 현재 풍선 터트리기
			int[] currentPeek = que.pollFirst();
			int popedBallon = currentPeek[0];
			int moveIndex = currentPeek[1];

			System.out.println("popedBallon = " + popedBallon);
			System.out.println("moveIndex = " + moveIndex);

			sb.append(popedBallon).append(" ");

			if (que.isEmpty())
				break;


			// 양 음수에 따라 터트린 풍선 만큼 좌 우 이동
			// 이동 후 while문 시작시 시작 풍선이 터트릴 풍선
			if (moveIndex > 0) {
				for (int i = 0; i < moveIndex - 1; i++) {
					que.offerLast(que.pollFirst());
				}
			} else {
				for (int i = 0; i < Math.abs(moveIndex); i++) {
					que.offerFirst(que.pollLast());
				}
			}
		}

		System.out.print(sb.toString().trim());
	}
}

// 문제 잘 못 이해함
// 두 번쨰 풍선까지 위치에 맞게 터트리고 양음수에 맞춰 앞뒤 자르는 줄
// public class PopABallon {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		int n = Integer.parseInt(br.readLine());
// 		StringTokenizer st = new StringTokenizer(br.readLine());
//
// 		Deque<int[]> que = new ArrayDeque<>();
//
// 		int index = 1;
// 		while (st.hasMoreTokens()) {
// 			que.add(new int[] {index++, Integer.parseInt(st.nextToken())});
// 		}
//
// 		List<Integer> popedNumList = new ArrayList<>();
//
// 		int popedBallonIndex;
// 		int popedBallonNum = 0;
//
// 		// 첫 번째 풍선과 그 다음 풍선
// 		if (!que.isEmpty()) {
// 			popedBallonIndex = que.peek()[0];
// 			popedBallonNum = que.peek()[1];
// 			que.poll();
//
// 			popedNumList.add(popedBallonIndex);
//
//
// 			Iterator<int[]> iterator = que.iterator();
//
// 			while (iterator.hasNext()) {
// 				int[] ballon = iterator.next();
// 				if (ballon[0] == Math.abs(popedBallonNum) + 1) {
// 					popedNumList.add(ballon[0]);
// 					popedBallonNum = ballon[1];
// 					iterator.remove();
// 				}
// 			}
// 		}
//
// 		// 두 번째로 뽑은 풍선 부터 양 음수 확인
// 		while (!que.isEmpty()) {
// 			if (popedBallonNum > 0) {
// 				popedNumList.add(que.peekFirst()[0]);
// 				popedBallonNum = que.peekFirst()[1];
// 				que.removeFirst();
// 			} else {
// 				popedNumList.add(que.peekLast()[0]);
// 				popedBallonNum = que.peekLast()[1];
// 				que.removeLast();
// 			}
// 		}
//
// 		StringBuilder sb = new StringBuilder();
// 		for (int i = 0; i < popedNumList.size(); i++) {
//
// 			sb.append(popedNumList.get(i));
// 			if(i != popedNumList.size() - 1) {
// 				sb.append(" ");
// 			}
// 		}
// 		System.out.println(sb);
// 	}
// }
