package itStep.yandr.javaStages.stage14.levelB.model.logic.decorator;

import itStep.yandr.javaStages.stage14.levelB.model.logic.strategy.ElementCountable;

public class ByModule extends Decorator {



    public ByModule(ElementCountable countable) {
        super(countable);
    }

    @Override
    public boolean relevant(int element, int number) {
        element = Math.abs(element);
        number = Math.abs(number);
        return countable.relevant(element, number);
    }


}
