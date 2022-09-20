package itStep.yandr.javaStages.stage14.levelA.model.logic.strategy;

public class CountPositiveNumbers implements ElementCountable {

    @Override
    public boolean relevant(int element) {
        return element > 0;
    }


}
