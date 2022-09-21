package itStep.yandr.javaStages.stage14.levelB.model.logic;

import itStep.yandr.javaStages.stage14.levelB.model.logic.strategy.CountMultipleElements;
import itStep.yandr.javaStages.stage14.levelB.model.logic.strategy.ElementCountable;

public class CounterElements {
   public static final ElementCountable MULTIPLE = new CountMultipleElements();

    public static int count(ElementCountable countable,int number, int... values) {
        if ((values == null || values.length == 0)||(countable.equals (MULTIPLE) && number==0)) {
            return -1;
        }
        int count = 0;
        for (int value : values) {
            if (countable.relevant(number, value)) {
                count ++;
            }
        }
        return count;
    }
}
