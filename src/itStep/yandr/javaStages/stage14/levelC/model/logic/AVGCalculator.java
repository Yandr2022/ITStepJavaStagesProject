package itStep.yandr.javaStages.stage14.levelC.model.logic;

public class AVGCalculator {


    public static double calculateGeometricAvg(int... numbers) {
        if (numbers == null || numbers.length < 2) {
            return -1;
        }
        long mpl = 1L;
        for (int number : numbers) {
            if (number <= 0) {
                return -1;
            }
            mpl *= number;
        }
        return Math.pow(mpl, 1.0 / numbers.length);
    }

    public static double calculateArithmeticAvg(int... numbers) {
        if (numbers == null || numbers.length < 2) {
            return -1;
        }
        long sum = 0L;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return (double) sum / numbers.length;
    }
}
