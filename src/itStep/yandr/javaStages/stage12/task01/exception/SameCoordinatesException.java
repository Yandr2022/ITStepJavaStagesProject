package itStep.yandr.javaStages.stage12.task01.exception;

public class SameCoordinatesException extends Exception {

    public String toString() {
        return "The coordinates of the starting and ending points shall differ";
    }
}
