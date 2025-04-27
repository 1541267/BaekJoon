package baekJoon.tier.sliver.two;

// (실버 2) 1058번 친구
// 그래프 이론, 브루트포스 아록리즘, 그래프 탐색, 최단 경로, 플로이드-워셜
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	128 MB	14371	6889	5736	49.249%
// 문제
// 지민이는 세계에서 가장 유명한 사람이 누구인지 궁금해졌다. 가장 유명한 사람을 구하는 방법은 각 사람의 2-친구를 구하면 된다. 어떤 사람 A가 또다른 사람 B의 2-친구가 되기 위해선, 두 사람이 친구이거나, A와 친구이고, B와 친구인 C가 존재해야 된다. 여기서 가장 유명한 사람은 2-친구의 수가 가장 많은 사람이다. 가장 유명한 사람의 2-친구의 수를 출력하는 프로그램을 작성하시오.
//
// A와 B가 친구면, B와 A도 친구이고, A와 A는 친구가 아니다.
//
// 입력
// 첫째 줄에 사람의 수 N이 주어진다. N은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 각 사람이 친구이면 Y, 아니면 N이 주어진다.
//
// 출력
// 첫째 줄에 가장 유명한 사람의 2-친구의 수를 출력한다.
//
// 예제 입력 1
// 3
// NYY
// YNY
// YYN
// 예제 출력 1
// 2
// 예제 입력 2
// 3
// NNN
// NNN
// NNN
// 예제 출력 2
// 0
// 예제 입력 3
// 5
// NYNNN
// YNYNN
// NYNYN
// NNYNY
// NNNYN
// 예제 출력 3
// 4
// 예제 입력 4
// 10
// NNNNYNNNNN
// NNNNYNYYNN
// NNNYYYNNNN
// NNYNNNNNNN
// YYYNNNNNNY
// NNYNNNNNYN
// NYNNNNNYNN
// NYNNNNYNNN
// NNNNNYNNNN
// NNNNYNNNNN
// 예제 출력 4
// 8
// 예제 입력 5
// 15
// NNNNNNNNNNNNNNY
// NNNNNNNNNNNNNNN
// NNNNNNNYNNNNNNN
// NNNNNNNYNNNNNNY
// NNNNNNNNNNNNNNY
// NNNNNNNNYNNNNNN
// NNNNNNNNNNNNNNN
// NNYYNNNNNNNNNNN
// NNNNNYNNNNNYNNN
// NNNNNNNNNNNNNNY
// NNNNNNNNNNNNNNN
// NNNNNNNNYNNNNNN
// NNNNNNNNNNNNNNN
// NNNNNNNNNNNNNNN
// YNNYYNNNNYNNNNN
// 예제 출력 5
// 6

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 기본적인 플로이드 워셜로 사용하면 모든 개별 정점(i)에 대한 처리를 따로 하지 않고
// 모든 정점쌍(i,j)에 대해 한 번에 최단 경로를 계산
//

public class Friend {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// 처음 친구 관계
		char[][] relation = new char[n][n];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				relation[i][j] = input.charAt(j);
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {

			boolean[] twoFriends = new boolean[n];
			// 직접 친구 확인
			for (int j = 0; j < n; j++) {
				if (i != j && relation[i][j] == 'Y') {
					twoFriends[j] = true;
				}
			}

			// 친구의 친구 관계
			for (int j = 0; j < n; j++) {
				if (i != j && relation[i][j] == 'Y') {
					for (int k = 0; k < n; k++) {
						if (i != k && j != k && relation[j][k] == 'Y') {
							twoFriends[k] = true;
						}
					}
				}
			}

			int count = 0;
			for (int j = 0; j < n; j++) {
				if (twoFriends[j]) {
					count++;
				}
			}
			max = Math.max(max, count);
		}
		System.out.println(max);
	}
}
