import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

public class PlumberOfGame {
    //ˮ�ܹ���Ϸ
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

        //�ж��Ƿ񵽴����յ�
        //�ж��Ƿ񵽴��յ�һ��Ҫ����Խ���ж�ǰ��
        if (x <= n - 1 && y == m){
            flag = true;
            while (!stack.isEmpty()){
                System.out.println(stack.pop());
            }
            return;
        }

        //�ж��Ƿ�Խ��
        if (x < 0 || x >= n || y < 0 || y >= m)
            return;

        //�ж����·���Ƿ��Ѿ�ʹ�ù��ˡ�
        if (book[x][y] == 1)
            return;

        //��Ǵ�·��
        book[x][y] = 1;
        stack.push("(" + x +" "+ y + " "+ ")");

        //��ǰˮ����ֱ�ܵ������
        if (map[x][y] >= 5 && map[x][y] <= 6){
            //��ˮ�������
            if (front == 1)
                dfs(x,y+1,1);
            //��ˮ�����ϱ�
            if (front == 2)
                dfs(x+1,y,2);
            //��ˮ�����ұ�
            if (front == 3)
                dfs(x,y-1,3);
            //��ˮ�����±�
            if (front ==4)
                dfs(x-1,y,4);
        }
        //��ǰˮ������������
        if (map[x][y] >= 1 && map[x][y] <= 4){
            //��ˮ�������
            if (front == 1) {
                dfs(x + 1, y, 2);//����״̬
                dfs(x - 1, y, 4);//�ĺ�״̬
            }

            //��ˮ�����ϱ�
            if (front == 2){
                dfs(x,y+1,1);//һ��״̬
                dfs(x,y-1,3);//�ĺ�״̬
            }

            //��ˮ�����ұ�
            if (front == 3){
               dfs(x-1,y,4);//һ��״̬
               dfs(x+1,y,2);//����״̬
            }
            //��ˮ�����±�
            if (front ==4){
                dfs(x,y+1,1);//����״̬
                dfs(x, y-1, 3);//����״̬
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
