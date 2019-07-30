import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

public class PlumberOfGame {
    //水管工游戏
    int map[][] = {{5,3,5,3},
            {1,5,3,0},
            {2,3,5,1},
            {6,1,1,5},
            {1,5,5,4}};
    int book[][] = new int[50][50];
    Stack<String> stack = new Stack<String>();
    boolean flag = false;
    int n,m;
    void dfs(int x, int y, int front){

        //判断是否到达总终点
        //判断是否到达终点一定要放在越界判断前边
        if (x <= n - 1 && y == m){
            flag = true;
            while (!stack.isEmpty()){
                System.out.println(stack.pop());
            }
            return;
        }

        //判断是否越界
        if (x < 0 || x >= n || y < 0 || y >= m)
            return;

        //判断这个路径是否已经使用过了。
        if (book[x][y] == 1)
            return;

        //标记此路径
        book[x][y] = 1;
        stack.push("(" + x +" "+ y + " "+ ")");

        //当前水管是直管的情况下
        if (map[x][y] >= 5 && map[x][y] <= 6){
            //进水口在左边
            if (front == 1)
                dfs(x,y+1,1);
            //进水口在上边
            if (front == 2)
                dfs(x+1,y,2);
            //进水口在右边
            if (front == 3)
                dfs(x,y-1,3);
            //进水口在下边
            if (front ==4)
                dfs(x-1,y,4);
        }
        //当前水管是弯的情况下
        if (map[x][y] >= 1 && map[x][y] <= 4){
            //进水口在左边
            if (front == 1) {
                dfs(x + 1, y, 2);//三号状态
                dfs(x - 1, y, 4);//四号状态
            }

            //进水口在上边
            if (front == 2){
                dfs(x,y+1,1);//一号状态
                dfs(x,y-1,3);//四号状态
            }

            //进水口在右边
            if (front == 3){
               dfs(x-1,y,4);//一号状态
               dfs(x+1,y,2);//二号状态
            }
            //进水口在下边
            if (front ==4){
                dfs(x,y+1,1);//二号状态
                dfs(x, y-1, 3);//三号状态
            }
        }
        book[x][y] = 0;
        if (!stack.isEmpty()){
            stack.pop();
        }
    }

    public static void main(String[] args) {
        PlumberOfGame s = new PlumberOfGame();
        s.n = 5;
        s.m = 4;
        s.dfs(0,0,1);
        System.out.println(s.flag);
    }
}
