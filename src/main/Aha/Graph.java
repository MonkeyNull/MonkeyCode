import java.util.Scanner;

public class Graph {

    //图的遍历算法

    int[] book = new int[101];
    int map[][] = new int[101][101];
    int sum,n,m;

    void dfs(int cur){
        int i ;
        System.out.println(cur);
        sum++;//每访问一顶点，sum就加一
        if (sum == n)
            return; //所有定点都访问完毕，直接退出
        for (i = 1; i <= n; i++){
            if (map[cur][i] == 1 && book[i] == 0){
                book[i] = 1;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        //初始化二维矩阵
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

        //读入顶点之间的边
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
