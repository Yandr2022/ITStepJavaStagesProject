package itStep.yandr.javaStages.stage14.levelB.model.logic.strategy;

import itStep.yandr.javaStages.stage14.levelB.model.logic.strategy.ElementCountable;

public abstract class Counter implements ElementCountable {

    public boolean equals(Object obj) {
        return (this.getClass() == obj.getClass());
    }
}
