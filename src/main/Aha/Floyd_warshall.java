import java.util.Scanner;

public class Floyd_warshall {

    //求最短路径的floyd_warshall算法

    public static void main(String[] args) {
        int map[][] = new int[10][10];
        int inf = 99999999;
        int n,m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if (i == j) map[i][j] = 0;
                map[i][j] = inf;
            }
        }

        //初始化路径
        for (int i = 1; i <= m ; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            map[a][b] = c;
        }

        //flodyd_warshall算法求最短路径
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (map[i][j] > map[i][k] + map[k][j])
                        map[i][j] = map[i][k] + map[k][j];

        //输出最后的结果
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.printf("%10d",map[i][j]);
            }
        }
    }

}
