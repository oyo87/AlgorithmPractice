import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//첫째줄에 테스트케이스
//둘째줄에 N명의 사람수, M초의 붕어빵생성시간, K개의 붕어빵을 입력받음
//공백으로 구분된 N개의 정수가 들어옴 사람의 도착시간을 초단위로 나타냄 (0~ 11111)
//1초단위로 반복문을 돌면서 손님이왔을때마다 빵이 존재하면 Possible, 아니면 Impossible
public class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String[] line = br.readLine().split(" ");
			int N = Integer.parseInt(line[0]);// 사람수(코드에서 추가로 사용 안함)
			int M = Integer.parseInt(line[1]);// 붕어빵 생성시간
			int K = Integer.parseInt(line[2]);// 생성시간마다 만들수있는 붕어빵의 수
			int sum = 0;// 마지막 손님이 올때까지 걸리는 시간
			int bread = 0;// 붕어빵 개수
			String[] timeStr = br.readLine().split(" ");// str형으로 입력받고 손님방문시간
			int[] time = new int[timeStr.length];// int형으로변환 손님방문시간

			for (int i = 0; i < timeStr.length; i++) {//손님이 찾아오는시간 배열을 만듦
				time[i] = Integer.parseInt(timeStr[i]);
				sum += time[i];
			}
			Arrays.sort(time);// 방문 시간 정렬
			int j = 0;// 손님 방문 time 인덱스를 관리하기 위함
			a: for (int i = 0; i <= sum; i++) {// 마지막손님이 올때까지 반복
				if (i != 0 && i % M == 0) {// 1이상의값이들어오니 0초마다 붕어빵을만들순없음 붕어빵 만들수있는 시간이 되면 K만큼 붕어빵수증가
					bread += K;
				}
				while (j < time.length && i == time[j]) {// 손님이 찾아온 시간이라면
					if (bread <= 0) {// 빵이없을때
						bread = -1;// -1을 false플래그처럼 사용. 뒤에 impossible출력용
						break a;
					} else {// 빵이있을때
						bread--;// 빵 감소
						j++;// 다음손님
					}

				}
			}
			bw.write("#");
			bw.write(String.valueOf(tc));
			bw.write(" ");
			if (bread == -1)// -1이라면 손님이왔는데 빵이 없다는 뜻이므로 불가
				bw.write("Impossible\n");
			else
				bw.write("Possible\n");

		}
		bw.flush();
		bw.close();

	}
}
