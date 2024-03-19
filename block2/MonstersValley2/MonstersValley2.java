public class MonstersValley2 {

    public static int minimumPrice(int[] dread, int[] price) {

        int i = 1;

        return getMin(dread, price, dread[0], price[0], i);

    }

    public static int getMin(int[] dread, int[] price, int d, int p, int i) {

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
                        {5216, 12512, 613, 1256, 66, 17202, 30000, 23512, 2125, 33333}, new int[]
                        {2, 2, 1, 1, 1, 1, 2, 1, 2, 1})
        );
    }
}
