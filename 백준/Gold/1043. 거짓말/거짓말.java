import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;//사람수
    static int M;//파티수
    static int[] parent;
    static boolean[] knowTruth;

    public static void main(String[] args) throws IOException {
        //사람의 수, 파티의 수
        //진실을 아는 사람의 수, 진실은 아는 사람들의 번호
        //0~M까지 파티마다 오는 사람의 수와 번호가 주어짐
        //과장된 이야기 할수있는 최대 파티의 개수
        //유니온파인드

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람수 1번부터로 계산.
        M = Integer.parseInt(st.nextToken()); // 파티수 0번부터로 계산
        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++)
            parent[i] = i;
        knowTruth = new boolean[N + 1];//진실을 알고있는 인원
        st = new StringTokenizer(br.readLine());
        int knowTruthLength = Integer.parseInt(st.nextToken());
        if (knowTruthLength == 0) {//진실은 아는사람 아무도 없으면 파티수만큼 거짓말가능
            System.out.println(M);
            return;
        }
        for (int i = 0; i < knowTruthLength; i++) {
            knowTruth[Integer.parseInt(st.nextToken())] = true;
        }

        ArrayList<Integer>[] party = new ArrayList[M]; // 파티 리스트
        for (int i = 0; i < party.length; i++) {
            party[i] = new ArrayList<>();
        }

        for (int i = 0; i < party.length; i++) { // 파티리스트에 참여자 추가
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            for (int j = 0; j < len; j++) {
                party[i].add(Integer.parseInt(st.nextToken())); // 파티 참여자
            }
        }

        for (int i = 0; i < party.length; i++) {
            for (int j = 0; j < party[i].size() - 1; j++) {
                union(party[i].get(j), party[i].get(j + 1)); // 파티 참여자 통합
            }
        }

        int answer = M; //출력할 정답 파티수만큼 초기화
        for (int i = 0; i < party.length; i++) {
            for (int j = 0; j < party[i].size(); j++) {
                if (knowTruth[find(party[i].get(j))]) {//진실은 아는 인원이 있다면 진실만 말해야하니 answer--;
                    answer--;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    public static void union(int a, int b) {
        if (find(a) == find(b))
            return;
        if (find(b) < find(a)) { // 작은 인덱스번호로 통합하기 위해 swap
            int temp = a;
            a = b;
            b = temp;
        }
        if (knowTruth[find(a)] || knowTruth[find(b)]) {
            knowTruth[find(a)] = true;
            knowTruth[find(b)] = true;
        }
        parent[find(b)] = find(a);

    }

    public static int find(int num) {
        if (parent[num] == num)
            return num;
        return parent[num] = find(parent[num]);

    }
}