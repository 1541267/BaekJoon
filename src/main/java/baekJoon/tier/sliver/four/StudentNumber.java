package baekJoon.tier.sliver.four;

// 1235번
// TODO 아직 안풀었음


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentNumber {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder stb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		List<String> students = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			students.add(br.readLine());
		}

		String[] numbers = new String[students.size()];

		for (int i = 0; i < n; i++) {
			int lastIndex = students.getFirst().length()-1;
			numbers[i] = String.valueOf(students.get(i).charAt(lastIndex));
		}
		System.out.println(Arrays.toString(numbers));
	}
}
