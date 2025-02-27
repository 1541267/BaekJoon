package baekJoon.tier.sliver.four;

// (실버 4) 14425번 문자열 집합
// - 자료 구조
// - 정렬
// - 이분 탐색
// - 해시를 사용한 집합과 맵
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초 (하단 참고)	1536 MB	64172	34960	26782	54.114%
// 문제
// 총 N개의 문자열로 이루어진 집합 S가 주어진다.
//
// 입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 문자열의 개수 N과 M (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)이 주어진다.
//
// 다음 N개의 줄에는 집합 S에 포함되어 있는 문자열들이 주어진다.
//
// 다음 M개의 줄에는 검사해야 하는 문자열들이 주어진다.
//
// 입력으로 주어지는 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않는다. 집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.
//
// 출력
// 첫째 줄에 M개의 문자열 중에 총 몇 개가 집합 S에 포함되어 있는지 출력한다.
//
// 예제 입력 1
// 5 11
// baekjoononlinejudge
// startlink
// codeplus
// sundaycoding
// codingsh
// baekjoon
// codeplus
// codeminus
// startlink
// starlink
// sundaycoding
// codingsh
// codinghs
// sondaycoding
// startrink
// icerink
// 예제 출력 1
// 4

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;


// 줄인 방법 364ms
public class StringSet {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashSet<String> first = new HashSet<>();

		for (int i = 0; i < n; i++) {
			first.add(br.readLine());
		}

		int count = 0;

		for (int i = 0; i < m ; i++) {

			if(first.contains(br.readLine())) {
				count++;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}

// 처음에 푼 방법  3188ms
// public class StringSet {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringTokenizer st = new StringTokenizer(br.readLine());
//
// 		int n = Integer.parseInt(st.nextToken());
// 		int m = Integer.parseInt(st.nextToken());
//
// 		TreeSet<String> first = new TreeSet<>();
// 		LinkedHashMap<Character, List<String>> second = new LinkedHashMap<>();
//
// 		for (int i = 0; i < n; i++) {
// 			first.add(br.readLine());
// 		}
// 		for (int i = 0; i < m; i++) {
// 			String newS = br.readLine();
//
// 			char firstChar = newS.charAt(0);
//
// 			second.putIfAbsent(firstChar, new ArrayList<>());
// 			second.get(firstChar).add(newS);
// 		}
//
// 		int count = 0;
//
// 		for (String s : first) {
// 			char currentSearchingChar = s.charAt(0);
//
// 			// System.out.println("----------------------------------------------");
// 			// System.out.println("비교 시작 문자열 = " + s);
//
// 			if (second.containsKey(currentSearchingChar)) {
// 				List<String> currentValues = second.get(currentSearchingChar);
//
// 				// System.out.println("currentValues = " + currentValues);
//
// 				for (int i = 0; i < second.get(currentSearchingChar).size(); i++) {
// 					if (currentValues.get(i).equals(s)) {
// 						count++;
// 						// System.out.println("카운트 업");
// 					}
// 				}
//
// 			}
//
// 		}
//
// 		System.out.println(count);
//
// 	}
// }
