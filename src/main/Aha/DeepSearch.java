import java.util.Scanner;

public class DeepSearch {

    //不撞南墙不回头，深度优先搜索

    //
    int a[] = new int[10];
    //
    int[] book = new int[10];
    //
    int n;

    public void dfs(int step){
        //
        int i;
        //如果站在第n + 1 个盒子面前，表示前n个盒子已经放满了。
        if (step == n + 1){
            //输出一种排列
            for (i = 1; i <= n; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
            //返回之前调用的那一步。
        }

        //此时站在是第step个盒子面前，应该放哪张牌呢
        //按照1.2，3，4的顺序一一尝试
        for (i = 1; i <= n; i++){//等于零表示扑克牌还在手上
            //判断扑克牌i是否还在手上
            if (book[i] == 0){
                a[step] = i;//使用扑克牌
                book[i] = 1;//将i扑克牌标记为已使用
                //第step个盒子已经放置好扑克牌，接下来需要走到下一个盒子面前
                dfs(step + 1);
                book[i] = 0;//将刚才尝试的扑克牌收回，才能进行下一次尝试。
            }
        }
        return;
    }

    public static void main(String[] args) {
        DeepSearch deepSearch = new DeepSearch();
        Scanner scanner = new Scanner(System.in);
        deepSearch.n = scanner.nextInt();
        deepSearch.dfs(1);
    }


}
