package io.github.web.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitTest {

    @BeforeClass
    public static void setupClass() {
        // Initialization per test case
    }

    @Before
    public void setupTest() {
        // Initialization per test
    }

    @Test
    public void test1() {
        // Exercise and verify
    }

    @Test
    public void test2() {
        // Exercise and verify

        boolean booleanCondition = true;
        Object object1 = null;
        Object object2 = new Object();
        Object[] array1 = {};
        Object[] array2 = {};

        Assert.assertTrue("The condition is not met", booleanCondition);
        Assert.assertFalse("The condition is met", booleanCondition);

        Assert.assertArrayEquals("The array is not equal", array1, array2);

        Assert.assertNull("The object is null", object1);
        Assert.assertNotNull("The object is not null", object2);

        Assert.fail("Test failure");
    }

    @After
    public void teardownTest() {
        // Finish per test
    }

    @AfterClass
    public static void teardownClass() {
        // Finish per test
    }

}
