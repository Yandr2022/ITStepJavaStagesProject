package itStep.yandr.javaStages.stage13.mainTask.controller;

import itStep.yandr.javaStages.stage13.exception.ArrayContainingIncorrectDataException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;
import itStep.yandr.javaStages.stage13.mainTask.model.logic.AcademicPerformanceAnalyzer;
import itStep.yandr.javaStages.stage13.util.ArrayInitializer;
import itStep.yandr.javaStages.stage13.util.InputManager;
import itStep.yandr.javaStages.stage13.view.MsgBuilder;
import itStep.yandr.javaStages.stage13.view.Printer;



public class Main {
    public static void main(String[] args) {
//
//        int size = ArrayInitializer.getSizeOfArray("numbers");
//        double[] numbers = new double[size];
//        ArrayInitializer.fillArrayWithSelectTypeInit(numbers);
        int[] array = new int[ArrayInitializer.getSizeOfArray("marks")];
        try {



        ArrayInitializer.fillArrayWithSelectTypeInit(array);
                double [] results = AcademicPerformanceAnalyzer.calculatePercentageOfMarks(array);
//                String []desc ={"fives","fours","triplets","deuces","units","zeros"};
            String msg = MsgBuilder.buildMsg("%",results,"fives","fours","triplets","deuces"
                    ,"units","zeros");
            Printer.print(msg);
            } catch (InvalidSizeOfArrayException | ArrayContainingIncorrectDataException e) {
                e.printStackTrace();
            }





    }
}
