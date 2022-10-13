package itStep.yandr.javaStages.stage14.levelA.model.logic;

import itStep.yandr.javaStages.stage14.levelA.model.logic.decorator.Inverter;
import itStep.yandr.javaStages.stage14.levelA.model.logic.strategy.*;

public interface Constants {
    ElementCountable EQUALS_ZERO = new CountNumbersEqualsZero();
    ElementCountable NON_ZERO = new Inverter(new CountNumbersEqualsZero());
    ElementCountable EVEN_NUM = new CountEvenNumbers();
    ElementCountable ODD_NUM = new Inverter(new CountEvenNumbers());
    ElementCountable POSITIVE_NUM = new CountPositiveNumbers();
    ElementCountable NEGATIVE_NUM = new CountNegativeNumbers();
    ElementCountable[] BEHAVIOR_OBJECTS = {EQUALS_ZERO, NON_ZERO, EVEN_NUM, ODD_NUM, POSITIVE_NUM, NEGATIVE_NUM};

    String [] DESCRIPTIONS = {"Amount of zero values","Amount of non-zero values", "Amount of even numbers"
            , "Amount of odd numbers", "Amount of positive numbers", "Amount of negative numbers"};

}
