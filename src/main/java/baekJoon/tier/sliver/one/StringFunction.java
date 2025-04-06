package baekJoon.tier.sliver.one;

// (실버 1) 30047번 함수 문자열
// 자료 구조, 스택
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	1024 MB	590	205	168	39.161%
// 문제
// 하나의 정수로 평가(evaluate)될 수 있는 함수 문자열은 다음과 같이 정의된다.
//
// x는 함수 문자열이다. 위 문자열은
// $0$으로 평가된다.
// S가 함수 문자열이면, gS도 함수 문자열이다. 위 문자열은 S가 평가된 값에
// $1$을 더한 값으로 평가된다.
// S, T가 함수 문자열이면, fST도 함수 문자열이다. 위 문자열은 S와 T가 평가된 값 중 더 크지 않은 값으로 평가된다.
// 문자열이 주어지면 함수 문자열인지 확인하고, 만약 그렇다면 평가한 값을 구하자.
//
// 입력
// 첫 번째 줄에 f, g, x로만 이루어진 문자열
// $S$가 주어진다.
// $(1 \leq$
// $|S|$
// $\leq 1\,000\,000)$
//
// 출력
// 첫 번째 줄에 주어진 문자열이 함수 문자열이라면 평가하여 값을 출력하고, 그렇지 않다면 -1을 출력한다.
//
// 예제 입력 1
// fggxgx
// 예제 출력 1
// 1
// 예제 입력 2
// xxx
// 예제 출력 2
// -1
// 예제 입력 3
// gggx
// 예제 출력 3
// 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// charAt -> toCharArray, 320ms
public class StringFunction {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		ArrayDeque<Integer> stack = new ArrayDeque<>();

		char[] arr = s.toCharArray();

		for (int i = arr.length - 1; i >= 0; i--) {
			char c = arr[i];
			if (c == 'x') {
				stack.addFirst(0);
			} else if (c == 'g') {
				Integer val = stack.pollFirst();
				if (val == null) {
					System.out.println(-1);
					return;
				}
				stack.push(val + 1);

			} else if (c == 'f') {
				Integer a = stack.pollFirst();
				Integer b = stack.pollFirst();
				if (a == null || b == null) {
					System.out.println(-1);
					return;
				}
				stack.push(Math.min(a, b));
			}
		}

		if (stack.size() != 1) {
			System.out.print(-1);
		} else {
			System.out.print(stack.pop());
		}
	}
}

// 처음 푼 것, 364ms
// public class StringFunction {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		String s = br.readLine();
//
// 		Stack<Integer> stack = new Stack<>();
//
// 		for (int i = s.length() - 1; i >= 0; i--) {
// 			char c = s.charAt(i);
// 			if (c == 'x') {
// 				stack.push(0);
// 			} else if (c == 'g') {
// 				if (stack.isEmpty()) {
// 					System.out.println(-1);
// 					return;
// 				}
// 				stack.push(stack.pop() + 1);
//
// 			} else if (c == 'f') {
// 				if (stack.isEmpty() || stack.size() < 2) {
// 					System.out.println(-1);
// 					return;
// 				}
// 				stack.push(Math.min(stack.pop(), stack.pop()));
//
// 			}
// 		}
//
// 		if (stack.size() != 1) {
// 			System.out.print(-1);
// 		} else {
// 			System.out.print(stack.pop());
// 		}
// 	}
// }
