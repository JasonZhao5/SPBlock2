public class MonstersValley2 {

    public static int minimumPrice(int[] dread, int[] price) {

        int i = 1;
        return getMin(dread, price, dread[0], price[0], i);

    }

    public static int getMin(int[] dread, int[] price, long d, int p, int i) {

        if (i == dread.length) {
            return p;
        }
        if (dread[i] > d) {
            return getMin(dread, price, d + dread[i], p + price[i], i + 1);
        } else {
            int x = getMin(dread, price, d + dread[i], p + price[i], i + 1);
            int y = getMin(dread, price, d, p, i + 1);
            return Math.min(x, y);
        }


    }

    public static void main(String[] args) {

        System.out.println(
                minimumPrice(new int[]
                        {1999999991, 1999999992, 1999999993, 1999999994, 1999999995, 1999999996, 1999999997, 1999999998, 1999999999, 2000000000}, new int[]
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1})
        );
    }
}
