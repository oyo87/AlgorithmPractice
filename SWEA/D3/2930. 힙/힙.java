import java.util.Scanner;

//최대힙 구현하기 완전 이진트리이기때문에 배열로 구현해보자.링크드리스트도 가능
//Priority Queue를 이용하면 method 사용 하지말고 구현하기
//최대값을 출력하고 그 이후 연산2의결과출력
//연산2 수행해야하는데 갑 없으면 -1출력

//삽입 및 삭제하고 자리 이동해주는것까지 구현
public class Solution {

	static int[] swap(int[] arr, int i, int j) {
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc);
			int N = sc.nextInt();
			int[] arr = new int[N];
			int size = 0;

			for (int i = 0; i < N; i++) {
				int cmd = sc.nextInt();
				if (cmd == 1) {// 삽입연산
					int insert = sc.nextInt();// 삽입할 값
					size++;// 추가됐으니 count++
					arr[size] = insert;
					int insertIndex = size;
					while (1 < insertIndex) {
						if (arr[insertIndex / 2] < arr[insertIndex])
							swap(arr, insertIndex, insertIndex / 2);
						insertIndex /= 2;
					}

				} else {// 삭제연산
					if (size == 0) {// 아무것도 없으면 -1출력
						sb.append(" -1");
					} else {// 루트값 삭제
						sb.append(" " + arr[1]);
						arr[1] = arr[size];
						arr[size] = 0;
						size--;
						int deleteIndex = 1;
						while (deleteIndex*2+1 < N) {
							if (arr[deleteIndex] < Math.max(arr[deleteIndex * 2], arr[deleteIndex * 2 + 1])) {// 부모보다 자식들중 하나가 더 큰 상황
								if (arr[deleteIndex * 2] < arr[deleteIndex * 2 + 1]) {// 자식들중우측자식이 더 크면
									arr = swap(arr, deleteIndex, deleteIndex * 2 + 1);
									deleteIndex = deleteIndex * 2 + 1;
								} else {// 좌측자식이 더 크면
									arr = swap(arr, deleteIndex, deleteIndex * 2);
									deleteIndex *= 2;
								}
							} else
								break;
						}
					}

				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
