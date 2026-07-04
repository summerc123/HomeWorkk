package homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class code5 {
    private String content = "";
    private String filePath = "";
    private boolean isDocx = false;
    private String font = "宋体";
    private int fontSize = 12;
    private int lineSpacing = 1;

    void save() {
        if (content.isEmpty()) { System.out.println("无内容可保存"); return; }
        String path = filePath;
        if (isDocx && path.toLowerCase().endsWith(".docx")) {
            System.out.println("注意: .docx 格式需要 Apache POI 库支持");
            System.out.println("将保存为 .txt 格式");
            try { 
                Files.write(Paths.get(path.replaceAll("\\.docx$", ".txt")), content.getBytes(StandardCharsets.UTF_8)); 
                System.out.println("TXT 保存成功"); 
            }
            catch (IOException e) { System.out.println("保存 TXT 失败:"+e.getMessage()); }
        } else {
            try { 
                Files.write(Paths.get(path), content.getBytes(StandardCharsets.UTF_8)); 
                System.out.println("TXT 保存成功"); 
            }
            catch (IOException e) { System.out.println("保存 TXT 失败:"+e.getMessage()); }
        }
    }
}
