import java.util.Scanner;

public class GameofCard {

    //纸牌游戏 小猫钓鱼

    public static void main(String[] args) {
        queue q1,q2;
        stack s = new stack();
        q1 = new queue();
        q2 = new queue();
        q1.head = 1;
        q2.head = 1;
        q1.tail = 1;
        q2.tail = 1;
        s.top = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("给小哼发牌！");
        //初始化小哼的牌
        for (int i = 1; i <= 6; i++) {
            q1.data[i] = scanner.nextInt();
            q1.tail++;
        }
        System.out.println("给小哈发牌！");
        //初始化小哈的牌
        for (int i = 1; i <= 6; i++) {
            q2.data[i] = scanner.nextInt();
            q2.tail++;
        }

        while (q1.head < q1.tail && q2.head < q2.tail) {
            //小哼出牌
            int t = q1.data[q1.head];
            //看桌面上有没有相同的牌
            boolean flag = false;
            for (int i = 1; i <= s.top; i++) {
                if (t == s.data[i]) {
                    flag = true;
                    break;
                }
            }
            //如果桌面没有相同的牌
            if (!flag) {
                //小哼此轮没有赢牌
                q1.head++;
                s.top++;
                s.data[s.top] = t;
            }
            //如果桌面有相同的牌
            if (flag) {
                //小哼此轮赢牌
                q1.head++;
                q1.data[q1.tail] = t;
                q1.tail++;
                while (s.data[s.top] == t) {
                    q1.data[q1.tail] = s.data[s.top];
                    q1.tail++;
                    s.top--;
                }
            }


            //小哈出牌
            int h = q2.data[q2.head];
            //看桌面上有没有相同的牌
            boolean flag2 = false;
            for (int i = 1; i <= s.top; i++) {
                if (t == s.data[i]) {
                    flag2 = true;
                    break;
                }
            }
            //如果桌面没有相同的牌
            if (!flag2) {
                //小哼此轮没有赢牌
                q2.head++;
                s.top++;
                s.data[s.top] = h;
            }
            //如果桌面有相同的牌
            if (flag2) {
                //小哼此轮赢牌
                q2.head++;
                q2.data[q2.tail] = h;
                q2.tail++;
                while (s.data[s.top] == h) {
                    q2.data[q2.tail] = s.data[s.top];
                    q2.tail++;
                    s.top--;
                }
            }
        }
        if (q2.head == q2.tail){
            System.out.println("小哼Win");
            System.out.println("小哼当前的牌是");
            for (int i = q1.head; i <= q1.tail; i++) {
                System.out.println(q1.data[i]);
            }
            if (s.top > 0){
                System.out.println("桌上的牌是");
                for (int i = 1; i <= s.top; i++) {
                    System.out.println(s.data[i]);
                }
            }
            else {
                System.out.println("桌面已经没有牌了！");
            }
        }
        if (q1.head == q1.tail){
            System.out.println("小哈Win");
            System.out.println("小哈手里的牌是");
            for (int i = q1.head; i <= q1.tail ; i++) {
                System.out.println(q2.data[i]);
            }
            if (s.top > 0){
                System.out.println("桌上的牌是");
                for (int i = 1; i <= s.top; i++) {
                    System.out.println(s.data[i]);
                }
            }
            else {
                System.out.println("桌面已经没有牌了！");
            }
        }
    }



}

class queue{
    int[] data = new int[1000];
    int head;
    int tail;
}
class stack{
    int[] data = new int[15];
    int top;
}
