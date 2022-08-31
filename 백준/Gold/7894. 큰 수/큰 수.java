import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//직접 구하기불가능
//로그를 이용
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];// 1이상10^7이하

		for (int i = 0; i < N; i++) {
			double length = 0;// 팩토리얼후 길이. int로 하면 소수점이 모두 잘린다.
			num[i] = Integer.parseInt(br.readLine());
			for (int j = num[i]; 1 <= j; j--) {
				length += Math.log10(j);
			}

			sb.append((int) length + 1).append("\n"); // length는 자릿수값.소수점값#######의 상태.로 이므로 int로 바꿔주고 +1을 해서 올림처리
		}
		System.out.println(sb);
	}
}
