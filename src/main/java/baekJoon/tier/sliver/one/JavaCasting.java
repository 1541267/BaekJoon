package baekJoon.tier.sliver.one;

// (실버 1) 25601번 자바의 형 변환
// 자료 구조, 그래프 이론, 그래프 탐색, 트리, 해시 집합 맵
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 2 초	512 MB	777	404	299	50.764%
// 문제
// 자바의 클래스끼리는 상속을 통해 자신의 기능 일부를 다른 클래스에게 이식할 수 있다. 여기서 상속을 받은 클래스는 자식 클래스, 상속을 한 클래스는 부모 클래스가 된다. 클래스를 이용해서 만든 객체는 다른 클래스로 형태를 변환할 수 있는데, 이를 형변환(Casting)이라고 한다. 만약 자식 클래스에서 부모 클래스로 변환한다면 업캐스팅(Upcasting), 부모 클래스에서 자식 클래스로 변환한다면 다운캐스팅(Downcasting) 이라고 부른다. 즉, 자식 클래스와 부모 클래스 관계에 놓여있다면 형변환이 가능하다. Downcasting의 경우 런타임에 문제를 발생시킬 수 있지만 이는 본 문제에서 고려하지 않는다. 또한, 자바에서는 클래스의 다중 상속은 지원하지 않는다
//
// 예를 들자면, number 클래스는 object 클래스를 상속받는다. 따라서, number 클래스는 object 클래스의 자식 클래스가 되고, object 클래스는 number 클래스의 부모 클래스가 된다.
//
// 또한, 자식 클래스가 여러 단계를 거쳐 상속을 받은 경우, 이 자식 클래스에게 상속을 해준 클래스들 모두 부모 클래스가 된다. 예를 들면, integer 클래스의 경우 number 클래스로 부터 상속을 받고, 이 number 클래스는 object 클래스의 상속을 받았으니, integer 클래스는 number, object 클래스로부터 상속을 받은 것과 같다. 따라서, integer 클래스와 object 클래스는 부모 - 자식 관계가 되기 때문에 두 클래스간 형변환이 가능하다.
//
// 입력으로
// $N$개의 임의의 클래스들간의 관계를 입력받고, 검사할 두 클래스에 대한 정보가 주어진다. 만약, 서로 형변환이 가능하면 1, 아니면 0을 출력한다.
//
// 입력
// 첫 줄에 클래스의 수
// $N$이 주어진다. (
// $2 \le N \le 100\ 000$)
//
// 다음
// $N - 1$개의 줄에 각 클래스 간의 관계 정보가 주어진다.
// $A$,
// $B$가 순서대로 주어지며 이는
// $A$가
// $B$의 자식 클래스란 뜻이다.
// $A$,
// $B$는 알파벳 소문자로 구성된 길이 2 이상 50 이하의 문자열이다.
//
// 마지막 줄엔 서로 형변환이 가능한지 확인할 두 클래스가 주어진다. 항상
// $N - 1$개 줄의 입력에서 주어졌던 클래스만 나오며, 두 클래스의 이름은 서로 다르다.
//
// 입력을 통해 만들어지는 트리는 하나의 루트가 있는 트리이다.
//
// 출력
// 두 클래스가 형변환이 가능하면 1, 아니라면 0을 출력한다.
//
// 예제 입력 1
// 3
// number object
// string object
// number string
// 예제 출력 1
// 0
// 예제 입력 2
// 4
// integer number
// number object
// string object
// number integer
// 예제 출력 2
// 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class JavaCasting {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = readNumber(br);

		Map<String, List<String>> tree = new HashMap<>();
		Map<String, String> parentMap = new HashMap<>();

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String child = st.nextToken();
			String parent = st.nextToken();

			tree.putIfAbsent(parent, new ArrayList<>());
			tree.get(parent).add(child);

			parentMap.put(child, parent);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());

		String class1 = st.nextToken();
		String class2 = st.nextToken();

		HashSet<String> set = new HashSet<>();

		System.out.println("parentMap = " + parentMap);


		findClass(class1, parentMap, set);

		if(set.contains(class2) || findClass(class2, parentMap, new HashSet<>()).contains(class1)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

	private static Set<String> findClass(String class1, Map<String, String> parentMap, HashSet<String> set) {
		while(parentMap.containsKey(class1)) {
			System.out.println("before class1 = " + class1);
			class1 = parentMap.get(class1);
			System.out.println("after class1 = " + class1);
			set.add(class1);
		}
		return set;

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

