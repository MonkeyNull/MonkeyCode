import java.util.Scanner;

public class Dljkstra {

    //��Դ���·���㷨

    public static void main(String[] args) {

        int map[][] = new int[10][10];
        int[] dis = new int[10];
        int[] book = new int[10];
        int n,m;
        int inf = 999999;
        int min;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        //��ʼ��ͼ
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n ; j++) {
                if (i == j) map[i][j] = 0;
                else map[i][j] = inf;
            }
        }
        int a,b,c;
        //��ͼ���·��
        for (int i = 1; i <= m; i++) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                c = scanner.nextInt();
                map[a][b] = c;
        }
        //��ʼ��dis
        for (int i = 1; i <= n ; i++)
            dis[i] = map[1][i];

        book[1] = 1;

        //dijkstra�㷨�������
         int u = 1;
        for (int i = 1; i <= n ; i++) {
            //�ҵ���1�Ŷ�������ĵ�
            min = inf;
            for (int j = 1; j <= n ; j++) {
                if (book[j] == 0 && dis[j] < min){
                    min = dis[j];
                    u = j;
                }
            }
            book[u] = 1;
            for (int j = 1; j <= n ; j++) {
                if (map[u][j] < inf){
                    if (dis[j] > dis[u] + map[u][j]){
                        dis[j] = dis[u] + map[u][j];
                    }
                }
            }
        }
        //������ս��
        for (int i = 1; i <= n ; i++)
            System.out.printf("%d ", dis[i]);
    }
}
