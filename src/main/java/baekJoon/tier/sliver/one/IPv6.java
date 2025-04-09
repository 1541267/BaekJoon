package baekJoon.tier.sliver.one;

// (실버 1) 3107번 IPv6
// 구현, 문자열
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	128 MB	5625	2011	1609	37.211%
// 문제
// IPv6은 길이가 128비트인 차세대 인터넷 프로토콜이다.
//
// IPv6의 주소는 32자리의 16진수를 4자리씩 끊어 나타낸다. 이때, 각 그룹은 콜론 (:)으로 구분해서 나타낸다.
//
// 예를 들면, 다음과 같다.
//
// 2001:0db8:85a3:0000:0000:8a2e:0370:7334
// 32자리의 16진수는 사람이 읽고 쓰기에 불편하고, 대부분의 자리가 0이기 때문에 아래와 같이 축약할 수 있다.
//
// 각 그룹의 앞자리의 0의 전체 또는 일부를 생략 할 수 있다. 위의 IPv6을 축약하면, 다음과 같다
// 2001:db8:85a3:0:00:8a2e:370:7334
// 만약 0으로만 이루어져 있는 그룹이 있을 경우 그 중 한 개 이상 연속된 그룹을 하나 골라 콜론 2개(::)로 바꿀 수 있다.
// 2001:db8:85a3::8a2e:370:7334
// 2번째 규칙은 모호함을 방지하기 위해서 오직 한 번만 사용할 수 있다.
//
// 올바른 축약형 IPv6주소가 주어졌을 때, 이를 원래 IPv6 (32자리의 16진수)로 복원하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 올바른 IPv6 주소가 주어진다. 이 주소는 최대 39글자이다. 또한, 주소는 숫자 0-9, 알파벳 소문자 a-f, 콜론 :으로만 이루어져 있다.
//
// 출력
// 첫째 줄에, 입력으로 주어진 IPv6의 축약되지 않은 형태를 출력한다.
//
// 예제 입력 1
// 25:09:1985:aa:091:4846:374:bb
// 예제 출력 1
// 0025:0009:1985:00aa:0091:4846:0374:00bb
// 예제 입력 2
// ::1
// 예제 출력 2
// 0000:0000:0000:0000:0000:0000:0000:0001

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IPv6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<String> list = new ArrayList<>(Arrays.asList(br.readLine().split(":", -1)));

		checkAndFixLength(list);

		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s).append(":");
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));
	}

	private static void checkAndFixLength(List<String> list) {

		if (list.contains("")) {

			int blinkCount = 0;

			for (String s : list) {
				if (s.isBlank()) {
					blinkCount++;
				}
			}

			if (blinkCount == 2) {
				list.remove("");
			}

			int needToAdd = 8 - list.size() + 1;
			int index = list.indexOf("");

			for (int i = 0; i < needToAdd; i++) {
				list.add(index++, "0000");
			}
			list.remove("");
		}

		for (int i = 0; i < list.size(); i++) {
			addZero(list, i);
		}

	}

	private static void addZero(List<String> list, int index) {
		if (list.get(index).length() != 4) {
			StringBuilder sb = new StringBuilder(list.get(index));
			while (sb.length() != 4) {
				sb.insert(0, "0");
			}
			list.set(index, sb.toString());
		}
	}
}
