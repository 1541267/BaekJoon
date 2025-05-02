package baekJoon.tier.sliver.one;

/*
	(실버 1) 17503번 맥주 축제
	자료 구조, 그리디 알고리즘, 정렬, 이분 탐색, 우선순위 큐
	시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
	1 초	256 MB	4915	1561	1141	30.821%
	문제
	내일부터 N일 동안 대구광역시에서 맥주 축제가 열립니다!

	이 축제에서는 무려 K종류의 맥주를 무료로 제공합니다.

	축제 주최자는 축제에서 더 많은 참가자들이 다양한 종류의 맥주를 즐겼으면 합니다. 그래서 축제에서 참가자들은 하루에 맥주 1병만 받을 수 있고, 이전에 받았던 종류의 맥주는 다시 받을 수 없습니다.

	맥주를 정말로 사랑하는 대학생 전씨는 무료 맥주 소식에 신이 났습니다. 전씨는 이 맥주 축제에 참가해 총 N일 동안 맥주 N병을 마시려 합니다.

	하지만 전씨에게는 큰 고민이 있었습니다. 전씨는 맥주를 사랑하지만, 도수가 높은 맥주를 마시면 기절하는 맥주병이 있습니다. 전씨는 맥주를 마시다 기절하면 늦잠을 자 다음 날 1교시 수업에 결석해 F를 받게 될 수도 있습니다.

	전씨는 고민을 해결하기 위해 천재석사 현씨과 천재박사 승씨에게 자신의 간을 강력하게 만들어달라고 부탁했습니다. 하지만 간을 강력하게 만드는 비용이 너무 비싸서, 전씨는 간을 가능한 한 조금만 강화할 계획을 세웠습니다.

	우선, K종류의 맥주에 각각 '선호도'와 '도수 레벨'을 매겼습니다. 선호도는 전씨가 해당 맥주를 얼마나 좋아하는지를 나타내는 수치이고, 도수 레벨은 해당 맥주의 도수가 얼마나 강한지를 나타내는 수치입니다. 편의상 전씨는 선호도와 도수 레벨을 정수로 매겼습니다.

	만약, 마시는 맥주의 도수 레벨이 전씨의 간 레벨보다 높으면 맥주병이 발병해 기절해버리고 맙니다.

	또한, 전씨는 맥주병에 걸리지 않으면서도 자신이 좋아하는 맥주를 많이 마시고 싶어합니다. 따라서, 마시는 맥주 N개의 선호도 합이 M이상이 되게 하려 합니다.

	거창한 계획을 세운 전, 현, 승 세 사람은 서로 머리를 맞대고 고민하다가, 스트레스를 받아 연구를 집어치고 맥주를 마시러 떠나버렸습니다.

	이를 본 여러분은 세 사람을 대신해 조건을 만족하는 간 레벨의 최솟값을 출력하는 프로그램을 만들어 주려고 합니다.

	세 사람을 도와주세요!

	입력
	첫 번째 줄에 축제가 열리는 기간 N (1 ≤ N ≤ 200,000) 과, 채워야 하는 선호도의 합 M (1 ≤ M < 231) 과, 마실 수 있는 맥주 종류의 수 K (N ≤ K ≤ 200,000) 가 주어집니다.

	다음 K개의 줄에는 1번부터 K번 맥주의 선호도 vi (0 ≤ vi ≤ 10,000) 와 도수 레벨 ci (1 ≤ ci < 231) (vi, ci는 정수) 이 공백을 사이에 두고 주어집니다.

	1번부터 K번 맥주의 종류는 모두 다릅니다.

	출력
	첫 번째 줄에 주어진 선호도의 합 M을 채우면서 N개의 맥주를 모두 마실 수 있는 간 레벨의 최솟값을 출력합니다.

	만약 아무리 레벨을 올려도 조건을 만족시킬 수 없으면 첫 번째 줄에 "-1" 하나만 출력하고 더 이상 아무것도 출력하지 않아야 합니다.

	예제 입력 1
	3 9 5
	2 5
	4 6
	3 3
	4 3
	1 4
	예제 출력 1
	5
	예제 입력 2
	1 100 2
	99 10
	99 10
	예제 출력 2
	-1
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 824ms
// 선호도 순으로 내림차순 정렬, 이분탐색으로 도수 레벨의 범위를 잡음
// (mid = 현재 선택 가능한 최대 도수 수준)
// 도수 레벨 이하의 맥주를 추가, 선호도 순으로 정렬 되어있음
// n개의 선호도를 모두 더해 m 이상이면 해당 알코올(mid) 값을 정답 후보 그리고 mid - 1로 다시 탐색
// 아니면 도수를 높여(mid + 1) 다시 탐색

public class BeerFestival {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n일동안 맥주 n병
		int n = readInt(br);
		// 타겟 선호도 합
		long m = readLong(br);
		// 맥주 종류
		int k = readInt(br);

		List<Beer> beers = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			beers.add(new Beer(readInt(br), readLong(br)));
		}

		beers.sort(Comparator.comparingInt((Beer a) -> a.preference).reversed());

		System.out.println(bs(beers, n, m));

	}

	private static long bs(List<Beer> beers, int n, long m) {

		long left = 0, right = Integer.MAX_VALUE;
		long answer = -1;
		while (left <= right) {

			long mid = left + (right - left) / 2;

			List<Beer> list = new ArrayList<>();

			for (Beer b : beers) {
				if (b.alcohol <= mid) list.add(b);

				if (list.size() > n) list.remove(list.size() - 1);
			}

			if (list.size() < n) {
				left = mid + 1;
				continue;
			}

			long total = 0;
			for (Beer beer : list) {
				total += beer.preference;
			}

			if (total >= m) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return answer;
	}

	static class Beer implements Comparable<Beer> {
		private int preference;
		private long alcohol;

		public Beer(int preference, long alcohol) {
			this.preference = preference;
			this.alcohol = alcohol;
		}

		@Override
		public int compareTo(Beer o) {
			return 0;
		}
	}

	private static int readInt(BufferedReader br) throws IOException {
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

	private static long readLong(BufferedReader br) throws IOException {
		long value = 0;
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


/*
828ms
public class BeerFestival {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n일동안 맥주 n병
		int n = readInt(br);
		// 타겟 선호도 합
		long m = readLong(br);
		// 맥주 종류
		int k = readInt(br);

		List<Beer> beers = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			beers.add(new Beer(readInt(br), readLong(br)));
		}

		beers.sort(Comparator.comparingInt((Beer a) -> a.preference).reversed());

		System.out.println(bs(beers, n, m));

	}

	private static long bs(List<Beer> beers, int n, long m) {

		long left = 0, right = Integer.MAX_VALUE;
		long answer = -1;
		while (left <= right) {

			long mid = left + (right - left) / 2;

			List<Beer> list = new ArrayList<>();

			for (Beer b : beers) {
				if (b.alcohol <= mid) list.add(b);
			}

			if (list.size() < n) {
				left = mid + 1;
				continue;
			}

			long total = 0;

			for (int i = 0; i < n; i++) {
				total += list.get(i).preference;
			}

			if (total >= m) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return answer;
	}

	static class Beer implements Comparable<Beer> {
		private int preference;
		private long alcohol;

		public Beer(int preference, long alcohol) {
			this.preference = preference;
			this.alcohol = alcohol;
		}

		@Override
		public int compareTo(Beer o) {
			return 0;
		}
	}

	private static int readInt(BufferedReader br) throws IOException {
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

	private static long readLong(BufferedReader br) throws IOException {
		long value = 0;
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
*/
