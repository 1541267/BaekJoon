package baekJoon.tier.sliver.four;

// (실버 4) 1302번 베스트셀러
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	128 MB	30331	16572	13775	54.835%
// 문제
// 김형택은 탑문고의 직원이다. 김형택은 계산대에서 계산을 하는 직원이다. 김형택은 그날 근무가 끝난 후에, 오늘 판매한 책의 제목을 보면서 가장 많이 팔린 책의 제목을 칠판에 써놓는 일도 같이 하고 있다.
//
// 오늘 하루 동안 팔린 책의 제목이 입력으로 들어왔을 때, 가장 많이 팔린 책의 제목을 출력하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 오늘 하루 동안 팔린 책의 개수 N이 주어진다. 이 값은 1,000보다 작거나 같은 자연수이다. 둘째부터 N개의 줄에 책의 제목이 입력으로 들어온다. 책의 제목의 길이는 50보다 작거나 같고, 알파벳 소문자로만 이루어져 있다.
//
// 출력
// 첫째 줄에 가장 많이 팔린 책의 제목을 출력한다. 만약 가장 많이 팔린 책이 여러 개일 경우에는 사전 순으로 가장 앞서는 제목을 출력한다.
//
// 예제 입력 1
// 5
// top
// top
// top
// top
// kimtop
// 예제 출력 1
// top
// 예제 입력 2
// 9
// table
// chair
// table
// table
// lamp
// door
// lamp
// table
// chair
// 예제 출력 2
// table
// 예제 입력 3
// 6
// a
// a
// a
// b
// b
// b
// 예제 출력 3
// a
// 예제 입력 4
// 8
// icecream
// peanuts
// peanuts
// chocolate
// candy
// chocolate
// icecream
// apple
// 예제 출력 4
// chocolate

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

// TreeMap -> HashMap, 정렬 최소화, 104ms
public class Bestseller {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		HashMap<String, Integer> books = new LinkedHashMap<>();
		int maxCount = 0;

		for (int i = 0; i < n; i++) {
			String book = br.readLine();
			books.put(book, books.getOrDefault(book, 0) + 1);
			maxCount = Math.max(maxCount, books.getOrDefault(book, 0));
		}

		List<String> result = new ArrayList<>();

		for (String book : books.keySet()) {
			if(books.get(book) == maxCount) {
				result.add(book);
			}
		}

		Collections.sort(result);
		System.out.println(result.get(0));
	}
}

// 처음 코드에서 정리
// public class Bestseller {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		int n = Integer.parseInt(br.readLine());
//
// 		TreeMap<String, Integer> books = new TreeMap<>();
//
// 		for (int i = 0; i < n; i++) {
// 			String book = br.readLine();
// 			books.put(book, books.getOrDefault(book, 0) + 1);
// 		}
//
// 		int maxCount = 0;
// 		String result = "";
// 		for (String book : books.keySet()) {
// 			if(books.get(book) > maxCount) {
// 				maxCount = books.get(book);
// 				result = book;
// 			}
// 		}
// 		System.out.println(result);
// 	}
// }

// 처음에 푼 것, 108ms
// public class Bestseller {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		int n = Integer.parseInt(br.readLine());
//
// 		LinkedHashMap<String, Integer> books = new LinkedHashMap<>();
//
// 		for (int i = 0; i < n; i++) {
// 			String book = br.readLine();
// 			books.put(book, books.getOrDefault(book, 0) + 1);
// 		}
//
// 		Arrays.sort(books.keySet().toArray());
//
// 		System.out.println("books.reversed() = " + books.reversed());
//
// 		System.out.println("books = " + books);
//
// 		List<String> list = new ArrayList<>();
//
// 		int max = Collections.max(books.values());
// 		for (String s : books.keySet()) {
// 			if(books.get(s) == max) {
// 				list.add(s);
// 			}
// 		}
//
// 		list.sort(Comparator.naturalOrder());
// 		System.out.println(list.get(0));
// 	}
// }
