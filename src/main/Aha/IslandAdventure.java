import java.util.ArrayDeque;
import java.util.Queue;

public class IslandAdventure {
    //宝岛探险

    //创建地图
    int[][] map = {{1,2,1,0,0,0,0,0,2,3},
            {3,0,2,0,1,2,1,0,1,2},
            {4,0,1,0,1,2,3,2,0,1},
            {3,2,0,0,0,1,2,4,0,0},
            {0,0,0,0,0,0,1,5,3,0},
            {0,1,2,1,0,1,5,4,3,0},
            {0,1,2,3,1,3,6,2,1,0},
            {0,0,3,4,8,9,7,5,0,0},
            {0,0,0,3,7,8,6,0,1,2},
            {0,0,0,0,0,0,0,0,1,0}};

    //创建记录
    int[][] book = new int[55][55];

    //定义方向数组
    int[][] next = { {0,1}, {1,0}, {0,-1}, {-1,0}};

    //定义临时变量
    int tx,ty,n,m;

    int sum = 0;

    //深度搜索实现
//    void dfs(int x,int y){
//        //枚举四个方向
//        for (int i = 0; i <= 3; i++) {
//            //计算下一步的坐标
//            tx = x + next[i][0];
//            ty = y + next[i][1];
//            //判断是否是陆地
//            if (tx < 1 || tx > n || ty < 1 || ty > m)
//                continue;
//            //判断是否是陆地
//            if (map[tx][ty] > 0 && book[tx][ty] == 0) {
//                sum++;
//                book[tx][ty] = 1;
//                dfs(tx, ty);
//            }
//        }
//    }


    //深度搜索实现
    void dfs(int x,int y,int color){
        //对格子进行染色
        map[x][y] = color;
        //枚举四个方向
        for (int i = 0; i <= 3; i++) {
            //计算下一步的坐标
            tx = x + next[i][0];
            ty = y + next[i][1];
            //判断是否越界
            if (tx < 0 || tx >= n || ty < 0 || ty >= m)
                continue;
            //判断是否是陆地
            if (map[tx][ty] > 0 && book[tx][ty] == 0) {
                book[tx][ty] = 1;
                dfs(tx, ty, color);
            }
        }
    }

    //floodfill算法查询地图中有多少独立的孤岛
    int num = 0;
    void floodfill(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    num--;//小岛需要染的颜色的编号
                    //每发现一个小岛应该染不同的颜色
                    book[i][j] = 1;
                    dfs(i, j, num);
                }
            }
        }
        //输出染色后的地图
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //广度优先
    class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    void wfs(int x, int y){
        //新建队列
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        Node node = new Node(x,y);
        book[x][y] = 1;
        queue.add(node);
        sum = 1;
        Node tempNode;
        while (!queue.isEmpty()){
            //枚举四个方向
            for (int i = 0; i <= 3; i++) {
                //计算下一个点的坐标
                tempNode = queue.peek();
                tx = tempNode.x + next[i][0];
                ty = tempNode.y + next[i][1];

                //判断是否越界
                if (tx < 1 || tx > n || ty < 1 || ty > m)
                    continue;
                //判断是否是陆地
                if (map[tx][ty] > 0 && book[tx][ty] == 0) {
                    sum++;
                    book[tx][ty] = 1;
                    queue.add(new Node(tx,ty));
                }
            }
            queue.poll();
        }
    }

    public static void main(String[] args) {
        IslandAdventure s = new IslandAdventure();
        s.n = 10;
        s.m = 10;
        s.floodfill();
//        System.out.println(s.sum);
    }

}
