import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord {

    //单元最短路径算法


    public static void main(String[] args) {
        int dis[] = new int[10];
        int u[] = new int[10];
        int v[] = new int[10];
        int w[] = new int[10];
        int inf = 99999999;
        //定点数
        int n;
        //边数
        int m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        for (int i = 1; i <= m ; i++) {
            u[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }

        //初始化dis数组
        for (int i = 1; i <= n ; i++) {
            dis[i] = inf;
        }
        dis[1] = 0;

        //Bellman-Ford核心算法
        for (int k = 1; k <= n - 1; k++) {
            for (int i = 1; i <= m ; i++) {
                if (dis[v[i]] > dis[u[i]] + w[i])
                    dis[v[i]] = dis[u[i]] + w[i];
            }
        }
        System.out.println(Arrays.toString(dis));
    }
}
