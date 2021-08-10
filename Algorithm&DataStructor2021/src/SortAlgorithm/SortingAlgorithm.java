package SortAlgorithm;

import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithm {
    static final int ARRAY_LENGTH = 10000;
    static final int CHECK_TIMES = 100;

    public int[] randomArrayGenerator() {
        Random random = new Random();

        int[] array = new int[ARRAY_LENGTH];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(ARRAY_LENGTH);
        }
        return array;
    }

    public int selectSorting(int[] noneOrderArray, int counter) {
        /*
         * 最简单，但是最不适用的排序算法，有优化空间
         *随机生产数据器、对数器
         * */
        System.out.println("这是选择排序");
        if (noneOrderArray == null || noneOrderArray.length == 0) {
            return counter;
        } else if (noneOrderArray.length == 1) {
            return counter;
        }

        int minIndex;
        int cacheValue;
        for (int outerIndex = 0; outerIndex < noneOrderArray.length; outerIndex++) {
            minIndex = outerIndex;

            for (int innerIndex = outerIndex + 1; innerIndex < noneOrderArray.length; innerIndex++) {
                if (noneOrderArray[innerIndex] < noneOrderArray[minIndex]) {
                    minIndex = innerIndex;
                }
                counter++;

            }

            swapArrayValue(noneOrderArray, minIndex, outerIndex);
//            System.out.println("第" + (outerIndex + 1) + "次循环：" + Arrays.toString(noneOrderArray));
        }

        return counter;
    }

    private void swapArrayValue(int[] noneOrderArray, int srcIndex, int destIndex) {
        int cacheValue;
        if (srcIndex != destIndex) {
            cacheValue = noneOrderArray[destIndex];
            noneOrderArray[destIndex] = noneOrderArray[srcIndex];
            noneOrderArray[srcIndex] = cacheValue;
        }
    }

    public int bubbleSorting(int[] noneOrderArray, int counter) {
        /*
         * 时间复杂度：O(n²)
         * 空间复杂度：O(1)
         * */
        System.out.println("这是冒泡排序");
        if (noneOrderArray == null || noneOrderArray.length == 0) {
            return counter;
        } else if (noneOrderArray.length == 1) {
            return counter;
        }

        for (int i = 0; i < noneOrderArray.length - 1; i++) {
            for (int j = 0; j < noneOrderArray.length - i - 1; j++) {
                if (noneOrderArray[j] > noneOrderArray[j + 1]) {
                    swapArrayValue(noneOrderArray, j, j + 1);
                }
                counter++;
            }
        }

        return counter;
    }

    public int insertSorting(int[] noneOrderArray, int counter) {
        /*
         * 插入排序，对于基本有序的数组，速度快，而且是稳定排序
         * */
        System.out.println("这是插入排序");
        if (noneOrderArray == null || noneOrderArray.length == 0) {
            return counter;
        } else if (noneOrderArray.length == 1) {
            return counter;
        }

        for (int i = 1; i < noneOrderArray.length; i++) {
            for (int j = i; j > 0; j--) {
                if (noneOrderArray[j] < noneOrderArray[j - 1]) {
                    swapArrayValue(noneOrderArray, j, j - 1);
                    counter++;
                } else {
                    break;
                }
            }


        }

        return counter;
    }

    public void sortingCheck() {
        System.out.println("长度为" + ARRAY_LENGTH + "的数组，排序" + CHECK_TIMES + "次，开始排序...");
        long start = System.currentTimeMillis();
        int counter = 0;
        for (int i = 0; i < CHECK_TIMES; i++) {
            int[] arr1 = randomArrayGenerator();
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);

            counter = bubbleSorting(arr1, counter);
            Arrays.sort(arr2);

            Arrays.equals(arr1, arr2);
        }

        System.out.println("排序结束，合计耗时：" + (System.currentTimeMillis() - start) / 1000 + "S");
        System.out.println("合计循环判断次数：" + counter);

    }

    public static void main(String[] args) {
        int[] array = {3, 5, 2, 8, 1};
        SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();
        sortingAlgorithm.sortingCheck();
//        System.out.println(Arrays.toString(sortingAlgorithm.BubbleSorting(array)));
    }

}
