package itStep.yandr.javaStages.stage14.levelA.model.logic.strategy;

public class CountEvenNumbers implements ElementCountable {

    @Override
    public boolean relevant(int element) {
        return element % 2 == 0;
    }


}
