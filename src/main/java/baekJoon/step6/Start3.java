package baekJoon.step6;

// 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
//
// 출력
// 첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
//
// 예제 입력 1
// 5
// 예제 출력 1
//     *
//    ***
//   *****
//  *******
// *********
//  *******
//   *****
//    ***
//     *


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Start3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j > i; j--) {
				bw.write(" ");

			}

			for (int j = 0; j <= i * 2; j++) {
				bw.write("*");
			}
			bw.newLine();
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				bw.write(" ");
			}

			for (int j = 0; j <= i * 2; j++) {
				bw.write("*");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
