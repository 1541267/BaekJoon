package baekJoon.tier.sliver.three;

// (실버 3) 20291번 파일 정리
// 자료 구조, 문자열, 정렬, 해시 | 트리 집합 맵, 파싱
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 3 초 (추가 시간 없음)	1024 MB	10528	7194	5424	68.330%
// 문제
// 친구로부터 노트북을 중고로 산 스브러스는 노트북을 켜자마자 경악할 수밖에 없었다. 바탕화면에 온갖 파일들이 정리도 안 된 채 가득했기 때문이다. 그리고 화면의 구석에서 친구의 메시지를 확인할 수 있었다.
//
// 바탕화면의 파일들에는 값진 보물에 대한 정보가 들어 있어. 하나라도 지우게 된다면 보물은 물론이고 다시는 노트북을 쓸 수 없게 될 거야. 파일들을 잘 분석해서 보물의 주인공이 될 수 있길 바랄게. 힌트는 “확장자”야.
//
// 화가 났던 스브러스는 보물 이야기에 금세 화가 풀렸고 보물의 정보를 알아내려고 애썼다. 하지만 파일이 너무 많은 탓에 이내 포기했고 보물의 절반을 보상으로 파일의 정리를 요청해왔다. 스브러스의 요청은 다음과 같다.
//
// 파일을 확장자 별로 정리해서 몇 개씩 있는지 알려줘
// 보기 편하게 확장자들을 사전 순으로 정렬해 줘
// 그럼 보물의 절반을 얻어내기 위해 얼른 스브러스의 노트북 파일 정리를 해줄 프로그램을 만들자!
//
// 입력
// 첫째 줄에 바탕화면에 있는 파일의 개수
// $N$이 주어진다. (
// $1 \leq N \leq 50\ 000$)
//
// 둘째 줄부터
// $N$개 줄에 바탕화면에 있는 파일의 이름이 주어진다. 파일의 이름은 알파벳 소문자와 점(.)으로만 구성되어 있다. 점은 정확히 한 번 등장하며, 파일 이름의 첫 글자 또는 마지막 글자로 오지 않는다. 각 파일의 이름의 길이는 최소
// $3$, 최대
// $100$이다.
//
// 출력
// 확장자의 이름과 그 확장자 파일의 개수를 한 줄에 하나씩 출력한다. 확장자가 여러 개 있는 경우 확장자 이름의 사전순으로 출력한다.
//
// 예제 입력 1
// 8
// sbrus.txt
// spc.spc
// acm.icpc
// korea.icpc
// sample.txt
// hello.world
// sogang.spc
// example.txt
// 예제 출력 1
// icpc 2
// spc 2
// txt 3
// world 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;


// split은 정규식 사용으로 느림 -> lastIndexOf 사용
// trim은 추가적인 문자 복사열 연산 발생, 마지막 공백을 직접 지정해서 제거
// 612ms
public class OrganizeFile {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		TreeMap<String, Integer> map = new TreeMap<>();
		String line;

		String extension;
		int lastIndex = 0;
		for (int i = 0; i <n ; i++) {
			line = br.readLine();
			lastIndex = line.lastIndexOf(".");
			extension = line.substring(lastIndex+1);


			map.put(extension, map.getOrDefault(extension, 0) + 1);
		}

		StringBuilder sb = new StringBuilder();
		for (String s : map.keySet()) {
			sb.append(s).append(" ").append(map.get(s)).append("\n");
		}

		System.out.print(sb.deleteCharAt(sb.length()-1));

	}
}
// // HashMap -> TreeMap 716ms
// public class OrganizeFile {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		int n = Integer.parseInt(br.readLine());
//
// 		TreeMap<String, Integer> map = new TreeMap<>();
// 		String[] line;
// 		for (int i = 0; i <n ; i++) {
// 			line = br.readLine().split("\\.");
// 			map.put(line[1], map.getOrDefault(line[1], 0) + 1);
// 		}
//
// 		StringBuilder sb = new StringBuilder();
// 		for (String s : map.keySet()) {
// 			sb.append(s).append(" ").append(map.get(s)).append("\n");
// 		}
//
// 		System.out.print(sb.toString().trim());
//
// 	}
// }

// 처음에 푼 것, 812ms
// public class OrganizeFile {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		int n = Integer.parseInt(br.readLine());
//
// 		HashMap<String, Integer> map = new HashMap<>();
// 		String[] line;
// 		for (int i = 0; i <n ; i++) {
// 			line = br.readLine().split("\\.");
// 			map.put(line[1], map.getOrDefault(line[1], 0) + 1);
// 		}
//
// 		List<String> keySet = new ArrayList<>(map.keySet());
//
// 		Collections.sort(keySet);
//
// 		StringBuilder sb = new StringBuilder();
// 		for (String s : keySet) {
// 			sb.append(s).append(" ").append(map.get(s)).append("\n");
// 		}
//
// 		System.out.print(sb.toString().trim());
//
// 	}
// }
