package baekJoon.tier.bronze.one;

// (브론즈 1) 3052번 나머지
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	128 MB	250866	145296	120449	57.733%
// 문제
// 두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다. 예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다.
//
// 수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄부터 열번째 줄 까지 숫자가 한 줄에 하나씩 주어진다. 이 숫자는 1,000보다 작거나 같고, 음이 아닌 정수이다.
//
// 출력
// 첫째 줄에, 42로 나누었을 때, 서로 다른 나머지가 몇 개 있는지 출력한다.
//
// 예제 입력 1
// 1
// 2
// 3
// 4
// 5
// 6
// 7
// 8
// 9
// 10
// 예제 출력 1
// 10
// 각 수를 42로 나눈 나머지는 1, 2, 3, 4, 5, 6, 7, 8, 9, 10이다.
//
// 예제 입력 2
// 42
// 84
// 252
// 420
// 840
// 126
// 42
// 84
// 420
// 126
// 예제 출력 2
// 1

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Remain {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < 10; i++) {
			int number = Integer.parseInt(br.readLine());
			int remainder = number % 42;

			set.add(remainder);
		}
		bw.write(String.valueOf(set.size()));

		bw.flush();
		bw.close();
		br.close();
	}
}
