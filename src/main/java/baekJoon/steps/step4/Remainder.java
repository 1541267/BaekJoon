package baekJoon.steps.step4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

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
// 모든 수를 42로 나눈 나머지는 0이다.
//
// 예제 입력 3
// 39
// 40
// 41
// 42
// 43
// 44
// 82
// 83
// 84
// 85
// 예제 출력 3
// 6
// 각 수를 42로 나눈 나머지는 39, 40, 41, 0, 1, 2, 40, 41, 0, 1이다. 서로 다른 값은 6개가 있다.

public class Remainder {

	// 중복 값을 자동으로 처리하는 Set
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
	// public static void main(String[] args) throws Exception {
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	// 	int[] remainders = new int[10];
	//
	// 	for (int i = 0; i < 10; i++) {
	// 		int numbers = Integer.parseInt(br.readLine());
	// 		int Remainder = numbers % 42;
	//
	// 		remainders[i] = Remainder;
	// 	}
	//
	// 	// 배열에 담긴 나머지 중 중복을 제거 후 길이를 반환
	// 	int result = Arrays.stream(remainders).distinct().toArray().length;
	//
	// 	bw.write(String.valueOf(result));
	//
	// 	bw.flush();
	// 	bw.close();
	// 	br.close();
	// }
// }
