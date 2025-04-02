package baekJoon.tier.sliver.four;

// (실버 4) 1120번 문자열
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	128 MB	21402	12332	10774	59.172%
// 문제
// 길이가 N으로 같은 문자열 X와 Y가 있을 때, 두 문자열 X와 Y의 차이는 X[i] ≠ Y[i]인 i의 개수이다. 예를 들어, X=”jimin”, Y=”minji”이면, 둘의 차이는 4이다.
//
// 두 문자열 A와 B가 주어진다. 이때, A의 길이는 B의 길이보다 작거나 같다. 이제 A의 길이가 B의 길이와 같아질 때 까지 다음과 같은 연산을 할 수 있다.
//
// A의 앞에 아무 알파벳이나 추가한다.
// A의 뒤에 아무 알파벳이나 추가한다.
// 이때, A와 B의 길이가 같으면서, A와 B의 차이를 최소로 하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 A와 B가 주어진다. A와 B의 길이는 최대 50이고, A의 길이는 B의 길이보다 작거나 같고, 알파벳 소문자로만 이루어져 있다.
//
// 출력
// A와 B의 길이가 같으면서, A와 B의 차이를 최소가 되도록 했을 때, 그 차이를 출력하시오.
//
// 예제 입력 1
// adaabc aababbc
// 예제 출력 1
// 2
// 예제 입력 2
// hello xello
// 예제 출력 2
// 1
// 예제 입력 3
// koder topcoder
// 예제 출력 3
// 1
// 예제 입력 4
// abc topabcoder
// 예제 출력 4
// 0
// 예제 입력 5
// giorgi igroig
// 예제 출력 5
// 6
// A 문자열을 B에 삽입 했을 떄 문자열의 차이가 적을 수록 추가하는 알파벳의 갯수가 적음

// TODO 코드 원리 좀 더 이해하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringsMinimunNumber {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String firstS = st.nextToken();
		String secondS = st.nextToken();

		int firstLength = firstS.length();
		int secondLength = secondS.length();
		int minCount = Integer.MAX_VALUE;

		for (int i = 0; i <= secondLength - firstLength; i++) {
			int currentCount = 0;

			String currentS = secondS.substring(i, i + firstLength);

			for (int j = 0; j < firstLength; j++) {
				if(currentS.charAt(j) != firstS.charAt(j)) {
					currentCount++;
				}
			}
			minCount = Math.min(minCount, currentCount);

		}
		System.out.println(minCount);
	}
}

// 47% 에서 에러
// public class StringsMinimunNumber {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringTokenizer st = new StringTokenizer(br.readLine());
//
// 		String firstS = st.nextToken();
// 		StringBuilder stb = new StringBuilder(st.nextToken());
//
// 		int firstSLength = firstS.length();
// 		int currentCount = 0;
// 		int minCount = Integer.MAX_VALUE;
//
// 		do {
// 			if (stb.length() < firstSLength) {
// 				break;
// 			}
//
// 			currentCount = 0;
// 			String currentString = stb.substring(0, firstSLength);
// 			// System.out.println("currentString: " + currentString);
// 			// System.out.println("stb: " + stb);
// 			for (int i = 0; i < firstSLength; i++) {
// 				if (firstS.charAt(i) != stb.charAt(i)) {
// 					currentCount++;
// 				}
// 			}
// 			// System.out.println("CurrentCount: " + currentCount);
// 			// System.out.println("minCount: " + minCount);
// 			if (minCount == 0 && firstSLength != currentCount) {
// 				minCount = currentCount;
// 			} else {
// 				minCount = Math.min(currentCount, minCount);
// 			}
// 			stb.deleteCharAt(0);
// 		} while (true);
//
// 		System.out.print(minCount);
// 	}
// }
