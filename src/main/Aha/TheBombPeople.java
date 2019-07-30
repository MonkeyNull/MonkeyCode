import java.util.ArrayDeque;
import java.util.Queue;

public class TheBombPeople {

    //ը����
    //���巽������
    int[][] next =  {{0,1},{1,0},{-1,0},{0,-1}};

    //�����ͼ
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

    //��¼ը�����߹���λ��
    int[][] book = new int[13][13];

    //������ʱ���� x,t
    int tx,ty;

    //ĳ�����������ĵ��� �������ĵ���
    int sum,max;

    int n = 13;
    int m = 13;

    //����ڵ�
    class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //���ÿ����ҵ�ը���˿��Ե���Щλ��
    void wds(int x, int y){
        //ʹ�ö��н��д洢�ڵ�
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(x,y));
        max = getnum(x,y);
        while (!queue.isEmpty()){
            Node node = queue.peek();
            //������ͬ������Ե��ĵط�
            for (int i = 0; i <= 3; i++) {
                tx = node.x + next[i][0];
                ty = node.y + next[i][1];
                if (tx < 0 || tx > n - 1 || ty < 0 || ty > m - 1)
                    continue;
                //�ж��Ƿ�Ϊƽ�ػ����Ƿ������߹�
                if (map[tx][ty] == '.' && book[tx][ty] == 0){
                    book[tx][ty] = 1;
                    queue.add(new Node(tx,ty));
                    //ͳ�Ƹõ��������ĵ���
                    sum = getnum(tx,ty);
                    if (sum > max)
                        max = sum;
                }
            }
            System.out.println(max);
            queue.poll();
        }
    }

    //ʹ���������
    void dsf(int x, int y){
        //���㵱ǰ��Ŀ�������ĵ�������
         sum = getnum(x,y);
         if (sum > max)
             max = sum;

         //ö���ĸ�����
        for (int k = 0; k <= 3; k++) {
            tx = x + next[k][0];
            ty = y + next[k][1];

            //�ж��Ƿ�Խ��
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
        //����ͳ��
        while (map[tx][ty] != '#'){
            //�����ǰ�ǵ��ˣ�����м���
            if(map[tx][ty] == 'G')
                tempSum++;
            tx++;
        }

        tx = x; ty = y;
        //����ͳ��
        while (map[tx][ty] != '#'){
            //�����ǰ�ǵ��ˣ�����м���
            if(map[tx][ty] == 'G')
                tempSum++;
            tx--;
        }

        tx = x; ty = y;
        //����ͳ��
        while (map[tx][ty] != '#'){
            //�����ǰ�ǵ��ˣ�����м���
            if(map[tx][ty] == 'G')
                tempSum++;
            ty++;
        }

        tx = x; ty = y;
        //����ͳ��
        while (map[tx][ty] != '#'){
            //�����ǰ�ǵ��ˣ�����м���
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
