package itStep.yandr.javaStages.stage14.levelB.model.logic.strategy;

public class CountEqualsElements extends Counter {
    @Override
    public boolean relevant(int element, int number) {
        return element == number;
    }


}
