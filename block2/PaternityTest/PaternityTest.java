import java.util.*;
import java.util.stream.Collectors;

public class PaternityTest {
    ArrayList<String> menArray;
    HashSet<Integer> resultValues = new HashSet<>();
    String childString;
    String motherString;

    public int[] possibleFathers(String child, String mother, String[] men) {
        int m = child.length() / 2;
        ArrayList<Integer> sorts = new ArrayList<>();
        menArray = new ArrayList<>(Arrays.asList(men));
        childString = child;
        motherString = mother;
        generateCombinations(0, m, sorts);
        return resultValues.stream().mapToInt(Integer::intValue).toArray();
    }

    void generateCombinations(int start, int m, ArrayList<Integer> sorts) {
        if (sorts.size() == m) {
            doTest(sorts);
        }
        for (int i = start; i < childString.length(); i++) {
            if (motherString.charAt(i) == childString.charAt(i)) {
                sorts.add(i);
            }
            generateCombinations(i + 1, m, sorts);
            if (motherString.charAt(i) == childString.charAt(i)) {
                sorts.remove(sorts.size() - 1);
            }
        }
    }

    void doTest(List<Integer> sorts) {
        sorts = sorts.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).collect(Collectors.toList());
        for (int i = 0; i < menArray.size(); i++) {
            StringBuilder childBuilder = new StringBuilder(childString);
            StringBuilder manBuilder = new StringBuilder(menArray.get(i));
            for (Integer sort : sorts) {
                childBuilder.deleteCharAt(sort);
                manBuilder.deleteCharAt(sort);

            }
            if (manBuilder.compareTo(childBuilder) == 0) {
                resultValues.add(i);
            }
        }
    }

    //    public int[] possibleFathers(String child, String mother, String[] men)
//    {
//        int[] poss = new int[men.length];
//
//        int nf = 0;
//        for (int i = 0; i < men.length; i++)
//        {
//            int fc = 0, mc = 0;
//            for (int j = 0; j < men[i].length(); j++)
//            {
//
//            }
//            if (fc == mc) poss[nf++] = i;
//        }
//        int[] res = new int[nf];
//        for (int i = 0; i < nf; i++) res[i] = poss[i];
//        return res;
//    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PaternityTest().possibleFathers("WXETPYCHUWSQEMKKYNVP",
                "AXQTUQVAUOSQEEKCYNVP",
                new String[]{"WNELPYCHXWXPCMNKDDXD",
                        "WFEEPYCHFWDNPMKKALIW",
                        "WSEFPYCHEWEFGMPKIQCK",
                        "WAEXPYCHAWEQXMSKYARN",
                        "WKEXPYCHYWLLFMGKKFBB"}

        )));
    }

}

