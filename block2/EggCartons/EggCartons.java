public class EggCartons {
    int minCnt = -1;

    public static int minCartons(int n) {
        // 如果n小于6或者n为奇数，则无法准确购买n个鸡蛋
        if (n < 6 || n % 2 != 0) return -1;

        // 初始化DP数组，所有值设为无穷大
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // 设置基本情况
        dp[0] = 0; // 0个鸡蛋需要0个纸盒
        for (int i = 6; i <= n; i += 6) {
            dp[i] = i / 6; // 只用6个鸡蛋的纸盒
        }
        for (int i = 8; i <= n; i += 8) {
            dp[i] = i / 8; // 只用8个鸡蛋的纸盒
        }

        // 填充DP数组
        for (int i = 1; i <= n; i++) {
            // 如果可以用6个鸡蛋的纸盒凑出i个鸡蛋
            if (i >= 6 && dp[i - 6] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 6] + 1);
            }
            // 如果可以用8个鸡蛋的纸盒凑出i个鸡蛋
            if (i >= 8 && dp[i - 8] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 8] + 1);
            }
        }

        // 如果无法凑出n个鸡蛋，则返回-1
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new EggCartons().minCartons(6*8*6));
    }

}
