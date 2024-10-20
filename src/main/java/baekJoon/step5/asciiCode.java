package baekJoon.step5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 문자의 아스키코드 출력

public class asciiCode {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(br.read());

		br.close();
	}
}
