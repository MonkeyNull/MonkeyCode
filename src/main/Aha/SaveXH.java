import java.util.ArrayDeque;
import java.util.Queue;

public class SaveXH {
    //解救小哈
    //存放地图的二维数组
    int[][] a = {{},{0,0,0,1,0},{0,0,0,0,0},{0,0,0,1,0},{0,0,1,0,0},{0,0,0,0,1}};
    //记录该点是否走过
    int[][] book = new int[6][5];
    //定义方向数组
    int[][] next = { {0,1}, {1,0}, {0,-1}, {-1,0}};
    int p,q,k,tx,ty,n,m;
    int min = 9999999;//记录最短路径

    //深度优先实现算法
    void dfs(int x, int y,int step){
        //判断是否到达小哈的位置
        if (x == p && y ==q){
            //更新最小值
            if (step < min)
                min = step;
            return;
        }
        //没有到小哈的位置
        //定义方向数组
        int[][] next = { {0,1}, {1,0}, {0,-1}, {-1,0}};
        for (k = 0; k <= 3; k++){
            //计算的下一个点的坐标
            tx = x + next[k][0];
            ty = y + next[k][1];

            //判断是否越界
            if (tx < 1 || tx > n || ty < 1 || ty > m)
                continue;
            //判断该点是否为障碍物或者已经在路径中
//            System.out.println(tx + " " + ty);
            if (a[tx][ty] == 0 && book[tx][ty] == 0){
                book[tx][ty] = 1;//标记这个点已经走过
                dfs(tx, ty, step + 1);//开始尝试下一个点
                book[tx][ty] = 0;//尝试结束，取消这个点的标记
            }
        }
        return;
    }

    //广度优先实现算法
    //定义一个节点记录x,y和步数
    class Node{
        int x;
        int y;
        int s;//步数
        public Node(int x, int y, int s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }

    //定义一个队列存放走过的坐标点
//    Queue<Node> queue = new ArrayDeque<>();
    ArrayDeque<Node> queue = new ArrayDeque();
    void wsf(){
        queue.addLast(new Node(1,1,0));
//        queue.add(new Node(1,1,0));
        boolean flag = false;
        while (!queue.isEmpty()){
            Node node = queue.peekFirst();
            //枚举四个方向
            for (k = 0; k <= 3; k++) {
                tx = node.x + next[k][0];
                ty = node.y + next[k][1];
            //判断是否越界
            if (tx < 1 || tx > n || ty < 1 || ty > m)
                continue;
            //判断是否是障碍物或者已经在路径中了
            if (a[tx][ty] == 0 && book[tx][ty] == 0){
                //把这个点标记为已经走过
                book[tx][ty] = 1;
                queue.addLast(new Node(tx,ty,node.s + 1));
            }
            if (tx == p && ty == q){
                flag = true;
                break;
            }
        }
            if (flag){
                System.out.println();
                break;
            }
            queue.pollFirst();
        }
    }


    public static void main(String[] args) {
        SaveXH saveXH = new SaveXH();
        saveXH.n = 5;
        saveXH.m = 4;
        saveXH.p = 4;
        saveXH.q = 3;
        int startx = 1;
        int starty = 1;
        saveXH.book[startx][starty] = 1;
//        saveXH.dfs(startx,starty,0);
        saveXH.wsf();
        System.out.println(saveXH.queue.peekLast().s);
    }


}
