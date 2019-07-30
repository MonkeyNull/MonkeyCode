import java.util.ArrayDeque;
import java.util.Queue;

public class SaveXH {
    //���С��
    //��ŵ�ͼ�Ķ�ά����
    int[][] a = {{},{0,0,0,1,0},{0,0,0,0,0},{0,0,0,1,0},{0,0,1,0,0},{0,0,0,0,1}};
    //��¼�õ��Ƿ��߹�
    int[][] book = new int[6][5];
    //���巽������
    int[][] next = { {0,1}, {1,0}, {0,-1}, {-1,0}};
    int p,q,k,tx,ty,n,m;
    int min = 9999999;//��¼���·��

    //�������ʵ���㷨
    void dfs(int x, int y,int step){
        //�ж��Ƿ񵽴�С����λ��
        if (x == p && y ==q){
            //������Сֵ
            if (step < min)
                min = step;
            return;
        }
        //û�е�С����λ��
        //���巽������
        int[][] next = { {0,1}, {1,0}, {0,-1}, {-1,0}};
        for (k = 0; k <= 3; k++){
            //�������һ���������
            tx = x + next[k][0];
            ty = y + next[k][1];

            //�ж��Ƿ�Խ��
            if (tx < 1 || tx > n || ty < 1 || ty > m)
                continue;
            //�жϸõ��Ƿ�Ϊ�ϰ�������Ѿ���·����
//            System.out.println(tx + " " + ty);
            if (a[tx][ty] == 0 && book[tx][ty] == 0){
                book[tx][ty] = 1;//���������Ѿ��߹�
                dfs(tx, ty, step + 1);//��ʼ������һ����
                book[tx][ty] = 0;//���Խ�����ȡ�������ı��
            }
        }
        return;
    }

    //�������ʵ���㷨
    //����һ���ڵ��¼x,y�Ͳ���
    class Node{
        int x;
        int y;
        int s;//����
        public Node(int x, int y, int s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }

    //����һ�����д���߹��������
//    Queue<Node> queue = new ArrayDeque<>();
    ArrayDeque<Node> queue = new ArrayDeque();
    void wsf(){
        queue.addLast(new Node(1,1,0));
//        queue.add(new Node(1,1,0));
        boolean flag = false;
        while (!queue.isEmpty()){
            Node node = queue.peekFirst();
            //ö���ĸ�����
            for (k = 0; k <= 3; k++) {
                tx = node.x + next[k][0];
                ty = node.y + next[k][1];
            //�ж��Ƿ�Խ��
            if (tx < 1 || tx > n || ty < 1 || ty > m)
                continue;
            //�ж��Ƿ����ϰ�������Ѿ���·������
            if (a[tx][ty] == 0 && book[tx][ty] == 0){
                //���������Ϊ�Ѿ��߹�
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
