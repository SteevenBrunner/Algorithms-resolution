package FindTheMissingNumber;

import java.math.BigInteger;
import java.util.*;

public class FindTheMissingNumber {

    //Testing 2 ways to find a missing number out of a list.
    //First uses a HashSet
    //Second uses a sum
    //Keep in mind that the sum method only works for numbers

    private static String UsingHashSet(int sizeList, List<Integer> missingNbList ) {

        HashSet<Integer> mySet = new HashSet<>();
        while (sizeList > 0) {
            mySet.add(sizeList);
            sizeList--;
        }

        missingNbList.forEach(mySet::remove);

        // check values
        for (Object aMySet : mySet) {
            return aMySet.toString();
        }
        return null;
    }

    // sum and total can be declared as BigInteger if the sum goes over the limit of a long
    private static String UsingSum(int sizeList, List<Integer> missingNbList) {
        long sum = 0;
        for (Integer nb : missingNbList)
            sum = sum + nb;

        BigInteger total = BigInteger.valueOf(sizeList + 1).multiply(BigInteger.valueOf(sizeList));
        BigInteger total2 = total.divide(BigInteger.valueOf(2));

        return String.valueOf(total2.subtract(BigInteger.valueOf(sum)));
    }

    public static void main(String[] args) {

        int sizeList = 10000000;

        List<Integer> missingNbList = new ArrayList<>();
        for (int i = 1; i <= sizeList; ++i) {
            missingNbList.add(i);
        }
        Collections.shuffle(missingNbList);
        missingNbList.remove(0);

        long tStart = System.currentTimeMillis();
        //HashSet method
        System.out.println("Missing number(s) with HashSet : " + UsingHashSet(sizeList, missingNbList) + " ");

        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;
        System.out.println("Time with HashSet : " + elapsedSeconds + " seconds.");


        tStart = System.currentTimeMillis();
        //Sum method
        System.out.println("Missing number(s) with Sum : " + UsingSum(sizeList, missingNbList) + " ");

        tEnd = System.currentTimeMillis();
        tDelta = tEnd - tStart;
        elapsedSeconds = tDelta / 1000.0;
        System.out.println("Time with Sum : " + elapsedSeconds + " seconds.");
    }
}
