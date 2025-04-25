package baekJoon.tier.sliver.two;

// (실버 2) 12867번 N차원 여행
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	512 MB	464	183	157	43.733%
// 문제
// 수빈이는 여행을 좋아한다. 더 이상 지구에서 여행할 곳이 없어진 수빈이는 N차원 우주로 여행을 떠났다. 우주의 각 점은 좌표 N개로 이루어 지며, 각각의 좌표는 1부터 N까지 인덱스가 매겨져 있다.
//
// 수빈이는 원점(모든 좌표가 0인 곳)에서  여행을 시작하며, 아래와 같은 방법으로 움직인다.
//
// 첫 번째로 움직일 좌표의 인덱스를 고른다. (1부터 N까지 중의 하나)
// 그 다음, 그 좌표의 값을 1만큼 증가시킨 곳이나 감소시킨 곳으로 이동한다. (다른 좌표는 이동하기 전과 같아야 한다)
// 수빈이는 여행을 떠나기 전에 여행 계획을 작성해 놓았고, 같은 점을 두 번 이상 방문하는지 아닌지 알아보려고 한다.
//
// 수빈이가 여행 계획에서 고른 좌표 인덱스와, 좌표가 증가하는 방향으로 이동했는지, 감소하는 방향으로 이동했는지가 주어진다. 수빈이가 첫 번째 점과 마지막 점을 포함한 모든 점을 중복해서 방문하지 않게 방문할 수 있다면 1을, 아니면 0을 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 N (1 ≤ N ≤ 1,000,000,000)이 주어진다.
//
// 둘째 줄에는 수빈이의 여행 계획의 길이 M (1 ≤ M ≤ 50)이 주어진다.
//
// 셋째 줄에는 수빈이가 여행 계획에서 고른 좌표의 인덱스가 순서대로 주어진다.
//
// 넷째 줄에는 증가하는 방향으로 이동할 것인지, 감소하는 방향으로 이동할 것인지를 나타내는 문자열이 주어지며, +는 증가하는 방향, -는 감소하는 방향을 나타낸다.
//
// 출력
// 모든 점을 중복해서 방문하지 않을 수 있으면 1을, 아니면 0을 출력한다.
//
// 예제 입력 1
// 1
// 1
// 1
// +
// 예제 출력 1
// 1
// 예제 입력 2
// 2
// 4
// 1 2 1 2
// ++--
// 예제 출력 2
// 0
// 예제 입력 3
// 3
// 5
// 1 2 3 1 2
// +++--
// 예제 출력 3
// 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class NthDimensionTrip {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[] indexArr = new int[m + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> indexSet = new HashSet<>();
		int index = 1;
		while (st.hasMoreTokens()) {
			int input = Integer.parseInt(st.nextToken());
			indexArr[index++] = input;
			indexSet.add(input);
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		HashSet<String> set = new HashSet<>();

		String op = "0" + br.readLine();
		char[] chars = op.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (Integer i : indexSet) {
			map.put(i, map.getOrDefault(i, 0));
			sb.append(map.get(i)).append(":");
		}
		sb.deleteCharAt(sb.length() - 1);
		set.add(sb.toString());
		sb.setLength(0);
		for (int i = 1; i <= m; i++) {
			if (chars[i] == '+') {
				map.put(indexArr[i], map.getOrDefault(indexArr[i], 0) + 1);
			} else {
				map.put(indexArr[i], map.getOrDefault(indexArr[i], 0) - 1);
			}

			for (Integer j : indexSet) {
				sb.append(map.get(j)).append(":");
			}
			sb.deleteCharAt(sb.length() - 1);

			if (set.contains(sb.toString())) {
				System.out.println(0);
				return;
			} else {
				set.add(sb.toString());
			}
			sb.setLength(0);
		}
		System.out.println(1);
	}
}
