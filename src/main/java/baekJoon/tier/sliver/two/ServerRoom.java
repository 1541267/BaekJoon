package baekJoon.tier.sliver.two;

// (실버 2) 17245번 서버실
// 이분 탐색, 매개 변수 탐색
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	256 MB	4972	1142	775	20.800%
// 문제
// 서버실은 여러 대의 서버 컴퓨터들을 안정적으로 운영할 수 있는 환경을 유지하기 위해 설치된 공간을 말한다.
//
// 이 회사의 서버실은 N×N 칸으로 구분되어 있고, 각 칸마다 서버 랙이 있어 컴퓨터를 여러 대 쌓을 수 있다. 서버가 과열되지 않도록 서버실에는 언제나 냉방기가 작동하고 있다. 그런데 회사가 경제적으로 어려움에 처한 나머지, 서버실의 운영 비용을 줄이기 위해 서버실 내의 컴퓨터 중 절반만 정상적으로 관리하기로 하였다.
//
// 냉방기에서 나온 차가운 공기는 서버실의 아래쪽부터 서서히 차오른다. 1분마다 컴퓨터 한 대의 높이만큼 방을 채운다. 이 회사의 서버 컴퓨터는 환경에 매우 민감하여 차가운 공기를 받아야만 동작하고 그렇지 못하면 장애를 일으킨다.
//
// 서버실의 컴퓨터 중 절반 이상이 켜지려면 몇 분이 필요할까?
//
// 입력
// 정수 N이 주어진다. (1 ≤ N ≤ 1000)
//
// N×N개의 각 칸에 컴퓨터가 몇 대 쌓여있는지가 입력된다. 한 칸에는 최대 10,000,000대까지 쌓여있을 수 있다.
//
// 출력
// 몇 분이 지나야 전체 컴퓨터의 절반 이상이 장애를 일으키지 않고 동작할 수 있는지 출력한다.
//
// 예제 입력 1
// 5
// 1 4 0 2 1
// 0 0 5 6 3
// 8 4 7 2 0
// 7 1 0 5 3
// 4 5 7 9 1
// 예제 출력 1
// 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServerRoom {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = readNumber(br);

		int[][] arr = new int[n][n];
		long halfQuantity = 0;

		int right = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int input = readNumber(br);
				arr[i][j] = input;

				halfQuantity += input;
				right = Math.max(right, input);
			}
		}
		halfQuantity = (halfQuantity + 1) /  2;

		if (right == 0) {
			System.out.println(0);
			return;
		} else if (n == 1) {
			System.out.println(Math.round(halfQuantity));
			return;
		}

		System.out.println(binarySearch(n, arr, right, halfQuantity));

	}

	private static int binarySearch(int n, int[][] arr, int right, long halfQuantity) {

		int left = 0;

		while (left <= right) {
			int mid = (right + left) / 2;
			long serverCount = countingServer(arr, mid);
			if (serverCount >= halfQuantity) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	private static long countingServer(int[][] arr, int mid) {
		long total = 0;
		for (int[] ints : arr) {
			for (int anInt : ints) {
				total += Math.min(anInt, mid);
			}
		}
		return total;
	}

	private static int readNumber(BufferedReader br) throws IOException {
		int value = 0;
		int c = br.read();

		while (c == ' ') {
			c = br.read();
		}

		do {
			value = value * 10 + (c - '0');
		} while ((c = br.read()) >= '0' && c <= '9');

		return value;
	}

}
