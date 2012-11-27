package day1;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: varun
 * Date: 11/27/12
 * Time: 11:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class UnitTest {

    @Test
    public void shouldReturnTrueForCompatibleTypes(){
        assertTrue(Unit.CUP.isCompatible(Unit.TBSP));
    }



    @Test
    public void shouldReturnFalseForIncompatibleTypes(){
        assertFalse(Unit.FEET.isCompatible(Unit.OZ));
    }


}
