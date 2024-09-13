public class Reduce {
    // 计算将 n 减少到 0 的步骤数
    public static int calculateSteps(int n) {
        int steps = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
            steps++;
        }
        return steps;
    }

    // 处理命令行参数的 main 方法
    public static void main(String[] args) {

        int defaultN = 100;

        // 处理命令行参数
        int n = defaultN;
        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Using default value.");
            }
        }

        System.out.println(calculateSteps(n));
    }
}
