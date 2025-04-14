package baekJoon.tier.sliver.three;

// (실버 3) 1213번 팰린드롬 만들기
// 구현, 그리디 알고리즘, 문자열
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	128 MB	36128	15957	11807	43.392%
// 문제
// 임한수와 임문빈은 서로 사랑하는 사이이다.
//
// 임한수는 세상에서 팰린드롬인 문자열을 너무 좋아하기 때문에, 둘의 백일을 기념해서 임문빈은 팰린드롬을 선물해주려고 한다.
//
// 임문빈은 임한수의 영어 이름으로 팰린드롬을 만들려고 하는데, 임한수의 영어 이름의 알파벳 순서를 적절히 바꿔서 팰린드롬을 만들려고 한다.
//
// 임문빈을 도와 임한수의 영어 이름을 팰린드롬으로 바꾸는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 임한수의 영어 이름이 있다. 알파벳 대문자로만 된 최대 50글자이다.
//
// 출력
// 첫째 줄에 문제의 정답을 출력한다. 만약 불가능할 때는 "I'm Sorry Hansoo"를 출력한다. 정답이 여러 개일 경우에는 사전순으로 앞서는 것을 출력한다.
//
// 예제 입력 1
// AABB
// 예제 출력 1
// ABBA
// 예제 입력 2
// AAABB
// 예제 출력 2
// ABABA
// 예제 입력 3
// ABACABA
// 예제 출력 3
// AABCBAA
// 예제 입력 4
// ABCD
// 예제 출력 4
// I'm Sorry Hansoo

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakePalindrome {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int[] alphabetCheck = new int[26];

		for (char c : input.toCharArray()) {
			alphabetCheck[c - 'A']++;
		}

		int oddCount = 0;
		int oddIndex = -1;
		for (int i = 0; i < 26; i++) {

			if (alphabetCheck[i] % 2 == 1) {
				oddCount++;
				oddIndex = i;
			}
		}

		if (oddCount > 1) {
			System.out.println("I'm Sorry Hansoo");
		} else {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < alphabetCheck[i] / 2; j++) {
					sb.append((char)('A' + i));
				}
			}

			StringBuilder reversed = new StringBuilder(sb).reverse();

			if (oddCount == 1) {
				sb.append((char)('A' + oddIndex));
			}
			sb.append(reversed);
			System.out.println(sb);
		}
	}
}
