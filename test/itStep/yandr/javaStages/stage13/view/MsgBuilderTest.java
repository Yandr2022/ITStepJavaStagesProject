package itStep.yandr.javaStages.stage13.view;

import itStep.yandr.javaStages.stage13.exception.InvalidObjectException;
import itStep.yandr.javaStages.stage13.exception.InvalidSizeOfArrayException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static itStep.yandr.javaStages.stage13.generalTask.model.logic.DescriptionsContainer.*;
import static itStep.yandr.javaStages.stage13.view.MsgBuilder.buildArrayOfDescriptionsByKeywords;

public class MsgBuilderTest {

    @Test
    public  void testBuildMsg(){
        
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
