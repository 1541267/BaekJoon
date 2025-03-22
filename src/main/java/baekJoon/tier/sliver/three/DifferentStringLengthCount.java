package baekJoon.tier.sliver.three;

// (실버 3) 11478번 서로 다른 부분 문자열의 개수
// 자료 구조, 문자열, 해시 | 트리 집합 맵
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	512 MB	37212	23595	19006	63.832%
// 문제
// 문자열 S가 주어졌을 때, S의 서로 다른 부분 문자열의 개수를 구하는 프로그램을 작성하시오.
//
// 부분 문자열은 S에서 연속된 일부분을 말하며, 길이가 1보다 크거나 같아야 한다.
//
// 예를 들어, ababc의 부분 문자열은 a, b, a, b, c, ab, ba, ab, bc, aba, bab, abc, abab, babc, ababc가 있고, 서로 다른것의 개수는 12개이다.
//
// 입력
// 첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000 이하이다.
//
// 출력
// 첫째 줄에 S의 서로 다른 부분 문자열의 개수를 출력한다.
//
// 예제 입력 1
// ababc
// 예제 출력 1
// 12

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// gpt 도움, suffix Array + LCP, 128ms
// 문자열의 맥가이버 칼? / 다양한 문제 풀이 가능
// suffix Array : 문자열 s 의 모든 접미사를 사전순으로 정렬
// LCP (Longest Common Prefix) : 접미사 배열에서 이웃한 두 접미사 간의 최장 공통 접두사(LCP)의 길이를 저장한 배열
public class DifferentStringLengthCount {
	static int[] buildSuffixArray(String s) {
		int n = s.length();
		int[] suffixArray = new int[n];
		Integer[] order = new Integer[n];

		for (int i = 0; i < n; i++) order[i] = i;

		Arrays.sort(order, Comparator.comparing(s::substring));
		// Arrays.sort(order, (a, b) -> s.substring(a).compareTo(s.substring(b)));

		for (int i = 0; i < n; i++) suffixArray[i] = order[i];
		System.out.println("suffixArray = " + Arrays.toString(suffixArray));

		return suffixArray;
	}

	static int[] buildLCPArray(String s, int[] suffixArray) {
		int n = s.length();
		int[] lcp = new int[n];
		int[] rank = new int[n];

		for (int i = 0; i < n; i++) rank[suffixArray[i]] = i;

		int h = 0;
		for (int i = 0; i < n; i++) {
			if (rank[i] > 0) {
				int j = suffixArray[rank[i] - 1];
				while (i + h < n && j + h < n && s.charAt(i + h) == s.charAt(j + h)) h++;
				lcp[rank[i]] = h;
				if (h > 0) h--;
			}
		}
		return lcp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = s.length();

		int[] suffixArray = buildSuffixArray(s);
		int[] lcp = buildLCPArray(s, suffixArray);

		// 전체 부분 문자열 개수 - 중복된 개수 제거
		int totalSubstrings = n * (n + 1) / 2;
		int commonSubstrings = Arrays.stream(lcp).sum();

		System.out.println(totalSubstrings - commonSubstrings);
	}
}

// // TrieNode 풀이, 260ms
// public class DifferentStringLengthCount {
//
// 	static class TrieNode {
// 		Map<Character, TrieNode> children = new HashMap<>();
// 	}
//
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		String s = br.readLine();
//
// 		TrieNode root = new TrieNode();
//
// 		int count = 0;
//
// 		for (int i = 0; i < s.length(); i++) {
// 			TrieNode node = root;
// 			for (int j = i; j < s.length(); j++) {
// 				char c = s.charAt(j);
//
// 				if(!node.children.containsKey(c)) {
// 					node.children.put(c, new TrieNode());
// 					count++;
// 				}
// 				node = node.children.get(c);
// 			}
// 		}
// 		System.out.println("count = " + count);
// 	}
// }
// 직접 푼 것, 모든 조합 검사 656ms
//
// public class DifferentStringLengthCount {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		String s = br.readLine();
//
// 		String[] sArr = s.split("");
// 		HashSet<String> testSet = new HashSet<>();
//
//
// 		for (int i = 0; i < s.length(); i++) {
//
// 			int endIndex = i + 1;
//
// 			while (endIndex != s.length() + 1) {
//
// 				testSet.add(s.substring(i, endIndex++));
//
// 			}
//
// 		}
// 		System.out.println(testSet.size());
// 	}
// }
