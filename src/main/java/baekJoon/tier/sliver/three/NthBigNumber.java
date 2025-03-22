package baekJoon.tier.sliver.three;

// (실버 3) 2075번 N 번째 큰 수
// 자료 구조, 정렬, 우선순위 큐
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	12 MB (하단 참고)	41417	16796	12230	39.236%
// 문제
// N×N의 표에 수 N2개 채워져 있다. 채워진 수에는 한 가지 특징이 있는데, 모든 수는 자신의 한 칸 위에 있는 수보다 크다는 것이다. N=5일 때의 예를 보자.
//
// 12	7	9	15	5
// 13	8	11	19	6
// 21	10	26	31	16
// 48	14	28	35	25
// 52	20	32	41	49
// 이러한 표가 주어졌을 때, N번째 큰 수를 찾는 프로그램을 작성하시오. 표에 채워진 수는 모두 다르다.
//
// 입력
// 첫째 줄에 N(1 ≤ N ≤ 1,500)이 주어진다. 다음 N개의 줄에는 각 줄마다 N개의 수가 주어진다. 표에 적힌 수는 -10억보다 크거나 같고, 10억보다 작거나 같은 정수이다.
//
// 출력
// 첫째 줄에 N번째 큰 수를 출력한다.
//
// 예제 입력 1
// 5
// 12 7 9 15 5
// 13 8 11 19 6
// 21 10 26 31 16
// 48 14 28 35 25
// 52 20 32 41 49
// 예제 출력 1
// 35

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// 자바 15에선 메모리 초과, 11에선 통과됨
public class NthBigNumber {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				queue.offer(Integer.parseInt(st.nextToken()));

				if(queue.size() > n) {
					queue.poll();
				}
			}
		}

		System.out.println(queue.poll());
	}
}
