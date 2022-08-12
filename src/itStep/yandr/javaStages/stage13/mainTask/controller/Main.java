package itStep.yandr.javaStages.stage13.mainTask.controller;

import itStep.yandr.javaStages.stage13.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;
import itStep.yandr.javaStages.stage13.mainTask.model.logic.AcademicPerformanceAnalyzer;
import itStep.yandr.javaStages.stage13.util.ArrayManager;
import itStep.yandr.javaStages.stage13.view.MsgBuilder;
import itStep.yandr.javaStages.stage13.view.Printer;



public class Main {
    public static void main(String[] args) {
//
//        int size = ArrayInitializer.getSizeOfArray("numbers");
//        double[] numbers = new double[size];
//        ArrayInitializer.fillArrayWithSelectTypeInit(numbers);
        int[] array = new int[ArrayManager.getSizeOfArray("marks")];
        try {



        ArrayManager.fillArrayWithSelectTypeInit(array);
                double [] results = AcademicPerformanceAnalyzer.calculatePercentageOfMarks(array);
//                String []desc ={"fives","fours","triplets","deuces","units","zeros"};
            String msg = MsgBuilder.buildMsg("%",results,"fives","fours","triplets","deuces"
                    ,"units","zeros");
            Printer.print(msg);
            } catch (InvalidSizeOfArrayException | InvalidObjectException e) {
                e.printStackTrace();
            }





    }
}
