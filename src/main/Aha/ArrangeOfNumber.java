public class ArrangeOfNumber {

    //����ȫ����

    public static void main(String[] args) {
        //����һ����¼���¼�Ѿ�ʹ�ù�����
        int[] recordArr = new int[10];
        //�����α�����
        int[] a = new int[10];
        for (a[1] = 1; a[1] < 10; a[1]++){
            for (a[2] = 1; a[2] < 10; a[2]++){
                for (a[3] = 1; a[3] < 10; a[3]++){
                    for (a[4] = 1; a[4] < 10; a[4]++) {
                        for (a[5] = 1; a[5] < 10; a[5]++) {
                            for (a[6] = 1; a[6] < 10; a[6]++) {
                                for (a[7] = 1; a[7] < 10; a[7]++) {
                                    for (a[8] = 1; a[8] < 10; a[8]++) {
                                        for (a[9] = 1; a[9] < 10; a[9]++) {
                                            //���ü�¼��
                                            for (int i = 1; i < 10; i++) {
                                                recordArr[i] = 0;
                                            }
                                            //��¼���ֵ�����
                                            for (int i = 1; i < 10; i++) {
                                                recordArr[a[i]] = 1;
                                            }
                                            if (countArr(recordArr) == 9){
                                                System.out.println(a[1] + " " + a[2] + " " + a[3] + " " + a[4] + " "  + a[5]+ " "  + a[6]+ " "  + a[7]+ " "  + a[8]+ " "  + a[9]+ " " );
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static int countArr(int[] arr) {
        int sum = 0;
        for (int num:arr) {
            sum += num;
        }
        return sum;
    }
}
