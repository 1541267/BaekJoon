package baekJoon.steps.step3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int number = Integer.parseInt(br.readLine());

		for (int i = 1; i <= number; i++) {
			for (int j = number; j > i; j--) {
				bw.write(" ");
			}
			for (int j = 0; j < i; j++) {
				bw.write("*");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}
}
