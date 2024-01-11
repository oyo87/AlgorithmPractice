import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
        이진트리 노드의 개수 : 1~26(알파뱃순서로 주어짐)

        전위, 중위, 후위 순회하기
        직접 클래스, 생성자 만들고
        각 순회방법규칙에 맞게 순회하는 방식으로 진행
     */

    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
        }
    }

    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char value = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            int nowIndex = value - 'A';

            if (nodes[nowIndex] == null) {
                nodes[nowIndex] = new Node(value);
            }

            if (left != '.') {
                nodes[left - 'A'] = new Node(left);
                nodes[nowIndex].left = nodes[left - 'A'];
            }
            if (right != '.') {
                nodes[right - 'A'] = new Node(right);
                nodes[nowIndex].right = nodes[right - 'A'];
            }


        }

        //전위 중->왼->오
        preOrder(nodes[0]);
        answer.append("\n");

        //중위 왼->중->오
        inOrder(nodes[0]);
        answer.append("\n");

        //후위 왼->오->중
        postOrder(nodes[0]);

        System.out.print(answer);

    }

    static void preOrder(Node node) {

        if (node == null)
            return;

        char value = node.value;
        Node left = node.left;
        Node right = node.right;

        answer.append(value);
        preOrder(left);
        preOrder(right);
    }

    static void inOrder(Node node) {

        if (node == null)
            return;

        char value = node.value;
        Node left = node.left;
        Node right = node.right;

        inOrder(left);
        answer.append(value);
        inOrder(right);
    }

    static void postOrder(Node node) {

        if (node == null)
            return;

        char value = node.value;
        Node left = node.left;
        Node right = node.right;

        postOrder(left);
        postOrder(right);
        answer.append(value);
    }

}