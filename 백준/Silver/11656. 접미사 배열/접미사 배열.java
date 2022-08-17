import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//queue로해도 되고, 일반 배열에 넣고 반복으로 해도 될것같다.  sort후  출력
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();// 초기 문자열
		String[] arr = new String[str.length()];// 문자열을 앞에서부터 한글자씩 없애며 이 배열에 담음

		for (int i = 0; i < arr.length; i++)
			arr[i] = str.substring(i, arr.length);

		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++)
			bw.write(arr[i] + "\n");
		bw.flush();
		bw.close();

	}
}
