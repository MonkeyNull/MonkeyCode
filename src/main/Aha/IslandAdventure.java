import java.util.ArrayDeque;
import java.util.Queue;

public class IslandAdventure {
    //����̽��

    //������ͼ
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

    //������¼
    int[][] book = new int[55][55];

    //���巽������
    int[][] next = { {0,1}, {1,0}, {0,-1}, {-1,0}};

    //������ʱ����
    int tx,ty,n,m;

    int sum = 0;

    //�������ʵ��
//    void dfs(int x,int y){
//        //ö���ĸ�����
//        for (int i = 0; i <= 3; i++) {
//            //������һ��������
//            tx = x + next[i][0];
//            ty = y + next[i][1];
//            //�ж��Ƿ���½��
//            if (tx < 1 || tx > n || ty < 1 || ty > m)
//                continue;
//            //�ж��Ƿ���½��
//            if (map[tx][ty] > 0 && book[tx][ty] == 0) {
//                sum++;
//                book[tx][ty] = 1;
//                dfs(tx, ty);
//            }
//        }
//    }


    //�������ʵ��
    void dfs(int x,int y,int color){
        //�Ը��ӽ���Ⱦɫ
        map[x][y] = color;
        //ö���ĸ�����
        for (int i = 0; i <= 3; i++) {
            //������һ��������
            tx = x + next[i][0];
            ty = y + next[i][1];
            //�ж��Ƿ�Խ��
            if (tx < 0 || tx >= n || ty < 0 || ty >= m)
                continue;
            //�ж��Ƿ���½��
            if (map[tx][ty] > 0 && book[tx][ty] == 0) {
                book[tx][ty] = 1;
                dfs(tx, ty, color);
            }
        }
    }

    //floodfill�㷨��ѯ��ͼ���ж��ٶ����Ĺµ�
    int num = 0;
    void floodfill(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    num--;//С����ҪȾ����ɫ�ı��
                    //ÿ����һ��С��Ӧ��Ⱦ��ͬ����ɫ
                    book[i][j] = 1;
                    dfs(i, j, num);
                }
            }
        }
        //���Ⱦɫ��ĵ�ͼ
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //�������
    class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    void wfs(int x, int y){
        //�½�����
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        Node node = new Node(x,y);
        book[x][y] = 1;
        queue.add(node);
        sum = 1;
        Node tempNode;
        while (!queue.isEmpty()){
            //ö���ĸ�����
            for (int i = 0; i <= 3; i++) {
                //������һ���������
                tempNode = queue.peek();
                tx = tempNode.x + next[i][0];
                ty = tempNode.y + next[i][1];

                //�ж��Ƿ�Խ��
                if (tx < 1 || tx > n || ty < 1 || ty > m)
                    continue;
                //�ж��Ƿ���½��
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
