import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//안정 정렬 하기
//counting sort 사용
public class Main {
	static class Person {
		int age;
		String name;

		Person() {
			age = 0;
			name = "";
		}

		Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int max = 0;
		int N = Integer.parseInt(br.readLine());
		Person[] arr = new Person[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		for (int i = 0; i < arr.length; i++) {// 최대 나이 구하기
			if (max < arr[i].age)
				max = arr[i].age;
		}

		int[] count = new int[max + 1];
		int[] sum = new int[max + 1];

		for (int i = 0; i < arr.length; i++) {
			count[arr[i].age]++;
		}
		for (int i = 1; i < sum.length; i++) {// 나이는 1부터 주어진다.
			sum[i] = count[i] + sum[i - 1];
		}

		Person[] sort = new Person[N];
		for (int i = arr.length - 1; 0 <= i; i--) {
			sort[--sum[arr[i].age]] = arr[i];
		}
		for (int i = 0; i < sort.length; i++) {
			bw.write(String.valueOf(sort[i].age));
			bw.write(" ");
			bw.write(sort[i].name);
			bw.write("\n");
		}
		bw.flush();
		bw.close();

	}
}
