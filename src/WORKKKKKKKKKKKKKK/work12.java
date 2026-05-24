package WORKKKKKKKKKKKKKK;

public class work12 {
    public static void main(String[] args) {
        int[] f = new int[20];  // 定义数组存储Fibonacci数

        // 前两个数均为1
        f[0] = 1;
        f[1] = 1;

        // 计算后续的Fibonacci数
        for (int i = 2; i < 20; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        // 输出结果
        for (int i = 0; i < 20; i++) {
            System.out.println("f[" + i + "] = " + f[i]);
        }
    }
}
