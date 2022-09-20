package itStep.yandr.javaStages.stage14.levelA.model.logic;

import itStep.yandr.javaStages.stage14.levelA.model.logic.strategy.ElementCountable;

public class CounterElements {

    public static int count(ElementCountable countable, int... values) {
        if (values == null || values.length == 0) {
            return -1;
        }
        int count = 0;
        for (int value : values) {
            if (countable.relevant(value)) {
                count ++;
            }
        }
        return count;
    }

}
