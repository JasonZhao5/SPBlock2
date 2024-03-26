public class EggCartons {

    public int minCartons(int n) {
        if (n < 6 || n % 2 != 0) return -1;

        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        for (int i = 6; i <= n; i += 6) {
            dp[i] = i / 6;
        }
        for (int i = 8; i <= n; i += 8) {
            dp[i] = i / 8;
        }

        for (int i = 1; i <= n; i++) {
            if (i >= 6 && dp[i - 6] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 6] + 1);
            }
            if (i >= 8 && dp[i - 8] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 8] + 1);
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new EggCartons().minCartons(6 * 8));
    }

}
