import java.util.Scanner;

public class DeepSearch {

    //��ײ��ǽ����ͷ�������������

    //
    int a[] = new int[10];
    //
    int[] book = new int[10];
    //
    int n;

    public void dfs(int step){
        //
        int i;
        //���վ�ڵ�n + 1 ��������ǰ����ʾǰn�������Ѿ������ˡ�
        if (step == n + 1){
            //���һ������
            for (i = 1; i <= n; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
            //����֮ǰ���õ���һ����
        }

        //��ʱվ���ǵ�step��������ǰ��Ӧ�÷���������
        //����1.2��3��4��˳��һһ����
        for (i = 1; i <= n; i++){//�������ʾ�˿��ƻ�������
            //�ж��˿���i�Ƿ�������
            if (book[i] == 0){
                a[step] = i;//ʹ���˿���
                book[i] = 1;//��i�˿��Ʊ��Ϊ��ʹ��
                //��step�������Ѿ����ú��˿��ƣ���������Ҫ�ߵ���һ��������ǰ
                dfs(step + 1);
                book[i] = 0;//���ղų��Ե��˿����ջأ����ܽ�����һ�γ��ԡ�
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
