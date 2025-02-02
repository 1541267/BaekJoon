package baekJoon.tier.sliver.one;

// (실버 1) 1105번 : 8번
// L과 R이 주어진다. 이때, L보다 크거나 같고, R보다 작거나 같은 자연수 중에 8이 가장 적게 들어있는 수에 들어있는 8의 개수를 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 L과 R이 주어진다. L은 2,000,000,000보다 작거나 같은 자연수이고, R은 L보다 크거나 같고, 2,000,000,000보다 작거나 같은 자연수이다.
//
// 출력
// 첫째 줄에 L보다 크거나 같고, R보다 작거나 같은 자연수 중에 8이 가장 적게 들어있는 수에 들어있는 8의 개수를 구하는 프로그램을 작성하시오.
//
// 예제 입력 1
// 1 10
// 예제 출력 1
// 0
// 예제 입력 2
// 88 88
// 예제 출력 2
// 2
// 예제 입력 3
// 800 899
// 예제 출력 3
// 1
// 예제 입력 4
// 8808 8880
// 예제 출력 4
// 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 처음 생각대로 문제 해결은 됐는데 엣지 케이스 한번에 잡지 못함 -> 자릿수

public class Eight {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String num1 = st.nextToken();
		String num2 = st.nextToken();

		System.out.print(checkNum(num1, num2));
	}

	private static int checkNum(String num1, String num2) {

		int eightCount = 0;

		if (num1.length() != num2.length()) {
			return 0;
		}

		for (int i = 0; i < num1.length(); i++) {

			char first = num1.charAt(i);
			char second = num2.charAt(i);

			boolean isSame = first == second;

			if(!isSame) {
				break;
			} else if (first == '8') {
				eightCount++;
			}
		}
		return eightCount;
	}
}

