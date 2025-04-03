package baekJoon.tier.sliver.two;

// (실버 2) 14713번 앵무새
// 구현, 자료 구조, 문자열, 큐
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	512 MB	5439	1641	1229	29.479%
// 문제
// 자가용 비행기를 타고 세계 일주를 하던 pps789와 cseteram은 어느 날 엔진 고장으로 인해 이름 모를 섬에 불시착하게 된다. 그들은 이 섬을 탐험하는 도중 아주 신기한 사실을 알게 되었는데, 바로 이 섬에 사는 앵무새들은 놀라울 정도로 인간의 말을 흉내 내는 데 뛰어나다는 것이다. 그들은 서로 떨어져 섬을 탐험하기로 하였으며, 필요하다면 앵무새를 이용해 서로에게 연락하기로 약속하였다.
//
// 1개월 후, pps789는 섬의 비밀을 밝힐 결정적인 증거를 찾게 된다. 그는 이 세기의 대발견을 cseteram에게 공유하고자 하였으나, 그의 발견은 방대하여 앵무새 한 마리가 기억하기에는 너무 많은 양이었다. 그렇기 에 pps789는 앵무새 한 마리 대신 앵무새 N마리를 이용하여 자신의 발견을 기록하였으며, 이 앵무새들을 cseteram을 향해 날렸다.
//
// 한편 섬의 반대편에서 탐험을 계속하던 cseteram은 앵무새 N마리가 자신에게 날아와 각자 할 말을 하는 것을 보고 당황하였다. pps789가 긴 글을 전달하고 싶었던 것은 알아차렸지만, 각각의 앵무새들이 말하는 것을 차례대로 기록하다 보니 원문이 무엇인지 알 수 없을 정도로 단어의 순서가 엉켜버린 것이다. 대신 그는 관찰을 통해 몇 가지 규칙을 발견할 수 있었다.
//
// 한 앵무새는 한 문장을 기억하고 있다. 문장은 여러 단어로 이루어져 있는데, 앵무새는 이 단어들을 순서대로 말한다.
// 한 앵무새가 단어를 말하고 그다음 단어를 말하기 전에는 약간의 간격이 있는데, 이때 다른 앵무새가 말을 가로채고 자신의 문장을 말할 수 있다.
// 한 앵무새가 단어를 말하는 도중에는, 다른 앵무새가 말을 가로채지 않는다.
// 어떤 단어도 앵무새가 말하는 모든 문장을 통틀어 2번 이상 등장하지 않는다.
// 앵무새는 자신이 기억하고 있는 문장을 끝까지 말한 다음 pps789에게 돌아가며, cseteram은 모든 앵무새가 돌아갈 때 까지 단어를 받아적는다. pps789가 각각의 앵무새들에게 전달한 문장 Si와, cseteram이 받아 적은 문장 L이 주어진다. 이때 문장 L이 위 규칙들을 이용하여 나올 수 있는 문장인지 판별하시오.
//
// 입력
// 첫 번째 줄에 앵무새의 수 N (1 ≤ N ≤ 100) 이 주어진다.
//
// 두 번째 줄부터 N개의 줄에 걸쳐 각 앵무새가 말한 문장 Si (1 ≤ i ≤ N) 가 주어지는데, 각 문장을 이루는 단어는 스페이스 한 칸을 구분으로 하여 주어진다. 문장 Si를 이루는 단어의 수는 1개 이상 100개 이하이며, 각 단어는 1개 이상 32개 이하의 영문 소문자로 구성되어있다.
//
// N + 2 번째 줄에는 cseteram이 받아 적은 문장 L이 주어진다. 문장 L을 이루는 단어의 수는 1개 이상 10000개 이하이며, 각 단어는 1개 이상 32개 이하의 영문 소문자로 구성된다.
//
// 출력
// 문장 L이 가능한 문장이라면 Possible을, 불가능한 문장이라면 Impossible을 출력한다.
//
// 예제 입력 1
// 3
// i want to see you
// next week
// good luck
// i want next good luck week to see you
// 예제 출력 1
// Possible
// 예제 입력 2
// 2
// i found
// an interesting cave
// i found an cave interesting
// 예제 출력 2
// Impossible
// 예제 입력 3
// 2
// please
// be careful
// pen pineapple apple pen
// 예제 출력 3
// Impossible

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Parrot {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<Queue<String>> parrotList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			parrotList.add(new ArrayDeque<>(Arrays.asList(br.readLine().split(" "))));
		}

		Queue<String> sentenceLQueue = new ArrayDeque<>(Arrays.asList(br.readLine().split(" ")));

		while (!sentenceLQueue.isEmpty()) {

			String word = sentenceLQueue.peek();
			boolean found = false;

			for (Queue<String> parrot : parrotList) {
				if (!parrot.isEmpty() && parrot.peek().equals(word)) {
					parrot.poll();
					found = true;
					break;
				}
			}

			sentenceLQueue.poll();

			if (!found) {
				System.out.print("Impossible");
				return;
			}
		}

		for (Queue<String> parrot : parrotList) {
			if (!parrot.isEmpty()) {
				System.out.println("Impossible");
				return;
			}
		}

		System.out.print("Possible");
	}
}
