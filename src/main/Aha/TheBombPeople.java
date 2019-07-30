import java.util.ArrayDeque;
import java.util.Queue;

public class TheBombPeople {

    //炸弹人
    //定义方向数组
    int[][] next =  {{0,1},{1,0},{-1,0},{0,-1}};

    //定义地图
    int[][] map = {{'#','#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','G','G','.','G','G','G','#','G','G','G','.','#'},
            {'#','#','#','.','#','G','#','G','#','G','#','G','#'},
            {'#','.','.','.','.','.','.','.','#','.','.','G','#'},
            {'#','G','#','.','#','#','#','.','#','G','#','G','#'},
            {'#','G','G','.','G','G','G','.','#','.','G','G','#'},
            {'#','G','#','.','#','G','#','.','#','.','#','.','#'},
            {'#','#','G','.','.','.','G','.','.','.','.','.','#'},
            {'#','G','#','.','#','G','#','#','#','.','#','G','#'},
            {'#','.','.','.','G','#','G','G','G','.','G','G','#'},
            {'#','G','#','.','#','G','#','G','#','.','#','G','#'},
            {'#','G','G','.','G','G','G','#','G','.','G','G','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#'}};

    //记录炸弹人走过的位置
    int[][] book = new int[13][13];

    //定义临时坐标 x,t
    int tx,ty;

    //某个点可以消灭的敌人 最多消灭的敌人
    int sum,max;

    int n = 13;
    int m = 13;

    //定义节点
    class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //先用宽搜找到炸弹人可以到哪些位置
    void wds(int x, int y){
        //使用队列进行存储节点
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(x,y));
        max = getnum(x,y);
        while (!queue.isEmpty()){
            Node node = queue.peek();
            //遍历不同方向可以到的地方
            for (int i = 0; i <= 3; i++) {
                tx = node.x + next[i][0];
                ty = node.y + next[i][1];
                if (tx < 0 || tx > n - 1 || ty < 0 || ty > m - 1)
                    continue;
                //判断是否为平地或者是否曾经走过
                if (map[tx][ty] == '.' && book[tx][ty] == 0){
                    book[tx][ty] = 1;
                    queue.add(new Node(tx,ty));
                    //统计该点可以消灭的敌人
                    sum = getnum(tx,ty);
                    if (sum > max)
                        max = sum;
                }
            }
            System.out.println(max);
            queue.poll();
        }
    }

    //使用深度搜索
    void dsf(int x, int y){
        //计算当前点的可以消灭的敌人总数
         sum = getnum(x,y);
         if (sum > max)
             max = sum;

         //枚举四个方向
        for (int k = 0; k <= 3; k++) {
            tx = x + next[k][0];
            ty = y + next[k][1];

            //判断是否越界
            if (tx < 0 || tx > n - 1 || ty < 0 || ty > m - 1)
                continue;
            if (map[tx][ty] == '.' && book[tx][ty] == 0){
                book[tx][ty] = 1;
                dsf(tx,ty);
            }
        }
    }

    private int getnum(int x, int y) {
        int tempSum = 0;
        int tx,ty;
        tx = x; ty = y;
        //向下统计
        while (map[tx][ty] != '#'){
            //如果当前是敌人，则进行计数
            if(map[tx][ty] == 'G')
                tempSum++;
            tx++;
        }

        tx = x; ty = y;
        //向上统计
        while (map[tx][ty] != '#'){
            //如果当前是敌人，则进行计数
            if(map[tx][ty] == 'G')
                tempSum++;
            tx--;
        }

        tx = x; ty = y;
        //向右统计
        while (map[tx][ty] != '#'){
            //如果当前是敌人，则进行计数
            if(map[tx][ty] == 'G')
                tempSum++;
            ty++;
        }

        tx = x; ty = y;
        //向左统计
        while (map[tx][ty] != '#'){
            //如果当前是敌人，则进行计数
            if(map[tx][ty] == 'G')
                tempSum++;
            ty--;
        }
        return tempSum;
    }

    public static void main(String[] args) {
        TheBombPeople demo = new TheBombPeople();
        demo.dsf(3,3);
        System.out.println(demo.max);
    }

}
