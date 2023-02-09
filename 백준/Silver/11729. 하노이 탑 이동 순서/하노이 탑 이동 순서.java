import java.util.*;

public class Main {
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        hanoi(n, 1, 2, 3);
        System.out.println(cnt);
        System.out.print(sb);
    }
    private static void hanoi(int n, int from, int by, int to) {
        cnt++;
        if (n == 1) {
            sb.append(from + " " + to + "\n");
            return;
        }
        hanoi(n - 1, from, to, by);
        sb.append(from + " " + to + "\n");
        hanoi(n - 1, by, from, to);
    }
}