package homework;

import java.util.Scanner;

public class code4 {
    private Scanner sc = new Scanner(System.in);
    private String content = "";
    private String font = "宋体";
    private int fontSize = 12;
    private int lineSpacing = 1;

    void advanced() {
        System.out.println("1.字数统计 2.自定义格式");
        switch (sc.nextLine().trim()) {
            case "1": stats(); break;
            case "2": customize(); break;
            default: System.out.println("无效");
        }
    }

    void stats() {
        int chars = content.length();
        int words = content.trim().isEmpty() ? 0 : content.split("[\\s\\p{Punct}]+").length;
        int cn = 0; for (char c : content.toCharArray()) if (c>=0x4E00 && c<=0x9FA5) cn++;
        System.out.println("字符数:"+chars+"  单词数:"+words+"  中文字符:"+cn);
    }

    void customize() {
        System.out.print("字体("+font+"):"); String f=sc.nextLine().trim(); if(!f.isEmpty()) font=f;
        System.out.print("字号("+fontSize+"):"); try { int s=Integer.parseInt(sc.nextLine().trim()); if(s>0) fontSize=s; } catch(Exception e){}
        System.out.print("行距("+lineSpacing+"):"); try { int s=Integer.parseInt(sc.nextLine().trim()); if(s>0) lineSpacing=s; } catch(Exception e){}
        System.out.println("格式参数已更新");
    }
}
