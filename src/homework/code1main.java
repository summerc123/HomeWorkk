package homework;

import java.util.Scanner;

public class code1main {
    private String content = "";
    
    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== 文档排版系统 =====");
            System.out.println("1. 读取文件");
            System.out.println("2. 文档排版");
            System.out.println("3. 字数统计");
            System.out.println("4. 保存文件");
            System.out.println("5. 退出");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    content = new code2read().load(sc);
                    if (!content.isEmpty()) {
                        System.out.println("读取成功！");
                    }
                    break;

                case "2":
                    content = new code3line().format(content);
                    System.out.println("排版完成！");
                    break;

                case "3":
                    new code4customized().stats(content);
                    break;

                case "4":
                    new code5save().save(content);
                    break;

                case "5":
                    System.out.println("是否保存？y/n");
                    if (sc.nextLine().equalsIgnoreCase("y")) {
                        new code5save().save(content);
                    }
                    System.exit(0);
            }
        }
    }
    
    public static void main(String[] args) {
        new code1main().run();
    }
}
