package baekJoon.tier.sliver.five;

// 문제 2751
// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
//
// 출력
// 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
//
// 예제 입력 1
// 5
// 5
// 4
// 3
// 2
// 1
// 예제 출력 1
// 1
// 2
// 3
// 4
// 5
// 입력 갯수가 많아 시간복잡도 생각
// QuickSort (Arrays.sort / Collections.sort 통과되긴 하나 시간이 많이 걸림

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class numberSorting {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder stb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		boolean[] checkList = new boolean[2000001];

		for (int i = 0; i < n; i++) {
			checkList[(Integer.parseInt(br.readLine()) + 1000000)] = true;
		}

		for (int i = 0; i < checkList.length; i++) {
			if (checkList[i]) {
				stb.append((i - 1000000)).append("\n");
			}
		}

		bw.write(String.valueOf(stb));
		bw.flush();
		bw.close();
		br.close();
	}
}

// 처음에 적은 코드, 통과는 되나 시간이 오래 걸림, 시간복잡도 해결해보기
// 1356ms
// public class numberSorting {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
// 		int n = Integer.parseInt(br.readLine());
// 		int[] numbers = new int[n];
//
// 		for (int i = 0; i < n; i++) {
// 			numbers[i] = Integer.parseInt(br.readLine());
// 		}
//
// 		Arrays.sort(numbers);
//
// 		for (int closestNumbers : numbers) {
// 			bw.write(String.valueOf(closestNumbers));
// 			bw.newLine();
// 		}
// 		bw.flush();
// 		bw.close();
// 		br.close();
// 	}
// }

// Collections.sort 1544ms
// public class numberSorting {
// 	public static void main(String[] args) throws Exception {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
// 		StringBuilder stb = new StringBuilder();
// 		int n = Integer.parseInt(br.readLine());
//
// 		List<Integer> numbers = new ArrayList<Integer>();
//
// 		for(int i = 0; i < n; i++) {
// 			numbers.add(Integer.parseInt(br.readLine()));
// 		}
//
// 		Collections.sort(numbers);
//
// 		for (Integer number : numbers) {
// 			stb.append(number).append("\n");
// 		}
//
// 		bw.write(String.valueOf(stb));
// 		bw.flush();
// 		bw.close();
// 		br.close();
// 	}
// }

//	CountingSort, 696ms
// public class numberSorting {
// 	public static void main(String[] args) throws Exception {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
// 		StringBuilder stb = new StringBuilder();
//
// 		int n = Integer.parseInt(br.readLine());
//
// 		boolean[] checkList = new boolean[2000001];
//
// 		for (int i = 0; i < n; i++) {
// 			checkList[(Integer.parseInt(br.readLine()) + 1000000)] = true;
// 		}
//
// 		for (int i = 0; i < checkList.length; i++) {
// 			if (checkList[i]) {
// 				stb.append((i - 1000000)).append("\n");
// 			}
// 		}
//
// 		bw.write(String.valueOf(stb));
// 		bw.flush();
// 		bw.close();
// 		br.close();
// 	}
// }