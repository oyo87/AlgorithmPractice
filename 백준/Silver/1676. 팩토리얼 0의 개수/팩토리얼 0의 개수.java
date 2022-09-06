import java.math.BigInteger;
import java.util.Scanner;

//팩토리얼 값을 끝에서부터 보는법
//그냥 계산하면 숫자가 너무 크니 불가
//빅인티저? 소인수분해5와 2 의 개수
//소인수분해가 더 빠르고좋겠지만 연습겸 빅인티저를 사용해보자.
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		BigInteger bi = new BigInteger("1");
		int zeroCount = 0;
		for (int i = 2; i <= N; i++) {
			BigInteger temp = new BigInteger(Integer.toString(i));
			bi = bi.multiply(temp);
		}

		String num = bi.toString();
		for (int i = 1; i < num.length(); i++) {
			if (num.charAt(num.length() - i) == '0')
				zeroCount++;
			else
				break;
		}
		System.out.println(zeroCount);
	}
}
