import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//숫자로된 한줄이 주어진다. 0~9
//오름차순 정렬할것
public class Main {

	public static int[] swap(int[] arr, int j) {
		int temp;

		temp = arr[j - 1];
		arr[j - 1] = arr[j];
		arr[j] = temp;
		return arr;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		int[] arr = new int[str.length()];
		for (int i = 0; i < str.length(); i++)
			arr[i] = str.charAt(i);

		// insertion sort활용 내림차순
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; 0 < j; j--) {
				if (arr[j - 1] < arr[j])
					arr = swap(arr, j);
			}
		}
		for (int i = 0; i < arr.length; i++) 
			bw.write(arr[i]);
		bw.flush();
		bw.close();
	}
}
