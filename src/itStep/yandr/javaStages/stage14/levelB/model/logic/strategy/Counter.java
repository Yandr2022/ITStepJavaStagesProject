package itStep.yandr.javaStages.stage14.levelB.model.logic.strategy;


public abstract class Counter implements ElementCountable {

    public boolean equals(Object obj) {
        return (this.getClass() == obj.getClass());
    }
}
