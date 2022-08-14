package itStep.yandr.javaStages.stage13.view;

import itStep.yandr.javaStages.stage13.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static itStep.yandr.javaStages.stage13.generalTask.model.logic.DescriptionsContainer.*;
import static itStep.yandr.javaStages.stage13.view.MsgBuilder.buildArrayOfDescriptionsByKeywords;
import static itStep.yandr.javaStages.stage13.view.MsgBuilder.buildMsg;
import static org.junit.Assert.fail;

public class MsgBuilderTest {
    public static final double[][] RESULTS = {{1, 1, 1}, {2}, {3}};
    public static final String[] DESCRIPTIONS = {"a", "b", "c"};
    public static final String COMPLEMENT = "!";
    public static final String[][] INVALID_ARRAYS = {null ,new String[0]};

    @Test
    public void testBuildMsgBasic() throws InvalidObjectException, InvalidSizeOfArrayException {
        String expected = "a : [1.0, 1.0, 1.0]\nb : [2.0]\nc : [3.0]\n";
        Assert.assertEquals(expected, buildMsg(RESULTS, DESCRIPTIONS));
        String expected2 = "a : 1,00 !\nb : 1,00 !\nc : 1,00 !\n";
        Assert.assertEquals(expected2, buildMsg(COMPLEMENT, RESULTS[0], DESCRIPTIONS));
        String expected3 = "a : a\nb : b\nc : c\n";
        Assert.assertEquals(expected3, buildMsg(DESCRIPTIONS, DESCRIPTIONS));
    }

    @Test
    public void testBuildMsgWithOneElement() throws InvalidObjectException, InvalidSizeOfArrayException {
        String expected = "a : [1.0, 1.0, 1.0]\n";
        Assert.assertEquals(expected, buildMsg(Arrays.copyOfRange(RESULTS, 0, 1)
                , Arrays.copyOfRange(DESCRIPTIONS, 0, 1)));
        String expected2 = "b : 2,00 !\n";
        Assert.assertEquals(expected2, buildMsg(COMPLEMENT, RESULTS[1], DESCRIPTIONS[1]));
        String expected3 = "a : a\n";
        Assert.assertEquals(expected3, buildMsg(Arrays.copyOfRange(DESCRIPTIONS, 0, 1), DESCRIPTIONS[0]));
    }

    @Test
    public void testBuildMsgWithNullObjectWithComplement() throws InvalidSizeOfArrayException {
        String[] complements = {null, "!"};
        String[][] descriptions = {{"a", "a", "a"}, {"a", null, "b"}};
        for (int i = 0; i < complements.length; i++) {
            try {
                buildMsg(complements[i], RESULTS[0], descriptions[i]);
                fail("The array of descriptions " + Arrays.toString(descriptions[i]) + "used with complement " + complements[i]
                        + " should have been thrown InvalidObjectException");
            } catch (InvalidObjectException e) {
            }
        }
    }

    @Test
    public void testBuildMsgWithNullObjectWithStrings() throws InvalidSizeOfArrayException {
        String[][] descriptions = {{"a", "a"}, {"a", null}};
        for (int i = 0, j = 1; i < descriptions.length; i++, j--) {
            try {
                buildMsg(descriptions[i], descriptions[j]);
                fail("The array of descriptions " + Arrays.toString(descriptions[i]) + " used with arrays of keyWords "
                        + Arrays.toString(descriptions[j]) + " should have been thrown InvalidObjectException");
            } catch (InvalidObjectException e) {
            }
        }
    }

    @Test
    public void testBuildMsgWithNullObjectWithDoubleResults() throws InvalidSizeOfArrayException {
        String[][] descriptions = {{"a", "a"}, {"a", null}};
        double[][][] results = {{null, {1, 2, 3}}, {{1}, {1}}};
        for (int i = 0; i < descriptions.length; i++) {
            try {
                buildMsg(results[i], descriptions[i]);
                fail("The array of descriptions " + Arrays.toString(descriptions[i]) + " used with arrays of results "
                        + Arrays.deepToString(results[i]) + " should have been thrown InvalidObjectException");
            } catch (InvalidObjectException e) {
            }
        }
    }
    @Test
    public void testBuildMsgWithDifferenceSizeOfArraysWithComplement() throws InvalidObjectException {
        for (int i = 0; i < 2; i++) {
            try {
                buildMsg(COMPLEMENT, RESULTS[i],Arrays.copyOfRange(DESCRIPTIONS,0,2));
                fail("The array of results " + Arrays.toString(RESULTS[i]) + " with descriptions " + DESCRIPTIONS[i]
                        + Arrays.toString(Arrays.copyOfRange(DESCRIPTIONS,0,2))
                        + " should have been thrown InvalidSizeOfArrayException");
            } catch (InvalidSizeOfArrayException e) {
            }
        }
    }
    @Test
    public void testBuildMsgWithDifferenceSizeOfArraysWithStrings() throws InvalidObjectException {
        String[][] descriptions = {{"a", "a"}, {"a"}};
        for (int i = 0, j = 1; i < descriptions.length; i++, j--) {
            try {
                buildMsg(descriptions[i], descriptions[j]);
                fail("The array of descriptions " + Arrays.toString(descriptions[i]) + " used with arrays of keyWords "
                        + Arrays.toString(descriptions[j]) + " should have been thrown InvalidSizeOfArrayException");
            } catch (InvalidSizeOfArrayException e) {
            }
        }
    }

    @Test
    public void testBuildMsgWithDifferenceSizeOfArraysWithDoubleResults() throws InvalidObjectException {
        String[][] descriptions = {{"a", "a", "a"}, {"a"}};
        double[][] results =  {{1}, {1}};
        for (int i = 0; i < descriptions.length; i++) {
            try {
                buildMsg(results, descriptions[i]);
                fail("The array of descriptions " + Arrays.toString(descriptions[i]) + " used with arrays of results "
                        + Arrays.deepToString(results) + " should have been thrown InvalidSizeOfArrayException");
            } catch (InvalidSizeOfArrayException e) {
            }
        }
    }

    @Test
    public void testBuildMsgWithNullWithComplement() throws InvalidObjectException {
        for (int i = 0; i < INVALID_ARRAYS.length; i++) {
            try {
                buildMsg(COMPLEMENT, RESULTS[0], INVALID_ARRAYS[i]);
                fail("The array of descriptions " + Arrays.toString(INVALID_ARRAYS[i])
                        + " should have been thrown InvalidSizeOfArrayException");
            } catch (InvalidSizeOfArrayException e) {
            }
        }
    }
    @Test
    public void testBuildMsgWithNullWithStrings() throws InvalidObjectException {
        String[][] descriptions = {{"a", "a"},{"a", "a"}, null, new String[0]};
        for (int i = 0,j=3; i < descriptions.length; i++,j--) {
            try {
                buildMsg(descriptions[i], descriptions[j]);
                fail("The array of descriptions " + Arrays.toString(descriptions[i]) + " used with arrays of keyWords "
                        +Arrays.deepToString(descriptions[j]) + " should have been thrown InvalidSizeOfArrayException");
            } catch (InvalidSizeOfArrayException e) {
            }
        }
    }
    @Test
    public void testBuildMsgWithNullWithDoubleResults() throws InvalidObjectException {
        String[][] descriptions = {{"a", "a"},{"a", "a"}, null, new String[0]};
        double[][][] results ={null,new double[0][],{{1},{1}},{{1},{1}}};
        for (int i = 0; i < descriptions.length; i++) {
            try {
                buildMsg(results[i], descriptions[i]);
                fail("The array of descriptions " + Arrays.toString(descriptions[i]) + " used with arrays of results "
                        +Arrays.deepToString(results[i]) + " should have been thrown InvalidSizeOfArrayException");
            } catch (InvalidSizeOfArrayException e) {
            }
        }
    }
    @Test
    public void testBuildArrayOfDescriptionsByKeywordsBasic() throws InvalidObjectException, InvalidSizeOfArrayException, IOException {
        String[][]usedCommands={{"1","2"},{"2","3"},{"3","1","2"}};
        String[]allCommands={"1","2","3"};
        String[]descriptions={"aaa","bbb","ccc"};
        String[][]expected={{"aaa","bbb"},{"bbb","ccc"},{"ccc","aaa","bbb"}};
        for (int i = 0; i < usedCommands.length ; i++) {
            Assert.assertArrayEquals(expected[i],buildArrayOfDescriptionsByKeywords(usedCommands[i],allCommands,descriptions));
        }
    }
    @Test
    public void testBuildArrayOfDescriptionsByKeywordsWithTheSameUsedCommands()
            throws InvalidObjectException, InvalidSizeOfArrayException, IOException {
        String[][]usedCommands={{"2","2"},{"1","2","1"},{"2","3","3"},{"1","3","1","2","1"}};
        String[]allCommands={"1","2","3"};
        String[]descriptions={"aaa","bbb","ccc"};
        String[][]expected={{"bbb","bbb"},{"aaa","bbb","aaa"},{"bbb","ccc","ccc"},{"aaa","ccc","aaa","bbb","aaa"}};
        for (int i = 0; i < usedCommands.length ; i++) {
            Assert.assertArrayEquals(expected[i],buildArrayOfDescriptionsByKeywords(usedCommands[i],allCommands,descriptions));
        }
    }

    @Test
    public void testBuildArrayOfDescriptionsByKeywordsWithReplaceableUsedCommands()
            throws InvalidObjectException, InvalidSizeOfArrayException, IOException {
        String[][]usedCommands={{"all","min"},{"swap","max","all"},{"avg","all","max"}};
        String[]allCommands= Arrays.copyOfRange(COMMAND_NAMES, 0, COMMAND_NAMES.length - 1);
        String[]descriptions= DESCRIPTION_OF_METHODS;
        String[][]expected={{DESCRIPTION_OF_METHOD_TO_FIND_MIN_VALUE, DESCRIPTION_OF_METHOD_TO_FIND_MAX_VALUE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_AVERAGE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_SUM_OF_NUMBERS_MODULES_ARE_LESS_THAN_AVERAGE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_PRODUCT_OF_POSITIVE_NUMBERS_TO_EVEN_PLACES
                , DESCRIPTION_OF_METHOD_TO_SWAP_EXTREME_VALUES,DESCRIPTION_OF_METHOD_TO_FIND_MIN_VALUE}
                ,{DESCRIPTION_OF_METHOD_TO_SWAP_EXTREME_VALUES, DESCRIPTION_OF_METHOD_TO_FIND_MAX_VALUE
                ,DESCRIPTION_OF_METHOD_TO_FIND_MIN_VALUE, DESCRIPTION_OF_METHOD_TO_FIND_MAX_VALUE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_AVERAGE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_SUM_OF_NUMBERS_MODULES_ARE_LESS_THAN_AVERAGE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_PRODUCT_OF_POSITIVE_NUMBERS_TO_EVEN_PLACES
                , DESCRIPTION_OF_METHOD_TO_SWAP_EXTREME_VALUES},{DESCRIPTION_OF_METHOD_TO_CALCULATE_AVERAGE
                ,DESCRIPTION_OF_METHOD_TO_FIND_MIN_VALUE, DESCRIPTION_OF_METHOD_TO_FIND_MAX_VALUE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_AVERAGE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_SUM_OF_NUMBERS_MODULES_ARE_LESS_THAN_AVERAGE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_PRODUCT_OF_POSITIVE_NUMBERS_TO_EVEN_PLACES
                , DESCRIPTION_OF_METHOD_TO_SWAP_EXTREME_VALUES,DESCRIPTION_OF_METHOD_TO_FIND_MAX_VALUE}};
        for (int i = 0; i < usedCommands.length ; i++) {
            Assert.assertArrayEquals(expected[i],buildArrayOfDescriptionsByKeywords(usedCommands[i],allCommands,descriptions));
        }
    }

    @Test
    public void testBuildArrayOfDescriptionsByKeywordsWithSameReplaceableUsedCommands()
            throws InvalidObjectException, InvalidSizeOfArrayException, IOException {
        String[][] usedCommands = {{"all", "min", "all"},  {"all", "all", "max"}};
        String[] allCommands = Arrays.copyOfRange(COMMAND_NAMES, 0, COMMAND_NAMES.length - 1);
        String[] descriptions = DESCRIPTION_OF_METHODS;
        String[][] expected = {{DESCRIPTION_OF_METHOD_TO_FIND_MIN_VALUE, DESCRIPTION_OF_METHOD_TO_FIND_MAX_VALUE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_AVERAGE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_SUM_OF_NUMBERS_MODULES_ARE_LESS_THAN_AVERAGE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_PRODUCT_OF_POSITIVE_NUMBERS_TO_EVEN_PLACES
                , DESCRIPTION_OF_METHOD_TO_SWAP_EXTREME_VALUES, DESCRIPTION_OF_METHOD_TO_FIND_MIN_VALUE
                , DESCRIPTION_OF_METHOD_TO_FIND_MIN_VALUE, DESCRIPTION_OF_METHOD_TO_FIND_MAX_VALUE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_AVERAGE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_SUM_OF_NUMBERS_MODULES_ARE_LESS_THAN_AVERAGE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_PRODUCT_OF_POSITIVE_NUMBERS_TO_EVEN_PLACES
                , DESCRIPTION_OF_METHOD_TO_SWAP_EXTREME_VALUES}
                 ,{DESCRIPTION_OF_METHOD_TO_FIND_MIN_VALUE, DESCRIPTION_OF_METHOD_TO_FIND_MAX_VALUE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_AVERAGE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_SUM_OF_NUMBERS_MODULES_ARE_LESS_THAN_AVERAGE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_PRODUCT_OF_POSITIVE_NUMBERS_TO_EVEN_PLACES
                , DESCRIPTION_OF_METHOD_TO_SWAP_EXTREME_VALUES
                ,DESCRIPTION_OF_METHOD_TO_FIND_MIN_VALUE, DESCRIPTION_OF_METHOD_TO_FIND_MAX_VALUE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_AVERAGE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_SUM_OF_NUMBERS_MODULES_ARE_LESS_THAN_AVERAGE
                , DESCRIPTION_OF_METHOD_TO_CALCULATE_PRODUCT_OF_POSITIVE_NUMBERS_TO_EVEN_PLACES
                , DESCRIPTION_OF_METHOD_TO_SWAP_EXTREME_VALUES,DESCRIPTION_OF_METHOD_TO_FIND_MAX_VALUE}};
        for (int i = 0; i < usedCommands.length ; i++) {
            Assert.assertArrayEquals(expected[i],buildArrayOfDescriptionsByKeywords(usedCommands[i],allCommands,descriptions));
        }
    }
}
