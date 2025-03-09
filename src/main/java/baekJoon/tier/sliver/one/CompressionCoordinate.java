package baekJoon.tier.sliver.one;

// (실버 2) 18870번 좌표 압축
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	512 MB	116404	49803	37249	39.955%
// 문제
// 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
//
// Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.
//
// X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
//
// 입력
// 첫째 줄에 N이 주어진다.
//
// 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
//
// 출력
// 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
//
// 제한
// 1 ≤ N ≤ 1,000,000
// -109 ≤ Xi ≤ 109
// 예제 입력 1
// 5
// 2 4 -10 4 -9
// 예제 출력 1
// 2 3 0 3 1
// 예제 입력 2
// 6
// 1000 999 1000 999 1000 999
// 예제 출력 2
// 1 0 1 0 1 0

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


// 1888ms
public class CompressionCoordinate {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			arr[i] = (Integer.parseInt(st.nextToken()));
		}

		int[] sortedArr = Arrays.stream(arr).sorted().toArray();


		int j = 0;
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(sortedArr[i])) {
				map.putIfAbsent(sortedArr[i], j++);
			}
		}

		for (int i : arr) {
			sb.append(map.get(i)).append(" ");
		}

		System.out.println(sb);
	}
}

// 처음에 푼 것 2736ms
// public class CompressionCoordinate {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringBuilder sb = new StringBuilder();
// 		int n = Integer.parseInt(br.readLine());
//
// 		StringTokenizer st = new StringTokenizer(br.readLine());
//
// 		List<Integer> list = new ArrayList<Integer>();
// 		TreeMap<Integer, Integer> map = new TreeMap<>();
// 		int j = 0;
//
// 		for (int i = 0; i < n; i++) {
// 			list.add(Integer.valueOf(st.nextToken()));
// 		}
//
//
// 		for (int i = 0; i < n; i++) {
// 			map.putIfAbsent(list.get(i), 0);
// 		}
//
// 		for (Integer i : map.keySet()) {
// 			map.put(i, j++);
// 		}
//
// 		for (int i : list) {
// 			sb.append(map.get(i)).append(" ");
// 		}
// 		System.out.println(sb);
// 	}
// }
//