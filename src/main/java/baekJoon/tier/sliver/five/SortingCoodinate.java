package baekJoon.tier.sliver.five;

// (실버 5) 11650번 좌표 정렬하기
// 정렬
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	256 MB	164866	80409	62596	48.669%
// 문제
// 2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
//
// 출력
// 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
//
// 예제 입력 1
// 5
// 3 4
// 1 1
// 1 -1
// 2 2
// 3 3
// 예제 출력 1
// 1 -1
// 1 1
// 2 2
// 3 3
// 3 4

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 차이 없음
public class SortingCoodinate {
	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Point[] points = new Point[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			points[i] = new Point(x, y);
		}

		Arrays.sort(points, (a, b) -> {
			if (a.x != b.x) {
				return a.x - b.x;
			}
			return a.y - b.y;
		});

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			sb.append(points[i].x).append(" ").append(points[i].y).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}

// 처음에 푼 것 660ms
// public class SortingCoodinate {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//
// 		int n = Integer.parseInt(br.readLine());
// 		int[][] first = new int[n][2];
//
// 		for (int i = 0; i < n; i++) {
// 			StringTokenizer st = new StringTokenizer(br.readLine());
// 			first[i][0] = Integer.parseInt(st.nextToken());
// 			first[i][1] = Integer.parseInt(st.nextToken());
// 		}
//
// 		Arrays.sort(first, Comparator.comparingInt((int[] i) -> i[0]).thenComparingInt((int[] i) -> i[1]));
//
// 		StringBuilder sb = new StringBuilder();
//
// 		for (int i = 0; i < n; i++) {
// 			sb.append(first[i][0]).append(" ").append(first[i][1]).append("\n"); ;
// 		}
// 		System.out.println(sb);
// 	}
// }
