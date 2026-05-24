package WORKKKKKKKKKKKKKK;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文件处理工具类
 * 功能：文件读取、清理多余空格空行、基础排版
 */
public class FileProcessor {

    /**
     * 读取文件内容
     * @param filePath 文件路径
     * @return 文件内容字符串
     */
    public static String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return new String(Files.readAllBytes(path));
    }

    /**
     * 清理多余空格和空行
     * @param content 原始内容
     * @return 清理后的内容
     */
    public static String cleanContent(String content) {
        if (content == null || content.isEmpty()) {
            return content;
        }

        String[] lines = content.split("\n");
        List<String> cleanedLines = new ArrayList<>();

        for (String line : lines) {
            // 去除每行首尾空格
            String trimmedLine = line.trim();
            
            // 跳过空行（只保留非空行）
            if (!trimmedLine.isEmpty()) {
                cleanedLines.add(trimmedLine);
            }
        }

        return String.join("\n", cleanedLines);
    }

    /**
     * 基础排版：为代码添加统一缩进和格式
     * @param content 原始内容
     * @return 排版后的内容
     */
    public static String formatContent(String content) {
        if (content == null || content.isEmpty()) {
            return content;
        }

        String[] lines = content.split("\n");
        StringBuilder formatted = new StringBuilder();
        int indentLevel = 0;

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();
            
            if (line.isEmpty()) {
                continue;
            }

            // 检测行尾是否有左大括号，增加缩进
            if (line.contains("{")) {
                formatted.append(getIndentation(indentLevel)).append(line).append("\n");
                indentLevel++;
            } 
            // 检测是否是右大括号，减少缩进
            else if (line.contains("}")) {
                indentLevel = Math.max(0, indentLevel - 1);
                formatted.append(getIndentation(indentLevel)).append(line).append("\n");
            } 
            // 普通行
            else {
                formatted.append(getIndentation(indentLevel)).append(line).append("\n");
            }
        }

        return formatted.toString();
    }

    /**
     * 生成指定级别的缩进字符串
     * @param level 缩进级别
     * @return 缩进字符串（每个级别4个空格）
     */
    private static String getIndentation(int level) {
        return "    ".repeat(level);
    }

    /**
     * 写入文件
     * @param filePath 文件路径
     * @param content 文件内容
     */
    public static void writeFile(String filePath, String content) throws IOException {
        Files.writeString(Paths.get(filePath), content);
    }

    /**
     * 主函数：演示三个功能
     */
    public static void main(String[] args) {
        try {
            System.out.println("=== 文件处理工具 ===\n");

            // 创建测试文件
            String testFilePath = "test_input.txt";
            String testContent = "public class Test {\n\n\n    public static void main(String[] args)   {\n\n        System.out.println(\"Hello\");\n\n\n    }\n\n}\n";
            writeFile(testFilePath, testContent);
            
            System.out.println("【功能1】读取文件内容：");
            String readContent = readFile(testFilePath);
            System.out.println(readContent);

            System.out.println("\n【功能2】清理多余空格和空行：");
            String cleanedContent = cleanContent(readContent);
            System.out.println(cleanedContent);

            System.out.println("\n【功能3】基础排版：");
            String formattedContent = formatContent(cleanedContent);
            System.out.println(formattedContent);

            // 保存处理后的文件
            String outputFilePath = "test_output.txt";
            writeFile(outputFilePath, formattedContent);
            System.out.println("\n排版后的内容已保存到: " + outputFilePath);

        } catch (IOException e) {
            System.err.println("文件处理出错: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
