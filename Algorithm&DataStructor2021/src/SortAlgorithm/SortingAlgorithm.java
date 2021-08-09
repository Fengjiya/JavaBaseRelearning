package SortAlgorithm;

import java.util.Arrays;
import java.util.List;

public class SortingAlgorithm {
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
            System.out.println("第" + (outerIndex + 1) + "次循环：" + Arrays.toString(noneOrderArray));
        }

        return noneOrderArray;
    }

    public static void main(String[] args) {
        int[] noneOrderArray = {8, 3, 5, 2, 6, 1};
//        int[] noneOrderArray = {1};
//        int[] noneOrderArray = null;
        SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();
        sortingAlgorithm.SelectSorting(noneOrderArray);
//        System.out.println(Arrays.sort(noneOrderArray));
    }

}
