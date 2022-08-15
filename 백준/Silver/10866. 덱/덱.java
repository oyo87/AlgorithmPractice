import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

//Deque 사용
//BufferedReader BufferedWriter 학습
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> d = new ArrayDeque<>();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String cmd = br.readLine();
			String[] cmd2 = cmd.split(" ");
			if (cmd2[0].equals("push_front")) {
				d.addFirst(Integer.parseInt(cmd2[1]));
			}

			else if (cmd2[0].equals("push_back")) {
				d.addLast(Integer.parseInt(cmd2[1]));
			}

			else if (cmd2[0].equals("pop_front")) {
				if (d.isEmpty())
					bw.write("-1\n");
				else
					bw.write(d.removeFirst() + "\n");
			}

			else if (cmd2[0].equals("pop_back")) {
				if (d.isEmpty())
					bw.write("-1\n");
				else
					bw.write(d.removeLast() + "\n");
			}

			else if (cmd2[0].equals("size")) {
				bw.write(d.size() + "\n");
			}

			else if (cmd2[0].equals("empty")) {
				if (d.isEmpty())
					bw.write("1\n");
				else
					bw.write("0\n");
			}

			else if (cmd2[0].equals("front")) {
				if (d.isEmpty())
					bw.write("-1\n");
				else
					bw.write(d.getFirst() + "\n");
			}

			else if (cmd2[0].equals("back")) {
				if (d.isEmpty())
					bw.write("-1\n");
				else
					bw.write(d.getLast() + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
