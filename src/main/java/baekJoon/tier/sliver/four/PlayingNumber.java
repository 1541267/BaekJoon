package baekJoon.tier.sliver.four;

// 숫자놀이
// 1755번
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	128 MB	6290	3890	3437	64.004%
// 문제
// 79를 영어로 읽되 숫자 단위로 하나씩 읽는다면 "seven nine"이 된다. 80은 마찬가지로 "eight zero"라고 읽는다. 79는 80보다 작지만, 영어로 숫자 하나씩 읽는다면 "eight zero"가 "seven nine"보다 사전순으로 먼저 온다.
//
// 문제는 정수 M, N(1 ≤ M ≤ N ≤ 99)이 주어지면 M 이상 N 이하의 정수를 숫자 하나씩 읽었을 때를 기준으로 사전순으로 정렬하여 출력하는 것이다.
//
// 입력
// 첫째 줄에 M과 N이 주어진다.
//
// 출력
// M 이상 N 이하의 정수를 문제 조건에 맞게 정렬하여 한 줄에 10개씩 출력한다.
//
// 예제 입력 1
// 8 28
// 예제 출력 1
// 8 9 18 15 14 19 11 17 16 13
// 12 10 28 25 24 21 27 26 23 22
// 20

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class PlayingNumber {
	// 108ms
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		String[] numToWord = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		List<String[]> numbers = new ArrayList<>();

		StringBuilder stb = new StringBuilder();
		for (int i = m; i <= n; i++) {
			stb = new StringBuilder();
			for (char c : String.valueOf(i).toCharArray()) {
				stb.append(numToWord[c - '0']).append(" ");
			}
			numbers.add(new String[] {stb.toString().trim(), String.valueOf(i)});
		}

		numbers.sort(Comparator.comparing(a -> a[0]));

		stb = new StringBuilder();
		for (int i = 0; i < numbers.size(); i++) {
			stb.append(numbers.get(i)[1]).append(" ");
			if ((i + 1) % 10 == 0) {
				stb.append("\n");
			}
		}
		System.out.println(stb);
	}
}
//
// public class PlayingNumber {
// 	// 108ms
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringTokenizer st = new StringTokenizer(br.readLine());
//
// 		int m = Integer.parseInt(st.nextToken());
// 		int n = Integer.parseInt(st.nextToken());
//
// 		String[] numList = numList = new String[n - m + 1];
//
// 		for (int i = 0; i < numList.length; i++) {
// 			numList[i] = String.valueOf(m++);
// 		}
//
// 		StringBuilder stb = new StringBuilder();
// 		String[] numToCharList = new String[numList.length];
// 		for (int i = 0; i < numList.length; i++) {
//
// 			if (numList[i].length() == 1) {
// 				numToCharList[i] = NUMTOCHAR.get(Integer.parseInt(numList[i]));
// 			} else {
// 				int firstNum = Integer.parseInt(String.valueOf(numList[i].charAt(0)));
// 				int secondNum = Integer.parseInt(String.valueOf(numList[i].charAt(1)));
//
// 				stb.append(NUMTOCHAR.get(firstNum)).append(" ");
// 				stb.append(NUMTOCHAR.get(secondNum));
// 				numToCharList[i] = stb.toString();
// 				stb.delete(0, stb.length());
// 			}
//
// 		}
//
// 		Arrays.sort(numToCharList);
// 		String[] result = new String[numToCharList.length];
// 		stb = new StringBuilder();
// 		for (int i = 0; i < numToCharList.length; i++) {
// 			String[] stringList = numToCharList[i].split(" ");
//
// 			if (stringList.length == 1) {
// 				stb.append(CHARTONUM.get(stringList[0])).append(" ");
// 				result[i] = stb.toString();
// 				stb.delete(0, stb.length());
//
// 			} else {
//
// 				String firstNum = String.valueOf(stringList[0]);
// 				String secondNum = String.valueOf(stringList[1]);
//
// 				stb.append(CHARTONUM.get(firstNum)).append(CHARTONUM.get(secondNum)).append(" ");
// 				result[i] = stb.toString();
// 				stb.delete(0, stb.length());
// 			}
// 		}
//
// 		for (int i = 0; i < result.length; i++) {
// 			System.out.print(result[i]);
// 			if((i+1) % 10 == 0) {
// 				System.out.println();
// 			}
// 		}
//
//
//
// 	}
//
// 	private static final Map<Integer, String> NUMTOCHAR;
//
// 	static {
// 		NUMTOCHAR = Map.of(
// 			0, "zero",
// 			1, "one",
// 			2, "two",
// 			3, "three",
// 			4, "four",
// 			5, "five",
// 			6, "six",
// 			7, "seven",
// 			8, "eight",
// 			9, "nine"
// 		);
// 	}
//
// 	private static final Map<String, Integer> CHARTONUM;
//
// 	static {
// 		CHARTONUM = Map.of(
// 			"zero", 0,
// 			"one", 1,
// 			"two", 2,
// 			"three", 3,
// 			"four", 4,
// 			"five", 5,
// 			"six", 6,
// 			"seven", 7,
// 			"eight", 8,
// 			"nine", 9
// 		);
// 	}
// }
