package homework;

public class code3line {
    private String content = "";

    String format(String input) {
        if (input == null || input.isEmpty()) { 
            System.out.println("请先读取文档"); 
            return "";
        }
        content = clean(input);
        System.out.println("排版完成（已清理多余空格/空行）");
        preview();
        return content;
    }

    String clean(String s) {
        String[] lines = s.split("\n");
        StringBuilder sb = new StringBuilder();
        boolean lastEmpty = false;
        for (String line : lines) {
            String t = line.trim();
            if (!t.isEmpty()) {
                sb.append(t.replaceAll(" +", " ")).append("\n");
                lastEmpty = false;
            } else if (!lastEmpty) {
                sb.append("\n");
                lastEmpty = true;
            }
        }
        String r = sb.toString();
        while (r.endsWith("\n\n")) r = r.substring(0, r.length()-1);
        return r;
    }

    void preview() {
        String p = content.length() > 80 ? content.substring(0,80)+"..." : content;
        System.out.println("预览: " + p);
    }
}
