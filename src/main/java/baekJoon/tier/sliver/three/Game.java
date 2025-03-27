package baekJoon.tier.sliver.three;

// (실버 3) 1072번 게임
// 수학, 이분 탐색
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	128 MB	55211	13561	10156	24.682%
// 문제
// 김형택은 지금 몰래 Spider Solitaire(스파이더 카드놀이)를 하고 있다. 형택이는 이 게임을 이길 때도 있었지만, 질 때도 있었다. 누군가의 시선이 느껴진 형택이는 게임을 중단하고 코딩을 하기 시작했다. 의심을 피했다고 생각한 형택이는 다시 게임을 켰다. 그 때 형택이는 잠시 코딩을 하는 사이에 자신의 게임 실력이 눈에 띄게 향상된 것을 알았다.
//
// 이제 형택이는 앞으로의 모든 게임에서 지지 않는다. 하지만, 형택이는 게임 기록을 삭제 할 수 없기 때문에, 자신의 못하던 예전 기록이 현재 자신의 엄청난 실력을 증명하지 못한다고 생각했다.
//
// 게임 기록은 다음과 같이 생겼다.
//
// 게임 횟수 : X
// 이긴 게임 : Y (Z%)
// Z는 형택이의 승률이고, 소수점은 버린다. 예를 들어, X=53, Y=47이라면, Z=88이다.
// X와 Y가 주어졌을 때, 형택이가 게임을 최소 몇 번 더 해야 Z가 변하는지 구하는 프로그램을 작성하시오.
//
// 입력
// 각 줄에 정수 X와 Y가 주어진다.
//
// 출력
// 첫째 줄에 형택이가 게임을 최소 몇 판 더 해야하는지 출력한다. 만약 Z가 절대 변하지 않는다면 -1을 출력한다.
//
// 제한
// 1 ≤ X ≤ 1,000,000,000
// 0 ≤ Y ≤ X
// 예제 입력 1
// 10 8
// 예제 출력 1
// 1
// 예제 입력 2
// 100 80
// 예제 출력 2
// 6
// 예제 입력 3
// 47 47
// 예제 출력 3
// -1
// 예제 입력 4
// 99000 0
// 예제 출력 4
// 1000
// 예제 입력 5
// 1000000000 470000000
// 예제 출력 5
// 19230770

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long x = readNumber(br);
		long y = readNumber(br);
		long z = y * 100 / x;

		if (z >= 99) {
			System.out.println(-1);
			return;
		}
		long left = 1, right = 1_000_000_000;
		long result = 0;

		while (left <= right) {
			long mid = left + (right - left) / 2;
			long newZ = (y + mid) * 100L / (x + mid);

			if (newZ <= z) {
				left = mid + 1;
			} else {
				result = mid;
				right = mid - 1;
			}
		}
		System.out.println(result);

	}

	private static long readNumber(BufferedReader br) throws IOException {
		long value = 0;
		long c = br.read();

		while (c == ' ') {
			c = br.read();
		}

		do {
			value = value * 10 + (c - '0');
		} while ((c = br.read()) >= '0' && c <= '9');

		return value;
	}
}
