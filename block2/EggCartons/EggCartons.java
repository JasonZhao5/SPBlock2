public class EggCartons {
    int minCnt = -1;

    int minCartons(int n) {
        rec(n, 0, 0);
        return minCnt;
    }

    private void rec(int n, int curr, int count) {
        if (count > n)
            return;

        if (curr == n) {
            if (minCnt == -1 || count < minCnt) {
                minCnt = count;
                return;
            }
        }

        rec(n, curr + 6, count + 1);

        rec(n, curr + 8, count + 1);
    }

    public static void main(String[] args) {
        System.out.println(new EggCartons().minCartons(4));
    }

}
