package baekJoon.tier.sliver.two;

// (실버 2) A -> B
// 그래프 이론, 그리디 알고리즘, 그래프 탐색, 너비 우선 탐색
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	512 MB	69324	28786	22673	39.923%
// 문제
// 정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
//
// 2를 곱한다.
// 1을 수의 가장 오른쪽에 추가한다.
// A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
//
// 입력
// 첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다.
//
// 출력
// A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.
//
// 예제 입력 1
// 2 162
// 예제 출력 1
// 5
// 2 → 4 → 8 → 81 → 162
//
// 예제 입력 2
// 4 42
// 예제 출력 2
// -1
// 예제 입력 3
// 100 40021
// 예제 출력 3
// 5
// 100 → 200 → 2001 → 4002 → 40021

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 그리디 + 역방향 시뮬레이션
public class AtoB {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int count = 0;
		while (a <= b) {

			if (b % 2 == 0) {
				b /= 2;
			} else if (b % 10 == 1){
				b /= 10;
			} else {
				System.out.println(-1);
				return;
			}

			count++;

			if (a == b) {
				System.out.println(count+1);
				return;
			}
		}
		System.out.println(-1);
	}
}
