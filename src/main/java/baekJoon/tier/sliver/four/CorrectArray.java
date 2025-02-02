package baekJoon.tier.sliver.four;

// (실버 4) 1337번 올바은 배열
// 올바른 배열이란 어떤 배열 속에 있는 원소 중 5개가 연속적인 것을 말한다. (연속적인 것이란 5개의 수를 정렬했을 때, 인접한 수의 차이가 1인 것을 말한다.)
//
// 예를 들어 배열 {6, 1, 9, 5, 7, 15, 8}은 올바른 배열이다. 왜냐하면 이 배열 속의 원소인 5, 6, 7, 8, 9가 연속이기 때문이다.
//
// 배열이 주어지면, 이 배열이 올바른 배열이 되게 하기 위해서 추가되어야 할 원소의 개수를 출력하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 배열의 크기 N이 주어진다. N은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 배열의 원소가 한 줄에 하나씩 주어진다. 원소는 1,000,000,000보다 작거나 같은 음이 아닌 정수이다. 배열에 중복되는 수는 없다.
//
// 출력
// 첫째 줄에 입력으로 주어진 배열이 올바른 배열이 되게 하기 위해서 추가되어야할 원소의 최소 개수를 출력한다.
//
// 예제 입력 1
// 3
// 5
// 6
// 7
// 예제 출력 1
// 2
// 예제 입력 2
// 6
// 5
// 7
// 9
// 8492
// 8493
// 192398
// 예제 출력 2
// 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class CorrectArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Set<Integer> numbers = new TreeSet<>();

		for (int i = 0; i < n; i++) {
			numbers.add(Integer.parseInt(br.readLine()));
		}

		int[] sortedNumbers = numbers.stream().mapToInt(i -> i).toArray();
		// 결과/ 시간 같음
		// int[] sortedNumbers = numbers.stream().mapToInt(Integer::intValue).toArray();

		int totalCount = 0;

		for (int i = 0; i < n; i++) {
			int count = 0;
			int currentMaxNum = sortedNumbers[i] + 4;


			for (int j = i; j < n; j++) {
				int currentNum = sortedNumbers[j];
				if(currentNum <= currentMaxNum) {
					count++;
				}
			}
			totalCount = Math.max(totalCount, count);


		}
		System.out.println(5 - totalCount);

	}
}
