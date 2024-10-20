package baekJoon.step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class groupword {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		boolean isGroupWord = true;

		int count = 0;

		for (int i = 0; i < n; i++) {
			boolean[] checkList = new boolean[26];
			String words = br.readLine();
			char prevChar = 0;

			for (int j = 0; j < words.length(); j++) {
				char currentChar = words.charAt(j);

				if (prevChar != currentChar) {
					if (!checkList[currentChar - 'a']) {
						checkList[currentChar - 'a'] = true;
						prevChar = currentChar;
					} else {
						count--;
						break;
					}
				}

			}
			count++;
		}
		System.out.println( count);
	}
}
