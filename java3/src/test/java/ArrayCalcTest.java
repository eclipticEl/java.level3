import lesson6.ArrayCalc;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayCalcTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, new int[]{1,4,1,4,2,3,4}, 4, true},
                {new int[] {1,5,1,1,2}, new int[]{1,4,1,5,1,1,2}, 4, true},
                {new int[]{5}, new int[] {2,-1,5},-1, false}
        });
    }

    private ArrayCalc arrayCalc;

    private int[] resArr;
    private int[] srcArr;
    private int searchVal;
    private boolean resFound;

    public ArrayCalcTest(int[] resArr, int[] srcArr, int searchVal, boolean resFound)  {
        this.resArr = resArr;
        this.srcArr = srcArr;
        this.searchVal = searchVal;
        this.resFound = resFound;
    }

    @Before
    public void init() {
        arrayCalc = new ArrayCalc();
    }

    @Test
    public void afterLastValTest() {
        Assert.assertArrayEquals(resArr, arrayCalc.afterLastVal(srcArr,searchVal));
    }

    @Test
    public void isFound() {
        Assert.assertTrue(arrayCalc.isFound(srcArr, 1,4) == resFound);
    }
}
