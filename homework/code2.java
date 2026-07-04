package homework;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class code2 {
    private Scanner sc = new Scanner(System.in);
    private String content = "";
    private boolean isDocx = false;
    private String filePath = "";

    void load() {
        System.out.print("文件路径: ");
        String path = sc.nextLine().trim();
        if (!new File(path).exists()) { System.out.println("文件不存在"); return; }
        try {
            if (path.toLowerCase().endsWith(".txt")) {
                content = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
                isDocx = false;
            } else if (path.toLowerCase().endsWith(".docx")) {
                System.out.println(".docx 格式需要安装 Apache POI 库，暂不支持");
                System.out.println("请使用 .txt 格式文件");
                return;
            } else { System.out.println("仅支持 .txt 或 .docx"); return; }
            filePath = path;
            System.out.println("加载成功，字数:" + content.split("[\\s\\p{Punct}]+").length);
        } catch (Exception e) { System.out.println("读取错误:" + e.getMessage()); }
    }
}
