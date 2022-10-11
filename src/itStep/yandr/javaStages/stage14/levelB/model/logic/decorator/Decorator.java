package itStep.yandr.javaStages.stage14.levelB.model.logic.decorator;

import itStep.yandr.javaStages.stage14.levelB.model.logic.strategy.ElementCountable;

public abstract class Decorator implements ElementCountable {
    ElementCountable countable;

    protected Decorator(ElementCountable countable) {
        this.countable = countable;
    }

    public ElementCountable getCountable() {
        return countable;
    }

    public void setCountable(ElementCountable countable) {
        this.countable = countable;
    }


    public boolean equals(Object obj) {
        return (countable.getClass() == obj.getClass());
    }

    @Override
    public String toString() {
        return "Decorator{ " + this.getClass().getName() +"\n"+
                "countable = " + countable.getClass().getName() +"\n"+
                '}';
    }
}
