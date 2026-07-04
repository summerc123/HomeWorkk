package homework;

public class code3 {
    private String content = "";

    void format() {
        if (content.isEmpty()) { System.out.println("请先读取文档"); return; }
        content = clean(content);
        System.out.println("排版完成（已清理多余空格/空行）");
        preview();
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
