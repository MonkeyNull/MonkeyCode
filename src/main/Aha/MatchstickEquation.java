import java.util.Scanner;

public class MatchstickEquation {
    //������ʽ

    //��¼ÿ��������Ҫ�Ļ����
    static int[] arr = {6,2,5,5,4,5,6,3,7,6};
    //��¼ÿ����Ԫ����Ҫ�Ļ����
    static int count = 0;
    //��¼�ܹ�����Ҫ�Ļ����
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
