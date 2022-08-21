import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//플레이어가 
//사각형 안에 있는경우
//좌측 우측 반원 안에 있는경우
//를 찾는다.
//원의 중심 좌표가 a,b이고 반지름이 r일때 특정좌표가 x,y라면 x,y가 원 내부에 있는지 알아보려면
//(x-a)^2 + (y-b)^2 <= r^2 를 만족해야한다. 부등호가 >라면 외부에 있는것 =이라면 겹치는것
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int radius = H / 2;
		int count = 0;
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int playerX = Integer.parseInt(st.nextToken());
			int playerY = Integer.parseInt(st.nextToken());

			//원일경우 좌표와 원의 중심까지의 거리가 반지름보다 작으면 내부에 있는것이다.
			if (X <= playerX && playerX <= X + W && Y <= playerY && playerY <= Y+H)// 사각형검사
				count++;
			//좌측 원 검사, 우측 원 검사
			else if ( ( (Math.pow(playerX- X,2)) + (Math.pow(playerY-(Y+radius), 2)) ) <= Math.pow(radius, 2))
				count++;
			else if ( ( (Math.pow(playerX-(X+W),2)) + (Math.pow(playerY-(Y+radius), 2)) ) <= Math.pow(radius, 2))
				count++;

		}
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();

	}
}
