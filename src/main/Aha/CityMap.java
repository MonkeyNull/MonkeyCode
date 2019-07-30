import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CityMap {
    //���е�ͼ
    int map[][] = new int[101][101];
    //��¼book
    int book[] = new int[101];
    //���·��
    int min = 10000;
    //��¼�߹���·��
    ArrayList<Integer> arrayList = new ArrayList<>();
    //������·��
    String minPath;
    int n,m;
    void dfs(int cur,int dis){
        if (dis > min)
            return;
        //�ߵ���ָ��·��
        if (cur == n){
            if (dis < min){
                min = dis;
                minPath = arrayList.toString();
                return;
            }
        }
        //����ͼ����һ�����뵱ǰ������
        for (int i = 1; i <= n ; i++) {
            //�жϵ�ǰ���㵽n�Ƿ��б�
            if (map[cur][i] > 0 && book[i] == 0){
                //��¼
                book[i] = 1;
                //���õ����
                arrayList.add(cur);
                //��Ȩ�ؼ���
                dfs(i,dis + map[cur][i]);
                book[i] = 0;
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }


    //ͼ�Ĺ�����ȱ�������ѯ����ת������
    //����ṹ��
    class Node{
        int terminal;
        int time;

        public Node(int terminal, int time) {
            this.terminal = terminal;
            this.time = time;
        }
    }

    void wfs(int start, int end){

        //���������������˫ѭ��
        boolean flag = false;

        //�½�����
        ArrayDeque<Node> deque = new ArrayDeque<>();
        //��ʼ����һ���ڵ㣬�������
        deque.add(new Node(start,1));
        book[start] = 1;

        //��ʼ���Խ������ڵ����
        while (!deque.isEmpty()){

            Node temp = deque.poll();
            //Ѱ���й�ϵ�Ľڵ�
            for (int i = 1; i <= n ; i++) {
                if (map[temp.terminal][i] > 0 && book[i] == 0){
                    deque.add(new Node(i,temp.time + 1));
                    book[i] = 1;
                }
                //�������Ŀ�ĵ���ֹͣ��չ
                if (temp.terminal == end){
                   flag = true;
                   break;
                }
            }
            if (flag){
                System.out.println(temp.time);
                break;
            }
        }
    }

    public static void main(String[] args) {
        //��ʼ����ά����
        Scanner scanner = new Scanner(System.in);
        CityMap graph = new CityMap();
        graph.n = scanner.nextInt();
        graph.m = scanner.nextInt();
        for (int i = 1; i <= graph.n ; i++) {
            for (int j = 1; j <= graph.m ; j++) {
                if (i == j) graph.map[i][j] = 0;
                else graph.map[i][j] = -1;
            }
        }
        //���붥��֮��ı�
        int start = scanner.nextInt();
        int end = scanner.nextInt();
//        graph.writeUndirected();
        for (int i = 1; i <= graph.m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.map[a][b] = 1;
            graph.map[b][a] = 1;
        }
        graph.wfs(start,end);
    }

    //��ʼ������ͼ��ϵ
    void writeDirected(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= this.m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            this.map[a][b] = c;
        }
    }

    //��ʼ������ͼ��ϵ
    private void writeUndirected(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= this.m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            this.map[a][b] = 1;
            this.map[b][a] = 1;
        }
    }
}
