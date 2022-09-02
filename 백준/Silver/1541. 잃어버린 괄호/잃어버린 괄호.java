import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//덧셈을 우선 수행한다.
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strArr = br.readLine().split("-");
		int result = 0;
		for (int i = 0; i < strArr.length; i++) {
			int sum = 0;
			String[] strArr2 = strArr[i].split("\\+");// +를 바로 쓰면 인식을 못해주기에 \\+사용
			for (int j = 0; j < strArr2.length; j++) {
				sum += Integer.parseInt(strArr2[j]);
			}
			if (i == 0)
				result += sum;
			else
				result -= sum;
		}
		System.out.println(result);
	}
}
