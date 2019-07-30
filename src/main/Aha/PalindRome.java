import java.util.Stack;

public class PalindRome {
    //用栈判断是否是回文字符串

    static boolean PalindRome(String str){
        if (str == null || str.length() < 2)
            return false;
        int mid = (str.length() >> 1) - 1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <= mid; i++) {
            stack.push(str.charAt(i));
        }
        if (str.length() % 2 == 0)
            mid += 1;
        else
            mid += 2;
        for (int i = mid; i < str. length(); i++) {
            if (stack.pop() != str.charAt(i))
                return false;
        }
        if (stack.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(PalindRome("1111"));
    }
}
