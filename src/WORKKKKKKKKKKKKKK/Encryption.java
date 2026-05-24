package WORKKKKKKKKKKKKKK;

import java.util.Scanner;

public class Encryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("请输入一个字符串:");
            String str = scanner.nextLine();
            System.out.println("原字符串是:" + str);

            StringBuilder result = new StringBuilder(str);
            for (int i = 0; i < result.length(); i++) {
                char c = result.charAt(i);
                if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                    if ((c > 'U' && c <= 'Z') || (c > 'u' && c <= 'z')) {
                        c = (char) (c - 21);
                    } else {
                        c = (char) (c + 5);
                    }
                    result.setCharAt(i, c);
                }
            }
            System.out.println("加密后的字符串是:" + result);
        } finally {
            scanner.close();
        }
    }
}
