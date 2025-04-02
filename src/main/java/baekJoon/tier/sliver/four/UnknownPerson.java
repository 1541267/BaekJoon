package baekJoon.tier.sliver.four;

// (실버 4) 문제 1764번 듣보잡
// 김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다. 이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다. 이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.
//
// 듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.
//
// 출력
// 듣보잡의 수와 그 명단을 사전순으로 출력한다.
//
// 예제 입력 1
// 3 4
// ohhenrie
// charlie
// baesangwook
// obama
// baesangwook
// ohhenrie
// clinton
// 예제 출력 1
// 2
// baesangwook
// ohhenrie


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class UnknownPerson {

	// 최적화 시도
	// HashSet 크기 n으로 미리 지정 292ms -> 256ms
	// parallelStream.sort -> 큰데이터에는 효과적이라 하나 데이터가 적어 오히려 느려짐 332ms
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashSet<String> unheard = new HashSet<>(n);

		// TreeSet<String> result = new TreeSet<>();
		List<String> result = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			unheard.add(br.readLine());
		}

		for (int i = 0; i < m; i++) {

			String addPerson = br.readLine();

			if (unheard.contains(addPerson)) {
				result.add(addPerson);
			}
		}
		Collections.sort(result);

		// result = result.parallelStream().sorted().collect(Collectors.toList());

		bw.write(String.valueOf(result.size()));
		bw.newLine();
		StringBuilder sb = new StringBuilder();
		for (String s : result) {
			sb.append(s).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}

// 292ms
// public class UnknownPerson {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
// 		StringTokenizer st = new StringTokenizer(br.readLine());
//
// 		int n = Integer.parseInt(st.nextToken());
// 		int m = Integer.parseInt(st.nextToken());
//
// 		HashSet<String> first = new HashSet<>();
//
// 		TreeSet<String> result = new TreeSet<>();
//
// 		for (int i = 0; i < n; i++) {
// 			first.add(br.readLine());
// 		}
//
// 		for (int i = 0; i < m; i++) {
//
// 			int beforeAddSize = first.size();
//
// 			String addPerson = br.readLine();
//
// 			first.add(addPerson);
//
// 			if (beforeAddSize == first.size()) {
// 				result.add(addPerson);
// 			}
// 		}
//
// 		System.out.println(result.size());
//
// 		StringBuilder sb = new StringBuilder();
// 		for (String s : result) {
// 			sb.append(s).append("\n");
// 		}
// 		System.out.println(sb);
// 	}
// }
