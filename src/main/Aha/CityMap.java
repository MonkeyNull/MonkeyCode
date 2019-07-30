import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CityMap {
    //城市地图
    int map[][] = new int[101][101];
    //记录book
    int book[] = new int[101];
    //最短路径
    int min = 10000;
    //记录走过的路径
    ArrayList<Integer> arrayList = new ArrayList<>();
    //存放最短路径
    String minPath;
    int n,m;
    void dfs(int cur,int dis){
        if (dis > min)
            return;
        //走到了指定路径
        if (cur == n){
            if (dis < min){
                min = dis;
                minPath = arrayList.toString();
                return;
            }
        }
        //遍历图看哪一个点与当前点链接
        for (int i = 1; i <= n ; i++) {
            //判断当前顶点到n是否有边
            if (map[cur][i] > 0 && book[i] == 0){
                //记录
                book[i] = 1;
                //将该点加入
                arrayList.add(cur);
                //将权重加入
                dfs(i,dis + map[cur][i]);
                book[i] = 0;
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }


    //图的广度优先遍历，查询最少转机次数
    //定义结构体
    class Node{
        int terminal;
        int time;

        public Node(int terminal, int time) {
            this.terminal = terminal;
            this.time = time;
        }
    }

    void wfs(int start, int end){

        //定义埋点用来跳出双循环
        boolean flag = false;

        //新建队列
        ArrayDeque<Node> deque = new ArrayDeque<>();
        //初始化第一个节点，并且入队
        deque.add(new Node(start,1));
        book[start] = 1;

        //开始尝试将其他节点入队
        while (!deque.isEmpty()){

            Node temp = deque.poll();
            //寻找有关系的节点
            for (int i = 1; i <= n ; i++) {
                if (map[temp.terminal][i] > 0 && book[i] == 0){
                    deque.add(new Node(i,temp.time + 1));
                    book[i] = 1;
                }
                //如果到达目的地则停止扩展
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
        //初始化二维矩阵
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
        //读入顶点之间的边
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

    //初始化有向图关系
    void writeDirected(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= this.m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            this.map[a][b] = c;
        }
    }

    //初始化无向图关系
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
