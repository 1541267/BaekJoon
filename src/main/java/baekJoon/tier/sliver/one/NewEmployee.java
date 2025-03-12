package baekJoon.tier.sliver.one;

// (실버 1) 1946번 신입 사원
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	256 MB	70171	25015	18178	34.025%
// 문제
// 언제나 최고만을 지향하는 굴지의 대기업 진영 주식회사가 신규 사원 채용을 실시한다. 인재 선발 시험은 1차 서류심사와 2차 면접시험으로 이루어진다. 최고만을 지향한다는 기업의 이념에 따라 그들은 최고의 인재들만을 사원으로 선발하고 싶어 한다.
// 
// 그래서 진영 주식회사는, 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다는 원칙을 세웠다. 즉, 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다.
// 
// 이러한 조건을 만족시키면서, 진영 주식회사가 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램을 작성하시오.
// 
// 입력
// 첫째 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 20)가 주어진다. 각 테스트 케이스의 첫째 줄에 지원자의 숫자 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개 줄에는 각각의 지원자의 서류심사 성적, 면접 성적의 순위가 공백을 사이에 두고 한 줄에 주어진다. 두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정한다.
// 
// 출력
// 각 테스트 케이스에 대해서 진영 주식회사가 선발할 수 있는 신입사원의 최대 인원수를 한 줄에 하나씩 출력한다.
// 
// 예제 입력 1 
// 2
// 5
// 3 2
// 1 4
// 4 1
// 2 3
// 5 5
// 7
// 3 6
// 7 3
// 4 2
// 1 4
// 5 7
// 2 5
// 6 1
// 예제 출력 1 
// 4
// 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 코드 참고 해서 고쳐본 것, 772ms
// List 사용에서 배열로 변경 -> 동적 배열 (객체 참조*박싱*언박싱 비용 발생), get() 접근 시 추가 메모리 인덱싱 발생 -> int[]로 정적 메모리 할당
// List 정렬 없이 배열로 비교 변경 -> 데이터 크기가 클 수록 연산이 성능 저하
// for each문 대신 for 문 사용

public class NewEmployee {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		while (n-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] documentScores = new int[N + 1];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				documentScores[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());

			}

			int count = 1;
			int currentScore = documentScores[1];

			for (int i = 2; i <= N; i++) {
				if (currentScore > documentScores[i]) {
					count++;
					currentScore = documentScores[i];
				}

			}
			sb.append(count).append("\n");
		}
		System.out.print(sb.deleteCharAt(sb.lastIndexOf("\n")));

	}
}

// 처음에 푼 것, 1924ms
// public class NewEmployee {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 		int n = Integer.parseInt(br.readLine());
//
// 		StringBuilder sb = new StringBuilder();
//
// 		while (n-- > 0) {
//
// 			int N = Integer.parseInt(br.readLine());
// 			List<int[]> list = new ArrayList<>();
//
// 			for (int i = 0; i < N; i++) {
// 				StringTokenizer st = new StringTokenizer(br.readLine());
// 				int documentScore = Integer.parseInt(st.nextToken());
// 				int interviewScore = Integer.parseInt(st.nextToken());
//
// 				list.add(new int[] {documentScore, interviewScore});
// 			}
//
// 			list.sort(Comparator.comparing(a -> a[0]));
//
// 			int maxHire = 1;
// 			int minInteviewScore = list.get(0)[1];
//
// 			for (int[] i : list) {
// 				int interviewScore = i[1];
//
// 				if (interviewScore < minInteviewScore) {
// 					maxHire++;
// 					minInteviewScore = interviewScore;
// 				}
// 			}
// 			sb.append(maxHire).append("\n");
// 		}
//
// 		System.out.print(sb.deleteCharAt(sb.lastIndexOf("\n")));
// 	}
// }
