package baekJoon.tier.gold.five;

// 1038번 감소 하는 수
// 음이 아닌 정수 X의 자릿수가 가장 큰 자릿수부터 작은 자릿수까지 감소한다면, 그 수를 감소하는 수라고 한다. 예를 들어, 321과 950은 감소하는 수지만, 322와 958은 아니다. N번째 감소하는 수를 출력하는 프로그램을 작성하시오. 0은 0번째 감소하는 수이고, 1은 1번째 감소하는 수이다. 만약 N번째 감소하는 수가 없다면 -1을 출력한다.
//
// 입력
// 첫째 줄에 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.
//
// 출력
// 첫째 줄에 N번째 감소하는 수를 출력한다.
//
// 예제 입력 1
// 18
// 예제 출력 1
// 42
// 예제 입력 2
// 0
// 예제 출력 2
// 0
// 예제 입력 3
// 500000
// 예제 출력 3
// -1
// TODO 수학적 사고..

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DecreaseNumber {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<Long> list = new ArrayList<>();
	static int n;

	public static void main(String[] args) throws IOException {

		n = Integer.parseInt(br.readLine());

		if (n <= 10) {
			System.out.println(n);
		} else if (n >= 1023) {
			System.out.println(-1);
		} else {

			for (int i = 0; i < 10; i++) {
				checkNum(i, 1);
			}

			Collections.sort(list);
			System.out.println(list.get(n));
		}
	}

	static void checkNum(long num, int index) {

		if (index > 10)
			return;

		list.add(num);

		for (int i = 0; i < num % 10; i++) {
			checkNum((num * 10) + i, index + 1);
		}
	}
}

//  간단하게 접근해서 시간 초과, 문제 잘 못 읽고 최대 수를 1백만으로 지정해서 31%에서 실패
// public class DecreaseNumber {
//
// 	public static void main(String[] args) throws IOException {
//
// 		int startTime = (int)System.nanoTime();
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		int n = Integer.parseInt(br.readLine());
//
// 		int maxNumber = Integer.MAX_VALUE;
// 		if (n == 0) {
// 			System.out.println(0);
// 			System.exit(0);
// 		} else if (n <= 10) {
// 			System.out.println(n);
// 			System.exit(0);
// 		}
//
// 		List<Integer> number = new ArrayList<>();
//
// 		for (int i = 0; i < maxNumber; i++) {
// 			if (numberCheck(String.valueOf(i))) {
// 				number.add(i);
// 			}
// 		}
// 		System.out.println("number = " + number);
//
// 		if (n <= number.size()) {
// 			System.out.println(number.get(n - 1));
// 		} else {
// 			System.out.println(-1);
// 		}
//
// 	}
//
// 	public static boolean numberCheck(String number) {
//
// 		for (int i = 1; i < number.length(); i++) {
//
// 			int firstNum = number.charAt(i - 1);
// 			int secondNum = number.charAt(i);
// 			if (firstNum <= secondNum) {
// 				return false;
// 			}
// 		}
// 		return true;
// 	}
// }
