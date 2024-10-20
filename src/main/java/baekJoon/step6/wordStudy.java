package baekJoon.step6;

// 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
//
// 입력
// 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
//
// 출력
// 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
//
// 예제 입력 1
// Mississipi
// 예제 출력 1
// ?
// 예제 입력 2
// zZa
// 예제 출력 2
// Z

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wordStudy {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		String upperCaseS = s.toUpperCase();

		int[] checking = new int[26];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < upperCaseS.length(); i++) {

			char a = upperCaseS.charAt(i);
			checking[a - 'A']++;
		}

		int maxCount = Arrays.stream(checking).max().getAsInt();


		for (int i = 0; i < checking.length; i++) {
			if (checking[i] == maxCount) {
				list.add(i);
			}
		}

			if(list.size() > 1) {
				System.out.println("?");
			} else {
				char a = (char)(list.get(0) + 65);
				System.out.println(a);
			}
		}
	}
