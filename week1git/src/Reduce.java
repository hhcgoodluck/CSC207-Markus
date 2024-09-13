public class Reduce {
    public static int main(int n) {
        int steps = 0;                         // 用于记录步骤数的变量
        for (int i = n; i > 0;) {              // 循环，直到i减小到0
            boolean even = i % 2 == 0;         // 检查当前的i是否为偶数
            if (even) {
                i = i / 2;                     // 如果是偶数，则将i除以2
                steps++;                       // 增加步骤计数
            } else {
                i = i - 1;                     // 如果是奇数，则将i减1
                steps++;                       // 增加步骤计数
            }
        }
        return steps;                          // 返回总共的步骤数
    }
}






