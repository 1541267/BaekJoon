package baekJoon.tier.sliver.two;

public class ㅁㅁㅁ {
	public static void main(String[] args) {

		int[] arr = new int[] {-7, -3, -2, 5, 8};

		int n = 5;

		System.out.println("1 << n = " + (1 << n));

		for (int i = 1; i < (1 << n); i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					sum += arr[j];
				}
			}
		}
	}
}
