package WORKKKKKKKKKKKKKK;

public class SeriesSum {
    public static void main(String[] args) {
        double sum = 0.0;
        
        for (int numerator = 1, denominator = 3; numerator <= 97; numerator += 2, denominator += 2) {
            sum += (double) numerator / denominator;
        }
        
        System.out.println("级数之和为：" + sum);
        System.out.println("预期结果应该是约 24.75");
    }
}
