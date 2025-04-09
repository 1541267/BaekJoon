package baekJoon.tier.sliver.one;

// (실버 1) 5525번 IOIOI
// 문자열
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	256 MB	51283	14573	11877	29.801%
// 문제
// N+1개의 I와 N개의 O로 이루어져 있으면, I와 O이 교대로 나오는 문자열을 PN이라고 한다.
//
// P1 IOI
// P2 IOIOI
// P3 IOIOIOI
// PN IOIOI...OI (O가 N개)
// I와 O로만 이루어진 문자열 S와 정수 N이 주어졌을 때, S안에 PN이 몇 군데 포함되어 있는지 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 N이 주어진다. 둘째 줄에는 S의 길이 M이 주어지며, 셋째 줄에 S가 주어진다.
//
// 출력
// S에 PN이 몇 군데 포함되어 있는지 출력한다.
//
// 제한
// 1 ≤ N ≤ 1,000,000
// 2N+1 ≤ M ≤ 1,000,000
// S는 I와 O로만 이루어져 있다.
// 서브태스크
// 번호	배점	제한
// 1	50
// N ≤ 100, M ≤ 10 000.
//
// 2	50
// 추가적인 제약 조건이 없다.
//
// 예제 입력 1
// 1
// 13
// OOIOIOIOIIOII
// 예제 출력 1
// 4
// OOIOIOIOIIOII
// OOIOIOIOIIOII
// OOIOIOIOIIOII
// OOIOIOIOIIOII
// 예제 입력 2
// 2
// 13
// OOIOIOIOIIOII
// 예제 출력 2
// 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 슬라이딩 기법, 완전 탐색은 O(M * N), 슬라이딩 O(M)
// KMP 알고리즘 필요? -> 코테 범위를 넘지만 알고리즘 대회에선 사용?
public class IOIOI {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();

		int i = 1;
		int count = 0;
		int pattern = 0;
		while (i < m - 1) {

			if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {

				pattern++;
				i += 2;

				if (pattern == n) {
					count++;
					pattern--;
				}
			} else {
				i++;
				pattern = 0;
			}
		}
		System.out.print(count);
	}
}
// 처음 푼 방법, 완전탐색, 50점
// public class IOIOI {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		int n = Integer.parseInt(br.readLine());
// 		int m = Integer.parseInt(br.readLine());
// 		String s = br.readLine();
//
// 		StringBuilder sb = new StringBuilder();
//
// 		sb.append("IOI");
//
// 		if (n > 1) {
// 			for (int i = 0; i < n -1; i++) {
// 				sb.append("OI");
// 			}
// 		}
//
// 		List<Integer> indexList = new ArrayList<>();
//
// 		for (int i = 0; i < s.length(); i++) {
// 			if (s.charAt(i) == 'I') {
// 				indexList.add(i);
// 			}
// 		}
//
// 		int count = 0;
// 		int sbLength = sb.length();
// 		String str = sb.toString();
// 		int length = s.length();
// 		for (int i = 0; i < indexList.size(); i++) {
// 			int index = indexList.get(i);
//
// 			if (index + sbLength <= length) {
//
// 				String compareStr = s.substring(index, index + sbLength);
// 				if (compareStr.equals(str)) {
// 					count++;
// 				}
// 			}
// 		}
// 		System.out.println(count);
// 	}
// }
