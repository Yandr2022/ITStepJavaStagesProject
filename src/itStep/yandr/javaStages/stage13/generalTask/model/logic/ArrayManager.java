package itStep.yandr.javaStages.stage13.generalTask.model.logic;

import itStep.yandr.javaStages.stage13.generalTask.exception.InvalidSizeOfArray;

public class ArrayManager {

    private static void ValidateIntegerArray(int[] array) throws InvalidSizeOfArray {
        if (array == null || array.length < 2) {
            throw new InvalidSizeOfArray();
        }
    }

    public static int findMaxValueIndex(int[] array) throws InvalidSizeOfArray {
        ValidateIntegerArray(array);
        int max = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }
}
