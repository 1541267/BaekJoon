package baekJoon.tier.sliver.one;

// (실버 1) 11286번 절댓값 힙
//  시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초 (추가 시간 없음) (하단 참고)	256 MB	68618	39168	30782	57.130%
// 문제
// 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
// 
// 배열에 정수 x (x ≠ 0)를 넣는다.
// 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
// 프로그램은 처음에 비어있는 배열에서 시작하게 된다.
// 
// 입력
// 첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다. 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다. 입력되는 정수는 -231보다 크고, 231보다 작다.
// 
// 출력
// 입력에서 0이 주어진 회수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.
// 
// 예제 입력 1 
// 18
// 1
// -1
// 0
// 0
// 0
// 1
// 1
// -1
// -1
// 2
// -2
// 0
// 0
// 0
// 0
// 0
// 0
// 0
// 예제 출력 1 
// -1
// 1
// 0
// -1
// -1
// 1
// 1
// -2
// 2
// 0

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

// 입력 최적화, 264ms
public class AbsoluteValueHeap {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = readNumber(br);

		PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
			int absA = Math.abs(a);
			int absB = Math.abs(b);

			if (absA == absB)
				return Integer.compare(a, b);
			return Integer.compare(absA, absB);
		});

		int input;
		for (int i = 0; i < n; i++) {
			input = readNumber(br);

			if (input == 0) {
				bw.write(heap.isEmpty() ? "0\n" : heap.poll() + "\n");
			} else {
				heap.add(input);
			}
		}
		bw.flush();
		bw.close();
		br.close();

	}

	private static int readNumber(BufferedReader br) throws IOException {
		int value = 0;
		int sign = 1;
		int c = br.read();

		if (c == '-') {
			sign = -1;
			c = br.read();
		}

		do {
			value = value * 10 + (c - '0');
		} while ((c = br.read()) >= '0' && c <= '9');

		return value * sign;
	}
}


// 처음 푼 것 320ms
//  public class Main {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
// 		int n = Integer.parseInt(br.readLine());
//
// 		PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
// 			int absA = Math.abs(a);
// 			int absB = Math.abs(b);
//
// 			if(absA == absB) return Integer.compare(a, b);
// 			return Integer.compare(absA, absB);
// 		});
//
// 		int input;
// 		for (int i = 0; i < n; i++) {
// 			input = Integer.parseInt(br.readLine());
//
// 			if (input == 0) {
// 				bw.write(heap.isEmpty() ? "0\n" : heap.poll() + "\n");
// 			} else {
// 				heap.add(input);
// 			}
// 		}
// 		bw.flush();
// 		bw.close();
// 		br.close();
//
// 	}
// }