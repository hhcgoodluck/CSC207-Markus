public class Reduce {

    public static int reduceSteps(int n) {
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

    // 带参数的 main 方法，调用 reduceSteps 并打印结果
    public static void main(String[] args) {
        if (args.length == 0) {
            // 使用默认值调用 reduceSteps
            System.out.println(reduceSteps(100));
        } else {
            int n = Integer.parseInt(args[0]);
            System.out.println(reduceSteps(n));
        }
    }
}

