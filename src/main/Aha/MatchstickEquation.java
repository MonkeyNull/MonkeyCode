import java.util.Scanner;

public class MatchstickEquation {
    //火柴棍等式

    //记录每个数字需要的火柴数
    static int[] arr = {6,2,5,5,4,5,6,3,7,6};
    //记录每个单元所需要的火柴数
    static int count = 0;
    //记录总共所需要的火柴数
    static int totalSum = 0;

    static int getSingleSum(int num){
        int res = 0;
        while (num >= 10){
            res += arr[num % 10];
            num = num / 10;
        }
        res += arr[num];
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < 1111; i++){
            for (int j = 0; j < 1111; j++) {
                totalSum = getSingleSum(i) + getSingleSum(j) + getSingleSum(i + j);
                if (totalSum == n - 4){
                    System.out.println(i + "+" + j + "=" + (i+j));
                    count++;
                }
            }
        }
    }
}
