package itStep.yandr.javaStages.stage14.levelB.model.logic;

import itStep.yandr.javaStages.stage14.levelB.model.logic.decorator.ByModule;
import itStep.yandr.javaStages.stage14.levelB.model.logic.decorator.Inverter;
import itStep.yandr.javaStages.stage14.levelB.model.logic.strategy.*;

public interface Constants {
   int[][] INVALID_ARRAYS = {null, new int[0],{0}};
   int INVALID_RESULT = -1;
   int EMPTY_RESULT = 0;
   ElementCountable GREATER = new CountGreaterElements();
   ElementCountable LESSER = new CountLesserElements();
   ElementCountable EQUALS = new CountEqualsElements();
   ElementCountable NOT_EQUALS = new Inverter(new CountEqualsElements());
   ElementCountable MULTIPLE = new CountMultipleElements();
   ElementCountable NOT_MULTIPLE = new Inverter(new CountMultipleElements());
   ElementCountable GREATER_BY_MODULE = new ByModule(new CountGreaterElements());
   ElementCountable LESSER_BY_MODULE = new ByModule(new CountLesserElements());
   ElementCountable EQUALS_BY_MODULE = new ByModule(new CountEqualsElements());
   ElementCountable NOT_EQUALS_BY_MODULE = new ByModule(new Inverter(new CountEqualsElements()));
   ElementCountable[] BEHAVIOR_OBJECTS = {GREATER, LESSER, EQUALS, NOT_EQUALS, MULTIPLE, NOT_MULTIPLE, GREATER_BY_MODULE
           , LESSER_BY_MODULE, EQUALS_BY_MODULE, NOT_EQUALS_BY_MODULE};
}
