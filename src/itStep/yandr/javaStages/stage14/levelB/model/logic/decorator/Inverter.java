package itStep.yandr.javaStages.stage14.levelB.model.logic.decorator;

import itStep.yandr.javaStages.stage14.levelB.model.logic.strategy.ElementCountable;

public class Inverter extends Decorator {


    public Inverter(ElementCountable countable) {
        super(countable);
    }

    @Override
    public boolean relevant(int element, int number) {
        return !(countable.relevant(element, number));
    }
}
