package baekJoon.step4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 바구니 뒤집기 성공
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	256 MB	83766	43855	38507	52.867%
// 문제
// 도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 순서대로 적혀져 있다. 바구니는 일렬로 놓여져 있고, 가장 왼쪽 바구니를 1번째 바구니, 그 다음 바구니를 2번째 바구니, ..., 가장 오른쪽 바구니를 N번째 바구니라고 부른다.
//
// 도현이는 앞으로 M번 바구니의 순서를 역순으로 만들려고 한다. 도현이는 한 번 순서를 역순으로 바꿀 때, 순서를 역순으로 만들 범위를 정하고, 그 범위에 들어있는 바구니의 순서를 역순으로 만든다.
//
// 바구니의 순서를 어떻게 바꿀지 주어졌을 때, M번 바구니의 순서를 역순으로 만든 다음, 바구니에 적혀있는 번호를 가장 왼쪽 바구니부터 출력하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 N (1 ≤ N ≤ 100)과 M (1 ≤ M ≤ 100)이 주어진다.
//
// 둘째 줄부터 M개의 줄에는 바구니의 순서를 역순으로 만드는 방법이 주어진다. 방법은 i j로 나타내고, 왼쪽으로부터 i번째 바구니부터 j번째 바구니의 순서를 역순으로 만든다는 뜻이다. (1 ≤ i ≤ j ≤ N)
//
// 도현이는 입력으로 주어진 순서대로 바구니의 순서를 바꾼다.
//
// 출력
// 모든 순서를 바꾼 다음에, 가장 왼쪽에 있는 바구니부터 바구니에 적혀있는 순서를 공백으로 구분해 출력한다.
//
// 예제 입력 1
// 5 4
// 1 2
// 3 4
// 1 4
// 2 2
// 예제 출력 1
// 3 4 1 2 5

public class reverseBucket {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int firstNum = Integer.parseInt(st.nextToken());
		int secondNum = Integer.parseInt(st.nextToken());

		// N 번까지 공 채워두기
		Integer[] bucket = new Integer[firstNum];
		Arrays.setAll(bucket, i -> i + 1);

		for (int i = 0; i < secondNum; i++) {

			st = new StringTokenizer(br.readLine());

			int num1 = Integer.parseInt(st.nextToken()) - 1;
			int num2 = Integer.parseInt(st.nextToken());

			// System.out.println("Before bucket : " + Arrays.toString(bucket));

			Integer[] tempBucket = Arrays.copyOfRange(bucket, num1, num2);
			Integer[] reverseBucket = new Integer[tempBucket.length];

			for (int j = 0; j < tempBucket.length; j++) {
				reverseBucket[j] = tempBucket[tempBucket.length - 1 - j];
			}
			// System.out.println("Reverse Bucket: " + Arrays.toString(reverseBucket));

			int k = 0;
			for(int j = num1; j < num2; j++) {

				bucket[j] = reverseBucket[k];
				k++;
			}

			// System.out.println("After Bucket: " + Arrays.toString(bucket));
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < bucket.length; i++) {
			result.append(bucket[i]);
			if (i < bucket.length - 1) {
				result.append(" ");
			}
		}

		bw.write(result.toString());

		bw.flush();
		bw.close();
		br.close();
	}
}
