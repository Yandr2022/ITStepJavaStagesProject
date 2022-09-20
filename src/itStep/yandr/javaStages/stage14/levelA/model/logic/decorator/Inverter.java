package itStep.yandr.javaStages.stage14.levelA.model.logic.decorator;

import itStep.yandr.javaStages.stage14.levelA.model.logic.strategy.ElementCountable;


public class Inverter implements ElementCountable {
    ElementCountable countable;

    public Inverter(ElementCountable countable) {
        this.countable = countable;
    }

    @Override
    public boolean relevant(int element) {
        return !(countable.relevant(element));
    }
}
