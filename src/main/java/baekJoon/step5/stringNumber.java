package baekJoon.step5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오. 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
//
// 입력
// 첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열의 길이는 1,000,000을 넘지 않는다. 단어는 공백 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다. 또한 문자열은 공백으로 시작하거나 끝날 수 있다.
//
// 출력
// 첫째 줄에 단어의 개수를 출력한다.
//
// 예제 입력 1
// The Curious Case of Benjamin Button
// 예제 출력 1
// 6
// 예제 입력 2
//  The first character is a blank
// 예제 출력 2
// 6
// 예제 입력 3
// The last character is a blank
// 예제 출력 3
// 6

public class stringNumber {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().trim().split("\\s+");
		
		// 공백만 주어 졌을 시
		if (line[0].isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(line.length);
		}
	}
}

// StringTokenizer 로 쪼개진 단어를 리스트로 길이 측정
// 	public static void main(String[] args) throws Exception{
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringTokenizer st = new StringTokenizer(br.readLine());
//
// 		List<String> list = new ArrayList<>();
//
// 		while(st.hasMoreTokens()) {
// 			String token = st.nextToken();
//
// 			list.add(token);
// 		}
// 		System.out.println(list.size());
// 	}
// }