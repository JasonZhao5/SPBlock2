
public class QuickSums {


    public int minSums(String numbers, int sum) {
        int min = -1;
        return search(numbers, sum, min, 0, 0, 0);
    }

    int search(String numbers, int sum, int min, int index, int count, long temp) {
        if (index == numbers.length()) {
            if (temp == sum && (min == -1 || count - 1 < min)) {
                min = count - 1;
            }
            return min;
        }

        for (int i = index; i < numbers.length(); ++i) {
            min = search(numbers, sum, min, i + 1, count + 1, temp + Long.parseLong(numbers.substring(index, i + 1)));
        }
        return min;
    }

    public static void main(String[] args) {
        QuickSums quickSums = new QuickSums();
        System.out.println(quickSums.minSums("9230560001",
                71
                ));
    }
}
