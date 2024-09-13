public class Reduce {

    // 计算从 1 到 n 中能够被 100 整除的整数的个数
    public static int countDivisibleBy100(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (i % 100 == 0) {
                count++;
            }
        }
        return count;
    }

    // 默认主方法
    public static int main() {
        int n = 1000; // 默认值
        return countDivisibleBy100(n);
    }

    // 参数化主方法
    public static int main(int n) {
        return countDivisibleBy100(n);
    }

    // 用于测试和输出结果的主方法
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                int n = Integer.parseInt(args[0]);
                System.out.println(main(n));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please provide an integer.");
            }
        } else {
            System.out.println(main()); // 使用默认值
        }
    }
}



