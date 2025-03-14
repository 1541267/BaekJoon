package baekJoon.tier.sliver.two;

// (씰버 2) 11279번 최대 힙
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초 (추가 시간 없음) (하단 참고)	256 MB	91669	44690	35471	50.239%
// 문제
// 널리 잘 알려진 자료구조 중 최대 힙이 있다. 최대 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.
//
// 배열에 자연수 x를 넣는다.
// 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.
// 프로그램은 처음에 비어있는 배열에서 시작하게 된다.
//
// 입력
// 첫째 줄에 연산의 개수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 가장 큰 값을 출력하고 그 값을 배열에서 제거하는 경우이다. 입력되는 자연수는 231보다 작다.
//
// 출력
// 입력에서 0이 주어진 횟수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 가장 큰 값을 출력하라고 한 경우에는 0을 출력하면 된다.
//
// 예제 입력 1
// 13
// 0
// 1
// 2
// 0
// 0
// 3
// 2
// 1
// 0
// 0
// 0
// 0
// 0
// 예제 출력 1
// 0
// 2
// 1
// 3
// 2
// 1
// 0
// 0

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;


// readLine시 문자열 생성, parseInt 변환 과정에서 객체 생셩 비용 발생
// 값을 하나씩 읽어 객체 생성 비용을 없애고 바로 값 확인
public class MaximumHeap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = readNumber(br);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		int input;

		for (int i = 0; i < n; i++) {
			input = readNumber(br);

			if (input == 0) {
				bw.write(maxHeap.isEmpty() ? "0" + "\n" : maxHeap.poll() + "\n");
			} else {
				maxHeap.add(input);
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static int readNumber(BufferedReader br) throws IOException {

		int c;
		int value = 0;

		while((c = br.read()) >= '0' && c <= '9') {
			value = value * 10 + (c - '0');
		}
		return value;
	}
}


// 처음에 푼 것 284ms
// public class Main {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		int n = Integer.parseInt(br.readLine());
//
// 		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
// 		int input;
// 		StringBuilder sb = new StringBuilder();
//
// 		for (int i = 0; i < n; i++) {
// 			input = Integer.parseInt(br.readLine());
//
// 			if (input == 0) {
// 				if (maxHeap.isEmpty()) {
// 					sb.append(0).append("\n");
// 				} else {
// 					sb.append(maxHeap.poll()).append("\n");
// 				}
// 			} else {
// 				maxHeap.add(input);
// 			}
// 		}
//
// 		System.out.println(sb.substring(0, sb.length() - 1));
// 	}
// }
