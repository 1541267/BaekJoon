package baekJoon.tier.sliver.four;
// (실버 4) 1822번 차집합
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	256 MB	14134	6556	5294	46.680%
// 문제
// 몇 개의 자연수로 이루어진 두 집합 A와 B가 있다. 집합 A에는 속하면서 집합 B에는 속하지 않는 모든 원소를 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에는 집합 A의 원소의 개수 n(A)와 집합 B의 원소의 개수 n(B)가 빈 칸을 사이에 두고 주어진다. (1 ≤ n(A), n(B) ≤ 500,000)이 주어진다. 둘째 줄에는 집합 A의 원소가, 셋째 줄에는 집합 B의 원소가 빈 칸을 사이에 두고 주어진다. 하나의 집합의 원소는 2,147,483,647 이하의 자연수이며, 하나의 집합에 속하는 모든 원소의 값은 다르다.
//
// 출력
// 첫째 줄에 집합 A에는 속하면서 집합 B에는 속하지 않는 원소의 개수를 출력한다. 다음 줄에는 구체적인 원소를 빈 칸을 사이에 두고 증가하는 순서로 출력한다. 집합 A에는 속하면서 집합 B에는 속하지 않는 원소가 없다면 첫째 줄에 0만을 출력하면 된다.
//
// 예제 입력 1
// 4 3
// 2 5 11 7
// 9 7 4
// 예제 출력 1
// 3
// 2 5 11
// 예제 입력 2
// 3 5
// 2 5 4
// 1 2 3 4 5
// 예제 출력 2
// 0

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

// 1024ms, HashSet + TreeSet O(n log n) -> TreeSet 사용 O(log n) 으로 입력부터 정렬
public class DifferenceSets {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = readNumber(br);
		int m = readNumber(br);

		TreeSet<Integer> firstSet = new TreeSet<>();

		for (int i = 0; i < n; i++) {
			firstSet.add(readNumber(br));
		}

		for (int i = 0; i < m; i++) {
			int input = readNumber(br);

			firstSet.remove(input);
		}

		StringBuilder sb = new StringBuilder();

		if(firstSet.isEmpty()) {
			System.out.print(0);
			return;
		}

		sb.append(firstSet.size()).append("\n");

		for (Integer i : firstSet) {
			sb.append(i).append(" ");
		}

		System.out.print(sb);

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

// // 1184ms, hashMap -> hashSet
// public class DifferenceSets {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		int n = readNumber(br);
// 		int m = readNumber(br);
//
// 		HashSet<Integer> firstSet = new HashSet<>();
//
// 		for (int i = 0; i < n; i++) {
// 			firstSet.add(readNumber(br));
// 		}
//
// 		for (int i = 0; i < m; i++) {
// 			int input = readNumber(br);
//
// 			firstSet.remove(input);
// 		}
// 		StringBuilder sb = new StringBuilder();
//
// 		TreeSet<Integer> sortedSet = new TreeSet<>(firstSet);
//
// 		if(sortedSet.isEmpty()) {
// 			System.out.println(0);
// 			return;
// 		}
//
// 		sb.append(sortedSet.size()).append("\n");
//
// 		for (Integer i : sortedSet) {
// 			sb.append(i).append(" ");
// 		}
//
// 		System.out.println(sb);
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

// 처음에 푼 것, 1248ms
// public class DifferenceSets {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		int n = readNumber(br);
// 		int m = readNumber(br);
//
// 		HashMap<Integer, Integer> firstSet = new HashMap<>();
//
// 		for (int i = 0; i < n; i++) {
// 			int input = readNumber(br);
// 			firstSet.put(input, firstSet.getOrDefault(input, 0) + 1);
// 		}
//
// 		for (int i = 0; i < m; i++) {
// 			int input = readNumber(br);
//
// 			firstSet.computeIfPresent(input, (k, v) -> v - 1);
// 		}
//
// 		firstSet.keySet().removeIf(currentKey -> firstSet.get(currentKey) == 0);
//
// 		StringBuilder sb = new StringBuilder();
//
// 		List<Integer> list = new ArrayList<>(firstSet.keySet());
//
// 		Collections.sort(list);
//
// 		if (firstSet.isEmpty()) {
// 			System.out.println(0);
// 		} else {
// 			sb.append(firstSet.size()).append("\n");
// 			for (Integer i : list) {
// 					sb.append(i).append(" ");
// 			}
//
// 			System.out.print(sb);
// 		}
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
