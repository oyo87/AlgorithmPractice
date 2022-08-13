import java.util.Arrays;
import java.util.Scanner;

//x,y좌표받고 오름차순정렬
//직접 정렬후 하려하니 시간초과발생
//Arrays.sort이용하여 2차원배열정렬
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int arr[][] = new int[n][2];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		Arrays.sort(arr, (e1, e2) -> {// 람다식 활용
			if (e1[0] == e2[0]) {// x가 같으면 y기준오름차순
				return e1[1] - e2[1];
			} else {// x가 다르면 x기준오름차순
				return e1[0] - e2[0];
			}
		});

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}

}