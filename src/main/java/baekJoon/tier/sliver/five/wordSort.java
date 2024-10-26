package baekJoon.tier.sliver.five;

// 문제 1181
// 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
//
// 길이가 짧은 것부터
// 길이가 같으면 사전 순으로
// 단, 중복된 단어는 하나만 남기고 제거해야 한다.
//
// 입력
// 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.
//
// 출력
// 조건에 따라 정렬하여 단어들을 출력한다.
//
// 예제 입력 1
// 13
// but
// i
// wont
// hesitate
// no
// more
// no
// more
// it
// cannot
// wait
// im
// yours
// 예제 출력 1
// i
// im
// it
// no
// but
// more
// wait
// wont
// yours
// cannot
// hesitate

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 커스텀 정렬 308ms

public class wordSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		String[] words = new String[n];

		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
		}

		Arrays.sort(words, (s1, s2) -> {
			if (s1.length() == s2.length()) {
				return s1.compareTo(s2);
			} else {
				return s1.length() - s2.length();
			}
		});

		for (int i = 0; i < n; i++) {

			bw.write(words[i]);
			bw.newLine();

			while (i + 1 < n && words[i + 1].equals(words[i])) {
				i++;
			}

		}

		bw.flush();
		bw.close();
		br.close();
	}
}

//	Comparator 사용 340ms
// public class wordSort {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
// 		int n = Integer.parseInt(br.readLine());
//
// 		Set<String> sets = new HashSet<>();
// 		for(int i = 0; i < n; i++){
// 			sets.add(br.readLine());
// 		}
//
// 		List<String> words = new ArrayList<>(sets);
//
// 		words.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
// 		for (String word : words) {
// 			bw.write(word);
// 			bw.newLine();
// 		}
// 		bw.flush();
// 		bw.close();
// 		br.close();
// 	}
// }
