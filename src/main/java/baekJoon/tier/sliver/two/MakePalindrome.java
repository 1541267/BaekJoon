package baekJoon.tier.sliver.two;

// (실버 2) 1254번 팰린드롬 만들기 
// 문자열, 브루트포스 알고리즘
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	128 MB	12573	5727	4815	47.261%
// 문제
// 동호와 규완이는 212호에서 문자열에 대해 공부하고 있다. 규완이는 팰린드롬을 엄청나게 좋아한다. 팰린드롬이란 앞에서부터 읽으나 뒤에서부터 읽으나 같게 읽히는 문자열을 말한다.
//
// 동호는 규완이를 위한 깜짝 선물을 준비했다. 동호는 규완이가 적어놓고 간 문자열 S에 0개 이상의 문자를 문자열 뒤에 추가해서 팰린드롬을 만들려고 한다. 동호는 가능하면 가장 짧은 문자열을 만들려고 한다.
//
// 동호가 만들 수 있는 가장 짧은 팰린드롬의 길이를 출력하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 최대 50이다.
//
// 출력
// 첫째 줄에 동호가 만들 수 있는 가장 짧은 팰린드롬의 길이를 출력한다.
//
// 예제 입력 1
// abab
// 예제 출력 1
// 5
// 예제 입력 2
// abacaba
// 예제 출력 2
// 7
// 예제 입력 3
// qwerty
// 예제 출력 3
// 11
// 예제 입력 4
// abdfhdyrbdbsdfghjkllkjhgfds
// 예제 출력 4
// 38

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakePalindrome {

	static int[] arr = new int[26];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int length = s.length();
		StringBuilder sb = new StringBuilder();

		if (isPalindrome(s)) {
			System.out.println(s.length());
			return;
		}

		for (int i = 0; i < length; i++) {

			if (isPalindrome(s.substring(i, length))) {
				System.out.println(i + length);
				break;
			}
		}

	}

	private static boolean isPalindrome(String sub) {

		int left = 0;
		int right = sub.length() - 1;

		while (left < right) {
			if (sub.charAt(left++) != sub.charAt(right--)) return false;
		}

		return true;
	}
}

// public class MakePalindrome {
//
// 	static int[] arr = new int[26];
//
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		String s = br.readLine();
// 		int length = s.length();
// 		StringBuilder sb = new StringBuilder();
//
// 		if (isPalindrome(s)) {
// 			System.out.println(s.length());
// 			return;
// 		}
//
// 		int addLength = 0;
// 		int subLength = 0;
// 		for (int i = 0; i < length; i++) {
// 			String sub = s.substring(i, length);
//
// 			if (isPalindrome(sub)) {
// 				addLength = 2 * (length - sub.length());
//
// 				System.out.println(addLength + sub.length());
// 				break;
// 			}
// 		}
//
// 	}
//
// 	private static boolean isPalindrome(String sub) {
//
// 		int left = 0;
// 		int right = sub.length() - 1;
//
// 		while (left < right) {
// 			if (sub.charAt(left) != sub.charAt(right)) {
// 				return false;
// 			}
// 			left++;
// 			right--;
// 		}
// 		return true;
// 	}
// }
