package baekJoon.steps.step5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class FindAlphabet {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		int[] checkingList = new int[26];

		Arrays.fill(checkingList, -1);

		for(int i = 0; i < str.length(); i++) {

			int index = (int)str.charAt(i) - 97;

			if(checkingList[index] == -1) {
				checkingList[index] = i;
			}

		}
		for (int i = 0; i < checkingList.length; i++) {
			bw.write(String.valueOf(checkingList[i]));
			if(i != checkingList.length - 1) {
				bw.write(" ");
			}
		}
		bw.flush();
		bw.close();
		br.close();

	}
}
