package baekJoon.tier.sliver.three;

// (실버 3) 22233번 가희와 키보드
// 자료 구조, 문자열, 해시를 사용한 집합과 맵 & 파싱
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1.5 초	512 MB	7950	3334	2549	40.167%
// 문제
// 가희는 블로그를 운영하고 있습니다. 가희는 블로그에 글을 쓰기 위해, 메모장에 키워드를 적곤 합니다.
//
// 지금까지 메모장에 써진 키워드는 모두 서로 다르며, 총 N개가 존재합니다.
//
// 가희는 새로운 글을 작성할 때, 최대 10개의 키워드에 대해서 글을 작성합니다.
//
// 이 키워드들 중에 메모장에 있었던 키워드는 가희가 글을 쓴 이후, 메모장에서 지워지게 됩니다.
//
// 가희는 블로그에 글을 쓰고 나서, 메모장에 있는 키워드 개수가 몇 개인지 알고 싶습니다. 가희를 도와주세요.
//
// 입력
// 첫 번째 줄에 가희가 메모장에 적은 키워드 개수 N, 가희가 블로그에 쓴 글의 개수 M이 공백으로 구분해서 주어집니다.
//
// 2번째 줄부터 N+1번째 줄까지 메모장에 적은 키워드 N개가 주어집니다.
//
// N+2번째 줄부터 N+M+1번째 줄까지, 가희가 쓴 글과 관련된 키워드가 , (쉼표)로 구분해서 주어집니다. 공백으로 구분되지 않음을 유의해 주세요.
//
// 출력
// x번째 줄에는 x번째 글을 쓰고 난 후에 메모장에 남아 있는 키워드의 개수를 출력해 주세요.
//
// 제한
// 1 ≤ N ≤ 2×105
// 1 ≤ M ≤ 2×105
// 1 ≤ 글에 있는 키워드 개수 ≤ 10
// 1 ≤ 키워드 길이 ≤ 10
// 키워드는 소문자와 숫자로만 이루어져 있습니다.
// 메모장에 있는 키워드 이름은 중복되지 않습니다.
// 글에 있는 키워드 이름은 중복되지 않습니다. 그러나, 한 키워드는 여러 글에 있을 수 있습니다
// 예제 입력 1
// 5 2
// map
// set
// dijkstra
// floyd
// os
// map,dijkstra
// map,floyd
// 예제 출력 1
// 3
// 2
// 1번째 글을 쓰고 난 후에, 메모장에 있는 키워드는 set, floyd, os가 됩니다.
//
// 2번째 글을 쓰고 난 후에, 메모장에 있는 키워드는 set, os가 됩니다.
//
// map은 1번째 글과 2번째 글에 중복으로 등장하였음을 참고해 주세요.
//
// 예제 입력 2
// 2 2
// gt26cw
// 1211train
// kiwoom,lottegiant
// kbo
// 예제 출력 2
// 2
// 2

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class GahuiAndKeyword {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}

		for (int i = 0; i < m; i++) {

			for (String s : br.readLine().split(",")) {
				set.remove(s);
			}

			bw.write(set.size() + "\n");

		}

		bw.flush();
		bw.close();
		br.close();
	}
}

// 시간초과
// public class GahuiAndKeyword {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
// 		StringTokenizer st = new StringTokenizer(br.readLine());
//
// 		int n = Integer.parseInt(st.nextToken());
// 		int m = Integer.parseInt(st.nextToken());
//
// 		HashMap<String, Integer> map = new HashMap<>();
//
// 		for (int i = 0; i < n; i++) {
// 			map.put(br.readLine(), 0);
// 		}
//
// 		for (int i = 0; i < m; i++) {
// 			String input = br.readLine();
//
// 			for (String s : input.split(",")) {
// 				if (map.containsKey(s)) {
// 					map.put(s, map.get(s) + 1);
// 				}
// 			}
// 			int remainKeword = 0;
//
// 			for (int j : map.values()) {
// 				if (j == 0) remainKeword++;
// 			}
// 			bw.write(remainKeword + "\n");
//
// 		}
//
// 		bw.flush();
// 		bw.close();
// 		br.close();
// 	}
// }
//
