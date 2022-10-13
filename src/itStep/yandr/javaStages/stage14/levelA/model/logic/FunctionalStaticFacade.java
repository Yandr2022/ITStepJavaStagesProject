package itStep.yandr.javaStages.stage14.levelA.model.logic;

import itStep.yandr.javaStages.stage14.levelA.model.logic.decorator.Inverter;
import itStep.yandr.javaStages.stage14.levelA.model.logic.strategy.*;

public class FunctionalStaticFacade {


    private FunctionalStaticFacade() {
    }

    public static int countNonZeroElements(int[] values) {
        return CounterElements.count(new Inverter(new CountNumbersEqualsZero()), values);
    }

    public static int countEqualsZeroElements(int[] values) {
        return CounterElements.count(new CountNumbersEqualsZero(), values);
    }

    public static int countEvenElements(int[] values) {
        return CounterElements.count(new CountEvenNumbers(), values);
    }

    public static int countOddElements(int[] values) {
        return CounterElements.count(new Inverter(new CountEvenNumbers()), values);
    }

    public static int countPositiveElements(int[] values) {
        return CounterElements.count(new CountPositiveNumbers(), values);
    }

    public static int countNegativeElements(int[] values) {
        return CounterElements.count(new CountNegativeNumbers(), values);
    }
}
