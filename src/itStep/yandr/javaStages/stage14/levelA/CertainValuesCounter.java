package itStep.yandr.javaStages.stage14.levelA;

public class CertainValuesCounter {

    public static int countNonZeroElements(int... values) {
        if (values == null || values.length == 0) {
            return -1;
        }
        int count = 0;
        for (int value : values) {
            if (value != 0) {
                count += 1;
            }
        }
        return count;
    }
    public static int countEvenNumbers(int... values) {
        if (values == null || values.length == 0) {
            return -1;
        }
        int count = 0;
        for (int value : values) {
            if (value % 2 == 0) {
                count += 1;
            }
        }
        return count;
    }
    public static int countPositiveNumbers(int... values) {
        if (values == null || values.length == 0) {
            return -1;
        }
        int count = 0;
        for (int value : values) {
            if (value % 2 == 0) {
                count += 1;
            }
        }
        return count;
    }

}
