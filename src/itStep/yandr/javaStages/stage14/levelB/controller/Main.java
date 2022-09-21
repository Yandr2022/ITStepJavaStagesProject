package itStep.yandr.javaStages.stage14.levelB.controller;

import itStep.yandr.javaStages.stage14.levelB.model.logic.decorator.Decorator;
import itStep.yandr.javaStages.stage14.levelB.model.logic.decorator.Inverter;
import itStep.yandr.javaStages.stage14.levelB.model.logic.strategy.CountEqualsElements;

import itStep.yandr.javaStages.stage14.levelB.model.logic.strategy.ElementCountable;
import itStep.yandr.javaStages.stage14.levelB.model.logic.strategy.CountMultipleElements;

public class Main {
    public static void main(String[] args) {
        Decorator countable = new Inverter(new CountMultipleElements());
        ElementCountable countable2 = new CountMultipleElements();
        Decorator inverter = new Inverter(countable2);
        inverter.setCountable(countable);

        System.out.println(countable.getClass()+"\n"+countable2.getClass()) ;
        System.out.println(countable.equals(countable2));
    }
}
