import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//그리디
//디버깅을 하면서 코드가 점점 더러워지고있다..!
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// 멀티탭 구멍 개수
		int K = sc.nextInt();// 전기용품의 총 사용 횟수
		int[] use = new int[K];

		for (int i = 0; i < K; i++) {
			use[i] = sc.nextInt() - 1;// 1번부터 K-1번까지 사용말고 0번부터 K번까지 사용하는게 계산이 편할것같다.
		}
		List<Integer> socket = new LinkedList<>();// 콘센트

		int answer = 0;// 플러그 뺀 횟수
		for (int i = 0; i < K; i++) {
			if (!socket.contains(use[i])) {// 연결 안된물건일때
				if (socket.size() < N) {// 연결할 공간이 있으면 연결
					socket.add(use[i]);
				} else {// 연결할 공간이 없으면 연결되어 있는것들중 가장 늦게 다시사용되는것을 뽑고 새로운것 연결
					if (i == K - 1) {// 마지막이면 그냥 아무거나뽑으면되니까 ++
						answer++;
						continue;
					}

					boolean[] used = new boolean[N];
					int temp = 0;
					for (int j = i + 1; j < K; j++) {

//						틀렸습니다가 나와서 디버깅후 이 조건을 아래에도 추가시켰다
						if (temp == N - 1) {// 종료조건 false인것 콘센트에서 제거해주기
							for (int k = 0; k < N; k++) {
								if (!used[k]) {
									socket.remove(k);
									answer++;
									break;
								}
							}
							socket.add(use[i]); // 뺏으니까 새로 연결
							break;
						} // 종료조건 끝

						if (socket.contains(use[j]) && !used[socket.indexOf(use[j])]) {// 콘센트 연결되어있는것중 먼저 사용될예정이면 true
							used[socket.indexOf(use[j])] = true;
							temp++;
						}

						//
						if (temp == N - 1 || j == K - 1) {// 추가 종료조건을 만들어줬다. 마지막인데 위에서 종료되지않았을때
							for (int k = 0; k < N; k++) {
								if (!used[k]) {
									socket.remove(k);
									answer++;
									break;
								}
							}
							socket.add(use[i]); // 뺏으니까 새로 연결
							break;
						}
					} // j for
				}
			} else {// 이미 연결되어있는물건이면 딱히 할것은 없다.

			}

		}
		System.out.println(answer);
	}
}
