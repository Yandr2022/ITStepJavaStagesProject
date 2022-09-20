package itStep.yandr.javaStages.stage14.levelA.model.logic.strategy;

public class CountNegativeNumbers implements ElementCountable {

    @Override
    public boolean relevant(int element) {
        return element < 0;
    }


}
