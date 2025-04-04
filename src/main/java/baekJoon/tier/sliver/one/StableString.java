package baekJoon.tier.sliver.one;

// (실버 1) 4889번 안정적인 문자열
// 자료 구조, 그리디 알고리즘, 문자열, 스택
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	128 MB	7731	3677	3023	47.065%
// 문제
// 여는 괄호와 닫는 괄호만으로 이루어진 문자열이 주어진다. 여기서 안정적인 문자열을 만들기 위한 최소 연산의 수를 구하려고 한다. 안정적인 문자열의 정의란 다음과 같다.
//
// 빈 문자열은 안정적이다.
// S가 안정적이라면, {S}도 안정적인 문자열이다.
// S와 T가 안정적이라면, ST(두 문자열의 연결)도 안정적이다.
// {}, {}{}, {{}{}}는 안정적인 문자열이지만, }{, {{}{, {}{는 안정적인 문자열이 아니다.
//
// 문자열에 행할 수 있는 연산은 여는 괄호를 닫는 괄호로 바꾸거나, 닫는 괄호를 여는 괄호로 바꾸는 것 2가지이다.
//
// 입력
// 입력은 여러 개의 데이터 세트로 이루어져 있다. 각 데이터 세트는 한 줄로 이루어져 있다. 줄에는 여는 괄호와 닫는 괄호만으로 이루어진 문자열이 주어진다. 문자열의 길이가 2000을 넘는 경우는 없고, 항상 길이는 짝수이다.
//
// 입력의 마지막 줄은 '-'가 한 개 이상 주어진다.
//
// 출력
// 각 테스트 케이스에 대해서, 테스트 케이스 번호와 입력으로 주어진 문자열을 안정적으로 바꾸는데 필요한 최소 연산의 수를 출력한다.
//
// 예제 입력 1
// }{
// {}{}{}
// {{{}
// ---
// 예제 출력 1
// 1. 2
// 2. 0
// 3. 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StableString {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String line;
		int index = 1;

		while (!(line = br.readLine()).contains("-")) {

			int count = 0;
			int open = 0; // { 개수 추적

			for (char c : line.toCharArray()) {
				if (c == '{') {
					open++;
				} else {
					if (open == 0) {
						count++;
						open++;
					} else {
						open--;
					}
				}
			}

			count += open / 2;

			sb.append(index++).append(". ").append(count).append("\n");
		}

		System.out.println(sb);
	}
}

// 처음에 푼 것, 스택, 140ms
// public class StableString {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//
// 		String line;
//
// 		StringBuilder sb = new StringBuilder();
// 		int index = 1;
//
// 		while (!(line = br.readLine()).contains("-")) {
//
// 			int count = 0;
//
// 			Stack<Character> stack = new Stack<>();
//
// 			for (char c : line.toCharArray()) {
// 				if (c == '{') {
//
// 					stack.push(c);
//
// 				} else {
// 					if (stack.isEmpty()) {
// 						count++;
// 						stack.push('{');
// 					} else {
// 						stack.pop();
// 					}
// 				}
// 			}
//
// 			if (stack.size() > 2) {
// 				count += stack.size() / 2;
// 			} else if (!stack.isEmpty()) {
// 				count++;
// 			}
//
// 			sb.append(index).append(". ").append(count).append("\n");
// 			index++;
// 		}
//
// 		System.out.println(sb);
// 	}
// }
