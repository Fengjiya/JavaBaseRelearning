package SortAlgorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortingAlgorithm {
    static final int arrayLength = 10000;
    static final int checkTimes = 100;

    public int[] randomArrayGenerator() {
        Random random = new Random();

        int[] array = new int[arrayLength];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(arrayLength);
        }
        return array;
    }

    public int[] SelectSorting(int[] noneOrderArray) {
        /*
         * 最简单，但是最不适用的排序算法，有优化空间
         *随机生产数据器、对数器
         * */
        if (noneOrderArray == null || noneOrderArray.length == 0) {
            return null;
        } else if (noneOrderArray.length == 1) {
            return noneOrderArray;
        }

        int minIndex;
        int cacheValue;
        for (int outerIndex = 0; outerIndex < noneOrderArray.length; outerIndex++) {
            cacheValue = noneOrderArray[outerIndex];
            minIndex = outerIndex;

            for (int innerIndex = outerIndex + 1; innerIndex < noneOrderArray.length; innerIndex++) {
                if (noneOrderArray[innerIndex] < noneOrderArray[minIndex]) {
                    minIndex = innerIndex;
                }

            }

            if (minIndex != outerIndex) {
                noneOrderArray[outerIndex] = noneOrderArray[minIndex];
                noneOrderArray[minIndex] = cacheValue;
            }
//            System.out.println("第" + (outerIndex + 1) + "次循环：" + Arrays.toString(noneOrderArray));
        }

        return noneOrderArray;
    }

    public void check() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < checkTimes; i++) {
            int[] arr1 = randomArrayGenerator();
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);

            arr1 = SelectSorting(arr1);
            Arrays.sort(arr2);

            Arrays.equals(arr1, arr2);

//            System.out.println("第" + (i + 1) + "次循环：" + (!Arrays.equals(arr1, arr2) ? "排序不相等" : "排序相等"));
            ;
        }

        System.out.println("合计耗时：" + (System.currentTimeMillis() - start) / 1000 + "S");

    }

    public static void main(String[] args) {
        SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();
        sortingAlgorithm.check();
    }

}
