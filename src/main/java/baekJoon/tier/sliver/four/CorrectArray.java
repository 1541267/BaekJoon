package baekJoon.tier.sliver.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

// TODO 아직 완성 x

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

		int missingCount = Integer.MAX_VALUE;
		int count = 1;
		
		for (int i = 1; i < sortedNumbers.length; i++) {
			if (sortedNumbers[i - 1] + 1 == sortedNumbers[i]) {
				count++;
			}
		}

		if (count < 5) {
			System.out.println(5 - count);
		} else if (count == 1) {
			System.out.println(4);
		} else {
			System.out.println(0);
		}
	}
}
