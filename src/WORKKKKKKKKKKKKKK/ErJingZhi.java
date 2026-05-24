package WORKKKKKKKKKKKKKK;
import java.util.Scanner;

public class ErJingZhi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个十进制正整数：");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("输入的数字不合法！");
            return;
        }
        String binary = Integer.toBinaryString(n);
        System.out.println("对应的二进制数是：" + binary);

    }
}
