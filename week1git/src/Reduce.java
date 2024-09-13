public class Reduce {

    // 计算将 n 减少到 0 所需的步骤数
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

    // main 方法，用于处理命令行参数和输出结果
    public static void main(String[] args) {
        if (args.length == 0) {
            // 使用默认值调用 calculateSteps 并输出结果
            System.out.println(calculateSteps(100));
        } else {
            int n = Integer.parseInt(args[0]);
            System.out.println(calculateSteps(n));
        }
    }
}


