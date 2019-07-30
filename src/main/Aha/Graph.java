import java.util.Scanner;

public class Graph {

    //ͼ�ı����㷨

    int[] book = new int[101];
    int map[][] = new int[101][101];
    int sum,n,m;

    void dfs(int cur){
        int i ;
        System.out.println(cur);
        sum++;//ÿ����һ���㣬sum�ͼ�һ
        if (sum == n)
            return; //���ж��㶼������ϣ�ֱ���˳�
        for (i = 1; i <= n; i++){
            if (map[cur][i] == 1 && book[i] == 0){
                book[i] = 1;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        //��ʼ����ά����
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();
        graph.n = scanner.nextInt();
        graph.m = scanner.nextInt();
        for (int i = 1; i <= graph.n ; i++) {
            for (int j = 1; j <= graph.m ; j++) {
                if (i == j) graph.map[i][j] = 0;
                else graph.map[i][j] = 9999999;
            }
        }

        //���붥��֮��ı�
        for (int i = 1; i <= graph.m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.map[a][b] = 1;
            graph.map[b][a] = 1;
        }

        graph.book[1] = 1;
        graph.dfs(1);
    }
}
