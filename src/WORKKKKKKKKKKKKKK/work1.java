package WORKKKKKKKKKKKKKK;

public class work1 {
    private double weight;  // 体重（千克）
    private double height;  // 身高（米）
    private double bmi;     // BMI 值（由 calculate 方法计算得到）

    // ----- Getter 和 Setter（仅 weight 和 height 提供 setter）-----
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // BMI 的 getter（只读，不提供 setter）
    public double getBmi() {
        return bmi;
    }

    /**
     * 根据当前体重和身高计算 BMI 值，并存储到 bmi 属性中
     * 公式：BMI = 体重（kg） / （身高（m） * 身高（m））
     */
    public void calculate() {
        if (height <= 0) {
            throw new IllegalArgumentException("身高必须大于0");
        }
        this.bmi = weight / (height * height);
    }

    /**
     * 判断是否超重
     * @return 如果 BMI > 25 返回 true，否则返回 false
     */
    public boolean isOverWeight() {
        return bmi > 25;
    }

    /**
     * main 方法：创建 BMICalculator 对象，设置体重和身高，
     * 计算 BMI 并判断是否超重，若超重则输出指定信息
     */
    public static void main(String[] args) {
        // 创建 BMICalculator 对象
        work1 calculator = new work1();

        // 如果提供了命令行参数，使用参数设置体重和身高
        if (args.length >= 2) {
            calculator.setWeight(Double.parseDouble(args[0]));
            calculator.setHeight(Double.parseDouble(args[1]));
        } else {
            // 使用默认值（示例：体重 70kg，身高 1.75m）
            calculator.setWeight(70);
            calculator.setHeight(1.75);
        }

        // 计算 BMI
        calculator.calculate();

        // 输出 BMI 信息
        System.out.println("体重：" + calculator.getWeight() + "kg");
        System.out.println("身高：" + calculator.getHeight() + "m");
        System.out.println("BMI指数：" + String.format("%.2f", calculator.getBmi()));

        // 判断是否超重并输出结果
        if (calculator.isOverWeight()) {
            System.out.println("您的BMI指数超重");
        } else {
            System.out.println("您的BMI指数正常");
        }
    }
}

