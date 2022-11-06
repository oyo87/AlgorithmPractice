import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

//분할정복
//빅인티저사용해도 시간초과없이되려나?
public class Main {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	BigInteger A = new BigInteger(st.nextToken());
	BigInteger B = new BigInteger(st.nextToken());
	BigInteger C = new BigInteger(st.nextToken());
	//A*B / C
	System.out.println(A.modPow(B, C));
}
}