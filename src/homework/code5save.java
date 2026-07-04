package homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class code5save {
    private String content = "";
    private String filePath = "";
    private boolean isDocx = false;
    private String font = "宋体";
    private int fontSize = 12;
    private int lineSpacing = 1;

    void save(String input) {
        if (input == null || input.isEmpty()) { 
            System.out.println("无内容可保存"); 
            return; 
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.print("保存路径: ");
        String path = sc.nextLine().trim();
        
        try { 
            Files.write(Paths.get(path), input.getBytes(StandardCharsets.UTF_8)); 
            System.out.println("保存成功"); 
        }
        catch (IOException e) { 
            System.out.println("保存失败:"+e.getMessage()); 
        }
    }
}
