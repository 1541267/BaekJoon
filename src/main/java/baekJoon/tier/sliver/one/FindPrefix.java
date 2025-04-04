package baekJoon.tier.sliver.one;

// (실버 1) 14426번 접두사 찾기
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	1536 MB	7554	2417	1765	36.756%
// 문제
// 문자열 S의 접두사란 S의 가장 앞에서부터 부분 문자열을 의미한다. 예를 들어, S = "codeplus"의 접두사는 "code", "co", "codepl", "codeplus"가 있고, "plus", "s", "cude", "crud"는 접두사가 아니다.
//
// 총 N개의 문자열로 이루어진 집합 S가 주어진다.
//
// 입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 문자열 중 적어도 하나의 접두사인 것의 개수를 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 문자열의 개수 N과 M (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)이 주어진다.
//
// 다음 N개의 줄에는 집합 S에 포함되어 있는 문자열이 주어진다.
//
// 다음 M개의 줄에는 검사해야 하는 문자열이 주어진다.
//
// 입력으로 주어지는 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않는다. 집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.
//
// 출력
// 첫째 줄에 M개의 문자열 중에 총 몇 개가 포함되어 있는 문자열 중 적어도 하나의 접두사인지 출력한다.
//
// 예제 입력 1
// 5 10
// baekjoononlinejudge
// startlink
// codeplus
// sundaycoding
// codingsh
// baekjoon
// star
// start
// code
// sunday
// coding
// cod
// online
// judge
// plus
// 예제 출력 1
// 7

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TrieNode 방법, map -> 배열, map으로 했을 때랑 비슷
public class FindPrefix {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		TrieNode root = new TrieNode();

		for (int i = 0; i < n; i++) {
			TrieNode node = root;

			String input = br.readLine();

			for (int j = 0; j < input.length(); j++) {
				char c = input.charAt(j);
				int index = c - 'a';
				if (node.children[index] == null) {
					node.children[index] = new TrieNode();
				}
				node = node.children[index];
			}
		}

		int count = 0;

		for (int i = 0; i < m; i++) {
			TrieNode node = root;
			boolean isLeaf = true;
			String input = br.readLine();

			for (int j = 0; j < input.length(); j++) {
				int index = input.charAt(j) - 'a';

				TrieNode aa = node.children[index];

				if (node.children[index] != null) {
					node = node.children[index];
				} else {
					isLeaf = false;
				}

				if (!isLeaf) {
					break;
				}
			}

			if (isLeaf) {
				count++;
			}
		}

		System.out.println(count);
	}

	static class TrieNode {
		TrieNode[] children = new TrieNode[26];
	}
}

// 이진 탐색 방법, 376ms
// public class FindPrefix {
// 	static int count = 0;
//
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringTokenizer st = new StringTokenizer(br.readLine());
//
// 		int n = Integer.parseInt(st.nextToken());
// 		int m = Integer.parseInt(st.nextToken());
//
// 		String[] arr = new String[n];
//
// 		for (int i = 0; i < n; i++) {
// 			arr[i] = br.readLine();
// 		}
//
// 		Arrays.sort(arr);
//
// 		for (int i = 0; i < m; i++) {
// 			searchAndCheck(arr, br.readLine());
// 		}
// 		System.out.println(count);
//
// 	}
//
// 	private static void searchAndCheck(String[] arr, String target) {
//
// 		int left = 0, right = arr.length - 1;
//
// 		while (left <= right) {
//
// 			int mid = left + (right - left) / 2;
//
// 			if (arr[mid].startsWith(target)) {
// 				count++;
// 				return;
// 			}
//
// 			if (arr[mid].compareTo(target) < 0) {
// 				left = mid + 1;
// 			} else {
// 				right = mid - 1;
// 			}
// 		}
// 	}
// }

// TrieNode 방법, 544ms
// public class FindPrefix {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringTokenizer st = new StringTokenizer(br.readLine());
//
// 		int n = Integer.parseInt(st.nextToken());
// 		int m = Integer.parseInt(st.nextToken());
//
// 		TrieNode root = new TrieNode();
//
// 		for (int i = 0; i < n; i++) {
// 			TrieNode node = root;
//
// 			String input = br.readLine();
//
// 			for (int j = 0; j < input.length(); j++) {
// 				char c = input.charAt(j);
//
// 				if (!node.children.containsKey(c)) {
// 					node.children.put(c, new TrieNode());
// 				}
// 				node = node.children.get(c);
//
// 			}
// 		}
//
// 		int count = 0;
//
// 		for (int i = 0; i < m; i++) {
// 			TrieNode node = root;
// 			boolean isLeaf = true;
// 			String input = br.readLine();
//
// 			for (int j = 0; j < input.length(); j++) {
//
// 				if (node.children.containsKey(input.charAt(j))) {
// 					node = node.children.get(input.charAt(j));
// 				} else {
// 					isLeaf = false;
// 				}
//
// 				if (!isLeaf) {
// 					break;
// 				}
// 			}
//
// 			if (isLeaf) {
// 				count++;
// 			}
// 		}
//
// 		System.out.println(count);
// 	}
//
// 	static class TrieNode {
// 		private Map<Character, TrieNode> children = new HashMap<>();
// 	}
// }
