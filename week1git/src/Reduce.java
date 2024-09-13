public class Reduce {
    public static int countSteps(int n) {
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

    public static void main(String[] args) {
        int n = 100; // 默认值

        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
        }

        System.out.println("Number of steps to reduce " + n + " to 0: " + countSteps(n));
    }
}
