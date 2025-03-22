package baekJoon.tier.sliver.four;

// (실버 4) 10825번 국영수
// 정렬
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	256 MB	41970	22997	16835	54.830%
// 문제
// 도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다. 이때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.
//
// 국어 점수가 감소하는 순서로
// 국어 점수가 같으면 영어 점수가 증가하는 순서로
// 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
// 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
// 입력
// 첫째 줄에 도현이네 반의 학생의 수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 한 줄에 하나씩 각 학생의 이름, 국어, 영어, 수학 점수가 공백으로 구분해 주어진다. 점수는 1보다 크거나 같고, 100보다 작거나 같은 자연수이다. 이름은 알파벳 대소문자로 이루어진 문자열이고, 길이는 10자리를 넘지 않는다.
//
// 출력
// 문제에 나와있는 정렬 기준으로 정렬한 후 첫째 줄부터 N개의 줄에 걸쳐 각 학생의 이름을 출력한다.
//
// 예제 입력 1
// 12
// Junkyu 50 60 100
// Sangkeun 80 60 50
// Sunyoung 80 70 100
// Soong 50 60 90
// Haebin 50 60 100
// Kangsoo 60 80 100
// Donghyuk 80 60 100
// Sei 70 70 70
// Wonseob 70 70 90
// Sanghyun 70 70 80
// nsj 80 80 80
// Taewhan 50 60 90
// 예제 출력 1
// Donghyuk
// Sangkeun
// Sunyoung
// nsj
// Wonseob
// Sanghyun
// Sei
// Kangsoo
// Haebin
// Junkyu
// Soong
// Taewhan

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


// 632ms
public class KoreanEnglishMath {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<Student> students = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			students.add(new Student(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()));
		}

		students.sort(null);

		StringBuilder sb = new StringBuilder();
		for (Student student : students) {
			sb.append(student.name).append("\n");
		}
		System.out.print(sb);
	}

	private static class Student implements Comparable<Student> {

		String name;
		int korean;
		int english;
		int math;

		public Student(String name, String korean, String english, String math) {
			this.name = name;
			this.korean = Integer.parseInt(korean);
			this.english = Integer.parseInt(english);
			this.math = Integer.parseInt(math);
		}

		@Override
		public int compareTo(Student s) {

			if (korean != s.korean)
				return Integer.compare(s.korean, korean);

			if (english != s.english)
				return Integer.compare(english, s.english);

			if (math != s.math)
				return Integer.compare(s.math, math);

			return name.compareTo(s.name);
		}
	}
}

// Student를 Comparable 구현, compare 재정의
// public class KoreanEnglishMath {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		int n = readNumber(br);
//
// 		Student[] students = new Student[n];
//
// 		for (int i = 0; i < n; i++) {
// 			StringTokenizer st = new StringTokenizer(br.readLine());
//
// 			students[i] = new Student(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
// 		}
//
// 		Arrays.sort(students);
// 		StringBuilder sb = new StringBuilder();
// 		for (Student student : students) {
// 			sb.append(student.name).append("\n");
// 		}
// 		System.out.print(sb);
// 	}
//
// 	private static class Student implements Comparable<Student> {
//
// 		String name;
// 		int korean;
// 		int english;
// 		int math;
//
// 		public Student(String name, String korean, String english, String math) {
// 			this.name = name;
// 			this.korean = Integer.parseInt(korean);
// 			this.english = Integer.parseInt(english);
// 			this.math = Integer.parseInt(math);
// 		}
//
// 		@Override
// 		public int compareTo(Student s) {
//
// 			if (korean != s.korean) return Integer.compare(s.korean, korean);
//
// 			if (english != s.english) return Integer.compare(english, s.english);
//
// 			if (math != s.math) return Integer.compare(s.math, math);
//
// 			return name.compareTo(s.name);
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
//

// 처음에 푼 것, 1032ms, Map의 키 별 정렬
// public class KoreanEnglishMath {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		int n = readNumber(br);
// 		HashMap<String, List<Integer>> map = new HashMap<>();
//
// 		for (int i = 0; i < n; i++) {
// 			StringTokenizer st = new StringTokenizer(br.readLine());
// 			String key = st.nextToken();
// 			map.putIfAbsent(key, new ArrayList<Integer>());
//
// 			for (int j = 0; j < 3; j++) {
// 				map.get(key).add(Integer.valueOf(st.nextToken()));
// 			}
// 		}
//
// 		StringBuilder sb = new StringBuilder();
// 		List<String> keys = new ArrayList<>(map.keySet());
//
// 		keys.sort((a, b) -> {
// 			List<Integer> first = map.get(a);
// 			List<Integer> second = map.get(b);
//
// 			int gap = Integer.compare(second.get(0), first.get(0));
//
// 			if (gap != 0)
// 				return gap;
//
// 			gap = Integer.compare(first.get(1), second.get(1));
//
// 			if (gap != 0)
// 				return gap;
//
// 			gap = Integer.compare(second.get(2), first.get(2));
//
// 			if (gap != 0) {
// 				return gap;
// 			}
//
// 			return a.compareTo(b);
//
// 		});
//
// 		for (String key : keys) {
// 			sb.append(key).append("\n");
// 		}
//
// 		System.out.print(sb);
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
