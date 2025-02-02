package baekJoon.tier.sliver.four;

// (실버 4) 1235번 : 학생 번호
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	128 MB	7313	3582	3100	49.871%
// 문제
// 이번에는 학생들을 더욱 효율적으로 관리하기 위해 학생마다 고유한 학생 번호를 부여하기로 하였다. 학생 번호는 0부터 9 사이의 숫자로 이루어진 문자열로, 모든 학생들의 학생 번호는 서로 다르지만 그 길이는 모두 같다.
//
// 학생들의 번호를 부여해 놓고 보니, 김진영 조교는 어쩌면 번호가 지나치게 긴 것은 아닌가 싶은 생각이 들었다. 예를 들어 아래와 같은 7자리의 학생 번호를 보자.
//
// 이름	번호
// 오민식	1212345
// 김형택	1212356
// 이동호	0033445
// 이처럼 학생 번호를 굳이 7자리로 하지 않고, 뒤에서 세 자리만을 추려서 남겨 놓아도 모든 학생들의 학생 번호를 서로 다르게 만들 수 있다.
//
// 이름	번호
// 오민식	345
// 김형택	356
// 이동호	445
// 하지만 세 자리보다 적게 남겨 놓아서는 모든 학생들의 학생 번호를 서로 다르게 만들 수 없다.
//
// 학생들의 번호가 주어 졌을 때, 뒤에서 k자리만을 추려서 남겨 놓았을 때 모든 학생들의 학생 번호를 서로 다르게 만들 수 있는 최소의 k를 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에는 학생의 수 N(2≤N≤1,000)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 학생의 학생 번호가 순서대로 주어진다. 모든 학생들의 학생 번호는 서로 다르지만 그 길이는 모두 같으며, 0부터 9 사이의 숫자로 이루어진 문자열이 주어진다. 문자열의 길이는 100보다 작거나 같다.
//
// 출력
// 첫째 줄에 구하고자 하는 가장 작은 k값을 출력한다.
//
// 예제 입력 1
// 3
// 1212345
// 1212356
// 0033445
// 예제 출력 1
// 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class StudentNumber {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int count = 1;

	public static void main(String[] args) throws IOException {

		n = Integer.parseInt(br.readLine());

		String[] studentNumber = new String[n];

		for (int i = 0; i < n; i++) {
			studentNumber[i] = br.readLine();
		}

		System.out.println(numberCheck(studentNumber, 1));
	}

	private static int numberCheck(String[] studentNumber, int index) {

		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < n; i++) {

			String s = studentNumber[i];

			String num = s.substring(s.length() - index);
			set.add(num);
		}

		if(set.size() == n) {
			return count;
		} else {
			count++;
			return	numberCheck(studentNumber, index + 1);
		}
	}
}
