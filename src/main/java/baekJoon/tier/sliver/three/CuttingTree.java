package baekJoon.tier.sliver.three;

// (실버 2) 14247번 나무 자르기
// 그리디 알고리즘, 정렬
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	512 MB	3227	1617	1248	48.297%
// 문제
// 영선이는 나무꾼으로 나무를 구하러 오전에 산에 오른다. 산에는
// $n$개의 나무가 있는데, 영선이는 하루에 한 나무씩
// $n$일 산에 오르며 나무를 잘라갈 것이다. 하지만 이 산은 영험한 기운이 있어 나무들이 밤만 되면 매우 빠른 속도로 자라는데, 그 자라는 길이는 나무마다 다르다.
//
// 따라서, 어느 나무를 먼저 잘라가느냐에 따라서 총 구할 수 있는 나무의 양이 다른데,
//
// 나무의 처음 길이와 하루에 자라는 양이 주어졌을 때, 영선이가 얻을 수 있는 최대 나무양을 구하시오.
//
// 참고로, 자른 이후에도 나무는
// $0$부터 다시 자라기 때문에 같은 나무를 여러 번 자를 수는 있다.
//
// 입력
// 첫째 줄에는 나무의 개수
// $n$개가 있다. 나무는
// $1$번부터
// $n$번까지 있다.
//
// 다음 줄에는 첫날 올라갔을 때 나무의 길이들
// $H_i$가
// $n$개가 순서대로 주어진다.
//
// 그 다음 줄에는 나무들이 자라는 길이
// $A_i$가
// $n$개가 순서대로 주어진다.
//
// 출력
// 영선이가 나무를 잘라서 구할 수 있는 최대 양을 출력하시오.
//
// 제한
//  
// $1≤n≤100\,000$ 
//  
// $1≤H_i≤100\,000$ 
//  
// $1≤A_i≤10\,000$ 
// 예제 입력 1
// 5
// 1 3 2 4 6
// 2 7 3 4 1
// 예제 출력 1
// 64

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 396ms
public class CuttingTree {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer height = new StringTokenizer(br.readLine());
		StringTokenizer grow = new StringTokenizer(br.readLine());
		Tree[] trees = new Tree[n];

		for (int i = 0; i < n; i++) {
			trees[i] = new Tree(Integer.parseInt(height.nextToken()), Integer.parseInt(grow.nextToken()));
		}

		Arrays.sort(trees, Comparator.comparingInt(t -> t.g));

		long result = 0;
		for (int i = 0; i < n; i++) {
			result += trees[i].h + (long)trees[i].g * i;
		}

		System.out.println(result);
	}

	private static class Tree {

		int h, g;

		public Tree(int h, int g) {
			this.h = h;
			this.g = g;
		}

	}
}
// 428ms
// public class CuttingTree {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		int n = Integer.parseInt(br.readLine());
//
// 		StringTokenizer height = new StringTokenizer(br.readLine());
// 		StringTokenizer grow = new StringTokenizer(br.readLine());
// 		List<Tree> trees = new ArrayList<>();
//
// 		for (int i = 0; i < n; i++) {
// 			trees.add(new Tree(Integer.parseInt(height.nextToken()), Integer.parseInt(grow.nextToken())));
// 		}
//
// 		Collections.sort(trees);
//
// 		long result = 0;
// 		for (int i = 0; i < n; i++) {
// 			result += trees.get(i).h + (long)trees.get(i).g * i;
// 		}
//
// 		System.out.println(result);
// 	}
//
// 	private static class Tree implements Comparable<Tree> {
//
// 		int h, g;
//
// 		public Tree(int h, int g) {
// 			this.h = h;
// 			this.g = g;
// 		}
//
// 		@Override
// 		public int compareTo(Tree o) {
//
// 			return Integer.compare(this.g, o.g);
// 		}
//
// 		@Override
// 		public String toString() {
// 			return "(" + this.h + ", " + this.g + ")";
// 		}
// 	}
// }

// 436ms
// public class CuttingTree {
// 	public static void main(String[] args) throws IOException {
//
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		int n = Integer.parseInt(br.readLine());
// 		List<Integer> height = new ArrayList<>();
// 		List<Integer> grow = new ArrayList<>();
//
// 		for (int i = 0; i < 2; i++) {
// 			StringTokenizer st = new StringTokenizer(br.readLine());
// 			if (i == 0) {
// 				while (st.hasMoreTokens()) {
// 					height.add(Integer.parseInt(st.nextToken()));
// 				}
// 			} else {
// 				while (st.hasMoreTokens()) {
// 					grow.add(Integer.parseInt(st.nextToken()));
// 				}
// 			}
// 		}
//
// 		List<Tree> trees = new ArrayList<>();
//
// 		for (int i = 0; i < n; i++) {
// 			trees.add(new Tree(height.get(i), grow.get(i)));
// 		}
//
// 		Collections.sort(trees);
// 		long result = 0;
// 		for (int i = 0; i < n; i++) {
// 			result += trees.get(i).h + (long)trees.get(i).g * i;
// 		}
// 		System.out.println(result);
// 	}
//
// 	private static class Tree implements Comparable<Tree> {
//
// 		int h, g;
//
// 		public Tree(int h, int g) {
// 			this.h = h;
// 			this.g = g;
// 		}
//
// 		@Override
// 		public int compareTo(Tree o) {
//
// 			return Integer.compare(this.g, o.g);
// 		}
//
// 		@Override
// 		public String toString() {
// 			return "(" + this.h + ", " + this.g + ")";
// 		}
// 	}
// }
