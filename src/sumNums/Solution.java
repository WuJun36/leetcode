package sumNums;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C)
 * 限制：1<=n<=10000
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(sumNums(9));
    }

    /**
     * 用递归实现，利用逻辑运算符的短路性质来确定递归的出口
     * A&&B，如果A为False，B就不会再执行
     * A||B，如果A为true，B就不会再执行
     *
     * @param n
     * @return
     */
    public static int sumNums(int n) {
//        boolean flag = (n > 0) && (n += sumNums(n - 1)) > 0;
        boolean flag = (n <= 0) || (n += sumNums(n - 1)) > 0;
        return n;
    }


}
