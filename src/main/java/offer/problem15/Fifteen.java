package offer.problem15;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description p99 15. 二进制中1的个数
 * @Date 2018-11-28
 * @Time 16:23
 */
public class Fifteen {
    /**
     * 对该数移位，遇到负数时，最高位用于是 1，因此会死循环
     */
    public static int numberOfOne(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    /**
     * 对辅助数移位，原数不变，常规做法
     */
    public static int numberOfOne2(int n) {
        int count = 0, flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag <<= 1;
        }
        return count;
    }

    /**
     * 最佳解法
     */
    public static int numberOfOne3(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            /*
               如 1100，1100 - 1 = 1011,1100 & 1011 = 1000，这样就把其中一个 1 去掉了
             */
            n = (n - 1) & n;
        }
        return count;
    }
}