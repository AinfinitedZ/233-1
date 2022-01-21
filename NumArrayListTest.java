import org.junit.Test;

import static org.junit.Assert.*;


public class NumArrayListTest {
    // a relative small number for assertequals(double, double, DELTA) method in JUnit test.
    private static final double DELTA = 1E-15;

    // this following unit is tested when <code>ExpandIfExceed()</code> is public method.
    @Test
    public void ExpandIfExceed() throws NotValidIndexException{
        NumArrayList testArray = new NumArrayList();
        testArray.ExpandIfExceed();
        testArray.add(3.0);
        assertEquals(3.0, testArray.lookup(0), DELTA);  // zero test.
        testArray.ExpandIfExceed();
        testArray.add(5.0);
        assertEquals(5.0, testArray.lookup(1), DELTA);  // normal test.
        testArray.ExpandIfExceed();
        testArray.ExpandIfExceed();                                 // element = 2, capacity = 3. Method disabled.
        assertEquals(3, testArray.capacity());             // condition test. ExpandIfExceed() only works when capacity <= elements.
    }

    @Test
    public void size() {
        NumArrayList testArray = new NumArrayList();
        assertEquals(0, testArray.size());                  // zero test.

    }

    @Test
    public void capacity() {
        NumArrayList testArray0 = new NumArrayList();
        NumArrayList testArray1 = new NumArrayList(1);
        NumArrayList testArray2 = new NumArrayList(3);
        assertEquals(0, testArray0.capacity());
        assertEquals(1, testArray1.capacity());
        assertEquals(3, testArray2.capacity());
    }

    @Test(expected = NotValidIndexException.class)
    public void add() throws NotValidIndexException {
        NumArrayList testArray = new NumArrayList(3);
        testArray.lookup(0);
        testArray.add(3.0);
        testArray.add(0.0);
        testArray.add(8.0);
        assertEquals(3.0, testArray.lookup(0),DELTA);
        assertEquals(0.0, testArray.lookup(1),DELTA);
        assertEquals(8.0, testArray.lookup(2),DELTA);
    }

    @Test
    public void insert() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void lookup() {
    }

    @Test
    public void testEquals() {
    }

    @Test
    public void removeDuplicates() {
    }

    @Test
    public void testToString() {
    }
}