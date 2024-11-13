package baekJoon.step4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 매겨져 있다. 바구니에는 공이 1개씩 들어있고, 처음에는 바구니에 적혀있는 번호와 같은 번호가 적힌 공이 들어있다.
//
// 도현이는 앞으로 M번 공을 바꾸려고 한다. 도현이는 공을 바꿀 바구니 2개를 선택하고, 두 바구니에 들어있는 공을 서로 교환한다.
//
// 공을 어떻게 바꿀지가 주어졌을 때, M번 공을 바꾼 이후에 각 바구니에 어떤 공이 들어있는지 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 N (1 ≤ N ≤ 100)과 M (1 ≤ M ≤ 100)이 주어진다.
//
// 둘째 줄부터 M개의 줄에 걸쳐서 공을 교환할 방법이 주어진다. 각 방법은 두 정수 i j로 이루어져 있으며, i번 바구니와 j번 바구니에 들어있는 공을 교환한다는 뜻이다. (1 ≤ i ≤ j ≤ N)
//
// 도현이는 입력으로 주어진 순서대로 공을 교환한다.
//
// 출력
// 1번 바구니부터 N번 바구니에 들어있는 공의 번호를 공백으로 구분해 출력한다.
//
// 예제 입력 1
// 5 4
// 1 2
// 3 4
// 1 4
// 2 2

public class ChangeBall {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int firstNum = Integer.parseInt(st.nextToken());
		int secondNum = Integer.parseInt(st.nextToken());

		// N 번까지 공 채워두기
		int[] bucket = new int[firstNum];
		Arrays.setAll(bucket, i -> i+1);
		// int[] bucket = IntStream.range(1, firstNum + 1).toArray();
		// for (int i = 0; i < firstNum; i++) {
		// 	bucket[i] = i+1;
		// }

		for (int i = 0; i < secondNum; i++) {

			st = new StringTokenizer(br.readLine());

			int num1 = Integer.parseInt(st.nextToken()) - 1;
			int num2 = Integer.parseInt(st.nextToken()) - 1;
			int tempNum = bucket[num2];

			bucket[num2] = bucket[num1];
			bucket[num1] = tempNum;

			System.out.println(Arrays.toString(bucket));
		}

		// StringBuilder 로 실행속도 최적화
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < bucket.length; i++) {
			result.append(bucket[i]);
			if (i < bucket.length - 1) {
				result.append(" ");
			}
		}

		bw.write(result.toString());
		// 평소 출력 방법
		// for (int i = 0; i < firstNum; i++) {
		// 	bw.write(String.valueOf(bucket[i]));
		// 	if (i < firstNum - 1) {
		// 		bw.write(" ");
		// 	}
		// }
		//
		bw.flush();
		bw.close();
		br.close();
	}
}
