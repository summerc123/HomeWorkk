package WORKKKKKKKKKKKKKK;

public class work {
    /**
     * 矩形类，包含长度和宽度属性，提供周长和面积计算方法
     */
    public static class Rectangle {
        // 私有属性：长度和宽度
        private double length;
        private double width;

        /**
         * 带参数的构造方法，使用给定的长和宽创建矩形对象
         * @param length 长度
         * @param width  宽度
         */
        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        /**
         * 默认构造方法，调用带参构造方法将长和宽均设为 2.0
         */
        public Rectangle() {
            this(2.0, 2.0);
        }

        // ----- Getter 和 Setter 方法 -----
        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        /**
         * 计算矩形周长
         * @return 周长 = 2 * (长 + 宽)
         */
        public double getPerimeter() {
            return 2 * (length + width);
        }

        /**
         * 计算矩形面积
         * @return 面积 = 长 * 宽
         */
        public double getArea() {
            return length * width;
        }

        /**
         * main 方法，用于测试矩形类
         * 创建两个矩形对象，分别输出其周长和面积
         */
        public static void main(String[] args) {
            // 第一个矩形对象：使用默认构造方法（长和宽均为 2.0）
            Rectangle rect1 = new Rectangle();
            System.out.println("第一个矩形（默认构造，长=2.0，宽=2.0）：");
            System.out.println("周长：" + rect1.getPerimeter());
            System.out.println("面积：" + rect1.getArea());

            // 第二个矩形对象：先使用默认构造，再通过 setter 方法设置长度为 4，宽度为 6
            Rectangle rect2 = new Rectangle();
            rect2.setLength(4);
            rect2.setWidth(6);
            System.out.println("\n第二个矩形（通过 setter 设置，长=4，宽=6）：");
            System.out.println("周长：" + rect2.getPerimeter());
            System.out.println("面积：" + rect2.getArea());
        }
    }
}
