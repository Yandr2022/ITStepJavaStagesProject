package itStep.yandr.javaStages.stage14.levelA.controller;


import static itStep.yandr.javaStages.stage14.levelA.model.logic.CounterElements.count;

import itStep.yandr.javaStages.stage14.levelA.model.logic.strategy.CountEvenNumbers;
import itStep.yandr.javaStages.stage14.levelA.model.logic.strategy.CountNumbersEqualsZero;
import itStep.yandr.javaStages.stage14.levelA.model.logic.strategy.CountPositiveNumbers;
import itStep.yandr.javaStages.stage14.levelA.model.logic.strategy.ElementCountable;
import itStep.yandr.javaStages.stage14.levelA.model.logic.decorator.Inverter;

public class Main {
    public static void main(String[] args) {
        ElementCountable NUM = new CountPositiveNumbers();
         NUM = new CountNumbersEqualsZero();
         NUM = new CountEvenNumbers();
         NUM = new Inverter(NUM);



        System.out.println(count(NUM, -8, 2, 3, 4, -5, 0, -2));
//        System.out.println(count(NUM, -8, 2, 3, 4, -5, 0, -2));
    }
}
