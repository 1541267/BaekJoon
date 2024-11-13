package baekJoon.step6;
//
// 인하대학교 컴퓨터공학과를 졸업하기 위해서는, 전공평점이 3.3 이상이거나 졸업고사를 통과해야 한다. 그런데 아뿔싸, 치훈이는 깜빡하고 졸업고사를 응시하지 않았다는 사실을 깨달았다!
//
// 치훈이의 전공평점을 계산해주는 프로그램을 작성해보자.
//
// 전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.
//
// 인하대학교 컴퓨터공학과의 등급에 따른 과목평점은 다음 표와 같다.
//
// A+	4.5
// A0	4.0
// B+	3.5
// B0	3.0
// C+	2.5
// C0	2.0
// D+	1.5
// D0	1.0
// F	0.0
// P/F 과목의 경우 등급이 P또는 F로 표시되는데, 등급이 P인 과목은 계산에서 제외해야 한다.
//
// 과연 치훈이는 무사히 졸업할 수 있을까?
//
// 입력
// 20줄에 걸쳐 치훈이가 수강한 전공과목의 과목명, 학점, 등급이 공백으로 구분되어 주어진다.
//
// 출력
// 치훈이의 전공평점을 출력한다.
//
// 정답과의 절대오차 또는 상대오차가
// \(10^{-4}\) 이하이면 정답으로 인정한다.
//
// 제한
// 1 ≤ 과목명의 길이 ≤ 50
// 과목명은 알파벳 대소문자 또는 숫자로만 이루어져 있으며, 띄어쓰기 없이 주어진다. 입력으로 주어지는 모든 과목명은 서로 다르다.
// 학점은 1.0,2.0,3.0,4.0중 하나이다.
// 등급은 A+,A0,B+,B0,C+,C0,D+,D0,F,P중 하나이다.
// 적어도 한 과목은 등급이 P가 아님이 보장된다.
// 예제 입력 1
// ObjectOrientedProgramming1 3.0 A+
// IntroductiontoComputerEngineering 3.0 A+
// ObjectOrientedProgramming2 3.0 A0
// CreativeComputerEngineeringDesign 3.0 A+
// AssemblyLanguage 3.0 A+
// InternetProgramming 3.0 B0
// ApplicationProgramminginJava 3.0 A0
// SystemProgramming 3.0 B0
// OperatingSystem 3.0 B0
// WirelessCommunicationsandNetworking 3.0 C+
// LogicCircuits 3.0 B0
// DataStructure 4.0 A+
// MicroprocessorApplication 3.0 B+
// EmbeddedSoftware 3.0 C0
// ComputerSecurity 3.0 D+
// Database 3.0 C+
// Algorithm 3.0 B0
// CapstoneDesigninCSE 3.0 B+
// CompilerDesign 3.0 D0
// ProblemSolving 4.0 P
// 예제 출력 1
// 3.284483

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;

public class AvgScore {

	public static final Map<String, Double> GRADE_TO_POINT;

	static {
		// 'P'는 계산에서 제외되므로 추가하지 않음
		GRADE_TO_POINT = Map.of(
			"A+", 4.5,
			"A0", 4.0,
			"B+", 3.5,
			"B0", 3.0,
			"C+", 2.5,
			"C0", 2.0,
			"D+", 1.5,
			"D0", 1.0,
			"F", 0.0);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		double sum = 0.0;
		double totalScore = 0;
		String line;

		while ((line = br.readLine()) != null && !line.isEmpty()) {
			StringTokenizer st = new StringTokenizer(line);

			if (st.hasMoreTokens()) {

				String subject = st.nextToken();
				double score = Double.parseDouble(st.nextToken());
				String subjectAvgScore = st.nextToken();

				if (!(subjectAvgScore.equals("P"))) {

					double grade = GRADE_TO_POINT.get(subjectAvgScore);

					sum += grade * score;

					totalScore += score;
				}
			}
		}
		if (totalScore > 0) {
			double avg = sum / totalScore;
			bw.write(String.format("%.6f", avg));
		} else {
			bw.write("0");
		}
		bw.flush();
		bw.close();
		br.close();

	}
}
