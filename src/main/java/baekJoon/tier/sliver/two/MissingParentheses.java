package baekJoon.tier.sliver.two;

// (실버 2) 1541번 잃어버린 괄호
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	128 MB	100875	55943	43502	54.777%
// 세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
//
// 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
//
// 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.
//
// 출력
// 첫째 줄에 정답을 출력한다.
//
// 예제 입력 1
// 55-50+40
// 예제 출력 1
// -35
// 예제 입력 2
// 10+20+30+40
// 예제 출력 2
// 100
// 예제 입력 3
// 00009-00009
// 예제 출력 3
// 0

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 직접 푼 방법
public class MissingParentheses {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String nums = br.readLine();

		String[] numArr = nums.split("[-+]");
		Matcher sigh = Pattern.compile("[+-]").matcher(nums);
		List<String> sighList = new ArrayList<>();

		while (sigh.find()) {
			sighList.add(sigh.group());
		}

		boolean isMinus = false;

		int sum1 = Integer.parseInt(numArr[0]);
		int sum2 = 0;

		for (int i = 0; i < sighList.size(); i++) {

			if (sighList.get(i).equals("-")) {
				isMinus = true;
			}

			if (isMinus) {
				sum2 += Integer.parseInt(numArr[i + 1]);
			} else {
				sum1 += Integer.parseInt(numArr[i + 1]);
			}

		}
		System.out.println((sum1 - sum2));
	}
}

// gpt
// public class MissingParentheses {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		String[] groups = br.readLine().split("-");
//
// 		int result = sum(groups[0]);
//
// 		for (int i = 1; i < groups.length; i++) {
// 			result -= sum(groups[i]);
// 		}
//
// 		System.out.println(result);
// 	}
//
// 	private static int sum(String expr) {
// 		int sum = 0;
// 		for (String num : expr.split("\\+")) {
// 			sum += Integer.parseInt(num);
// 		}
// 		return sum;
// 	}
// }
