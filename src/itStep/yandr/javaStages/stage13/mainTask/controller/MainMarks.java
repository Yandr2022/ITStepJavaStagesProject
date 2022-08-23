package itStep.yandr.javaStages.stage13.mainTask.controller;

import itStep.yandr.javaStages.stage13.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;
import itStep.yandr.javaStages.stage13.mainTask.model.logic.AcademicPerformanceAnalyzer;
import itStep.yandr.javaStages.stage13.util.ArrayManager;
import itStep.yandr.javaStages.stage13.view.MsgBuilder;
import itStep.yandr.javaStages.stage13.view.Printer;

import static itStep.yandr.javaStages.stage13.mainTask.model.logic.AcademicPerformanceAnalyzer.MARKS;


public class MainMarks {
    public static void main(String[] args) {
        int[] array = new int[ArrayManager.getSizeOfArray("marks: ")];
        try {
            ArrayManager.fillArrayWithSelectTypeInitWithControllingBounds(array, MARKS[MARKS.length - 1], MARKS[0]);
            double[] results = AcademicPerformanceAnalyzer.calculatePercentageOfMarks(array);
            String msg = MsgBuilder.buildMsg("%", results, "fives", "fours", "triplets", "deuces"
                    , "units", "zeros");
            Printer.print(msg);
        } catch (InvalidSizeOfArrayException | InvalidObjectException e) {
            e.printStackTrace();
        }
    }
}
