package baekJoon.tier.sliver.three;

// (실버 3) 16471번 작은 수 내기
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	512 MB	1377	577	484	41.905%
// 문제
// 여자친구와 함께 보드게임카페에 간 주언이는, 여러 보드게임을 하며 데이트를 즐겼다. 3시간 커플세트로 결제를 하려던 순간, 주언이는 가격표 옆에 쓰여 있는 새로운 이벤트를 보았다.
//
// 바로 “사장님과의 게임에서 이기면 무료, 지거나 비기면 5000원 추가 지불” 이벤트였다. 보드게임에 자신이 있는 주언이는 사장님에게 게임 룰을 물어보았고, 그 룰은 다음과 같았다.
//
// 각자 N장의 카드를 받는다. (N은 홀수다)
// 각자 카드를 1장씩 골라서 카드에 적힌 수의 크기를 비교한다. (각 카드에 적힌 수는 0이상, 100,000이하의 정수다)
// 더 작은 수가 적힌 카드를 낸 사람이 1점을 얻고, 승부에 사용된 카드는 버린다. (무승부의 경우, 둘 다 점수를 획득하지 못한다)
// 총 N번의 승부 후, (N+1)/2점 이상의 점수를 획득한 사람이 승리한다.
// (N+1)/2점 이상의 점수를 획득한 사람이 없을 경우, 승자가 없는 것으로 게임이 끝난다.
// 주언이는 자신이 이길 확률이 조금이라도 있을 경우 게임을 하고자 한다.
//
// 사장님이 받은 카드에 적힌 수들과, 주언이가 받은 카드에 적힌 수들이 주어질 때, 주언이가 게임을 해도 되는지 확인하자.
//
// 입력
// N값이 첫 번째 줄에 입력된다. (1 ≤ N < 100,000, N은 홀수)
//
// 주언이가 받은 카드 N장에 적힌 수들이 두 번째 줄에 입력된다.
//
// 사장님이 받은 카드 N장에 적힌 수들이 세 번째 줄에 입력된다.
//
// 출력
// 주언이가 이길 확률이 조금이라도 있을 경우 “YES” 라고 출력하고,주언이가 이길 확률이 존재하지 않을 경우 “NO”라고 출력한다.
//
// 예제 입력 1
// 5
// 2 1 3 5 6
// 1 1 3 2 5
// 예제 출력 1
// YES
// 예제 입력 2
// 5
// 8 7 6 5 4
// 4 4 4 4 4
// 예제 출력 2
// NO

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 292ms
public class SmallerNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = readNumber(br);

		PriorityQueue<Integer> jueon = new PriorityQueue<>();
		PriorityQueue<Integer> boss = new PriorityQueue<>();

		int winScore = (n + 1) / 2;

		for (int j = 0; j < 2; j++) {

			if (j == 0) {
				for (int i = 0; i < n; i++) {
					jueon.add(readNumber(br));
				}
			} else {
				for (int i = 0; i < n; i++) {
					boss.add(readNumber(br));

				}
			}
		}

		int count = 0;

		for (int i = 0; i < n; i++) {

			int jueonPick = jueon.peek();
			int bossPick = boss.poll();

			if (jueonPick < bossPick) {
				count++;
				jueon.poll();
			}
			if (count >= winScore) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");

	}

	private static int readNumber(BufferedReader br) throws IOException {
		int value = 0;
		int c = br.read();

		while (c == ' ') {
			c = br.read();
		}

		do {
			value = value * 10 + (c - '0');
		} while ((c = br.read()) >= '0' && c <= '9');

		return value;
	}
}

// 372ms
// public class SmallerNumber {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		int n = readNumber(br);
//
// 		int[] juun = new int[n];
// 		int[] boss = new int[n];
//
// 		int winScore = (n + 1) / 2;
//
// 		for (int j = 0; j < 2; j++) {
//
// 			if (j == 0) {
// 				for (int i = 0; i < n; i++) {
// 					juun[i] = (readNumber(br));
// 				}
// 			} else {
// 				for (int i = 0; i < n; i++) {
// 					boss[i] = readNumber(br);
//
// 				}
// 			}
// 		}
//
// 		Arrays.sort(juun);
// 		Arrays.sort(boss);
//
// 		int count = 0;
// 		int index = 0;
// 		int temp = 0;
//
// 		for (int i = 0; i < n; i++) {
// 			index = temp;
// 			for (int j = index; j < n; j++) {
// 				if (juun[i] < boss[j]) {
// 					count++;
// 					temp = j + 1;
// 					break;
// 				}
// 			}
// 			if (count >= winScore) {
// 				System.out.println("YES");
// 				return;
// 			}
// 		}
// 		System.out.println("NO");
//
// 	}
//
// 	private static int readNumber(BufferedReader br) throws IOException {
// 		int value = 0;
// 		int c = br.read();
//
// 		while (c == ' ') {
// 			c = br.read();
// 		}
//
// 		do {
// 			value = value * 10 + (c - '0');
// 		} while ((c = br.read()) >= '0' && c <= '9');
//
// 		return value;
// 	}
// }
