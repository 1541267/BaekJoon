package baekJoon.tier.bronze.one;

// (브론즈 1) 15792번 A/B -2
// 문제
// 두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 A와 B가 주어진다. (0 < A, B ≤ 10,000)
//
// 출력
// 첫째 줄에 A/B를 출력한다.
//
// 서브태스크
// 번호	배점	제한
// 1	1
// 절대/상대 오차는 10-1 까지 허용한다.
//
// 2	2
// 절대/상대 오차는 10-2 까지 허용한다.
//
// 3	6
// 절대/상대 오차는 10-6 까지 허용한다.
//
// 4	9
// 절대/상대 오차는 10-9 까지 허용한다.
//
// 5	20
// 절대/상대 오차는 10-20 까지 허용한다.
//
// 6	50
// 절대/상대 오차는 10-50 까지 허용한다.
//
// 7	100
// 절대/상대 오차는 10-100 까지 허용한다.
//
// 8	312
// 절대/상대 오차는 10-312 까지 허용한다.
//
// 9	500
// 절대/상대 오차는 10-500 까지 허용한다.
//
// 10	1000
// 절대/상대 오차는 10-1000 까지 허용한다.
//
// 예제 입력 1
// 1 3
// 예제 출력 1
// 0.33333333333333333333333333333333
// 예제 입력 2
// 4 5
// 예제 출력 2
// 0.8

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ADivideBMinusTwo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder stb = new StringBuilder();

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		stb.append(a / b).append(".");

		int c = 1000;
		a = 10 * (a - b * (a / b));

		while (c-- > 0) {
			stb.append(a/b);
			a = 10 * (a - b * (a / b));
		}
		System.out.println(stb);
	}
}
