import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 여러 방법을 해봤더니 시간초과 발생
// 빠른 Collections.sort
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
		}
		
		Collections.sort(arr);
		
		for(int num : arr) {
			sb.append(num).append('\n');
		}
		System.out.println(sb);
	}
}