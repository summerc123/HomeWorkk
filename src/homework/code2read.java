package homework;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class code2read {
    private String content = "";
    private boolean isDocx = false;
    private String filePath = "";

    String load(Scanner scanner) {
        System.out.print("文件路径: ");
        String path = scanner.nextLine().trim();
        
        // 自动去除首尾的引号(支持双引号和单引号)
        if ((path.startsWith("\"") && path.endsWith("\"")) || 
            (path.startsWith("'") && path.endsWith("'"))) {
            path = path.substring(1, path.length() - 1);
        }
        
        System.out.println("正在检查文件: " + path);
        
        File file = new File(path);
        if (!file.exists()) { 
            System.out.println("文件不存在: " + path);
            System.out.println("请确认路径是否正确(建议使用完整路径,如: C:\\Users\\xxx\\Desktop\\test.txt)");
            return "";
        }
        
        if (!file.isFile()) {
            System.out.println("这不是一个文件: " + path);
            return "";
        }
        
        try {
            if (path.toLowerCase().endsWith(".txt")) {
                content = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
                isDocx = false;
            } else if (path.toLowerCase().endsWith(".docx")) {
                System.out.println(".docx 格式需要安装 Apache POI 库，暂不支持");
                System.out.println("请使用 .txt 格式文件");
                return "";
            } else { 
                System.out.println("仅支持 .txt 或 .docx"); 
                return "";
            }
            filePath = path;
            int charCount = content.length();
            System.out.println("加载成功，字符数:" + charCount);
            return content;
        } catch (Exception e) { 
            System.out.println("读取错误: " + e.getMessage());
            System.out.println("错误详情: " + e.getClass().getName());
            e.printStackTrace();
            return "";
        }
    }
}
