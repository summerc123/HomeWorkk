package homework;

import java.util.Scanner;

public class code1 {
    private Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) { 
        new code1().run(); 
    }

    void run() {
        while (true) {
            System.out.println("\n1.读取 2.排版 3.进阶 4.保存 5.退出");
            switch (sc.nextLine().trim()) {
                case "1": load(); break;
                case "2": format(); break;
                case "3": advanced(); break;
                case "4": save(); break;
                case "5": exit(); return;
                default: System.out.println("无效选项，请重新输入");
            }
        }
    }

    void load() {
        System.out.println("执行读取操作...");
        // TODO: 实现读取功能
    }

    void format() {
        System.out.println("执行排版操作...");
        // TODO: 实现排版功能
    }

    void advanced() {
        System.out.println("执行进阶操作...");
        // TODO: 实现进阶功能
    }

    void save() {
        System.out.println("执行保存操作...");
        // TODO: 实现保存功能
    }

    void exit() {
        System.out.print("保存当前文档？(y/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("y")) save();
        System.out.println("再见");
        sc.close();
    }
}
